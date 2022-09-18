package com.example.stackoverflow.ui.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stackoverflow.R
import com.example.stackoverflow.ui.adapter.QuestionsAdapter
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupUI()
    }

    private fun setupUI() {
        supportFragmentManager
            .beginTransaction()
            .add(R.id.fragment_container_view, QuestionsFragment())
            .commitNow()
    }
}