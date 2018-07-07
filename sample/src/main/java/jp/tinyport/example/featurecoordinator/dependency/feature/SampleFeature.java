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

package jp.tinyport.example.featurecoordinator.dependency.feature;

import java.util.Collections;
import java.util.List;

import jp.tinyport.example.featurecoordinator.dependency.dependency.SampleDependency;
import jp.tinyport.featurecoordinator.CacheStrategy;
import jp.tinyport.featurecoordinator.Dependency;
import jp.tinyport.featurecoordinator.Feature;

public class SampleFeature implements Feature {
    @Override
    public String getDescription() {
        return "";
    }

    @Override
    public List<Dependency> getDependencyList() {
        return Collections.singletonList(new SampleDependency());
    }

    @Override
    public CacheStrategy getCacheStrategy() {
        return CacheStrategy.ALWAYS;
    }
}
