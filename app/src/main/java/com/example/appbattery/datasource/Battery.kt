package com.example.appbattery.datasource

import android.content.Context
import android.os.BatteryManager
import com.example.appbattery.mobile.BatteryStatus

class Battery {

fun getBatteryInfo(context: Context): BatteryStatus{
    val batteryManager=context.getSystemService(Context.BATTERY_SERVICE)  as BatteryManager
    val batteryLevel = batteryManager.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY)

    return BatteryStatus(batteryLevel)
   }
}