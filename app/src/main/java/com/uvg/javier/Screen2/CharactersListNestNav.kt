package com.uvg.javier.Screen2

import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.uvg.javier.Screen3.CharacterDetailDestination
import com.uvg.javier.Screen3.characterDetailScreen
import com.uvg.javier.Screen3.navigateToCharacterDetailScreen
import kotlinx.serialization.Serializable

@Serializable
data object CharacterDestination2

fun NavGraphBuilder.characterScreen2(
    navController: NavController,
    onBackToLogin: () -> Unit
) {
    navigation<CharacterDestination2>(CharacterDestination) {
        characterScreen(
            onCharacterClick = { id ->
                navController.navigateToCharacterDetailScreen(CharacterDetailDestination(id))
            },
            onBackToLogin = onBackToLogin
        )

        characterDetailScreen(onNavigateBack = {
            navController.navigateUp()
        })
    }
}
