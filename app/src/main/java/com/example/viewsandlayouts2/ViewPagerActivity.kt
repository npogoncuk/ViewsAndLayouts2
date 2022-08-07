package com.example.viewsandlayouts2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.lifecycle.Lifecycle
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.widget.ViewPager2
import com.example.viewsandlayouts2.viewpagerfragments.Fragment1
import com.example.viewsandlayouts2.viewpagerfragments.Fragment2
import com.example.viewsandlayouts2.viewpagerfragments.Fragment3

class ViewPagerActivity : AppCompatActivity() {

    private lateinit var viewPager: ViewPager2

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_view_pager)

        viewPager = findViewById(R.id.view_pager)
        viewPager.adapter = PagerAdapter(supportFragmentManager, lifecycle, FragmentsData.data)
    }

    override fun onBackPressed() {
        if (viewPager.currentItem == 0) super.onBackPressed()
        else viewPager.currentItem -= 1
    }

    private inner class PagerAdapter(fragmentManager: FragmentManager, lifecycle: Lifecycle,val fragmentData: List<FragmentsData.FragmentData>)
        : FragmentStateAdapter(fragmentManager, lifecycle) {
        override fun getItemCount(): Int = fragmentData.size

        override fun createFragment(position: Int): Fragment {
            val (name, imageId) = fragmentData[position]
            return when(position) {
                0 -> Fragment1.newInstance(name, imageId)
                1 -> Fragment2.newInstance(name, imageId)
                2 -> Fragment3.newInstance(name, imageId)
                else -> throw IllegalArgumentException("There is only 3 fragments")
            }
        }

    }
}