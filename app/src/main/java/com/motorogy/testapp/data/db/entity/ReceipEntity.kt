package com.motorogy.testapp.data.db.entity

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.motorogy.testapp.data.remote.domain.ReceipDoamainModel
import java.util.ArrayList

@Entity(tableName = "Receips")
data class ReceipEntity(
    @PrimaryKey(autoGenerate = true) val id: Int = 0,
    @ColumnInfo(name = "idItem") val idItem: Int,
    @ColumnInfo(name = "title") val titleItem: String = "",
    @ColumnInfo(name = "readyInMinutes") val readyInMin: Int,
    @ColumnInfo(name = "servings") val servings: Int,
    @ColumnInfo(name = "image") val image: String = ""
) {

    companion object {

        fun toReceip(receipDomain: ReceipDoamainModel): ReceipEntity {
            return ReceipEntity(
                idItem = receipDomain.id,
                titleItem = receipDomain.title,
                readyInMin = receipDomain.readyInMin,
                servings = receipDomain.serving,
                image = receipDomain.imgItem
            )
        }
    }

}