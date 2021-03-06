// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:3.6.3")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:1.3.71")

        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle.kts.kts.kts files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

tasks.register("clean", Delete::class){
    delete(rootProject.buildDir)
}

