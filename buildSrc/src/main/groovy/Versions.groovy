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

class Versions {
    static final arch = new Arch()
    static final errorprone = '2.3.1'
    static final dagger = '2.16'
    static final gradle = new Gradle()
    static final glide = '4.7.1'
    static final kotlin = '1.2.50'
    static final leakcanary = '1.5.4'
    static final manifest = new Manifest()
    static final orma = '4.2.5'
    static final rx = new Rx()
    static final support = new Support()

    static class Arch {
        final live = '1.1.1'
    }

    static class Gradle {
        final android = '3.1.3'
        final androidCacheFix = '0.5.1'
        final errorprone = '0.0.14'
    }

    static class Manifest {
        final compileSdk = 27
        final buildTools = '28.0.0'
        final minSdk = 21
        final targetSdk = 27
    }

    static class Rx {
        final java = '2.1.16'
        final android = '2.0.2'
    }

    static class Support {
        final support = '27.1.1'
        final constraint = '1.1.2'
    }
}
