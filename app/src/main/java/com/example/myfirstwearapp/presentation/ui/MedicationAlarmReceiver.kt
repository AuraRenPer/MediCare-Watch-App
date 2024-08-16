package com.example.myfirstwearapp.ui

import android.annotation.SuppressLint
import android.content.BroadcastReceiver
import android.content.Context
import android.content.Intent
import androidx.core.app.NotificationCompat
import androidx.core.app.NotificationManagerCompat
import com.example.myfirstwearapp.R

@SuppressLint("MissingPermission")
class MedicationAlarmReceiver : BroadcastReceiver() {
    override fun onReceive(context: Context, intent: Intent) {
        val medicationName = intent.getStringExtra("medication_name") ?: "Medicamento"
        val notificationId = intent.getIntExtra("notification_id", 0)

        val builder = NotificationCompat.Builder(context, "medication_channel")
            .setSmallIcon(R.drawable.brocoli)
            .setContentTitle("Es hora de tu medicamento")
            .setContentText("Es hora de tomar $medicationName")
            .setPriority(NotificationCompat.PRIORITY_HIGH)
            .setAutoCancel(true)

        val notificationManager = NotificationManagerCompat.from(context)
        notificationManager.notify(notificationId, builder.build())
    }
}
