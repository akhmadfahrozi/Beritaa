package com.example.beritap.Retrofit

import com.example.beritap.ModelUtama.ResponseBeritaUtama
import retrofit2.Call
import retrofit2.http.GET

interface ApiService {
    @GET("index.php/json/berita_utama")
    fun getBeritaUtama(): Call<ResponseBeritaUtama>
}