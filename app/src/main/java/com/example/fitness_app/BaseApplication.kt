package com.example.fitness_app

import android.app.Application
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp //tell app that we want to inject dependencies using dagger hilt
class BaseApplication: Application() {

}