package com.sermage.chucknorrisjokesapp.pojo

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName



@Entity(tableName = "jokes")
data class Joke (
    @PrimaryKey
    @SerializedName("id")
    @Expose
    val id:Int = 0,

    @SerializedName("joke")
    @Expose
    val joke: String? = null,



)