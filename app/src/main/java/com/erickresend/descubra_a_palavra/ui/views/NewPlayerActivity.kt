package com.erickresend.descubra_a_palavra.ui.views

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.ViewModelProvider
import com.erickresend.descubra_a_palavra.data.models.DuoModel
import com.erickresend.descubra_a_palavra.databinding.ActivityNewPlayerBinding
import com.erickresend.descubra_a_palavra.ui.viewmodels.PlayersViewModel

class NewPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNewPlayerBinding
    private lateinit var playerViewModel: PlayersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNewPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playerViewModel = ViewModelProvider(this)[PlayersViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()

        binding.btnNewDuo.setOnClickListener {
            val playerName1 = binding.editNewPlayer1.text.toString()
            val playerName2 = binding.editNewPlayer2.text.toString()

            if (playerName1.isNotEmpty() && playerName1.isNotBlank() && playerName2.isNotEmpty() && playerName2.isNotBlank()) {
                playerViewModel.insertPlayer(DuoModel(playerName1, playerName2))
                finish()
            } else {
                Toast.makeText(this, "Digite o nome dos dois jogadores", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}