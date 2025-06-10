package com.thechance.myweather.presentation.weather

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import org.koin.androidx.compose.koinViewModel


@Composable
fun WeatherScreenRoot() {
    val weatherViewModel: WeatherViewModel = koinViewModel()

    PermissionForLocationScreen(weatherViewModel)
}

@OptIn(ExperimentalPermissionsApi::class)
@Composable
fun PermissionForLocationScreen(
    weatherViewModel: WeatherViewModel,
) {
    val uiState = weatherViewModel.state.collectAsStateWithLifecycle()

    val locationPermissions = rememberMultiplePermissionsState(
        permissions = listOf(
            android.Manifest.permission.ACCESS_COARSE_LOCATION,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        )
    )

    LaunchedEffect(locationPermissions.allPermissionsGranted) {
        if (!locationPermissions.allPermissionsGranted) {
            locationPermissions.launchMultiplePermissionRequest()
        } else {
            weatherViewModel.getLocationAndLoadWeather()
        }
    }

    if (locationPermissions.allPermissionsGranted) {
        WeatherScreen(
            state = uiState.value
        )
    }
}