package org.d3if3130.assessment2mobpro1.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pengunjung")
data class Pengunjung (
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0L,
    val nama: String,
    val ruangan: String,
    val durasi: String,
    val status: String,
)