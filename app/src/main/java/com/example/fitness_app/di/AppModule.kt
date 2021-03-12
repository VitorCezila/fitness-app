package com.example.fitness_app.di

import android.content.Context
import androidx.room.Room
import com.example.fitness_app.db.RunningDatabase
import com.example.fitness_app.other.Constants.RUNNING_DATABASE_NAME
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Singleton

@Module //tell to dagger that this is a module
@InstallIn(ApplicationComponent::class)
/*
those components are used to determine when the objects inside of app module are created and when they are destroyed.
in this case will be created when application is running and destroyed when the application is quit.
*/

object AppModule {

    @Singleton //scope
    @Provides
    /*
    "@Provides" tell the dagger that the result of that function can be used to create other dependencies
    and can also be used to be injected into our classes.
     */
    fun provideRunningDatabase(
        @ApplicationContext app: Context
    ) = Room.databaseBuilder(
        app,
        RunningDatabase::class.java,
        RUNNING_DATABASE_NAME
    ).build()

    @Singleton
    @Provides
    fun provideRunDao(db: RunningDatabase) = db.getRunDao()

}