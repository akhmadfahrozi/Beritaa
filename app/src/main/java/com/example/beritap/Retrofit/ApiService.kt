package com.example.beritap.Retrofit

import com.example.beritap.ModelUtama.ResponseBeritaUtama
import com.example.beritap.Tambah_beritaa.Response_Tambah
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query

interface ApiService {
    @GET("index.php/json/berita_utama")
    fun getBeritaUtama(): Call<ResponseBeritaUtama>

    @GET("index.php/json/tambah_berita")
    fun tambahberita(
        @Query("judul_berita") judul_berita: String?,
        @Query("isi_berita") isi_berita: String?)
            :Call<Response_Tambah>
}