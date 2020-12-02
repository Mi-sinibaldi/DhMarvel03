package com.example.dhmarvel03.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.dhmarvel03.R
import com.example.dhmarvel03.model.ComicsResult
import kotlinx.android.synthetic.main.activity_detail_capa_h_q2.*
import kotlinx.android.synthetic.main.activity_detail_h_q.*

class DetailCapaHQ : AppCompatActivity() {

    private var detail: ComicsResult? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_capa_h_q2)

        val extras = intent.extras
        if (extras != null) {
            detail = extras.getParcelable<ComicsResult>("detail")
            setUpItens()
        }

        imageViewClose.setOnClickListener {
            onBackPressed()
        }
    }

    private fun setUpItens() {
        var photoBackgroud =
            detail?.images?.firstOrNull()?.path + "." + detail?.images?.firstOrNull()?.extension

        photoBackgroud = photoBackgroud.replace("http://", "https://")
        Glide.with(this)
            .load(photoBackgroud)
            .into(imageViewCapaHQ)
    }
}