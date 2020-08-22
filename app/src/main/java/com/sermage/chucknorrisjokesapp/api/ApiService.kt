package com.sermage.chucknorrisjokesapp.api

import com.sermage.chucknorrisjokesapp.pojo.JokesValue
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Path

interface ApiService {
    @GET("jokes/random/{numberOfJokes}")
    fun getRandomJokes(
        @Path(VALUE_NUMBER) number:Int
    ): Single<JokesValue>
    companion object{
        private const val VALUE_NUMBER="numberOfJokes"
    }
}