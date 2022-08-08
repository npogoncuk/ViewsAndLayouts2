package com.example.viewsandlayouts2

import android.graphics.Color
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.FrameLayout
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlin.random.Random

class RecyclerViewActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_recycler_view)
        findViewById<RecyclerView>(R.id.recyclerView).adapter = RecyclerViewAdapter(generateData())
    }

    private fun generateData(): List<Any> {
        val mutableList = mutableListOf<Any>(*FragmentsData.data.toTypedArray())
        repeat(3) {
            mutableList += "Just a string ${it + 1}"
        }
        val random = Random(System.currentTimeMillis())
        repeat(3) {
            mutableList += Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256))
        }
        mutableList.shuffle()
        return mutableList
    }

}
private const val FRAGMENTS_DATA_TYPE = 0
private const val TEXT_TYPE = 1
private const val BACKGROUND_TYPE = 2

private class RecyclerViewAdapter(val data: List<Any>) : RecyclerView.Adapter<RecyclerViewAdapter.BaseViewHolder<*>>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BaseViewHolder<*> {
        return when (viewType) {
            FRAGMENTS_DATA_TYPE -> FragmentsDataViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item, parent, false))
            TEXT_TYPE -> TextViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_text, parent, false))
            BACKGROUND_TYPE -> BackgroundViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.recycler_view_item_background, parent, false))
            else -> throw IllegalArgumentException("Number $viewType is not view type")
        }
    }

    override fun onBindViewHolder(holder: BaseViewHolder<*>, position: Int) {
        val element = data[position]
        when(holder) {
            is FragmentsDataViewHolder -> holder.bind(element as FragmentsData.FragmentData)
            is TextViewHolder -> holder.bind(element as String)
            is BackgroundViewHolder -> holder.bind(element as Int)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when(data[position]) {
            is FragmentsData.FragmentData -> FRAGMENTS_DATA_TYPE
            is String -> TEXT_TYPE
            is Int -> BACKGROUND_TYPE
            else -> throw IllegalArgumentException("RecyclerView cannot work with this data: ${data[position]::class.simpleName}")
        }
    }
    override fun getItemCount(): Int = data.size

    abstract class BaseViewHolder<T>(itemView: View) : RecyclerView.ViewHolder(itemView) {
        abstract fun bind(item: T)
    }

    inner class FragmentsDataViewHolder(itemView: View) : BaseViewHolder<FragmentsData.FragmentData>(itemView) {
        val itemTextView: TextView = itemView.findViewById(R.id.item_title)
        val itemImage: ImageView = itemView.findViewById(R.id.item_image)

        override fun bind(item: FragmentsData.FragmentData) {
            val (name, imageId) = item
            itemTextView.text = name
            itemImage.setImageResource(imageId)
        }
    }

    inner class TextViewHolder(itemView: View) : BaseViewHolder<String>(itemView) {
        override fun bind(item: String) {
            itemView.findViewById<TextView>(R.id.item_text).text = item
        }
    }

    inner class BackgroundViewHolder(itemView: View) : BaseViewHolder<Int>(itemView) {
        override fun bind(item: Int) {
            itemView.findViewById<FrameLayout>(R.id.item_background).setBackgroundColor(item)
        }

    }
}