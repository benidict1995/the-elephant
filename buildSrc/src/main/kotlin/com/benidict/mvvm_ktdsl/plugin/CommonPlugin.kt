package com.benidict.mvvm_ktdsl.plugin

import com.benidict.mvvm_ktdsl.configuration.PluginConfig
import org.gradle.api.Project

internal fun Project.commonPlugin(){
    project.plugins.apply(PluginConfig.kotlinAndroid)
    project.plugins.apply(PluginConfig.kotlinKapt)
    project.plugins.apply(PluginConfig.kotlinAndroidExt)
}