import com.benidict.mvvm_ktdsl.configuration.AndroidConfig
plugins{
    id("com.benidict.mvvm_ktdsl.app")
}

android {
    compileSdkVersion(AndroidConfig.compileSdk)
    buildToolsVersion(AndroidConfig.buildTools)
    defaultConfig {
        applicationId = AndroidConfig.applicationId
        versionCode = AndroidConfig.versionCode
        versionName = AndroidConfig.versionName
    }

    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }

    packagingOptions {
        exclude("META-INF/*.kotlin_module")
    }
}

dependencies {

    implementation(project(":data"))
    implementation(project(":domain"))

    implementation(project(":android:elephantlist"))
    implementation(project(":android:elephantinfo"))
    implementation(project(":android:core"))
}
