package com.example.beritap.ModelUtama

import com.google.gson.annotations.SerializedName

data class DataItem(

	@field:SerializedName("viewer")
	val viewer: String? = null,

	@field:SerializedName("tgl_berita")
	val tglBerita: String? = null,

	@field:SerializedName("kategori")
	val kategori: String? = null,

	@field:SerializedName("id")
	val id: String? = null,

	@field:SerializedName("judul")
	val judul: String? = null,

	@field:SerializedName("gambar")
	val gambar: String? = null,

	@field:SerializedName("isi_berita")
	val isiBerita: String? = null
)