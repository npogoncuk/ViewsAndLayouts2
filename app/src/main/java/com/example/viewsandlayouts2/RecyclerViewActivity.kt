package com.example.viewsandlayouts2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)

        findViewById<RecyclerView>(R.id.recyclerView).adapter = RecyclerViewAdapter(FragmentsData)
    }

}

private class RecyclerViewAdapter(val dataObject: FragmentsData) : RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val (name, imageId) = dataObject.data[position]
        holder.itemTextView.text = name
        holder.itemImage.setImageResource(imageId)
    }

    override fun getItemCount(): Int = dataObject.data.size

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val itemTextView: TextView = itemView.findViewById(R.id.item_title)
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)
    }
}