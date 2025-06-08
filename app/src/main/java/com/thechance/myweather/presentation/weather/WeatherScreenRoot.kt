package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import org.koin.androidx.compose.koinViewModel
import org.koin.compose.getKoin

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun WeatherScreenRoot() {
    val weatherViewModel: WeatherViewModel = koinViewModel()
    val uiState = weatherViewModel.state.collectAsStateWithLifecycle()

    val interactionHandler: InteractionHandler = getKoin().get()

    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    LaunchedEffect(Unit) {
        if (!locationPermissions.allPermissionsGranted || locationPermissions.shouldShowRationale) {
            locationPermissions.launchMultiplePermissionRequest()
        } else {
            interactionHandler.getUserLocation()
        }
    }

    WeatherScreen(
        state = uiState.value,
        interactionHandler = interactionHandler
    )
}