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

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;
import android.util.Log;

public class DebugFeatureActivityHandler implements LifecycleObserver {
    private static final String TAG = "FeatureCoordinator";

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    public void onCreate() {
        log("onCreate");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    public void onDestroy() {
        log("onDestroy");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_START)
    public void onStart() {
        log("onStart");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    public void onStop() {
        log("onStop");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    public void onResume() {
        log("onResume");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    public void onPause() {
        log("onPause");
    }

    private static void log(String format, Object... args) {
        Log.i(TAG, String.format("[DebugFeatureActivityHandler] " + format, args));
    }
}
