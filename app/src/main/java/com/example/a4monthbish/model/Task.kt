package com.example.a4monthbish.model

import androidx.room.Entity
import androidx.room.PrimaryKey


@Entity(tableName = "tasks")
data class Task(
    @PrimaryKey(autoGenerate = true)
    val id : Int? = null,
    val title : String? = null,
    val desk : String? = null,
    val image: String? = null
): java.io.Serializable
