package com.benidict.mvvm_ktdsl.injection

import com.benidict.domain.interactor.app.IsFirstInstallUseCase
import com.benidict.domain.interactor.app.SaveFirstInstallUseCase
import com.benidict.domain.interactor.elephantinfo.LoadElephantInfoUseCase
import com.benidict.domain.interactor.elephantlist.LoadElephantListUseCase
import com.benidict.domain.interactor.elephantlist.SaveElephantInfoUseCase
import org.koin.dsl.module

val useCaseModule = module {
    single { LoadElephantListUseCase(get()) }

    single { SaveFirstInstallUseCase(get()) }
    single { IsFirstInstallUseCase(get()) }

    single { SaveElephantInfoUseCase(get()) }
    single { LoadElephantInfoUseCase(get()) }
}