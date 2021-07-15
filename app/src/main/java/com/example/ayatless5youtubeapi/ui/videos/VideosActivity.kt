package com.example.ayatless5youtubeapi.ui.videos

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.ayatless5youtubeapi.R

class VideosActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_videos)

        var text = intent.getStringExtra("Key")
        Toast.makeText(baseContext,text,Toast.LENGTH_SHORT).show()
    }
}