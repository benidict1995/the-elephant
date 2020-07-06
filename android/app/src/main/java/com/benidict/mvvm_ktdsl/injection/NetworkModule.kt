package com.benidict.mvvm_ktdsl.injection

import android.app.Application
import android.content.Context
import android.content.SharedPreferences
import com.benidict.data.service.PersistenceService
import com.benidict.data.service.RemoteService
import com.benidict.mvvm_ktdsl.BuildConfig
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

val netWorkModule = module {
    single { provideGson() }
    single { provideHttpLoggingInterceptor() }
    single { provideOkHttpClient(get()) }
    single { provideRetrofit(get(), get()) }
    single { provideElephantService(get()) }
    single { provideElephantSharedPreference(androidApplication()) }
    single { PersistenceService(get()) }
}

private fun provideGson(): Gson  = GsonBuilder().create()

private fun provideHttpLoggingInterceptor(): HttpLoggingInterceptor
        = HttpLoggingInterceptor().apply {
    level = HttpLoggingInterceptor.Level.BODY
}

private fun provideOkHttpClient(loggingInterceptor: HttpLoggingInterceptor): OkHttpClient
        = OkHttpClient.Builder().apply {
        addInterceptor(loggingInterceptor)
}.build()

private fun provideRetrofit(gson: Gson , okHttpClient: OkHttpClient): Retrofit
        = Retrofit.Builder().apply {
    client(okHttpClient)
    baseUrl(BuildConfig.BASE_URL)
    addConverterFactory(GsonConverterFactory.create(gson))
}.build()

private fun provideElephantService(retrofit: Retrofit): RemoteService
        = retrofit.create(RemoteService::class.java)

private fun provideElephantSharedPreference(application: Application): SharedPreferences
        = application.getSharedPreferences("Elephant", Context.MODE_PRIVATE)