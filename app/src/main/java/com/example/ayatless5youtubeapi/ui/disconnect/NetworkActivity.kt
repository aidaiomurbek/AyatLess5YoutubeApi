package com.example.ayatless5youtubeapi.ui.disconnect

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.Observer
import com.example.ayatless5youtubeapi.R
import com.example.youtubeparser27.ui.disconnect.NetworkCheker
import kotlinx.android.synthetic.main.activity_network.*

class NetworkActivity : AppCompatActivity() {
    private lateinit var networkCheker:NetworkCheker
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_network)
        networkCheker = NetworkCheker(this)

        btn1.setOnClickListener {
            if(isNetworkAvaible()){
                finish()
            }else{
                Toast.makeText(baseContext,"error",Toast.LENGTH_SHORT).show()
            }
        }

    }

    private fun isNetworkAvaible(): Boolean {
        var isAvaible: Boolean = false
        networkCheker.observe(this, Observer {
            isAvaible = it
        })

        return isAvaible
    }
}