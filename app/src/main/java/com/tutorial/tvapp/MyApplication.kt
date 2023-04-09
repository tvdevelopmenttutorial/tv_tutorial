package com.tutorial.tvapp

import android.app.Application
import com.tutorial.tvapp.api.ApiService
import com.tutorial.tvapp.api.RetrofitHelper
import com.tutorial.tvapp.api.TmdbRepo

class MyApplication : Application() {

    lateinit var tmdbRepo : TmdbRepo

    override fun onCreate() {
        super.onCreate()

        init()
    }

    private fun init(){
        val service = RetrofitHelper.getInstance().create(ApiService::class.java)
        tmdbRepo = TmdbRepo(service)
    }
}