package com.erickresend.descubra_a_palavra.ui.views

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.erickresend.descubra_a_palavra.data.models.DuoModel
import com.erickresend.descubra_a_palavra.databinding.ActivityScoreBinding
import com.erickresend.descubra_a_palavra.repositories.PlayerRepository
import com.erickresend.descubra_a_palavra.ui.adapters.ScoreAdapter
import com.erickresend.descubra_a_palavra.ui.viewmodels.PlayersViewModel
import com.erickresend.descubra_a_palavra.ui.viewmodels.ScoreViewModel

class ScoreActivity : AppCompatActivity(), ScoreAdapter.OnItemClick {

    private lateinit var binding: ActivityScoreBinding
    private val adapter = ScoreAdapter(this)
    private lateinit var scoreViewModel: ScoreViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewScore.adapter = adapter
        scoreViewModel = ViewModelProvider(this)[ScoreViewModel::class.java]

        scoreViewModel.getAllPlayers.observe(this){
            adapter.setPlayerList(it)
        }
    }

    override fun onStart() {
        super.onStart()

        binding.btnNextPlayer.setOnClickListener {
            startActivity(Intent(this, GameActivity::class.java))
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    override fun onClick(player: DuoModel) {
        startActivity(Intent(this, GameActivity::class.java))
    }
}