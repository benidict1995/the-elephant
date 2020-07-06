package com.benidict.mvvm_ktdsl

import android.app.Application
import com.benidict.mvvm_ktdsl.injection.*
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class MvvmKtDslApplication  : Application(){
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidContext(this@MvvmKtDslApplication)
            modules(
                viewModelModule,
                gateWayModule,
                useCaseModule,
                netWorkModule
            )
        }
    }
}