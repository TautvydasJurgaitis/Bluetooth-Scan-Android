package com.jurgaitis.bluetoothscan.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.jurgaitis.bluetoothscan.domain.controller.BluetoothController
import com.jurgaitis.bluetoothscan.domain.model.Device
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BluetoothViewModel @Inject constructor(
    private val bluetoothController: BluetoothController
): ViewModel() {
    private val _scannedDevices = MutableStateFlow<List<Device>>(emptyList())
    val scannedDevices = bluetoothController.scannedDevices

    fun startScan() {
        bluetoothController.startDeviceScan()
    }

    fun releaseBluetooth() {
        bluetoothController.release()
    }

    suspend fun saveDeviceToDatabase() {
        scannedDevices.collect { data ->
            // every time anything changes, the code inside collect is going to get called again
        }
    }
}