package com.uvg.javier.Screen4

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.uvg.javier.Screen2.CharacterDestination
import com.uvg.javier.Screen2.characterScreen
import com.uvg.javier.Screen3.CharacterDetailDestination
import com.uvg.javier.Screen3.characterDetailScreen
import com.uvg.javier.Screen3.navigateToCharacterDetailScreen
import com.uvg.javier.Screen5.LocationDetailScreen
import com.uvg.javier.Screen5.LocationDetailsDestination
import com.uvg.javier.Screen5.navigateToLocationDetailsScreen
import kotlinx.serialization.Serializable

@Serializable
data object LocationDestination2

fun NavGraphBuilder.locationScreen2(
    navController: NavController
) {
    navigation<LocationDestination2>(LocationDestination) {
        locationScreen(
            onLocationClick = {
                    id -> navController.navigateToLocationDetailsScreen(LocationDetailsDestination(id))
            }
        )
        LocationDetailScreen(onNavigateBack = navController::navigateUp)
    }
}