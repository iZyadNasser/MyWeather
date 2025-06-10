package com.thechance.myweather.presentation.weather

import android.widget.Toast
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import com.google.accompanist.permissions.ExperimentalPermissionsApi
import com.google.accompanist.permissions.rememberMultiplePermissionsState
import com.thechance.myweather.presentation.ui.theme.DayThemeColor
import com.thechance.myweather.presentation.utils.ObserveAsEvent
import org.koin.androidx.compose.koinViewModel


@Composable
fun WeatherScreenRoot() {
    val weatherViewModel: WeatherViewModel = koinViewModel()

    val context = LocalContext.current

    ObserveAsEvent(weatherViewModel.event) { event ->
        when (event) {
            is WeatherEvent.HandleError -> {
                Toast.makeText(
                    context,
                    event.message.asString(context),
                    Toast.LENGTH_LONG
                ).show()
            }
        }
    }

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