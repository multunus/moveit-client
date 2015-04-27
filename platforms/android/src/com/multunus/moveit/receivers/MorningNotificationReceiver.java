package com.multunus.moveit.receivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.multunus.moveit.MainActivity;
import com.multunus.moveit.R;

public class MorningNotificationReceiver extends BroadcastReceiver {
    int notificationId = 500;

    public MorningNotificationReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent activityIntent = new Intent(context,MainActivity.class);
        PendingIntent pIntent = PendingIntent.getActivity(context, 0, activityIntent, 0);

        Notification n  = new Notification.Builder(context)
                .setContentTitle(context.getString(R.string.morning_notification_title))
                .setContentText(context.getString(R.string.morning_notification_text))
                .setSmallIcon(R.drawable.ic_notification)
                .setContentIntent(pIntent)
                .setDefaults(Notification.DEFAULT_ALL)
                .setStyle(new Notification.BigTextStyle()
                        .bigText(context.getString(R.string.morning_notification_text)))
                .setAutoCancel(true).build();

        NotificationManager notificationManager =
                (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

        notificationManager.notify( notificationId, n);
    }
}
