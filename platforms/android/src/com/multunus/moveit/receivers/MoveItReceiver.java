package com.multunus.moveit.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

import java.util.Calendar;

public class MoveItReceiver extends BroadcastReceiver {
    public MoveItReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
        throw new UnsupportedOperationException("Not yet implemented");
    }

    public boolean eligibleToNotify(int lateHour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        Log.d("moveit", String.valueOf(currentHour));
        if(currentHour > lateHour){
            return false;
        }
        return true;
    }

}
