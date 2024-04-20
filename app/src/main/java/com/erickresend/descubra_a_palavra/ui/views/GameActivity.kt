package com.erickresend.descubra_a_palavra.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.erickresend.descubra_a_palavra.data.datasource.DataSourceWords
import com.erickresend.descubra_a_palavra.databinding.ActivityGameBinding
import com.erickresend.descubra_a_palavra.databinding.ActivityScoreBinding
import com.erickresend.descubra_a_palavra.ui.adapters.WordAdapter
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private val adapter = WordAdapter()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewWords.adapter = adapter
        //binding.recyclerviewWords.layoutManager = LinearLayoutManager(this)

        val list = mutableListOf<String>()

        val dataSource: ArrayList<String> = DataSourceWords.createDataSetWords()

        while (list.size < 5) {
            val randomIndex = Random.nextInt(dataSource.size)
            list.add(dataSource[randomIndex])
        }

        adapter.setWordsList(list)
    }

    override fun onStart() {
        super.onStart()

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}