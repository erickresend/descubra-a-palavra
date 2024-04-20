package com.erickresend.descubra_a_palavra.data.models

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "player")
data class DuoModel(

    @ColumnInfo(name = "name1")
    var name1: String,

    @ColumnInfo(name = "name2")
    var name2: String
) {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "id")
    var id: Int = 0

    @ColumnInfo(name = "score1")
    var score1: Int = 0

    @ColumnInfo(name = "score2")
    var score2: Int = 0
}
