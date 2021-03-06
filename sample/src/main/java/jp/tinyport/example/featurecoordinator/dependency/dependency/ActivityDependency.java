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

package jp.tinyport.example.featurecoordinator.dependency.dependency;

import android.content.Context;
import android.content.Intent;

import jp.tinyport.featurecoordinator.Dependency;

public class ActivityDependency implements Dependency {
    private final Intent mIntent;

    public ActivityDependency(Intent intent) {
        mIntent = intent;
    }

    @Override
    public boolean isAvailable(Context context) {
        return mIntent.resolveActivity(context.getPackageManager()) != null;
    }
}
