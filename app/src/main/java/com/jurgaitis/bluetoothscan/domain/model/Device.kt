package com.jurgaitis.bluetoothscan.domain.model

import android.annotation.SuppressLint
import android.bluetooth.BluetoothDevice
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Device(
    val name: String?,
    @PrimaryKey
    val macAddress: String
) {
    @SuppressLint("MissingPermission")
    companion object {
        fun mapToDevice(bluetoothDevice: BluetoothDevice): Device {
            return Device(
                bluetoothDevice.name,
                bluetoothDevice.address
            )
        }
    }
}
