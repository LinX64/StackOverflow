package com.example.stackoverflow.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.stackoverflow.data.model.Item
import com.example.stackoverflow.databinding.QuestionsListItemBinding

class QuestionsAdapter : RecyclerView.Adapter<QuestionsAdapter.MyViewHolder>() {
    private var books = ArrayList<Item>()

    inner class MyViewHolder(
        private val binding: QuestionsListItemBinding
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(questions: Item) {
            binding.question = questions
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemBinding =
            QuestionsListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemBinding)
    }

    override fun getItemCount(): Int = books.size

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.bind(books[position])
    }

    fun setData(list: List<Item>) {
        books.clear()
        books.addAll(list)
    }
}