package com.example.learncompose.intercpetor



import retrofit2.Call
import retrofit2.http.GET

interface ApiService {

    @GET("/photos")
    fun getAllPhotos(): Call<List<Photos>>
}