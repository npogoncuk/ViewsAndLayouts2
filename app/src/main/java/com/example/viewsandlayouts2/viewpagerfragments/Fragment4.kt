package com.example.viewsandlayouts2.viewpagerfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.viewsandlayouts2.R

class Fragment4 : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_4, container, false)
    }

    companion object {
        @JvmStatic
        fun newInstance() =
            Fragment4().apply {
                arguments = Bundle().apply {

                }
            }
    }
}