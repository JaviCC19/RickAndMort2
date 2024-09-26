package com.uvg.javier.BottomBar

import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavController
import androidx.navigation.NavDestination.Companion.hierarchy

import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.javier.Screen2.CharacterDestination2
import com.uvg.javier.Screen2.characterScreen2
import com.uvg.javier.Screen4.locationScreen2
import com.uvg.javier.Screen6.ProfileScreen

@Composable
fun BottomBar(navController: NavHostController = rememberNavController(), onProfileClick: () -> Unit, onBackToLogin: ()-> Unit) {
    Scaffold(
        bottomBar = {
            NavigationBar {
                BottomNavigationBar.forEach { BottomNavigationItem ->
                    val isSelected = navController.currentDestination?.hierarchy?.any { it.route == BottomNavigationItem.onClick } ?: false
                    NavigationBarItem(
                        selected = isSelected,
                        onClick = {
                            navController.navigate(BottomNavigationItem.onClick) {
                                popUpTo(navController.graph.startDestinationId) {
                                    saveState = true
                                }
                                launchSingleTop = true
                                restoreState = true
                            }
                        },
                        label = { Text(text = BottomNavigationItem.label) },
                        icon = {
                            Icon(
                                imageVector = if (isSelected) {
                                    BottomNavigationItem.selectedIcon
                                } else BottomNavigationItem.unselectedIcon,
                                contentDescription = BottomNavigationItem.label
                            )
                        }
                    )
                }
            }
        }
    ) { innerPadding ->
        NavHost(
            navController = navController,
            startDestination = CharacterDestination2,
            modifier = Modifier
                .fillMaxSize()
                .padding(innerPadding)
        ) {
            characterScreen2(navController, onBackToLogin =  onBackToLogin)
            locationScreen2(navController)
            ProfileScreen(onProfileClick = onProfileClick)
        }
    }
}
