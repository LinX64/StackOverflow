package com.example.stackoverflow.util

import android.view.View
import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

fun View.visible() {
    visibility = View.VISIBLE
}

fun View.inVisible() {
    visibility = View.INVISIBLE
}

fun ChipGroup.createChipTags(mList: List<String>) {
    val mTags = mList.joinToString(separator = ", ").split(",").map { it.trim() }
    for (i in mTags.indices) {
        val chip = Chip(context).apply {
            text = mTags[i]
            chipMinHeight = 0f
        }
        addView(chip)
    }
}