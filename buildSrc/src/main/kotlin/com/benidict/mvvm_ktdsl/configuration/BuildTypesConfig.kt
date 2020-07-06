package com.benidict.mvvm_ktdsl.configuration

object BuildTypesConfig {
    const val proguardRules = "proguard-rules.pro"

    object Release{
        const val buildTypes = "release"
        const val minified = true
        const val proguardFilesDefault = "proguard-android-optimize.txt"
    }

    object Debug{
        const val buildTypes = "debug"
        const val minified = false
    }
    
    object Api{
        const val baseUrl = "\"https://elephant-api.herokuapp.com/\""
    }
}