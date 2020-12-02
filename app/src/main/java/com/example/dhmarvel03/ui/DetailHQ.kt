package com.example.dhmarvel03.ui

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.bumptech.glide.Glide
import com.example.dhmarvel03.R
import com.example.dhmarvel03.model.ComicsResult
import kotlinx.android.synthetic.main.activity_detail_h_q.*
import kotlinx.android.synthetic.main.item_hq_adapter.view.*

class DetailHQ : AppCompatActivity() {

    private var detail: ComicsResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_h_q)

        val extras = intent.extras
        if (extras != null) {
            detail = extras.getParcelable<ComicsResult>("detail")
            setUpItens()
            clickImageCapa()
        }

        imageViewArrowBack.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setUpItens() {
        var photoBackgroud =
            detail?.images?.firstOrNull()?.path + "." + detail?.images?.firstOrNull()?.extension

        photoBackgroud = photoBackgroud.replace("http://", "https://")
        Glide.with(this)
            .load(photoBackgroud)
            .into(imageViewBackground)

        var photo = detail?.thumbnail?.path + "." + detail?.thumbnail?.extension
        photo = photo.replace("http://", "https://")
        Glide.with(this)
            .load(photo)
            .into(imageViewCapa)

        textViewNameHQ.text = detail?.title
        textViewDescHQ.text = detail?.description
        textViewPubliItem.text = detail?.modified
        textViewPriceItem.text = "$ ${detail?.prices?.firstOrNull()?.price.toString()}"
        textViewPagesItem.text = detail?.pageCount.toString()
    }

    private fun clickImageCapa(){
        imageViewCapa.setOnClickListener {
            val i = Intent(this, DetailCapaHQ::class.java)
            i.putExtra("detail", detail)
            startActivity(i)
        }
    }
}