package com.example.stackoverflow.util

import com.google.android.material.chip.Chip
import com.google.android.material.chip.ChipGroup

object BindingAdapter {

    @JvmStatic
    @androidx.databinding.BindingAdapter("setTags")
    fun ChipGroup.setTags(mTags: List<String>) {
        val m = mTags.joinToString(separator = ", ").split(",").map { it.trim() }
        createChipTags(m)
    }

    private fun ChipGroup.createChipTags(m: List<String>) {
        for (i in m.indices) {
            val chip = Chip(context)
            chip.text = m[i]
            chip.isClickable = false
            chip.isCheckable = false
            addView(chip)
        }
    }
}