package com.example.ayatless5youtubeapi.base

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

abstract class BaseActivity(private val layout : Int): AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layout)
        setUpDisconnectState()
        setUpUI()
        setUppLiveData()
    }

    abstract fun setUpDisconnectState()


    abstract fun setUpUI()

    abstract fun setUppLiveData()


}