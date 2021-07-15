package com.example.ayatless5youtubeapi.ui.main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.ayatless5youtubeapi.`object`.Constant
import com.example.ayatless5youtubeapi.data.remote.ApiService
import com.example.ayatless5youtubeapi.data.remote.RetrofitClient
import com.example.ayatless5youtubeapi.model.PlayList
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel: ViewModel() {
    fun fetchPlayList():LiveData<PlayList?>{
        return fetchYoutubeApiPlayList()
    }
    private var apiService : ApiService? = null

    private fun fetchYoutubeApiPlayList():LiveData<PlayList?> {
        apiService = RetrofitClient.create()


        val data = MutableLiveData<PlayList?>()

        apiService?.fetchAllPLayList(Constant.API_KEY,Constant.PART,Constant.CHANNEL_ID)
            ?.enqueue(object : Callback<PlayList>{
                override fun onResponse(call: Call<PlayList>, response: Response<PlayList>) {
                    data.value = response.body()
                }

                override fun onFailure(call: Call<PlayList>, t: Throwable) {
                    data.value = null
                }


            })
        return data
    }

}