package com.benidict.mvvm_ktdsl

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.benidict.core.base.BaseViewModel
import com.benidict.core.ui.state.UIState
import com.benidict.domain.exception.ServiceException
import com.benidict.domain.interactor.app.IsFirstInstallUseCase
import com.benidict.domain.interactor.app.SaveFirstInstallUseCase
import kotlinx.coroutines.delay

class SplashViewModel(
        private val isFirstInstallUseCase: IsFirstInstallUseCase,
        private val saveFirstInstallUseCase: SaveFirstInstallUseCase) : BaseViewModel(){


    val doCheckIfFirstInstall = MutableLiveData<String>()
    val checkIfFirstInstall = doCheckIfFirstInstall.switchMap { key ->
        liveData{
            emit(UIState.Loading)
            try{
                delay(3000)
                val data = isFirstInstallUseCase.execute(key)
                emit(UIState.Success(data))
            }catch (e: ServiceException){
                emit(UIState.Error(e.message))
            }
        }
    }

    val doSaveFirstInstall = MutableLiveData<String>()
    val saveFirstInstall = doSaveFirstInstall.switchMap {key ->
        liveData {
            emit(UIState.Loading)
            try{
                delay(3000)
                val data = saveFirstInstallUseCase.execute(key)
                emit(UIState.Success(data))
            }catch (e: ServiceException){
                emit(UIState.Error(e.message))
            }
        }
    }

}