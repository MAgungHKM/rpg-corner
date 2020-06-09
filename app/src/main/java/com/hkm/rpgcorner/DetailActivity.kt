package com.hkm.rpgcorner

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Window
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.ActionBar
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class DetailActivity : AppCompatActivity(), MainActivity.OnBackPressedListener {

    companion object {
        private var EXTRA_RPG = RPG()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val actionBar = supportActionBar
        actionBar!!.setHomeButtonEnabled(true)
        actionBar.setDisplayHomeAsUpEnabled(true)

        EXTRA_RPG = intent.getParcelableExtra("RPG") as RPG

        val imgGame = findViewById(R.id.img_game_photo) as ImageView
//        imgGame.setImageResource(EXTRA_RPG.game)
        Glide.with(imgGame.context)
            .load(EXTRA_RPG.game)
            .apply(RequestOptions().override(1280, 720))
            .into(imgGame)

        val imgStore = findViewById(R.id.img_sell_photo) as ImageView
//        imgStore.setImageResource(EXTRA_RPG.store)
        Glide.with(imgStore.context)
            .load(EXTRA_RPG.store)
            .apply(RequestOptions().override(64, 64))
            .into(imgStore)

        val tvName = findViewById(R.id.tv_item_name) as TextView
        tvName.text = EXTRA_RPG.name

        val tvPrice = findViewById(R.id.tv_item_price) as TextView
        tvPrice.text = EXTRA_RPG.price

        val tvDetail = findViewById(R.id.tv_item_detail) as TextView
        tvDetail.text = EXTRA_RPG.detail

        val btnBuy = findViewById(R.id.btn_store) as Button
        btnBuy.setOnClickListener {
            goToUrl(EXTRA_RPG.link)
        }

        val btnSrc = findViewById(R.id.btn_source) as Button
        btnSrc.setOnClickListener {
            goToUrl(EXTRA_RPG.review)
        }

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = EXTRA_RPG.name
        }
    }

    private fun goToUrl (url: String?) {
        val myWebLink = Intent(Intent.ACTION_VIEW, Uri.parse(url))
        startActivity(myWebLink)
    }

    override fun doBack() {
        finish()
    }
}
