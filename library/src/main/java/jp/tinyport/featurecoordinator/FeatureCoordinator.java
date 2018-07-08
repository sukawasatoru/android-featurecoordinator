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

import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public final class FeatureCoordinator {
    private static final Map<Class<? extends Feature>, FeatureCache> sCache;

    static {
        sCache = new ConcurrentHashMap<>();
    }

    private FeatureCoordinator() {
    }

    public static boolean isAvailable(Context context, Class<? extends Feature> feature) {
        final Availability debugAvailability =
                DebugFeatureCoordinator.getAvailabilityImpl(context, feature);
        if (debugAvailability != Availability.NOTHING) {
            return debugAvailability == Availability.AVAILABLE;
        }

        return isAvailableImpl(context, feature);
    }

    public static void clear() {
        sCache.clear();
    }

    static boolean isAvailableImpl(Context context, Class<? extends Feature> feature) {
        synchronized (feature) {
            FeatureCache cache = sCache.get(feature);
            if (cache == null) {
                cache = new FeatureCache(createInstance(feature));
                sCache.put(feature, cache);
            }

            final Availability availability = cache.getAvailability();
            if (availability != Availability.NOTHING) {
                return availability == Availability.AVAILABLE;
            }

            final Feature instance = cache.getInstance();
            final boolean isAvailable = mapDependencies(context, instance.getDependencyList());
            if (instance.getCacheStrategy() == CacheStrategy.ALWAYS) {
                cache.setAvailability(isAvailable);
            }

            return isAvailable;
        }
    }

    private static Feature createInstance(Class<? extends Feature> feature) {
        try {
            return feature.newInstance();
        } catch (InstantiationException | IllegalAccessException e) {
            throw new AssertionError(e);
        }
    }

    private static boolean mapDependencies(Context context, List<Dependency> dependencies) {
        for (Dependency dependency : dependencies) {
            if (!dependency.isAvailable(context)) {
                return false;
            }
        }

        return true;
    }
}
