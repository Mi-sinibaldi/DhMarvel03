package com.example.dhmarvel03.adapter

import android.content.Context
import androidx.recyclerview.widget.RecyclerView
import com.example.dhmarvel03.model.MarvelComicsResult

class ItemHqAdapter(
private val marvelComicsResult: List<MarvelComicsResult>,
private val context: Context
) : RecyclerView.Adapter<DetailMenuAdapter.ViewHolder>() {