package com.jurgaitis.bluetoothscan.presentation.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.findNavController
import com.jurgaitis.bluetoothscan.domain.model.Device

@Composable
fun ScannedDevicesScreen(scannedDevices: List<Device>
) {
    Column(
        modifier = Modifier.fillMaxWidth()
    ) {
        ScannedDevices(scannedDevices)
    }
}

@Composable
fun ScannedDevices(scannedDevices: List<Device>) {
    LazyColumn() {
        item {
            Text(text = "Scanned devices")
        }

        itemsIndexed(items = scannedDevices) {index, item ->
            Text(text = item.name ?: "Unknow")
        }
    }
}