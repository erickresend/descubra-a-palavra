package com.erickresend.descubra_a_palavra

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class PlayerModel(

    @ColumnInfo(name = "name1")
    var name1: String,

    @ColumnInfo(name = "name2")
    var name2: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0
}
