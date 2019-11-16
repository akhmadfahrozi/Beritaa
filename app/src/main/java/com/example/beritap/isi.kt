package com.example.beritap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beritap.ModelUtama.DataItem
import com.example.beritap.ModelUtama.ResponseBeritaUtama
import com.example.beritap.Retrofit.NetworkClient
import kotlinx.android.synthetic.main.activity_isi.*
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class isi : AppCompatActivity() {
    private var data: List<DataItem> = ArrayList()
    private var adapter: AdapterUtama? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_isi)
        loadData()
    }

    private fun loadData() {
        NetworkClient.getService()?.getBeritaUtama()
            ?.enqueue(object : Callback<ResponseBeritaUtama> {
                override fun onFailure(call: Call<ResponseBeritaUtama>, t: Throwable) {
                }

                override fun onResponse(
                    call: Call<ResponseBeritaUtama>,
                    response: Response<ResponseBeritaUtama>
                ) {
                    if (response.isSuccessful) {
                        data=response.body()?.data!!
                        adapter= AdapterUtama(data)
                        val mLayoutManager=LinearLayoutManager(this@isi)
                        rc_utama!!.layoutManager=mLayoutManager
                        rc_utama!!.itemAnimator=DefaultItemAnimator()
                        rc_utama!!.adapter=adapter
                    }

                }
            })

    }
}