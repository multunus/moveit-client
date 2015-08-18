package com.multunus.moveit.receivers;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.util.Log;

import com.multunus.moveit.Configuration;
import com.multunus.moveit.MainActivity;
import com.multunus.moveit.R;
import com.multunus.moveit.SharedPreferenceInterface;
import com.multunus.moveit.network.NotificationFetcher;

import org.json.JSONObject;

public class MorningNotificationReceiver extends MoveItReceiver implements NotificationFetcher.NotificationFetchListener{
    public static final int LATE_HOUR = 7;
    int notificationId = 500;
    Context context;

    public MorningNotificationReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        this.context = context;
        Log.d("moveit", "onreceive morning");
        if(eligibleToNotify(LATE_HOUR)){
            SharedPreferences sharedPreferences = context.getSharedPreferences(SharedPreferenceInterface.MAIN_SHARED_PREFERENCE, Context.MODE_PRIVATE);
            String email = sharedPreferences.getString("email", "");
            NotificationFetcher notificationFetcher = new NotificationFetcher(this);
            notificationFetcher.execute(Configuration.NOTIFICATION_URL, email, String.valueOf(Configuration.MorningNotification.HOUR));
        }
    }

    @Override
    public void onNotificationSuccess(JSONObject jsonObject) {
        try {
            String shortMessage = jsonObject.getString("short");
            String longMessage = jsonObject.getString("long");
            String activity = jsonObject.getString("activity");
            Log.d("moveit", "morning l = " + longMessage + " s " + shortMessage);

            if(activity == ""){
	        	return;
	        }

            Intent activityIntent = new Intent(context,MainActivity.class);
            PendingIntent pIntent = PendingIntent.getActivity(context, 0, activityIntent, 0);

            Notification n  = new Notification.Builder(context)
                    .setContentTitle(shortMessage)
                    .setContentText(longMessage)
                    .setSmallIcon(R.drawable.ic_notification)
                    .setContentIntent(pIntent)
                    .setDefaults(Notification.DEFAULT_ALL)
                    .setStyle(new Notification.BigTextStyle()
                            .bigText(longMessage))
                    .setAutoCancel(true).build();

            NotificationManager notificationManager =
                    (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);

            notificationManager.notify( notificationId, n);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
