package org.d3if3130.assessment2mobpro1.ui.screen

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.stateIn
import org.d3if3130.assessment2mobpro1.database.PengunjungDao
import org.d3if3130.assessment2mobpro1.model.Pengunjung

class MainViewModel(dao: PengunjungDao) : ViewModel() {

    val dataSelesai: StateFlow<List<Pengunjung>> = dao.getSelesai().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )

    val dataDigunakan: StateFlow<List<Pengunjung>> = dao.getDigunakan().stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000L),
        initialValue = emptyList()
    )
}