package com.benidict.mvvm_ktdsl.dependencies

object Dependencies {

    object SupportDependencies{
        const val kotlinStd = "org.jetbrains.kotlin:kotlin-stdlib-jdk7:${Versions.kotlin}"
        const val kotlinCore = "androidx.core:core-ktx:${Versions.kotlinCore}"

        const val appCompat = "androidx.appcompat:appcompat:${Versions.appCompat}"
        const val constraintLayout = "androidx.constraintlayout:constraintlayout:${Versions.constraintLayout}"
        const val cardView = "androidx.cardview:cardview:${Versions.cardView}"
    }

    object CommonDependencies{
        const val coroutinesAndroidX = "org.jetbrains.kotlinx:kotlinx-coroutines-android:${Versions.coroutinesAndroidX}"

        const val epoxy = "com.airbnb.android:epoxy:${Versions.epoxy}"
        const val epoxyProcessor = "com.airbnb.android:epoxy-processor:${Versions.epoxyProcessor}"

        const val circleImageView = "de.hdodenhof:circleimageview:${Versions.circleImageView}"

        const val glide = "com.github.bumptech.glide:glide:${Versions.glide}"
        const val glideCompiler = "com.github.bumptech.glide:compiler:${Versions.glide}"

        const val koinAndroid = "org.koin:koin-android:${Versions.koinAndroidX}"
        const val koinScopeAndroidX = "org.koin:koin-androidx-scope:${Versions.koinAndroidX}"
        const val koinViewModelAndroidX = "org.koin:koin-androidx-viewmodel:${Versions.koinAndroidX}"
        const val koinFragmentAndroidX = "org.koin:koin-androidx-fragment:${Versions.koinAndroidX}"

        const val liveDataAndroidx = "androidx.lifecycle:lifecycle-livedata-ktx:${Versions.lifeCycle}"

        const val navFragmentAndroidX = "androidx.navigation:navigation-fragment-ktx:${Versions.navigationAndroidX}"
        const val navUIAndroidX = "androidx.navigation:navigation-ui-ktx:${Versions.navigationAndroidX}"

        const val retrofit = "com.squareup.retrofit2:retrofit:${Versions.retrofit}"
        const val retrofitGsonConverter = "com.squareup.retrofit2:converter-gson:${Versions.retrofit}"
        const val okHttp = "com.squareup.okhttp3:okhttp:${Versions.okHttp}"
        const val okHttpInterceptor = "com.squareup.okhttp3:logging-interceptor:${Versions.okHttp}"

        const val gson = "com.google.code.gson:gson:${Versions.gson}"
    }

    object TestDependencies{
        const val junit = "junit:junit:${Versions.junit}"
        const val extJunit = "androidx.test.ext:junit:${Versions.extJunit}"
        const val espressoCore = "androidx.test.espresso:espresso-core:${Versions.espressoCore}"
    }
}