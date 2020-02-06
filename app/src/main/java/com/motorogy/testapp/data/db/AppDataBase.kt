package com.motorogy.testapp.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.migration.Migration
import androidx.sqlite.db.SupportSQLiteDatabase
import com.motorogy.testapp.data.db.dao.ReceipDao
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel

@Database(entities = [ReceipEntity::class], version = 1, exportSchema = false)
abstract class AppDataBase: RoomDatabase() {

    abstract fun getReceipDao(): ReceipDao

    companion object {
        @Volatile private var instance: AppDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDataBase::class.java, "db-name.db").build()
    }




}