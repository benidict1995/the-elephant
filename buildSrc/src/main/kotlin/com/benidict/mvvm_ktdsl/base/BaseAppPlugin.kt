package com.benidict.mvvm_ktdsl.base

import com.android.build.gradle.AppExtension
import com.benidict.mvvm_ktdsl.plugin.commonPlugin
import org.gradle.api.Plugin
import org.gradle.api.Project
import org.gradle.kotlin.dsl.getByType
import com.benidict.mvvm_ktdsl.configuration.PluginConfig
import com.benidict.mvvm_ktdsl.extension.androidAppConfiguration
import com.benidict.mvvm_ktdsl.dependencies.commonDependencies


open class BaseAppPlugin : Plugin<Project> {
    override fun apply(project: Project) {
        project.plugins.apply(PluginConfig.androidApplication)
        project.commonPlugin()
        project.extensions.getByType<AppExtension>().apply {
            androidAppConfiguration()
        }
        project.commonDependencies()
    }
}