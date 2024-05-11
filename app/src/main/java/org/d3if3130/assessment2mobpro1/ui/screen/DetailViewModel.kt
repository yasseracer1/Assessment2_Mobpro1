package org.d3if3130.assessment2mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import org.d3if3130.assessment2mobpro1.database.PengunjungDao
import org.d3if3130.assessment2mobpro1.model.Pengunjung

class DetailViewModel(private val dao: PengunjungDao) : ViewModel() {

    fun insert(nama: String, ruangan: String, durasi: String, status: String) {
        val pengunjung = Pengunjung(
            nama = nama,
            ruangan = ruangan,
            durasi = durasi,
            status = status,
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.insert(pengunjung)
        }
    }
    suspend fun getPengunjung(id: Long): Pengunjung? {
        return dao.getPengunjungById(id)
    }

    fun update(id: Long, nama: String, ruangan: String, durasi: String, status: String) {
        val pengunjung = Pengunjung(
            id = id,
            nama = nama,
            ruangan = ruangan,
            durasi = durasi,
            status = status
        )

        viewModelScope.launch(Dispatchers.IO) {
            dao.update(pengunjung)
        }
    }

    fun delete(id: Long) {
        viewModelScope.launch(Dispatchers.IO) {
            dao.deleteById(id)
        }
    }
}