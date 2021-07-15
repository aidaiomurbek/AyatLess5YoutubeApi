package com.example.ayatless5youtubeapi.ui.main

import android.content.Intent
import android.widget.Adapter
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.ayatless5youtubeapi.R
import com.example.ayatless5youtubeapi.base.BaseActivity
import com.example.ayatless5youtubeapi.ui.disconnect.NetworkActivity
import com.example.ayatless5youtubeapi.ui.videos.VideosActivity
import com.example.youtubeparser27.ui.disconnect.NetworkCheker
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : BaseActivity(R.layout.activity_main), MainAdapter.PlayListClickListener {

    private  var viewModel : MainViewModel? = null
    private  var adapter = MainAdapter()
    private lateinit var networkCheker :NetworkCheker

    override fun setUpDisconnectState() {
            networkCheker = NetworkCheker(this)
            if (!networkCheker.isNetworkAvaible(this)){
                startActivity(Intent(this, NetworkActivity::class.java))
            }
            networkCheker.observe(this, Observer {
                if (it) {
                    setUppLiveData()
                }else {
                    startActivity(Intent(this, NetworkActivity::class.java))
                }
            })
    }

    override fun setUpUI() {
        viewModel = ViewModelProvider(this).get(MainViewModel:: class.java)
        adapter.addListener(this)
        res_View.adapter = adapter


    }

    override fun setUppLiveData() {
        viewModel?.fetchPlayList()?.observe(this,{
            Toast.makeText(this,it?.kind.toString(),Toast.LENGTH_SHORT).show()
            if (it != null) {
                adapter.addItems(it)
            }
        })
    }

    override fun itemClick(id: String) {
        var intent :Intent = Intent(this,VideosActivity::class.java)
        intent.putExtra("Key",id)
        startActivity(intent)
    }

}