package com.benidict.mvvm_ktdsl.injection

import com.benidict.elephantinfo.ElephantInfoViewModel
import com.benidict.elephantlist.MainListViewModel
import com.benidict.mvvm_ktdsl.SplashViewModel
import org.koin.androidx.viewmodel.dsl.viewModel
import org.koin.dsl.module

val viewModelModule = module {
    viewModel { MainListViewModel(get(), get()) }
    viewModel { SplashViewModel(get(), get()) }
    viewModel { ElephantInfoViewModel(get()) }
}