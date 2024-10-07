package com.uvg.javier.States

import com.uvg.javier.dataLocations.Location

data class LocationDetailState(
    val isLoading: Boolean = false,
    val data: Location? = null,
    val hasError: Boolean = false
)