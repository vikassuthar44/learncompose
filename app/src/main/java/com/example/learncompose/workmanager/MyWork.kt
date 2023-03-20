package com.example.learncompose.workmanager

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import android.os.Build
import androidx.core.app.NotificationCompat
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.learncompose.R

class MyWork constructor(context: Context, workerParameters: WorkerParameters): Worker(context,workerParameters) {

    override fun doWork(): Result {
        createNotification(title = "Background Notification", description = " This is sample for background notification using work manager")
        return Result.success()
    }


    private fun createNotification(title:String, description:String) {
        val notificationManager = applicationContext.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager

        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O) {
            val notificationChannel = NotificationChannel("101","channel",NotificationManager.IMPORTANCE_DEFAULT)
            notificationManager.createNotificationChannel(notificationChannel)
        }

        val notificationBuilder = NotificationCompat.Builder(applicationContext, "101")
            .setContentTitle(title)
            .setContentText(description)
            .setSmallIcon(R.drawable.ic_launcher_background)

        notificationManager.notify(1,notificationBuilder.build())
    }
}