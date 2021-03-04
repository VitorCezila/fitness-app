package com.example.fitness_app.db

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao //my database functions
interface RunDAO {

    @Insert(onConflict = OnConflictStrategy.REPLACE) //when insert a run that already exist then the old one will be replaced by the new
    suspend fun insertRun(run: Run)

    @Delete
    suspend fun deleteRun(run: Run)

    //sort runs by:

    @Query("SELECT * FROM running_table ORDER BY timeStamp DESC")
    fun getAllRunsSortedByDate(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY timeInMillis DESC")
    fun getAllRunsSortedByTimeInMillis(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY caloriesBurned DESC")
    fun getALlRunsSortedByCaloriesBurned(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY avgSpeedInKMH DESC")
    fun getAllRunsSortedByAvgSpeed(): LiveData<List<Run>>

    @Query("SELECT * FROM running_table ORDER BY distanceInMeters DESC")
    fun getAllRunsSortedByDistance(): LiveData<List<Run>>


    fun getTotalTimeInMillis(): LiveData<Long>
    
}