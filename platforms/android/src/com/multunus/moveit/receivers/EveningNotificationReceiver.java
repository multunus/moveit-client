package com.multunus.moveit.receivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import com.multunus.moveit.MainActivity;
import com.multunus.moveit.R;

public class EveningNotificationReceiver extends MoveItReceiver {
    public static final int LATE_HOUR = 19;
    int notificationId = 502;
    public EveningNotificationReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        Log.d("moveit", "onreceive evening alarm");
        if(eligibleToNotify(LATE_HOUR)){
            Intent activityIntent = new Intent(context, MainActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(context, 0, activityIntent, 0);

            Notification n = new Notification.Builder(context)
                    .setContentTitle(context.getString(R.string.evening_notification_title))
                    .setContentText(context.getString(R.string.evening_notification_text))
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentIntent(pIntent)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setAutoCancel(true)
                    .setStyle(new Notification.BigTextStyle()
                            .bigText(context.getString(R.string.evening_notification_text)))
                    .build();

            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify(notificationId, n);
        }
    }


}