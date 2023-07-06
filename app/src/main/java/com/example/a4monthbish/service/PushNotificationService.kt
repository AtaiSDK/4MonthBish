package com.example.a4monthbish.service

import android.app.Notification
import android.app.NotificationChannel
import android.app.NotificationManager
import androidx.core.app.NotificationManagerCompat
import com.example.a4monthbish.R
import com.google.firebase.messaging.FirebaseMessagingService
import com.google.firebase.messaging.RemoteMessage


class PushNotificationService: FirebaseMessagingService() {

    override fun onMessageReceived(message: RemoteMessage) {
        super.onMessageReceived(message)


        val channel = NotificationChannel(
            CHANNEL_ID,
            "Heads Up Notification",
            NotificationManager.IMPORTANCE_HIGH
        )
        getSystemService(NotificationManager::class.java).createNotificationChannel(channel)
        val notification = Notification.Builder(this, CHANNEL_ID)
        notification.setSmallIcon(R.mipmap.ic_launcher)
            notification.setContentTitle(message.notification?.title)
            notification.setContentText(message.notification?.body)
            notification.setAutoCancel(false)

        NotificationManagerCompat.from(this).notify(1, notification.build())
    }
    companion object{
        const val CHANNEL_ID = "HEADS_UP_NOTIFICATION"
    }
}