package com.sermage.chucknorrisjokesapp.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.sermage.chucknorrisjokesapp.R
import com.sermage.chucknorrisjokesapp.pojo.Joke
import kotlinx.android.synthetic.main.joke_item.view.*

class JokesAdapter : RecyclerView.Adapter<JokesAdapter.JokeViewHolder>() {
    inner class JokeViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewJoke=itemView.textViewJoke
    }

    var listOfJokes= listOf<Joke>()
    set(value) {
        field=value
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): JokeViewHolder {
        val view:View=LayoutInflater.from(parent.context).inflate(R.layout.joke_item,parent,false)
        return JokeViewHolder(view)
    }

    override fun onBindViewHolder(holder: JokeViewHolder, position: Int) {
        val joke=listOfJokes[position]
        holder.textViewJoke.text=joke.joke
    }

    override fun getItemCount(): Int {
        return listOfJokes.size
    }
}