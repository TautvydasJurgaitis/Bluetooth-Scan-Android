package com.jurgaitis.bluetoothscan.di

import android.content.Context
import com.jurgaitis.bluetoothscan.data.controller.DeviceBluetoothController
import com.jurgaitis.bluetoothscan.domain.controller.BluetoothController
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideBluetoothController(@ApplicationContext context: Context): BluetoothController {
        return DeviceBluetoothController(context)
    }
}