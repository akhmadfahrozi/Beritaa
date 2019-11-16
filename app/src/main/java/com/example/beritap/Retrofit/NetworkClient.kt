package com.example.beritap.Retrofit

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

object NetworkClient {
    val BASE_URL =
        "http://akhmad-fahrozi.com/lauwbanews/"
    private var retrofit: Retrofit? = null
    fun getRetrofitClient(): Retrofit? {
        if (retrofit == null)
            retrofit = Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getOkHttp())
                .addConverterFactory(GsonConverterFactory.create())
                .build()

        return retrofit
    }

    private fun getOkHttp(): OkHttpClient {
        val httpLoggingInterceptor = HttpLoggingInterceptor()
            .setLevel(HttpLoggingInterceptor.Level.BASIC)
            .setLevel(HttpLoggingInterceptor.Level.BODY)
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(httpLoggingInterceptor)
            .build()
        return okHttpClient

    }

    fun getService(): ApiService? {
        return getRetrofitClient()?.create<ApiService>(ApiService::class.java)
    }
}