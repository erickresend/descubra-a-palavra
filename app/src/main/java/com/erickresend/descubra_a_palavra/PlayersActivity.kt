package com.erickresend.descubra_a_palavra

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.erickresend.descubra_a_palavra.databinding.ActivityPlayersBinding

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

        playerViewModel.getAllPlayers.observe(this, Observer {
            adapter.setPlayerList(it)
        })
    }

    override fun onStart() {
        super.onStart()

        binding.btnNewDuo.setOnClickListener {
            startActivity(Intent(this, NewPlayerActivity::class.java))
        }
    }

    override fun onClick(player: PlayerModel) {
        TODO("Not yet implemented")
    }
}