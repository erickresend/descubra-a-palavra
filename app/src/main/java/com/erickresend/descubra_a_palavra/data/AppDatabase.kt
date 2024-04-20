package com.erickresend.descubra_a_palavra.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.erickresend.descubra_a_palavra.data.daos.PlayerDao
import com.erickresend.descubra_a_palavra.data.models.DuoModel

@Database(entities = [DuoModel::class], version = 1, exportSchema = false)
abstract class AppDatabase: RoomDatabase() {

    abstract fun playerDao(): PlayerDao

    companion object {
        private lateinit var INSTANCE: AppDatabase

        fun getDatabase(context: Context): AppDatabase {
            if (!Companion::INSTANCE.isInitialized) {
                synchronized(AppDatabase::class) {
                    INSTANCE = Room.databaseBuilder(context, AppDatabase::class.java, "playerdatabase")
                        .addMigrations(MIGRATION_1_2)
                        .allowMainThreadQueries()
                        .build()
                }
            }
            return INSTANCE
        }

        private val MIGRATION_1_2: Migration = object : Migration(1, 2) {
            override fun migrate(db: SupportSQLiteDatabase) {
                db.execSQL("DELETE FROM player")
            }
        }
    }
}