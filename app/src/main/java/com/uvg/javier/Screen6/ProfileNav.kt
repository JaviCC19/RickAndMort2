package com.uvg.javier.Screen6

import LoginRoute
import androidx.navigation.compose.composable
import kotlinx.serialization.Serializable
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavGraphBuilder


@Serializable
data object ProfileDestination

fun NavGraphBuilder.ProfileScreen(
    onProfileClick: () -> Unit
){
    composable<ProfileDestination>{
        ProfileRoute(
            onProfileClick = onProfileClick,
            modifier = Modifier.fillMaxWidth()

        )
    }
}