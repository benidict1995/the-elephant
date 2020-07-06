package com.benidict.mvvm_ktdsl.extension

import com.android.build.gradle.LibraryExtension
import org.gradle.api.JavaVersion
import com.benidict.mvvm_ktdsl.configuration.BuildTypesConfig

internal fun LibraryExtension.androidLibraryConfiguration(){

    androidConfigPlugin()

    buildTypes {
        getByName(BuildTypesConfig.Release.buildTypes){
            buildConfigField("String", "BASE_URL", BuildTypesConfig.Api.baseUrl)
            isMinifyEnabled = BuildTypesConfig.Release.minified
            consumerProguardFiles("consumer-rules.pro")
        }

        getByName(BuildTypesConfig.Debug.buildTypes){
            buildConfigField("String", "BASE_URL", BuildTypesConfig.Api.baseUrl)
            isMinifyEnabled = BuildTypesConfig.Debug.minified
        }
    }

    viewBinding {
        isEnabled = true
    }

    compileOptions {
        sourceCompatibility = JavaVersion.VERSION_1_8
        targetCompatibility = JavaVersion.VERSION_1_8
    }
}