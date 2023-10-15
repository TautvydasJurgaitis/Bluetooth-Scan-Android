package com.jurgaitis.bluetoothscan.domain.controller

import com.jurgaitis.bluetoothscan.domain.model.Device
import kotlinx.coroutines.flow.StateFlow

interface BluetoothController {
    val scannedDevices: StateFlow<List<Device>>

    fun startDeviceScan()
    fun release()
}