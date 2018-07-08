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

public final class DebugFeatureCoordinator {
    public static AvailabilityPair checkAvailability(
            Context context, Class<? extends Feature> feature) {
        return new AvailabilityPair(
                FeatureCoordinator.isAvailableImpl(context, feature) ?
                        Availability.AVAILABLE : Availability.NOT_AVAILABLE,
                getAvailabilityImpl(context, feature));
    }

    public static void storeAvailability(
            Context context, Class<? extends Feature> feature, boolean availability) {
        DebugPreferences.storeAvailability(context, feature, availability);
    }

    public static void clear(Context context, Class<? extends Feature> feature) {
        DebugPreferences.clear(context, feature);
    }

    public static void clear(Context context) {
        DebugPreferences.clear(context);
    }

    static Availability getAvailabilityImpl(Context context, Class<? extends Feature> feature) {
        return DebugPreferences.getAvailability(context, feature);
    }
}
