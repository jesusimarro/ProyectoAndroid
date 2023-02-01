package com.example.appfootball.Retrofit

import android.util.Log
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object RetrofitHelper {

    val BASEURL = "https://api.football-data.org/v4/"

    var retrofitService: RetrofitService? = null

    fun getRetrofit(): RetrofitService {

        if (retrofitService == null) {
            val retrofit = Retrofit.Builder()
                .baseUrl(BASEURL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(okhttpClient())
                .build()

            retrofitService = retrofit.create(RetrofitService::class.java)
        }

        return retrofitService!!
    }

    /**
     * Initialize OkhttpClient with our interceptor
     */
    private fun okhttpClient(): OkHttpClient {
        val interceptor = HttpLoggingInterceptor {
            Log.d("MI ETIQUETA", it)
        }
        interceptor.setLevel(HttpLoggingInterceptor.Level.BODY)

        val client = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        return client
    }
}