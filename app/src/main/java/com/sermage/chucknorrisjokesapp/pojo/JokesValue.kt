package com.sermage.chucknorrisjokesapp.pojo

import com.google.gson.annotations.Expose

import com.google.gson.annotations.SerializedName




data class JokesValue (
    @SerializedName("type")
    @Expose
    val type: String? = null,

    @SerializedName("value")
    @Expose
    val value: List<Joke>? = null
)