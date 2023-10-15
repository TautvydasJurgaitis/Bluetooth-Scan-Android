package com.jurgaitis.bluetoothscan.data.controller

import android.Manifest
import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import android.bluetooth.BluetoothManager
import android.content.Context
import android.content.IntentFilter
import com.jurgaitis.bluetoothscan.common.Permissions
import com.jurgaitis.bluetoothscan.data.receiver.FoundDeviceReceiver
import com.jurgaitis.bluetoothscan.domain.controller.BluetoothController
import com.jurgaitis.bluetoothscan.domain.model.Device
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update

@SuppressLint("MissingPermission")
class DeviceBluetoothController(private val context: Context) : BluetoothController {
    private val _scannedDevices = MutableStateFlow<List<Device>>(emptyList())
    override val scannedDevices: StateFlow<List<Device>>
        get() = _scannedDevices.asStateFlow()

    private val bluetoothManager by lazy {
        context.getSystemService(BluetoothManager::class.java)
    }

    private val bluetoothAdapter by lazy {
        bluetoothManager?.adapter
    }

    private val foundDeviceReceiver = FoundDeviceReceiver { newDevice ->
        _scannedDevices.update {
            if (Device.mapToDevice(newDevice) in it) {
                it
            } else {
                it + Device.mapToDevice(newDevice)
            }
        }
    }

    override fun startDeviceScan() {
        if(!Permissions.hasPermission(context, Manifest.permission.BLUETOOTH_SCAN)) {
            return
        }

        context.registerReceiver(foundDeviceReceiver,
            IntentFilter(BluetoothDevice.ACTION_FOUND)
        )
        bluetoothAdapter?.startDiscovery()
    }

    override fun release() {
        context.unregisterReceiver(foundDeviceReceiver)
    }
}