package com.sermage.chucknorrisjokesapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.ArrayAdapter
import androidx.activity.viewModels
import androidx.lifecycle.Observer
import com.sermage.chucknorrisjokesapp.adapters.JokesAdapter
import com.sermage.chucknorrisjokesapp.api.ApiFactory
import com.sermage.chucknorrisjokesapp.pojo.Joke
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val viewModel:ChucksViewModel by viewModels()
        viewModel.loadData(5)
        val adapter=JokesAdapter()
        val recyclerViewJokes=recyclerViewJokes
        recyclerViewJokes.adapter=adapter
        viewModel.jokesList.observe(this, Observer {
            adapter.listOfJokes=it
        })




    }

}
