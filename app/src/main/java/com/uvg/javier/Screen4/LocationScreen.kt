package com.uvg.javier.Screen4

import android.provider.CallLog.Locations
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.uvg.javier.dataCharacters.Character
import com.uvg.javier.dataCharacters.CharacterDb
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.ui.tooling.preview.Preview
import com.uvg.javier.dataLocations.Location
import com.uvg.javier.dataLocations.LocationDb


@Composable
fun LocationsRoute(
    onLocationClick: (Int) -> Unit,
    modifier: Modifier = Modifier
){
    val locationState by remember { mutableStateOf(LocationDb().getAllLocations()) }

    LocationsListScreen(onLocationClick = onLocationClick, location = locationState, modifier = modifier)
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun LocationsListScreen(
    modifier: Modifier = Modifier,
    location: List<Location>,
    onLocationClick: (Int) -> Unit) {
    Scaffold(

    ) { paddingValues ->
        val locationDb = remember { LocationDb() }
        val locations = locationDb.getAllLocations()

        LazyColumn(contentPadding = paddingValues) {
            items(locations.size) { location ->
                com.uvg.javier.Screen4.LocationsListItem(
                    location = locations[location],
                    onClick = onLocationClick
                )
            }
        }
    }
}


@Composable
fun LocationsListItem(location: Location, onClick: (Int) -> Unit) {
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .clickable { onClick(location.id) }
            .padding(8.dp)
    ) {

        Spacer(modifier = Modifier.width(8.dp))
        Column {
            Text(text = location.name, style = MaterialTheme.typography.bodyLarge)
            Text(text = location.type, style = MaterialTheme.typography.bodySmall)
        }
    }
}

