package com.arpak.useofretrofit


//Binding an interface with a Retrofit object
class ApiUtils {

    companion object {
        const val BASE_URL = "http://kasimadalan.pe.hu/"

        fun getKisilerDaoInterface(): KisilerDaoInterface{
            return RetrofitClient.getClient(BASE_URL).create(KisilerDaoInterface::class.java)
        }
    }

}