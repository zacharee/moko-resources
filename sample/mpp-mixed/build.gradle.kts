/*
 * Copyright 2020 IceRock MAG Inc. Use of this source code is governed by the Apache 2.0 license.
 */

plugins {
    id("com.android.library")
    id("org.jetbrains.kotlin.multiplatform")
    id("dev.icerock.mobile.multiplatform-resources")
}

android {
    compileSdkVersion(Versions.Android.compileSdk)

    defaultConfig {
        minSdkVersion(Versions.Android.minSdk)
        targetSdkVersion(Versions.Android.targetSdk)
    }
}

kotlin {
    android()
    iosX64 {
        binaries.framework {
            baseName = "MultiPlatformLibrary"
            isStatic = false
        }
    }
    iosArm64 {
        binaries.framework {
            baseName = "MultiPlatformLibrary"
            isStatic = false
        }
    }

    sourceSets {
        val iosX64Main by getting {}
        val iosX64Test by getting {}
        val iosArm64Main by getting {
            dependsOn(iosX64Main)
        }
        val iosArm64Test by getting {
            dependsOn(iosX64Test)
        }
    }
}

dependencies {
    commonMainImplementation("org.jetbrains.kotlin:kotlin-stdlib:${Versions.kotlin}")
    commonMainImplementation("dev.icerock.moko:resources:${Versions.Libs.MultiPlatform.mokoResources}")
}

multiplatformResources {
    multiplatformResourcesPackage = "com.icerockdev.library"
}
