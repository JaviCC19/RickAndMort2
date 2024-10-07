package com.uvg.javier.Factorys

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.uvg.javier.ViewModels.LocationDetailViewModel

class LocationFactory(private val locationId: Int) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LocationDetailViewModel::class.java)) {
            return LocationDetailViewModel(locationId) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class")
    }
}