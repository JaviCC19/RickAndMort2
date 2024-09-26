package com.uvg.javier.Screen5

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.toRoute
import com.uvg.javier.Screen3.CharacterProfileRoute
import kotlinx.serialization.Serializable

@Serializable
data class LocationDetailsDestination(
    val locationId: Int
)

fun NavController.navigateToLocationDetailsScreen(
    destination: LocationDetailsDestination,
    navOptions: NavOptions? = null
){
    this.navigate(destination, navOptions)
}

fun NavGraphBuilder.LocationDetailScreen(onNavigateBack: () -> Unit){
    composable<LocationDetailsDestination> { backStackEntry ->
        val destination: LocationDetailsDestination = backStackEntry.toRoute()
        LocationsDetailsRoute (
            LocationId = destination.locationId,
            onNavigateBack = onNavigateBack
        )
    }
}