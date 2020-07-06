package com.benidict.mvvm_ktdsl.injection

import com.benidict.data.gateway.AppDataGateway
import com.benidict.data.gateway.ElephantDataGateway
import com.benidict.domain.gateway.AppGateway
import com.benidict.domain.gateway.ElephantGateway
import org.koin.dsl.module

val gateWayModule = module {
    single { ElephantDataGateway(get(), get()) as ElephantGateway }
    single { AppDataGateway(get()) as AppGateway }
}