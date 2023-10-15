package com.jurgaitis.bluetoothscan.data.repository

import com.jurgaitis.bluetoothscan.domain.model.Device
import com.jurgaitis.bluetoothscan.domain.repository.DeviceRepository
import kotlinx.coroutines.flow.Flow

class DeviceRepositoryImpl(): DeviceRepository {
    override fun getDevices(): Flow<List<Device>> {
        TODO("Not yet implemented")
    }

    override suspend fun saveDevice(device: Device) {
        TODO("Not yet implemented")
    }

    override suspend fun deleteDevice(device: Device) {
        TODO("Not yet implemented")
    }
}