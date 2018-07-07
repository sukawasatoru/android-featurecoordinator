/*
 * Copyright 2018 sukawasatoru
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package jp.tinyport.example.featurecoordinator;

import android.app.Activity;
import android.os.Bundle;
import android.os.Handler;
import android.os.HandlerThread;
import android.util.Log;

import java.util.concurrent.CountDownLatch;

import jp.tinyport.example.featurecoordinator.dependency.feature.Java8Feature;
import jp.tinyport.example.featurecoordinator.dependency.feature.SampleFeature;
import jp.tinyport.example.featurecoordinator.dependency.feature.TvProviderFeature;
import jp.tinyport.featurecoordinator.FeatureCoordinator;

public class MainActivity extends Activity {
    private static final String TAG = "FeatureCoordinator";

    private HandlerThread mHandlerThread1;
    private HandlerThread mHandlerThread2;
    private Handler mHandler1;
    private Handler mHandler2;
    private CountDownLatch mLatch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        log("onCreate");

        super.onCreate(savedInstanceState);

        mHandlerThread1 = new HandlerThread("handler1");
        mHandlerThread1.start();
        mHandler1 = new Handler(mHandlerThread1.getLooper());
        mHandlerThread2 = new HandlerThread("handler2");
        mHandlerThread2.start();
        mHandler2 = new Handler(mHandlerThread2.getLooper());
        mLatch = new CountDownLatch(2);

        log("Java8: %s", FeatureCoordinator.isAvailable(this, Java8Feature.class));
        log("TvProvider: %s", FeatureCoordinator.isAvailable(this, TvProviderFeature.class));

        mHandler1.post(() -> {
            log("pre handler1");
            FeatureCoordinator.isAvailable(this, SampleFeature.class);
            log("post handler1");
            FeatureCoordinator.isAvailable(this, SampleFeature.class);
            mLatch.countDown();
        });
        mHandler2.post(() -> {
            log("pre handler2");
            FeatureCoordinator.isAvailable(this, SampleFeature.class);
            log("post handler2");
            mLatch.countDown();
        });
        try {
            mLatch.await();
        } catch (InterruptedException e) {
            // do nothing.
        }

        finish();
    }

    @Override
    protected void onDestroy() {
        log("onDestroy");

        mHandlerThread1.quitSafely();
        mHandlerThread2.quitSafely();

        super.onDestroy();
    }

    private static void log(String format, Object... args) {
        Log.i(TAG, String.format(format, args));
    }
}
