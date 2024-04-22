package com.erickresend.descubra_a_palavra.repositories

import android.content.Context
import com.erickresend.descubra_a_palavra.data.AppDatabase
import com.erickresend.descubra_a_palavra.data.models.DuoModel

class PlayerRepository(context: Context) {

    private val playerDatabase = AppDatabase.getDatabase(context).playerDao()
    val getAllPlayers = playerDatabase.getAllPlayers()

    suspend fun insertPlayer(player: DuoModel) {
        playerDatabase.insertPlayer(player)
    }

    suspend fun updatePlayer(id: Int, name1: String, name2: String) {
        playerDatabase.updatePlayer(id, name1, name2)
    }

    suspend fun updatePlayerScore1(id: Int, score1: Int) {
        playerDatabase.updatePlayerScore1(id, score1)
    }

    suspend fun updatePlayerScore2(id: Int, score2: Int) {
        playerDatabase.updatePlayerScore2(id, score2)
    }

    suspend fun deletePlayer(id: Int) {
        playerDatabase.deletePlayer(id)
    }

    suspend fun deletePlayer() {
        playerDatabase.deletePlayer()
    }

    fun getPlayer(id: Int): DuoModel {
        return playerDatabase.getPlayer(id)
    }
}