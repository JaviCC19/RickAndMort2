package com.uvg.javier.ViewModels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.uvg.javier.States.LocationListState
import com.uvg.javier.dataLocations.LocationDb
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class LocationListViewModel : ViewModel() {
    private val _state = MutableStateFlow(LocationListState(isLoading = true))
    val state: StateFlow<LocationListState> = _state

    init {
        loadLocations()
    }

    private fun loadLocations() {
        viewModelScope.launch {
            delay(4000) // Simulate loading
            _state.value = LocationListState(data = LocationDb().getAllLocations())
        }
    }

    fun retry() {
        _state.value = LocationListState(isLoading = true)
        loadLocations()
    }

    fun setError() {
        _state.value = LocationListState(hasError = true)
    }
}