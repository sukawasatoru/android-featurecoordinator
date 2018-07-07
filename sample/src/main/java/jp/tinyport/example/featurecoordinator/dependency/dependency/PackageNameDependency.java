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
import android.content.pm.PackageManager;

import jp.tinyport.featurecoordinator.Dependency;

public class PackageNameDependency implements Dependency {
    private final String mPackageName;

    public PackageNameDependency(String packageName) {
        mPackageName = packageName;
    }

    @Override
    public boolean isAvailable(Context context) {
        try {
            context.getPackageManager().getPackageInfo(mPackageName, 0);
            return true;
        } catch (PackageManager.NameNotFoundException e) {
            return false;
        }
    }
}
