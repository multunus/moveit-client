package com.multunus.moveit.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

import com.multunus.moveit.alarms.DailyAlarms;

public class OnBootReceiver extends BroadcastReceiver {
    public OnBootReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        DailyAlarms dailyAlarms = new DailyAlarms(context);
        dailyAlarms.setUpAlarms();
    }
}
