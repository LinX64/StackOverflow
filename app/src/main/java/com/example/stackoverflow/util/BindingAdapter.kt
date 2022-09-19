package com.example.stackoverflow.util

import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

object BindingAdapter {

    @JvmStatic
    @androidx.databinding.BindingAdapter("setTags")
    fun ChipGroup.setTags(mList: List<String>) {
        val mTags = mList.joinToString(separator = ", ").split(",").map { it.trim() }
        createChipTags(mTags)
    }

    private fun ChipGroup.createChipTags(mTags: List<String>) {
        for (i in mTags.indices) {
            val chip = Chip(context).apply {
                text = mTags[i]
                isClickable = false
                isCheckable = false
            }
            addView(chip)
        }
    }
}