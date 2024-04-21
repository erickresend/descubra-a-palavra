package com.erickresend.descubra_a_palavra.ui.views

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.erickresend.descubra_a_palavra.data.models.DuoModel
import com.erickresend.descubra_a_palavra.databinding.ActivityScoreBinding
import com.erickresend.descubra_a_palavra.ui.adapters.ScoreAdapter
import com.erickresend.descubra_a_palavra.ui.viewmodels.PlayersViewModel

class ScoreActivity : AppCompatActivity(), ScoreAdapter.OnItemClick {

    private lateinit var binding: ActivityScoreBinding
    private val adapter = ScoreAdapter(this)
    private lateinit var playerViewModel: PlayersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityScoreBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewScore.adapter = adapter
        playerViewModel = ViewModelProvider(this)[PlayersViewModel::class.java]

        playerViewModel.getAllPlayers.observe(this){
            adapter.setPlayerList(it)
        }
    }

    override fun onStart() {
        super.onStart()

        binding.btnClose.setOnClickListener {
            finish()
        }
    }

    override fun onClick(player: DuoModel) {
        if(player.score1 > 0 && player.score2 > 0) {
            Toast.makeText(this,
                "${player.name1} e ${player.name2} já jogaram",
                Toast.LENGTH_SHORT).show()
        } else {
            val intent = Intent(this, GameActivity::class.java)
            intent.putExtra("playerId", player.id)
            startActivity(intent)
        }
    }
}