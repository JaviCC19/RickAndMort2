package com.uvg.javier.Screen4

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import com.uvg.javier.Screen2.CharacterRoute
import kotlinx.serialization.Serializable

@Serializable
data object LocationDestination

fun NavGraphBuilder.locationScreen(
    onLocationClick: (Int) -> Unit,
) {
    composable<LocationDestination> {
        LocationsRoute(
            onLocationClick = onLocationClick,
            modifier = Modifier.fillMaxWidth()
        )

    }

}