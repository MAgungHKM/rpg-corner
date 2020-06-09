package com.hkm.rpgcorner

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar

class AboutActivity : NavigationActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //inflate your activity layout here!
        val contentView = inflater.inflate(R.layout.activity_about2, null, false)
        val frameView = findViewById(R.id.myContent) as View
        val fullView = frameView.getParent() as ViewGroup
        val indexChild = fullView.indexOfChild(frameView)
        fullView.removeViewAt(indexChild)
        fullView.addView(contentView,indexChild)

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "About"
        }
    }
}
