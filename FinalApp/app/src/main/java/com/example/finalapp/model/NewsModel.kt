package com.example.finalapp.model

import com.google.gson.annotations.SerializedName
import retrofit2.http.Url

data class NewsModel(
    @SerializedName("title")
    var title:String,
    @SerializedName("url")
    var url: String,
    @SerializedName("image")
    var image: String,
    @SerializedName("description")
    var description:String,
    @SerializedName("source")
    var source:String,
    @SerializedName("published_at")
    var published:String

)