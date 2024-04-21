package com.erickresend.descubra_a_palavra.data.daos

import androidx.lifecycle.LiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.erickresend.descubra_a_palavra.data.models.DuoModel

@Dao
interface PlayerDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPlayer(player: DuoModel)

    @Query("UPDATE player SET name1 = :name1, name2 = :name2 WHERE id = :id")
    suspend fun updatePlayer(id: Int, name1: String, name2: String)

    @Query("UPDATE player SET score1 = :score1 WHERE id = :id")
    suspend fun updatePlayerScore1(id: Int, score1: Int)

    @Query("UPDATE player SET score2 = :score2 WHERE id = :id")
    suspend fun updatePlayerScore2(id: Int, score2: Int)

    @Query("DELETE FROM player WHERE id = :id")
    suspend fun deletePlayer(id: Int)

    @Query("SELECT * FROM player WHERE id = :id")
    fun getPlayer(id: Int): DuoModel

    @Query("SELECT * FROM player")
    fun getAllPlayers(): LiveData<List<DuoModel>>
}