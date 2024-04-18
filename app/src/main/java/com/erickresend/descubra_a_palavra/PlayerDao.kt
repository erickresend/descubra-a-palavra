package com.erickresend.descubra_a_palavra

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: PlayerModel)

    @Query("UPDATE player SET name1 = :name1, name2 = :name2 WHERE id = :id")
    suspend fun updatePlayer(id: Int, name1: String, name2: String)

    @Query("DELETE FROM player WHERE id = :id")
    suspend fun deletePlayer(id: Int)

    @Query("SELECT * FROM player WHERE id = :id")
    fun getPlayer(id: Int): PlayerModel

    @Query("SELECT * FROM player")
    fun getAllPlayers(): LiveData<List<PlayerModel>>
}