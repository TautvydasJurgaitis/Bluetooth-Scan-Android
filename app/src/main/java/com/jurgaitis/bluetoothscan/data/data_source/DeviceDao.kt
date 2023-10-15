package com.jurgaitis.bluetoothscan.data.data_source

import androidx.room.Dao
import androidx.room.Query
import com.jurgaitis.bluetoothscan.domain.model.Device
import kotlinx.coroutines.flow.Flow

@Dao
interface DeviceDao {

    @Query("SELECT * FROM device")
    fun getNotes(): Flow<List<Device>>
}