package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import org.koin.androidx.compose.koinViewModel

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherScreenRoot() {
    val weatherViewModel: WeatherViewModel = koinViewModel()
    val uiState = weatherViewModel.state.collectAsStateWithLifecycle()

    //val interactionHandler: InteractionHandler = getKoin().get()

    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    LaunchedEffect(locationPermissions.allPermissionsGranted || locationPermissions.shouldShowRationale) {
        if (!locationPermissions.allPermissionsGranted || locationPermissions.shouldShowRationale) {
            locationPermissions.launchMultiplePermissionRequest()
        } else {
            weatherViewModel.getUserLocation()
        }
    }

    WeatherScreen(
        state = uiState.value,
    )
}