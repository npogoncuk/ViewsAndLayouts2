package com.example.viewsandlayouts2.viewpagerfragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.annotation.DrawableRes
import com.example.viewsandlayouts2.R

private const val ARG_NAME = "name"
private const val ARG_IMAGE = "image"

class Fragment2 : Fragment() {

    private var name: String? = null
    private var imageId: Int? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            name = it.getString(ARG_NAME)
            imageId = it.getInt(ARG_IMAGE)
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_2, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        view.findViewById<TextView>(R.id.fragment_text_view).text = name ?: throw IllegalArgumentException("Name of fragment is null")
        view.findViewById<ImageView>(R.id.fragment_imageView).setImageResource(imageId ?: throw IllegalArgumentException("imageId is null"))
    }

    companion object {
        @JvmStatic
        fun newInstance(name: String, @DrawableRes imageId: Int) =
            Fragment2().apply {
                arguments = Bundle().apply {
                    putString(ARG_NAME, name)
                    putInt(ARG_IMAGE, imageId)
                }
            }
    }
}