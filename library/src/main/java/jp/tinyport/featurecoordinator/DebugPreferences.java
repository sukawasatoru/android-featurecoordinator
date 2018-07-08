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

package jp.tinyport.featurecoordinator;

import android.content.Context;
import android.content.SharedPreferences;

final class DebugPreferences {
    private static final String NAME = "debug-featureavailability";

    static Availability getAvailability(Context context, Class<? extends Feature> feature) {
        final String name = feature.getName();
        return get(context).contains(name) ?
                convertToAvailability(get(context).getBoolean(name, false)) :
                Availability.NOTHING;
    }

    static void storeAvailability(
            Context context, Class<? extends Feature> feature, boolean availability) {
        get(context).edit()
                .putBoolean(feature.getName(), availability)
                .apply();
    }

    static void clear(Context context, Class<? extends Feature> feature) {
        get(context).edit().remove(feature.getName()).apply();
    }

    static void clear(Context context) {
        get(context).edit().clear().apply();
    }

    private static Availability convertToAvailability(boolean available) {
        return available ? Availability.AVAILABLE : Availability.NOT_AVAILABLE;
    }

    private static SharedPreferences get(Context context) {
        return context.getApplicationContext()
                .getSharedPreferences(NAME, Context.MODE_PRIVATE);
    }
}
