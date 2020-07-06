plugins{
    id("com.benidict.mvvm_ktdsl.library")
}

android {
    kotlinOptions {
        val options = this as org.jetbrains.kotlin.gradle.dsl.KotlinJvmOptions
        options.jvmTarget = "1.8"
    }

}

dependencies {

}
