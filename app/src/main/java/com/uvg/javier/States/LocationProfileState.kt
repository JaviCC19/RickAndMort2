package com.uvg.javier.States

import com.uvg.javier.dataLocations.Location

data class LocationListState(
    val isLoading: Boolean = false,
    val data: List<Location>? = null,
    val hasError: Boolean = false
)