package com.erickresend.descubra_a_palavra

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class PlayersViewModel(application: Application) : AndroidViewModel(application) {

    private val repository = PlayerRepository(application.applicationContext)
    val getAllPlayers = repository.getAllPlayers

    fun insertPlayer(player: PlayerModel) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.insertPlayer(player)
        }
    }

    fun updatePlayer(id: Int, name1: String, name2: String) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.updatePlayer(id, name1, name2)
        }
    }

    fun deletePlayer(id: Int) {
        viewModelScope.launch(Dispatchers.IO) {
            repository.deletePlayer(id)
        }
    }
}