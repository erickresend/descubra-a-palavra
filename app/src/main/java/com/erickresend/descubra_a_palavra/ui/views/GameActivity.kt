package com.erickresend.descubra_a_palavra.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.erickresend.descubra_a_palavra.data.datasource.DataSourceWords
import com.erickresend.descubra_a_palavra.databinding.ActivityGameBinding
import com.erickresend.descubra_a_palavra.ui.adapters.WordAdapter
import com.erickresend.descubra_a_palavra.ui.viewmodels.PlayersViewModel
import kotlin.random.Random

class GameActivity : AppCompatActivity() {

    private lateinit var binding: ActivityGameBinding
    private val adapter = WordAdapter()
    private lateinit var playerViewModel: PlayersViewModel

    private var counterScore: Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityGameBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewWords.adapter = adapter
        //binding.recyclerviewWords.layoutManager = LinearLayoutManager(this)
        playerViewModel = ViewModelProvider(this)[PlayersViewModel::class.java]

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

        val getPlayerId = intent.getIntExtra("playerId", 1)
        val player = playerViewModel.getPlayer(getPlayerId)

        if(player.score1 == 0) {
            binding.textPlayer1.text = "${player.name1}\nVai tentar adivinhar as palavras"
            binding.textPlayer2.text = "${player.name2}\nVai ajudar falando palavras que sejam relacionadas\nNão pode fazer gestos\nApenas um palavra por vez "
        } else {
            binding.textPlayer1.text = "${player.name2}\nVai tentar adivinhar as palavras"
            binding.textPlayer2.text = "${player.name1}\nVai ajudar a adivinhar as palavras"
        }

        binding.btnCounter.setOnClickListener {
            counterScore++
            binding.textCounter.text = counterScore.toString()
        }

        binding.btnConcluded.setOnClickListener {

            val counterChanges = binding.textCounter.text.toString()

            if(player.score1 == 0) {
                binding.textPlayer1.text = "${player.name1}\nVai tentar adivinhar as palavras"
                binding.textPlayer2.text = "${player.name2}\nVai ajudar a adivinhar as palavras"

                playerViewModel.updatePlayerScore1(player.id, counterChanges.toInt())
                finish()

            } else {
                binding.textPlayer1.text = "${player.name2}\nVai tentar adivinhar as palavras"
                binding.textPlayer2.text = "${player.name1}\nVai ajudar a adivinhar as palavras"

                playerViewModel.updatePlayerScore2(player.id, counterChanges.toInt())
                finish()
            }
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}