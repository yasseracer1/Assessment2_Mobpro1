package org.d3if3130.assessment2mobpro1.database

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import org.d3if3130.assessment2mobpro1.model.Pengunjung

@Dao
interface PengunjungDao {

    @Insert
    suspend fun insert(pengunjung: Pengunjung)

    @Update
    suspend fun update(pengunjung: Pengunjung)

    @Query("SELECT * FROM pengunjung WHERE status = 'Digunakan' ORDER BY ruangan ASC")
    fun getDigunakan(): Flow<List<Pengunjung>>

    @Query("SELECT * FROM pengunjung WHERE status = 'Selesai' ORDER BY id DESC")
    fun getSelesai(): Flow<List<Pengunjung>>

    @Query("SELECT * FROM pengunjung WHERE id = :id")
    suspend fun getPengunjungById(id: Long): Pengunjung?

    @Query("DELETE FROM pengunjung WHERE id = :id")
    suspend fun deleteById(id: Long)
}