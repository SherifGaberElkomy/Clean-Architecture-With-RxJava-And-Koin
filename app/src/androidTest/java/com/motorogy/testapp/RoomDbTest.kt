package com.motorogy.testapp

import androidx.room.Room
import androidx.test.runner.AndroidJUnit4
import com.motorogy.testapp.data.db.AppDataBase
import com.motorogy.testapp.data.db.dao.ReceipDao
import com.motorogy.testapp.data.db.entity.ReceipEntity
import com.motorogy.testapp.domain.model.ReceipDoamainModel
import org.junit.After
import org.junit.Assert
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import java.io.IOException

@RunWith(AndroidJUnit4::class)
class RoomDbTest {

    private lateinit var receipDao: ReceipDao
    private lateinit var db: AppDataBase

    @Before
    @Throws(Exception::class)
    fun createDB() {
        val context = AppClassApplication.mContext.getApplicationContext()
        db = Room.inMemoryDatabaseBuilder(
            context, AppDataBase::class.java
        ).build()

        receipDao = db.getReceipDao()
    }

    @Test

    fun addAndSelectItem() {
        var mLstItem: ArrayList<String> = ArrayList<String>()
        var mReceipModelItem: ReceipDoamainModel =
            ReceipDoamainModel(
                0,
                "Title",
                2,
                2,
                "imgPath",
                mLstItem
            )
        var mReceipEntity = ReceipEntity.toReceip(mReceipModelItem)
        var mLongItem: Long = receipDao.insert(mReceipEntity)
        Assert.assertEquals(mLongItem, mLongItem)
        
        var itemList: List<ReceipEntity> = receipDao.findAll()
        var mSingleObject: ReceipEntity = itemList.get(0)
        Assert.assertEquals(mSingleObject.titleItem, mSingleObject.titleItem)
    }

    @After
    @Throws(IOException::class)
    fun closeDb() {
        db.close()
    }



}