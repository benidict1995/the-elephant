package com.benidict.mvvm_ktdsl.extension

import com.android.build.gradle.AppExtension
import org.gradle.api.JavaVersion
import com.benidict.mvvm_ktdsl.configuration.BuildTypesConfig

internal fun AppExtension.androidAppConfiguration(){

    androidConfigPlugin()

    signingConfigs {

    }

    buildTypes {
        getByName(BuildTypesConfig.Release.buildTypes){
            buildConfigField("String", "BASE_URL", BuildTypesConfig.Api.baseUrl)
            isMinifyEnabled = BuildTypesConfig.Release.minified
            proguardFiles (getDefaultProguardFile(BuildTypesConfig.Release.proguardFilesDefault), BuildTypesConfig.proguardRules)
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