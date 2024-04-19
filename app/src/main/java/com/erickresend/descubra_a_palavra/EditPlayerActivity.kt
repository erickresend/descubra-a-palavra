package com.erickresend.descubra_a_palavra

import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.lifecycle.ViewModelProvider
import com.erickresend.descubra_a_palavra.databinding.ActivityEditPlayerBinding
import com.erickresend.descubra_a_palavra.databinding.ActivityNewPlayerBinding

class EditPlayerActivity : AppCompatActivity() {

    private lateinit var binding: ActivityEditPlayerBinding
    private lateinit var playerViewModel: PlayersViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityEditPlayerBinding.inflate(layoutInflater)
        setContentView(binding.root)

        playerViewModel = ViewModelProvider(this)[PlayersViewModel::class.java]
    }

    override fun onStart() {
        super.onStart()

        val playerId = intent.extras?.getInt("duoId")
        val duoName1 = intent.extras?.getString("duoName1")
        val duoName2 = intent.extras?.getString("duoName2")

        binding.editEditPlayer1.setText(duoName1)
        binding.editEditPlayer2.setText(duoName2)

        binding.btnSave.setOnClickListener {
            val playerNameEdited1 = binding.editEditPlayer1.text.toString()
            val playerNameEdited2 = binding.editEditPlayer2.text.toString()

            if (playerNameEdited1.isNotBlank() && playerNameEdited1.isNotEmpty() && playerNameEdited2.isNotBlank() && playerNameEdited2.isNotEmpty() && playerId != null) {
                playerViewModel.updatePlayer(playerId, playerNameEdited1, playerNameEdited2)
                Toast.makeText(this, "Dupla editada com sucesso", Toast.LENGTH_SHORT).show()
                finish()
            } else {
                Toast.makeText(this, "Digite o nome dos jogadores", Toast.LENGTH_SHORT).show()
            }
        }

        binding.btnDeletePlayer.setOnClickListener {
            if (playerId != null) {
                playerViewModel.deletePlayer(playerId)
                Toast.makeText(this, "Jogador deletado com sucesso", Toast.LENGTH_SHORT).show()
                finish()
            }
        }

        binding.btnClose.setOnClickListener {
            finish()
        }
    }
}