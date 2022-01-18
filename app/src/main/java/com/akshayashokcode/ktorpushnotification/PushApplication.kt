package com.akshayashokcode.ktorpushnotification

import android.app.Application
import com.onesignal.OneSignal

class PushApplication :Application(){
    override fun onCreate() {
        super.onCreate()
        OneSignal.initWithContext(this)
        OneSignal.setAppId(ONESIGNAL_APP_ID)
    }
    companion object{
        private const val ONESIGNAL_APP_ID="877b0e06-ce04-4a62-9e8d-7dced205058e"
    }
}