package com.uvg.javier

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.rememberNavController
import com.uvg.javier.BottomBar.BarDestination
import com.uvg.javier.BottomBar.BarScreen
import com.uvg.javier.Screen1.LoginDestination
import com.uvg.javier.ui.theme.MyApplicationTheme
import com.uvg.javier.Screen1.loginScreen
import com.uvg.javier.Screen2.CharacterDestination
import com.uvg.javier.Screen2.characterScreen
import com.uvg.javier.Screen3.CharacterDetailDestination
import com.uvg.javier.Screen3.characterDetailScreen
import com.uvg.javier.Screen3.navigateToCharacterDetailScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MyApplicationTheme{
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    val navController = rememberNavController()
                    NavHost(
                        navController = navController,
                        startDestination = LoginDestination,
                        modifier = Modifier.fillMaxSize().padding(innerPadding)
                    ) {

                        loginScreen(
                            onLoginClick = {

                                navController.navigate(BarDestination) {
                                    popUpTo(LoginDestination) {
                                        inclusive = true
                                    }
                                }
                            }
                        )


                        BarScreen(
                            onProfileClick = {navController.navigate(LoginDestination) {popUpTo(0)} },

                            onBackToLogin = {
                                finish()
                            }
                        )


                    }
                }
            }
        }
    }
}