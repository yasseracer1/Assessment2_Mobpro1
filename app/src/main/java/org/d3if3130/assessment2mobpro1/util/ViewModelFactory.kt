package org.d3if3130.assessment2mobpro1.util

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import org.d3if3130.assessment2mobpro1.database.PengunjungDao
import org.d3if3130.assessment2mobpro1.ui.screen.DetailViewModel
import org.d3if3130.assessment2mobpro1.ui.screen.MainViewModel

class ViewModelFactory(
    private val dao: PengunjungDao
) : ViewModelProvider.Factory {
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(dao) as T
        } else if (modelClass.isAssignableFrom(DetailViewModel::class.java)) {
            return DetailViewModel(dao) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}