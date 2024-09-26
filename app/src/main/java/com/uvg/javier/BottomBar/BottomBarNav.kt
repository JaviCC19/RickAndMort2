package com.uvg.javier.BottomBar


import androidx.activity.compose.BackHandler
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavOptions
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.uvg.javier.Screen2.CharacterRoute
import com.uvg.javier.Screen3.CharacterDetailDestination
import kotlinx.serialization.Serializable

@Serializable
data object BarDestination

fun NavGraphBuilder.BarScreen(
    onProfileClick: () -> Unit,
    onBackToLogin: () -> Unit
) {
    composable<BarDestination> {
        val navController = rememberNavController()
        BottomBar (
            navController = navController,
            onProfileClick = onProfileClick,
            onBackToLogin = onBackToLogin,
        )
        BackHandler {
            onBackToLogin()
        }
    }
}

fun NavController.navigateToBottomBarScreen(
    navOptions: NavOptions? = null
){
    this.navigate(BarDestination, navOptions)
}