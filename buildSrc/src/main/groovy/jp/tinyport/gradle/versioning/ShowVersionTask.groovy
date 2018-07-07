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

package jp.tinyport.gradle.versioning

import org.gradle.api.tasks.TaskAction

class ShowVersionTask extends AbstractVersioningTask {
    int getVersionCode() {
        appVersion.versionCode
    }

    String getVersionName() {
        appVersion.versionName
    }

    @TaskAction
    void showVersion() {
        def version = appVersion
        logger.quiet("versionName=${version == null ? 'N/A' : version}\n" +
                "  - major=${version == null ? 'N/A' : version.major}\n" +
                "  - brahch=${version == null ? 'N/A' : version.branch}\n" +
                "  - minor=${version == null ? 'N/A' : version.minor}\n" +
                "  - revision=${version == null ? 'N/A' : version.revision}\n" +
                "versionCode=${version == null ? 'N/A' : version.versionCode}")
    }
}