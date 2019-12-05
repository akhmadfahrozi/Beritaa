package com.example.beritap

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.beritap.ModelUtama.DataItem
import com.example.beritap.ModelUtama.ResponseBeritaUtama
import com.example.beritap.Retrofit.NetworkClient
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity(),View.OnClickListener {
    lateinit var a: Button
    lateinit var b: Button
    lateinit var c: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        a = findViewById(R.id.bt_play)
        b = findViewById(R.id.bt_about)
        c = findViewById(R.id.bt_close)


        a.setOnClickListener(this)
        b.setOnClickListener(this)
        c.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        when (view.id) {
            R.id.bt_play -> {
                val pindah = Intent(this@MainActivity, isi::class.java)
                startActivity(pindah)
            }
            R.id.bt_about -> {
                val pindah = Intent(this@MainActivity, Tambah_berita::class.java)
                startActivity(pindah)

            }
            R.id.bt_close -> finish()
        }
    }
}

