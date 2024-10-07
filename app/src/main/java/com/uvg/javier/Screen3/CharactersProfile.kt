package com.uvg.javier.Screen3

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.uvg.javier.Factorys.CharacterProfileViewModelFactory
import com.uvg.javier.Loading.ErrorScreen
import com.uvg.javier.Loading.LoadingScreen
import com.uvg.javier.ViewModels.CharacterProfileViewModel
import com.uvg.javier.dataCharacters.Character


@Composable
fun CharacterProfileRoute(
    characterId : Int,
    onNavigateBack: () -> Unit,
    viewModel: CharacterProfileViewModel = viewModel(factory = CharacterProfileViewModelFactory(characterId))
) {
    val state by viewModel.state.collectAsState()

    when {
        state.isLoading -> LoadingScreen(onClick = { viewModel.setError() })
        state.hasError -> ErrorScreen(onRetry = { viewModel.retry() })
        else -> CharacterDetailScreen(
            characterId = state.data!!,
            onBackClick = onNavigateBack,

        )
    }
}
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CharacterDetailScreen(
    characterId: Character,
    onBackClick: () -> Unit,

) {


    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Character Details") },
                navigationIcon = {
                    IconButton(onClick = onBackClick) {
                        Icon(Icons.Default.ArrowBack, contentDescription = null)
                    }
                },
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primary // Usa el color primario del tema
                )
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(paddingValues)
                .padding(16.dp),
            verticalArrangement = Arrangement.Center, // Centra verticalmente
            horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
        ) {
            AsyncImage(
                model = ImageRequest.Builder(LocalContext.current)
                    .data(characterId.image)
                    .crossfade(true)
                    .build(),
                contentDescription = null,
                modifier = Modifier
                    .size(150.dp)
                    .clip(CircleShape) // Hacer que la imagen sea circular
                    .background(MaterialTheme.colorScheme.surface, shape = CircleShape)
                    .padding(8.dp)
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Name: ${characterId.name}", style = MaterialTheme.typography.headlineMedium)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Species: ${characterId.species}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Status: ${characterId.status}", style = MaterialTheme.typography.bodyLarge)
            Spacer(modifier = Modifier.height(8.dp))
            Text(text = "Gender: ${characterId.gender}", style = MaterialTheme.typography.bodyLarge)
        }
    }
}