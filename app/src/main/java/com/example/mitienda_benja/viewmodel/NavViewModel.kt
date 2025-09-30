package com.example.mitienda_benja.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.mitienda_benja.navigation.NavEvent
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.asSharedFlow
import kotlinx.coroutines.launch

class NavViewModel: ViewModel() {//el view model se encargará de emitir los eventos de navegacion
    private val _events= MutableSharedFlow<NavEvent>()
    val events = _events.asSharedFlow()

    fun goTo(route:String) = viewModelScope.launch{
        _events.emit(NavEvent.To(route))
    }
    fun back()=viewModelScope.launch{
        _events.emit(NavEvent.Back)
    }
}