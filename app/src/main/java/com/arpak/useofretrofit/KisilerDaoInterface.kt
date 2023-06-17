package com.arpak.useofretrofit


import retrofit2.Call
import retrofit2.http.Field
import retrofit2.http.FormUrlEncoded
import retrofit2.http.GET
import retrofit2.http.POST

interface KisilerDaoInterface {

    @POST("kisiler/delete_kisiler.php")
    @FormUrlEncoded
    fun personDelete(@Field("kisi_id") kisi_id: Int): Call<CRUDCevap>

    @POST("kisiler/insert_kisiler.php")
    @FormUrlEncoded
    fun personInsert(
        @Field("kisi_ad") kisi_ad: String, @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @POST("kisiler/update_kisiler.php")
    @FormUrlEncoded
    fun personUpdate(
        @Field("kisi_id") kisi_id: Int,
        @Field("kisi_ad") kisi_ad: String,
        @Field("kisi_tel") kisi_tel: String
    ): Call<CRUDCevap>

    @GET("kisiler/tum_kisiler.php")
    fun personSelect(): Call<KisilerCevap>

    @POST("kisiler/tum_kisiler_arama.php")
    @FormUrlEncoded
    fun allSearch(@Field("kisi_ad") kisi_ad: String): Call<KisilerCevap>

}