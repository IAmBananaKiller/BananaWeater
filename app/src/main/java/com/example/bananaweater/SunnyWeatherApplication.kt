package com.example.bananaweater

import android.annotation.SuppressLint
import android.app.Application
import android.content.Context

class SunnyWeatherApplication : Application(){
    companion object{
        const val TOKEN = "3xdCmMyWc2vw6vhN"
        @SuppressLint("StaticFiledLeak")
        lateinit var context: Context
    }

    override fun onCreate() {
        super.onCreate()
        context = applicationContext
    }
}