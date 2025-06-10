package com.thechance.myweather.data.dataSource

import android.content.Context
import android.content.pm.PackageManager
import android.location.Address
import android.location.Geocoder
import android.location.Location
import android.location.LocationManager
import android.os.Build
import androidx.core.content.ContextCompat
import com.google.android.gms.location.FusedLocationProviderClient
import com.thechance.myweather.domain.dataSource.LocationDataSource
import com.thechance.myweather.domain.model.UserLocation
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import java.util.Locale
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine

class LocationDataSourceImpl(
    private val context: Context,
    private val fusedLocationProviderClient: FusedLocationProviderClient
) : LocationDataSource {
    override suspend fun getCurrentLocation(): Result<UserLocation> {
        val hasGrantedFineLocationPermission = ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_FINE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val hasGrantedCoarseLocationPermission = ContextCompat.checkSelfPermission(
            context,
            android.Manifest.permission.ACCESS_COARSE_LOCATION
        ) == PackageManager.PERMISSION_GRANTED

        val locationManager = context.getSystemService(
            Context.LOCATION_SERVICE
        ) as LocationManager

        val isGpsEnabled = locationManager.isProviderEnabled(LocationManager.NETWORK_PROVIDER) ||
                locationManager.isProviderEnabled(LocationManager.GPS_PROVIDER)

        if (!isGpsEnabled && !(hasGrantedCoarseLocationPermission || hasGrantedFineLocationPermission)) {
            return Result.failure(SecurityException("Missing location permission"))
        }

        return locationToUserLocation(fusedLocationProviderClient.lastLocation.await())
    }

    private suspend fun locationToUserLocation(location: Location): Result<UserLocation> {
        return try {
            val city = getCityName(location.latitude, location.longitude)

            Result.success(
                UserLocation(
                    latitude = location.latitude,
                    longitude = location.longitude,
                    cityName = city
                )
            )
        } catch (e: Exception) {
            Result.failure(e)
        }

    }

    suspend fun getCityName(
        lat: Double,
        lon: Double
    ): String? {
        return if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            getCityNameModern(context, lat, lon)
        } else {
            getCityNameLegacy(context, lat, lon)
        }
    }

    @Suppress("DEPRECATION")
    private suspend fun getCityNameLegacy(
        context: Context,
        lat: Double,
        lon: Double
    ): String? = withContext(Dispatchers.IO) {
        try {
            Geocoder(context, Locale.getDefault()).let { geocoder ->
                geocoder.getFromLocation(lat, lon, 1)?.firstOrNull()?.toCityName()
            }
        } catch (_: Exception) {
            null
        }
    }

    @androidx.annotation.RequiresApi(Build.VERSION_CODES.TIRAMISU)
    private suspend fun getCityNameModern(
        context: Context,
        lat: Double,
        lon: Double
    ): String? = withContext(Dispatchers.IO) {
        try {
            val geocoder = Geocoder(context, Locale.getDefault())
            suspendCoroutine<String?> { continuation ->
                geocoder.getFromLocation(lat, lon, 1, object : Geocoder.GeocodeListener {
                    override fun onGeocode(addresses: List<Address>) {
                        continuation.resume(addresses.firstOrNull()?.toCityName())
                    }

                    override fun onError(errorMessage: String?) {
                        continuation.resume(null)
                    }
                })
            }
        } catch (_: Exception) {
            null
        }
    }

    private fun Address?.toCityName(): String? {
        return this?.let {
            it.locality ?: it.subAdminArea ?: it.adminArea
        }
    }
}