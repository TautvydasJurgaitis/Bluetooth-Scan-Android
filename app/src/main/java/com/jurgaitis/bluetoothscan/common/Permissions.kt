package com.jurgaitis.bluetoothscan.common

import android.content.Context
import android.content.pm.PackageManager

class Permissions {
    companion object {
        fun hasPermission(context: Context, permissionType: String): Boolean {
            return context.checkSelfPermission(permissionType) == PackageManager.PERMISSION_GRANTED
        }
    }
}