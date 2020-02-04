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

//    companion object{
//
//        const val DB_VERSION = 1
//        private const val DB_NAME = "demo.db"
//        @Volatile
//        private var INSTANCE: AppDataBase? = null
//
//        private var mInstance: AppDataBase? = null
//
//        fun getInstance(context: Context): AppDataBase? {
////            INSTANCE ?: synchronized(this) {
////                INSTANCE ?: build(context).also {
////                    INSTANCE = it
////                }
//
//            if(mInstance == null){
//            //    mInstance = build(context)
//                mInstance = Room.databaseBuilder(
//                    context.applicationContext,
//                    AppDataBase::class.java!!,
//                    DB_NAME
//                ).allowMainThreadQueries().build()
//            }
//
//             return mInstance
//
//            }
//
//
//        public fun build(context: Context): AppDataBase? {
//
//            try {
//                return  Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, DB_NAME)
//                    .allowMainThreadQueries().build()
//            }catch (e: Exception){
//                e.message?.let{
//                    var mErrorString: String = it
//                }
//            }
//           return null
//        }
//
//
//
////        public fun build(context: Context) =
////            Room.databaseBuilder(context.applicationContext, AppDataBase::class.java, DB_NAME)
////                .addMigrations(MIGRATION_1_TO_2)
////                .build()
////
////        private val MIGRATION_1_TO_2 = object : Migration(1, 2) {
////            override fun migrate(database: SupportSQLiteDatabase) {
////            }
////        }
//    }




    companion object {
        @Volatile private var instance: AppDataBase? = null
        private val LOCK = Any()

        operator fun invoke(context: Context)= instance ?: synchronized(LOCK){
            instance ?: buildDatabase(context).also { instance = it}
        }

        private fun buildDatabase(context: Context) = Room.databaseBuilder(context,
            AppDataBase::class.java, "db-name.db").allowMainThreadQueries()
            .build()
    }




}