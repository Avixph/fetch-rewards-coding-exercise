package com.example.fetchrewardscodingexercise

import android.app.Application
import com.example.fetchrewardscodingexercise.data.AppContainer
import com.example.fetchrewardscodingexercise.data.DefaultAppContainer

class FetchRewardsCodingExerciseApplication : Application() {
    lateinit var container: AppContainer
    override fun onCreate() {
        super.onCreate()
        container = DefaultAppContainer()
    }
}