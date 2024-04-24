package com.erickresend.descubra_a_palavra.ui.views

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.erickresend.descubra_a_palavra.data.models.DuoModel
import com.erickresend.descubra_a_palavra.ui.adapters.PlayerAdapter
import com.erickresend.descubra_a_palavra.databinding.ActivityPlayersBinding
import com.erickresend.descubra_a_palavra.ui.viewmodels.PlayersViewModel

class PlayersActivity : AppCompatActivity(), PlayerAdapter.OnItemClick {

    private lateinit var binding : ActivityPlayersBinding
    private val adapter = PlayerAdapter(this)
    private lateinit var playerViewModel: PlayersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityPlayersBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.recyclerviewPlayers.adapter = adapter
        playerViewModel = ViewModelProvider(this)[PlayersViewModel::class.java]

        //playerViewModel.deletePlayer()

        playerViewModel.getAllPlayers.observe(this){
            adapter.setPlayerList(it)

            if(it.isEmpty()) {
                binding.layoutNoPlayers.visibility = View.VISIBLE
            } else {
                binding.layoutNoPlayers.visibility = View.INVISIBLE
            }
        }
    }

    override fun onStart() {
        super.onStart()

        binding.btnNewDuo.setOnClickListener {
            startActivity(Intent(this, NewPlayerActivity::class.java))
        }

        binding.btnPlayGame.setOnClickListener {
            val playersSize = playerViewModel.getAllPlayers.value?.size
            if (playersSize != null) {
                if(playersSize < 2) {
                    Toast.makeText(this, "Precisa ter no mínimo duas duplas para jogar", Toast.LENGTH_SHORT).show()
                } else {
                    startActivity(Intent(applicationContext, ScoreActivity::class.java))
                }
            }
        }
    }

    override fun onClick(player: DuoModel) {

        val intent = Intent(this, EditPlayerActivity::class.java)
        intent.putExtra("duoId", player.id)
        intent.putExtra("duoName1", player.name1)
        intent.putExtra("duoName2", player.name2)
        startActivity(intent)
    }
}