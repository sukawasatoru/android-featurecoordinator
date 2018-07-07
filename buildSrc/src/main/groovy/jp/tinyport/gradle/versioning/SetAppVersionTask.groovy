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

class SetAppVersionTask extends AbstractVersioningTask {
    @TaskAction
    void updateAppVersion() {
        if (!project.hasProperty(AppVersion.KEY_VERSION_NAME)) {
            logger.quiet("""usase
  setVersion -P${AppVersion.KEY_VERSION_NAME}=<(0..125).(A..Z).(0..695).(0..1280)>""")
            return
        }

        appVersion = new AppVersion(project.property(AppVersion.KEY_VERSION_NAME).toString())
        appVersion.saveAppVersion(project)
    }
}
