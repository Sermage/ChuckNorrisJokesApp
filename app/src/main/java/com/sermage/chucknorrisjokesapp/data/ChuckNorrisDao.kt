package com.sermage.chucknorrisjokesapp.data

import androidx.lifecycle.LiveData
import androidx.room.*
import com.sermage.chucknorrisjokesapp.pojo.Joke

@Dao
interface ChuckNorrisDao {
    @Insert(onConflict =OnConflictStrategy.REPLACE)
    fun insertListOfJokes(list:List<Joke>)
    @Query("SELECT*FROM jokes")
    fun getJokes():LiveData<List<Joke>>
    @Query("DELETE FROM jokes")
    fun deleteAllJokes()

}