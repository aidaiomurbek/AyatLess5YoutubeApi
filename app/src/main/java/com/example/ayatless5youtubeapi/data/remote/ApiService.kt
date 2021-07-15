package com.example.ayatless5youtubeapi.data.remote

import com.example.ayatless5youtubeapi.model.PlayList
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Query
import java.nio.channels.spi.AbstractSelectionKey

interface ApiService {
    @GET("/youtube/v3/playlists")
    fun fetchAllPLayList(
        @Query("key") apiKey:String,
        @Query("part") part: String,
        @Query("channelId") channelId : String

    ): Call<PlayList>
}