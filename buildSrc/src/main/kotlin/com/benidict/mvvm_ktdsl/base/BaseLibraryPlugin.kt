package com.benidict.mvvm_ktdsl.base

import com.android.build.gradle.LibraryExtension
import com.benidict.mvvm_ktdsl.configuration.PluginConfig
import org.gradle.api.Plugin
import org.gradle.api.Project
import com.benidict.mvvm_ktdsl.dependencies.commonDependencies
import com.benidict.mvvm_ktdsl.extension.androidLibraryConfiguration
import com.benidict.mvvm_ktdsl.plugin.commonPlugin
import org.gradle.kotlin.dsl.getByType

open class BaseLibraryPlugin: Plugin<Project>{
    override fun apply(project: Project) {
        project.plugins.apply(PluginConfig.androidLibrary)
        project.commonPlugin()
        project.extensions.getByType<LibraryExtension>().apply{
            androidLibraryConfiguration()
        }
        project.commonDependencies()
    }
}