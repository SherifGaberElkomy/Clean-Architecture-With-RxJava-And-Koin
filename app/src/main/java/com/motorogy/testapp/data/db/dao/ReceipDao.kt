package com.motorogy.testapp.data.db.dao

import androidx.room.*
import com.motorogy.testapp.data.db.entity.ReceipEntity
import javax.sql.DataSource

@Dao
interface ReceipDao {
    @Query("SELECT * FROM  Receips")
    fun findAll(): List<ReceipEntity>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(receipEntity: ReceipEntity): Long

    @Delete
    fun delete(receipEntity: ReceipEntity)
}