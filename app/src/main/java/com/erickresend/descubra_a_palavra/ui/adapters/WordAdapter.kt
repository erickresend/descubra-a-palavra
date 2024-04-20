package com.erickresend.descubra_a_palavra.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.erickresend.descubra_a_palavra.databinding.ResWordsBinding

class WordAdapter : RecyclerView.Adapter<WordAdapter.WordViewHolder>() {

        private var list = mutableListOf<String>()

        inner class WordViewHolder(private val binding: ResWordsBinding) : RecyclerView.ViewHolder(binding.root) {
            fun bind(word: String) {
                binding.textWord.text = word
            }
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): WordViewHolder {
            val binding = ResWordsBinding.inflate(LayoutInflater.from(parent.context), parent, false)
            return WordViewHolder(binding)
        }

        override fun getItemCount(): Int {
            return list.size
        }

        override fun onBindViewHolder(holder: WordViewHolder, position: Int) {
            val word = list[position]
            holder.bind(word)
        }

        fun setWordsList(words: MutableList<String>) {
            list = words
            notifyDataSetChanged()
        }
    }