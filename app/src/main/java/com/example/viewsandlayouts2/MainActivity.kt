package com.example.viewsandlayouts2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_nav_view)

        findViewById<NavigationView>(R.id.navigation_view).setNavigationItemSelectedListener {
            when(it.itemId) {
                R.id.menu_item_view_pager -> startActivity(Intent(this, ViewPagerActivity::class.java))
                R.id.menu_item_wed_view -> startActivity(Intent(this, WebViewActivity::class.java))
                R.id.menu_item_recycler_view -> startActivity(Intent(this, RecyclerViewActivity::class.java))
                else -> throw IllegalArgumentException("NavigationView item is not implemented")
            }
            true
        }
    }
}