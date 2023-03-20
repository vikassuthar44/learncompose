package com.example.learncompose.intercpetor

import com.google.gson.annotations.SerializedName

data class Photos(
    @SerializedName("url")
    val url: String
)
