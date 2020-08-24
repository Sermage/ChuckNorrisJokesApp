package com.sermage.chucknorrisjokesapp.screens

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.RecyclerView
import com.sermage.chucknorrisjokesapp.R
import com.sermage.chucknorrisjokesapp.adapters.JokesAdapter

class JokesFragment : Fragment() {



    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val rootView=inflater.inflate(R.layout.fragment_jokes,container,false)
        val recyclerViewJokes=rootView.findViewById<RecyclerView>(R.id.recyclerViewJokes)
        val buttonReload=rootView.findViewById<Button>(R.id.buttonReload)
        val editTextNumberOfJokes=rootView.findViewById<EditText>(R.id.editTextNumberOfJokes)
        val viewModel: ChucksViewModel by viewModels()
        val adapter= JokesAdapter()
        recyclerViewJokes.adapter=adapter
        viewModel.jokesList.observe(viewLifecycleOwner, {
            adapter.listOfJokes=it
        })
        buttonReload.setOnClickListener {
            viewModel.loadData(editTextNumberOfJokes.text.toString().toInt())
        }
        return rootView
    }
}