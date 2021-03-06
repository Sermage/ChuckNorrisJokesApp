package com.sermage.chucknorrisjokesapp.screens

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import com.sermage.chucknorrisjokesapp.api.ApiFactory
import com.sermage.chucknorrisjokesapp.data.AppDatabase
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers

class ChucksViewModel(application: Application):AndroidViewModel(application) {

   private val compositeDisposable= CompositeDisposable()
    private val db=AppDatabase.getInstance(application)
    val jokesList=db.chuckNorrisDao().getJokes()

    fun loadData(numberOfJokes:Int){
        val disposable= ApiFactory.apiService.getRandomJokes(numberOfJokes)
            .map{it.value}
            .subscribeOn(Schedulers.io())
            .subscribe({
                db.chuckNorrisDao().deleteAllJokes()
                if (it != null) {
                    db.chuckNorrisDao().insertListOfJokes(it)
                }
            }, {

            })
        compositeDisposable.add(disposable)
    }

    override fun onCleared() {
        super.onCleared()
        compositeDisposable.dispose()
    }
}