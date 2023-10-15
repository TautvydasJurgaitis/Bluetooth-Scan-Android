package com.jurgaitis.bluetoothscan.data.data_source

import androidx.room.Database
import androidx.room.RoomDatabase
import com.jurgaitis.bluetoothscan.domain.model.Device

@Database(
    entities = [Device::class],
    version = 1
)
abstract class DeviceDatabase: RoomDatabase() {
    abstract val deviceDao: DeviceDao

    companion object {
        const val DATABASE_NAME = "device_db"
    }
}