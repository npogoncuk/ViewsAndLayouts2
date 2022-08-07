package com.example.viewsandlayouts2.viewpagerfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import com.example.viewsandlayouts2.R

private const val ARG_NAME = "name"

class Fragment3 : Fragment() {

    private var name: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_3, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.fragment_text_view).text = name ?: throw IllegalArgumentException("Name of fragment is null")
    }

    companion object {
        /**
         * @param param1 Parameter 1.
         * @return A new instance of fragment Fragment1.
         */
        @JvmStatic
        fun newInstance(param1: String) =
            Fragment3().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, param1)
                }
            }
    }
}