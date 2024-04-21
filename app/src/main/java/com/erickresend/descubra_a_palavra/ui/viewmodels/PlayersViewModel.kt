package com.erickresend.descubra_a_palavra.ui.viewmodels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.erickresend.descubra_a_palavra.data.models.DuoModel
import com.erickresend.descubra_a_palavra.repositories.PlayerRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PlayerRepository(application.applicationContext)
    val getAllPlayers = repository.getAllPlayers

    fun insertPlayer(player: DuoModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPlayer(player)
        }
    }

    fun updatePlayer(id: Int, name1: String, name2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePlayer(id, name1, name2)
        }
    }

    fun updatePlayerScore1(id: Int, score1: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePlayerScore1(id, score1)
        }
    }

    fun updatePlayerScore2(id: Int, score2: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePlayerScore2(id, score2)
        }
    }

    fun deletePlayer(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePlayer(id)
        }
    }

    fun getPlayer(id: Int): DuoModel {
        return repository.getPlayer(id)
    }
}