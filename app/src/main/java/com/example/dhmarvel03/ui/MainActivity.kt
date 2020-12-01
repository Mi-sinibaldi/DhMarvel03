package com.example.dhmarvel03.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.widget.Toolbar
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.dhmarvel03.R
import com.example.dhmarvel03.adapter.ItemHqAdapter
import com.example.dhmarvel03.model.CommicsResult
import com.example.githubapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.view.*

@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemHqAdapter.ItemListener {

    lateinit var recyclerView: RecyclerView
    private lateinit var adapter: ItemHqAdapter
    private val viewModel: MarvelComicsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupObservers()

        val toolbar: Toolbar = findViewById(R.id.toolbarPrincipal)
        toolbar.title = "Marvel"
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(false)

        recyclerView = findViewById(R.id.recyclerViewListHq)

        recyclerView.layoutManager = GridLayoutManager(this, 3)
    }

    private fun setupRecyclerView(view: View) {
        adapter = ItemHqAdapter(this)
        view.recyclerViewListHq.layoutManager = LinearLayoutManager(this)
        view.recyclerViewListHq.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.comics.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    Toast.makeText(this, "Deu certo!", Toast.LENGTH_SHORT).show()
                }
                Resource.Status.ERROR ->
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()

                Resource.Status.LOADING ->
                    Toast.makeText(this, "Carregando", Toast.LENGTH_SHORT).show()
            }
        })
    }

    override fun onClickedItem(result: CommicsResult) {
        TODO("Not yet implemented")
    }
}