package com.benidict.elephantinfo

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.benidict.core.base.BaseViewModel
import com.benidict.core.ui.state.UIState
import com.benidict.domain.exception.ServiceException
import com.benidict.domain.interactor.elephantinfo.LoadElephantInfoUseCase

class ElephantInfoViewModel(private val loadElephantInfoUseCase: LoadElephantInfoUseCase) : BaseViewModel(){

    val doLoadElephantInfo = MutableLiveData<Boolean>()
    val loadElephantInfo = doLoadElephantInfo.switchMap {
        liveData {
            emit(UIState.Loading)
            try{
                val data = loadElephantInfoUseCase.execute()
                emit(UIState.Success(data))
            }catch (e: ServiceException){
                emit(UIState.Error(e.message))
            }
        }
    }

}