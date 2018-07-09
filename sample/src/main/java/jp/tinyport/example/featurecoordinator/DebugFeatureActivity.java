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
 */

package jp.tinyport.example.featurecoordinator;

import android.app.Activity;
import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.util.Log;

public class DebugFeatureActivity extends Activity implements LifecycleOwner {
    private static final String TAG = "FeatureCoordinator";

    private LifecycleRegistry mLifecycleRegistry;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        log("onCreate");

        mLifecycleRegistry = new LifecycleRegistry(this);
        mLifecycleRegistry.addObserver(new DebugFeatureActivityHandler());

        super.onCreate(savedInstanceState);
    }

    @Override
    protected void onDestroy() {
        log("onDestroy");

        super.onDestroy();
    }

    @Override
    protected void onRestart() {
        log("onRestart");

        super.onRestart();
    }

    @Override
    protected void onStart() {
        log("onStart");

        super.onStart();
    }

    @Override
    protected void onStop() {
        log("onStop");

        super.onStop();
    }

    @Override
    protected void onResume() {
        log("onResume");

        super.onResume();
    }

    @Override
    protected void onPause() {
        log("onPause");

        super.onPause();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        log("onSaveInstanceState");

        super.onSaveInstanceState(outState);
    }

    @NonNull
    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    private static void log(String format, Object... args) {
        Log.i(TAG, String.format("[DebugFeatureActivity] " + format, args));
    }
}
