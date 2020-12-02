package com.example.dhmarvel03.ui

import android.content.Intent
import android.os.Bundle
import android.view.View.GONE
import android.view.View.VISIBLE
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.dhmarvel03.R
import com.example.dhmarvel03.adapter.ItemHqAdapter
import com.example.dhmarvel03.model.ComicsResult
import com.example.githubapp.utils.Resource
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.android.synthetic.main.activity_main.*


@AndroidEntryPoint
class MainActivity : AppCompatActivity(), ItemHqAdapter.ItemListener {

    private lateinit var adapter: ItemHqAdapter
    private val viewModel: MarvelComicsViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupRecyclerView()
        setupObservers()

        val toolbar: Toolbar = findViewById(R.id.toolbarPrincipal)
        toolbar.title = "Marvel"
        setSupportActionBar(toolbar)

        supportActionBar!!.setDisplayHomeAsUpEnabled(false)
    }

    private fun setupRecyclerView() {
        adapter = ItemHqAdapter(this)
        recyclerViewListHq.layoutManager = GridLayoutManager(this, 3)
        recyclerViewListHq.adapter = adapter
    }

    private fun setupObservers() {
        viewModel.comics.observe(this, Observer {
            when (it.status) {
                Resource.Status.SUCCESS -> {
                    if (!it.data?.data?.results.isNullOrEmpty()) adapter.setItems(ArrayList(it.data?.data?.results))
                    progressBarList.visibility = GONE
                }
                Resource.Status.ERROR -> {
                    Toast.makeText(this, it.message, Toast.LENGTH_SHORT).show()
                    progressBarList.visibility = GONE
                }
                Resource.Status.LOADING -> {
                    progressBarList.visibility = VISIBLE
                }
            }
        })
    }

    override fun onClickedItem(result: ComicsResult) {
        val i = Intent(this, DetailHQ::class.java)
        i.putExtra("detail", result)
        startActivity(i)
    }
}