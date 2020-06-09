package com.hkm.rpgcorner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.appcompat.app.ActionBar
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView

open class NavigationActivity : AppCompatActivity() {
    private lateinit var dl: DrawerLayout
    private lateinit var t: ActionBarDrawerToggle
    lateinit var nv: NavigationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_navigation)


//        val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
//        val frameView = findViewById(R.id.myContent) as View
//        val fullView = frameView.getParent() as ViewGroup
//        val indexChild = fullView.indexOfChild(frameView)

        dl = findViewById(R.id.activity_navigation)
        t = ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close)

        dl.addDrawerListener(t)
        t.syncState()

        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        nv = findViewById(R.id.nv)
        nv.setNavigationItemSelectedListener(object :
            NavigationView.OnNavigationItemSelectedListener {
            override fun onNavigationItemSelected(item: MenuItem): Boolean {
                //inflate your activity layout here!
                when (item.itemId) {
                    R.id.home -> {
                        finish()
                        overridePendingTransition(0, 0);
                        startActivity(Intent(this@NavigationActivity, MainActivity::class.java))
                        overridePendingTransition(0, 0);
                        if (supportActionBar != null) {
                        }
                    }
                    R.id.about -> {
                        finish()
                        overridePendingTransition(0, 0);
                        startActivity(Intent(this@NavigationActivity, AboutActivity::class.java))
                        overridePendingTransition(0, 0);
                        if (supportActionBar != null) {
                        }
                    }
                    else -> return true
                }
                return true
            }
        })
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        return if (t.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
    }
}
