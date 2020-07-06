package com.benidict.data.service

import android.content.SharedPreferences
import com.benidict.domain.model.Elephant

class PersistenceService(private val sharedPreferences: SharedPreferences){

    private var elephantList : List<Elephant> = arrayListOf()

    private var mElephant = Elephant()

    fun saveElephantList(elephant: List<Elephant>): List<Elephant>{
        elephantList = elephant
        return elephantList
    }

    fun loadElephantList(): List<Elephant> = elephantList

    fun saveElephantInfo(elephant: Elephant) { mElephant = elephant }

    fun loadElephantInfo(): Elephant = mElephant

    fun clearElephantList() : List<Elephant> = arrayListOf()

    fun clearElephantInfo() : Elephant = Elephant()

    fun write(key: String?, value: String?) {
        sharedPreferences.edit().putString(key, value).apply()
    }

    fun write(key: String?, value: Boolean){
        sharedPreferences.edit().putBoolean(key, value).apply()
    }

    fun readString(key: String?): String? = sharedPreferences.getString(key, "")

    fun readBool(key: String): Boolean = sharedPreferences.getBoolean(key, false)

}