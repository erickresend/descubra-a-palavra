package com.erickresend.descubra_a_palavra

import android.content.Context

class PlayerRepository(context: Context) {

    private val playerDatabase = AppDatabase.getDatabase(context).playerDao()
    val getAllPlayers = playerDatabase.getAllPlayers()

    suspend fun insertPlayer(player: PlayerModel) {
        playerDatabase.insertPlayer(player)
    }

    suspend fun updatePlayer(id: Int, name1: String, name2: String) {
        playerDatabase.updatePlayer(id, name1, name2)
    }

    suspend fun deletePlayer(id: Int) {
        playerDatabase.deletePlayer(id)
    }
}