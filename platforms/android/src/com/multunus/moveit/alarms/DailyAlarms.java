package com.multunus.moveit.alarms;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;

import com.multunus.moveit.Configuration;
import com.multunus.moveit.receivers.MorningNotificationReceiver;
import com.multunus.moveit.receivers.EveningNotificationReceiver;

import java.util.Calendar;

/**
 * Created by popeye on 27/4/15.
 */
public class DailyAlarms {
    public Context context;

    public DailyAlarms(Context context) {
      this.context = context;
    }

    public void setUpAlarms(){
        setUpMorningAlarm();
        setUpEveningAlarm();
    }

    protected void setUpMorningAlarm(){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, MorningNotificationReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 0, intent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, Configuration.MorningNotification.HOUR);
        calendar.set(Calendar.MINUTE, Configuration.MorningNotification.MINUTE);
        calendar.set(Calendar.SECOND, Configuration.MorningNotification.SECOND);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
    }

    protected void setUpEveningAlarm(){
        AlarmManager alarmManager = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        Intent intent = new Intent(context, EveningNotificationReceiver.class);
        PendingIntent alarmIntent = PendingIntent.getBroadcast(context, 1, intent, 0);
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        calendar.set(Calendar.HOUR_OF_DAY, Configuration.EveningNotification.HOUR);
        calendar.set(Calendar.MINUTE, Configuration.EveningNotification.MINUTE);
        calendar.set(Calendar.SECOND, Configuration.EveningNotification.SECOND);
        alarmManager.setInexactRepeating(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), AlarmManager.INTERVAL_DAY, alarmIntent);
    }
}
