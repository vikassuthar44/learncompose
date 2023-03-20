package com.example.learncompose.intercpetor

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.Text
import androidx.compose.ui.Alignment
import com.example.learncompose.ui.theme.LearnComposeTheme
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class NetworkClass: ComponentActivity() {

    companion object {
        const val TAG = "NetworkClass"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        callNetwork()
        setContent {
            LearnComposeTheme {
                Box(contentAlignment = Alignment.Center) {
                    Text(text = "Vikas Suthar")
                }
            }
        }
    }

    private fun callNetwork() {
        /*val apiService: ApiService = RetrofitClientInstance.getInstance().create(ApiService::class.java)
        val call = apiService.getAllPhotos()
        call.enqueue(object : Callback<List<Photos>> {

            override fun onResponse(call: Call<List<Photos>>, response: Response<List<Photos>>) {
                Log.d(TAG, "onResponse: ${response.body().toString()}")
            }

            override fun onFailure(call: Call<List<Photos>>, t: Throwable) {

            }
        })*/
    }
}