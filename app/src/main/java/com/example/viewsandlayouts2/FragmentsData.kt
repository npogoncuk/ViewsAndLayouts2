package com.example.viewsandlayouts2

object FragmentsData {
    val data = listOf(FragmentData("Fragment1", R.drawable.image1),
        FragmentData("Fragment2", R.drawable.image2),
        FragmentData("Fragment3", R.drawable.image3),)
    data class FragmentData(val name: String, val imageId: Int)
}