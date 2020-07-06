package com.benidict.elephantlist

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.liveData
import androidx.lifecycle.switchMap
import com.benidict.core.base.BaseViewModel
import com.benidict.core.ui.state.UIState
import com.benidict.core.util.Event
import com.benidict.domain.exception.ServiceException
import com.benidict.domain.interactor.elephantlist.LoadElephantListUseCase
import com.benidict.domain.interactor.elephantlist.SaveElephantInfoUseCase
import com.benidict.domain.model.Elephant

class MainListViewModel(
    private val loadElephantListUseCase: LoadElephantListUseCase,
    private val saveElephantInfoUseCase: SaveElephantInfoUseCase
) : BaseViewModel(){

    val doLoadElephantList = MutableLiveData<Pair<Boolean, String>>()
    val loadElephantList = doLoadElephantList.switchMap {
        liveData {
            emit(UIState.Loading)
            try{
                val data = loadElephantListUseCase.execute(it.second)
                emit(UIState.Success(data))
            }catch (e: ServiceException){
                emit(UIState.Error(e.message))
            }
        }
    }

    val doSaveElephantInfo = MutableLiveData<Elephant>()
    val saveElephantInfo = doSaveElephantInfo.switchMap { info ->
        liveData {
            emit(Event(UIState.Loading))
            try{
                val data = saveElephantInfoUseCase.execute(info)
                emit(Event(UIState.Success(data)))
            }catch (e: ServiceException){
                emit(Event(UIState.Error(e.message)))
            }
        }
    }


}