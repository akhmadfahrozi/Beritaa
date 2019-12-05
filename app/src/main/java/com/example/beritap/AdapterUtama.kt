package com.example.beritap

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.view.menu.ActionMenuItemView
import androidx.core.content.ContextCompat.startActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.beritap.ModelUtama.DataItem
import com.example.beritap.Retrofit.NetworkClient

class AdapterUtama(private val model: List<DataItem>) :
    RecyclerView.Adapter<AdapterUtama.ViewHolder>() {
    private var ct: Context? = null
    override fun onBindViewHolder(holder: AdapterUtama.ViewHolder, position: Int) {
        val data = model[position]
        holder.tv_judul.text = data.judul//nampilkan judul
        holder.tv_tanggal.text = data.tglBerita
        // holder.tv_view.text=data.viewer
          holder.tv_isi.text=data.isiBerita//nampilkan isi utama
        ct?.let {
            Glide.with(it).load(NetworkClient.BASE_URL + "assets/gambar/${data.gambar}")
                .into(holder.iv_gambar)


        }//menampilkan gambar

    }




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val L = LayoutInflater.from(parent.context)
        val V = L.inflate(R.layout.adapter_utama, parent, false)
        ct = parent.context
        return ViewHolder(V)

    }

    override fun getItemCount(): Int {
        return model.size

    }

            inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        internal var tv_judul: TextView = itemView.findViewById(R.id.tv_judul)
        internal var tv_tanggal: TextView = itemView.findViewById(R.id.tv_tanggal)
        internal var tv_isi: TextView = itemView.findViewById(R.id.tv_isi)
        //  internal var tv_view:TextView=itemView.findViewById(R.id.tv_viewer)
        internal var iv_gambar: ImageView = itemView.findViewById(R.id.iv_gambar)



    }


}




