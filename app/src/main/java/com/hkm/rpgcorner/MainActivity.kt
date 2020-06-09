package com.hkm.rpgcorner

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Parcelable
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.drawerlayout.widget.DrawerLayout
import com.google.android.material.navigation.NavigationView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.ActionBar


class MainActivity : NavigationActivity() {
    private lateinit var rvRPGs: RecyclerView
    private var list: ArrayList<RPG> = arrayListOf()
    private lateinit var onBackPressedListener: OnBackPressedListener

//    private lateinit var dl: DrawerLayout
//    private lateinit var t: ActionBarDrawerToggle
//    private lateinit var nv: NavigationView

    fun setOnBackPressedListener(onBackPressedListener: OnBackPressedListener) {
        this.onBackPressedListener = onBackPressedListener
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val inflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        //inflate your activity layout here!
        val contentView = inflater.inflate(R.layout.activity_main, null, false)
        val frameView = findViewById(R.id.myContent) as View
        val fullView = frameView.getParent() as ViewGroup
        val indexChild = fullView.indexOfChild(frameView)
        fullView.removeViewAt(indexChild)
        fullView.addView(contentView,indexChild)

//        dl = findViewById(R.id.activity_main)
//        t = ActionBarDrawerToggle(this, dl, R.string.Open, R.string.Close)
//
//        dl.addDrawerListener(t)
//        t.syncState()
//
//        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
//
//        nv = findViewById(R.id.nv)
//        nv.setNavigationItemSelectedListener(object :
//            NavigationView.OnNavigationItemSelectedListener {
//            override fun onNavigationItemSelected(item: MenuItem): Boolean {
//                when (item.itemId) {
//                    R.id.home -> Toast.makeText(
//                        this@MainActivity,
//                        "My Account",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    R.id.about -> Toast.makeText(
//                        this@MainActivity,
//                        "Settings",
//                        Toast.LENGTH_SHORT
//                    ).show()
//                    else -> return true
//                }
//                return true
//            }
//        })

        rvRPGs = findViewById(R.id.rv_rpgs)
        rvRPGs.setHasFixedSize(true)

        list.addAll(RPGsData.listData)
        showRecyclerList()

        if (supportActionBar != null) {
            (supportActionBar as ActionBar).title = "Home"
        }
    }

//    override fun onOptionsItemSelected(item: MenuItem): Boolean {
//        return if (t.onOptionsItemSelected(item)) true else super.onOptionsItemSelected(item)
//    }

    private fun showRecyclerList() {
        rvRPGs.layoutManager = LinearLayoutManager(this)
        val rpgsAdapter = RPGsAdapter(list)
        rvRPGs.adapter = rpgsAdapter

        rpgsAdapter.setOnItemClickCallback(object : RPGsAdapter.OnItemClickCallback {
            override fun onItemClicked(data: RPG) {
                showSelectedGame(data)
            }
        })
    }

    private fun showSelectedGame(rpg: RPG) {
        val moveWithDataIntent = Intent(this@MainActivity, DetailActivity::class.java)
        moveWithDataIntent.putExtra("RPG", rpg as Parcelable)
        startActivity(moveWithDataIntent)
    }


    interface OnBackPressedListener {
        fun doBack()
    }
}
