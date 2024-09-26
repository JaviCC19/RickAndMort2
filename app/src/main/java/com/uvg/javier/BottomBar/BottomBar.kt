package com.uvg.javier.BottomBar

import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountBox
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Place
import androidx.compose.material.icons.outlined.AccountBox
import androidx.compose.material.icons.outlined.List
import androidx.compose.material.icons.outlined.Person
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavController
import com.uvg.javier.Screen2.CharacterDestination2
import com.uvg.javier.Screen4.LocationDestination2
import com.uvg.javier.Screen6.ProfileDestination


class BottomNavigationItem(val label: String, val selectedIcon: ImageVector,val unselectedIcon: ImageVector, val onClick: Any) {

}

val BottomNavigationBar = listOf(
        BottomNavigationItem(
            label = "Character",
            selectedIcon = Icons.Filled.Person,
            unselectedIcon = Icons.Outlined.Person,
            onClick = CharacterDestination2
        ),
        BottomNavigationItem(
            label = "Location",
            selectedIcon = Icons.Filled.List,
            unselectedIcon = Icons.Outlined.List,
            onClick = LocationDestination2
        ),
        BottomNavigationItem(
            label = "Profile",
            selectedIcon = Icons.Filled.AccountBox,
            unselectedIcon = Icons.Outlined.AccountBox,
            onClick = ProfileDestination
        )

)


