package com.example.beritap.ModelUtama


import com.google.gson.annotations.SerializedName


data class ResponseBeritaUtama(

	@field:SerializedName("data")
	val data: List<DataItem>? = null
)