package com.benidict.data.gateway.mock

import com.benidict.domain.gateway.AppGateway

class AppDataGatewayMock(): AppGateway{

    companion object{
        const val KEY_FIRST_TIME_INSTALL = "key_first_time_install"
        const val IS_FIRST_TIME_INSTALL = true
    }

    override suspend fun saveFirstInstall(key: String, firstInstall: Boolean): Boolean
        = key == KEY_FIRST_TIME_INSTALL && IS_FIRST_TIME_INSTALL


    override suspend fun isFirstInstall(key: String): Boolean
        = key == KEY_FIRST_TIME_INSTALL && IS_FIRST_TIME_INSTALL


}