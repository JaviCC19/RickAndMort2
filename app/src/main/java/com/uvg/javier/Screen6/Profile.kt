    package com.uvg.javier.Screen6

    import androidx.compose.foundation.background
    import androidx.compose.foundation.layout.*
    import androidx.compose.foundation.shape.CircleShape
    import androidx.compose.material.icons.Icons
    import androidx.compose.material.icons.filled.AccountBox
    import androidx.compose.material.icons.filled.ArrowBack
    import androidx.compose.material3.*
    import androidx.compose.runtime.Composable
    import androidx.compose.ui.Alignment
    import androidx.compose.ui.Modifier
    import androidx.compose.ui.draw.clip
    import androidx.compose.ui.graphics.Color
    import androidx.compose.ui.layout.ContentScale
    import androidx.compose.ui.text.font.FontWeight
    import androidx.compose.ui.unit.dp
    import coil.compose.AsyncImage
    import coil.request.ImageRequest
    import androidx.compose.ui.platform.LocalContext
    import androidx.compose.ui.text.style.TextAlign
    import androidx.compose.ui.tooling.preview.Preview
    import androidx.navigation.NavController
    import com.uvg.javier.Screen5.LocationDetailScreen


    @Composable
    fun ProfileRoute(onProfileClick: () -> Unit,
                   modifier: Modifier = Modifier){
        UserProfileScreen (onProfileClick = onProfileClick, modifier = modifier)
    }

    @Composable
    fun UserProfileScreen(
        onProfileClick: () -> Unit,
        modifier: Modifier = Modifier
    ) {
        Scaffold(

        ) { paddingValues ->
            Column(
                modifier = Modifier
                    .fillMaxSize()
                    .padding(paddingValues)
                    .padding(16.dp),
                verticalArrangement = Arrangement.Center, // Centra verticalmente
                horizontalAlignment = Alignment.CenterHorizontally // Centra horizontalmente
            ) {
                Icon(Icons.Default.AccountBox,
                    contentDescription = null,
                    modifier = Modifier
                        .size(150.dp)
                        .clip(CircleShape)
                        .background(MaterialTheme.colorScheme.surface, shape = CircleShape)
                        .padding(8.dp)
                )
                Spacer(modifier = Modifier.height(16.dp))
                Text(
                    text = "Name: Javier",
                    style = MaterialTheme.typography.headlineMedium,
                    fontWeight = FontWeight.Bold
                )
                Spacer(modifier = Modifier.height(8.dp))
                Text(
                    text = "Carné: 23079",
                    style = MaterialTheme.typography.bodyLarge
                )
                Spacer(modifier = Modifier.height(24.dp))


                Button(onClick = { onProfileClick ()

                }) {
                    Text(text = "Cerrar sesión", textAlign = TextAlign.Center)
                }
            }
        }
    }


