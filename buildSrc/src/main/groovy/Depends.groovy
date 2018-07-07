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

class Depends {
    static final arch = new Arch()
    static final errorprone = "com.google.errorprone:error_prone_core:$Versions.errorprone"
    static final dagger = new Dagger()
    static final glide = new Glide()
    static final gradle = new Gradle()
    static final kotlin = "org.jetbrains.kotlin:kotlin-stdlib:$Versions.kotlin"
    static final leakcanary = new Leakcanary()
    static final orma = new Orma()
    static final rx = new Rx()
    static final support = new Support()

    static class Arch {
        final lifecycle = "android.arch.lifecycle:extensions:$Versions.arch.live"
        final lifecycleCompiler = "android.arch.lifecycle:compiler:$Versions.arch.live"
    }

    static class Dagger {
        final dagger = "com.google.dagger:dagger:$Versions.dagger"
        final compiler = "com.google.dagger:dagger-compiler:$Versions.dagger"
    }

    static class Glide {
        final glide = "com.github.bumptech.glide:glide:$Versions.glide"
        final okhttp3 = "com.github.bumptech.glide:okhttp3-integration:$Versions.glide"
    }

    static class Gradle {
        final android = "com.android.tools.build:gradle:$Versions.gradle.android"
        final androidCacheFix =
                "gradle.plugin.org.gradle.android:android-cache-fix-gradle-plugin:$Versions.gradle.androidCacheFix"
        final kotlin = "org.jetbrains.kotlin:kotlin-gradle-plugin:$Versions.kotlin"
        final errorprone = "net.ltgt.gradle:gradle-errorprone-plugin:$Versions.gradle.errorprone"
    }

    static class Leakcanary {
        final debug = "com.squareup.leakcanary:leakcanary-android:$Versions.leakcanary"
        final release = "com.squareup.leakcanary:leakcanary-android-no-op:$Versions.leakcanary"
        final test = "com.squareup.leakcanary:leakcanary-android-no-op:$Versions.leakcanary"
    }

    static class Orma {
        final orma = "com.github.gfx.android.orma:orma:$Versions.orma"
        final compiler = "com.github.gfx.android.orma:orma-processor:$Versions.orma"
    }

    static class Rx {
        final java = "io.reactivex.rxjava2:rxjava:$Versions.rx.java"
        final android = "io.reactivex.rxjava2:rxandroid:$Versions.rx.android"
    }

    static class Support {
        final constraint = "com.android.support.constraint:constraint-layout:$Versions.support.constraint"
        final annotations = "com.android.support:support-annotations:$Versions.support.support"
        final recyclerview = "com.android.support:recyclerview-v7:$Versions.support.support"
        final cardview = "com.android.support:cardview-v7:$Versions.support.support"
        final leanback = "com.android.support:leanback-v17:$Versions.support.support"
        final tvProvider = "com.android.support:support-tv-provider:$Versions.support.support"
        final compat = "com.android.support:support-compat:$Versions.support.support"
        final compatV4 = "com.android.support:support-v4:$Versions.support.support"
        final compatV7 = "com.android.support:appcompat-v7:$Versions.support.support"
        final coreUtils = "com.android.support:support-core-utils:$Versions.support.support"
    }
}
