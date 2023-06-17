package com.arpak.useofretrofit

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

//        personDeletion()
//        personInsertion()
//        personUpdation()

//        personSelection()

            allSearchSelect()
    }


    fun personDeletion () {

        val kisiDaoInterface = ApiUtils.getKisilerDaoInterface()

        kisiDaoInterface.personDelete(14891).enqueue(object : Callback<CRUDCevap>{
            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {


                Log.e("Success",response.body()!!.success.toString())
                Log.e("message",response.body()!!.message)


            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }

        })

    }

    fun personInsertion() {

        val kisiDaoInterface = ApiUtils.getKisilerDaoInterface()
        kisiDaoInterface.personInsert("RetrofitAdd","999999").enqueue(object : Callback<CRUDCevap>{


            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {

                Log.e("Success", response.body()?.success.toString())
                response.body()?.let {
                    Log.e("message", it.message) }
            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }

        })
    }

    fun personUpdation(){

        val kisiDaoInterface = ApiUtils.getKisilerDaoInterface()
        kisiDaoInterface.personUpdate(14929,"UpdatedRetrofit","9999888").enqueue(object : Callback<CRUDCevap>{

            override fun onResponse(call: Call<CRUDCevap>, response: Response<CRUDCevap>) {

                Log.e("success",response.body()?.success.toString())
               response.body()?.let {
                   Log.e("message",it.message)
               }

            }

            override fun onFailure(call: Call<CRUDCevap>, t: Throwable) {

            }
        })
    }

    fun personSelection() {

        val kisiDaoInterface = ApiUtils.getKisilerDaoInterface()
        kisiDaoInterface.personSelect().enqueue(object : Callback<KisilerCevap>{

            override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {


                val kisiListesi = response.body()?.kisiler

                if (kisiListesi != null) {
                    for (k in kisiListesi) {

                        Log.e("-----------","-----------")
                        Log.e("Kisi_id",(k.kisiId).toString())
                        Log.e("Kisi_ad",(k.kisiAd))
                        Log.e("Kisi_tel",(k.kisiTel))

                    }
                }

            }

            override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {

            }
        })
    }


    fun allSearchSelect(){

        val kisiDaoInterface = ApiUtils.getKisilerDaoInterface()
         kisiDaoInterface.allSearch("a").enqueue(object : Callback<KisilerCevap>{

             override fun onResponse(call: Call<KisilerCevap>, response: Response<KisilerCevap>) {

                 val kisiListesi = response.body()?.kisiler

                 if (kisiListesi != null) {
                     for (k in kisiListesi) {
                         Log.e("-------------","--------------")
                         Log.e("Kisi_id",(k.kisiId).toString())
                         Log.e("Kisi_ad",(k.kisiAd))
                         Log.e("Kisi_tel",(k.kisiTel))
                     }
                 }

             }
             override fun onFailure(call: Call<KisilerCevap>, t: Throwable) {

             }


         })

    }

}