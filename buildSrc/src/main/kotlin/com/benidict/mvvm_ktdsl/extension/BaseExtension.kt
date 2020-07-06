package com.benidict.mvvm_ktdsl.extension

import com.benidict.mvvm_ktdsl.configuration.AndroidConfig
import com.android.build.gradle.BaseExtension

internal fun BaseExtension.androidConfigPlugin(){
    compileSdkVersion(AndroidConfig.compileSdk)
    defaultConfig{
        minSdkVersion (AndroidConfig.minSdk)
        targetSdkVersion (AndroidConfig.targetSdk)
        testInstrumentationRunner = AndroidConfig.androidJunitRunner
    }
}