package com.jurgaitis.bluetoothscan.domain.repository

import com.jurgaitis.bluetoothscan.domain.model.Device
import kotlinx.coroutines.flow.Flow

interface DeviceRepository {
    fun getDevices(): Flow<List<Device>>
    suspend fun saveDevice(device: Device)
    suspend fun deleteDevice(device: Device)
}