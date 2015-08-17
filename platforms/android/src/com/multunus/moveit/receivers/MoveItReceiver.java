package com.multunus.moveit.receivers;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.content.SharedPreferences;
import com.multunus.moveit.SharedPreferenceInterface;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;

public class MoveItReceiver extends BroadcastReceiver {
	Context context;
    public MoveItReceiver() {
    }

    @Override
    public void onReceive(Context context, Intent intent) {
    	this.context = context;
    }

    public boolean eligibleToNotify(int lateHour){
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(System.currentTimeMillis());
        int currentHour = calendar.get(Calendar.HOUR_OF_DAY);
        Log.d("moveit", String.valueOf(currentHour));
        if(isEntryMadeToday()){
        	return false;
        }
        if(currentHour > lateHour){
            return false;
        }
        return true;
    }

	private boolean isEntryMadeToday() {
        SharedPreferences sharedPreferences = this.context.getSharedPreferences(SharedPreferenceInterface.MAIN_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        String lastEntryMadeOn = sharedPreferences.getString("lastEntryMadeOn", "");
        Date entryDate = new Date();
        
        try {
          DateFormat df = new SimpleDateFormat("EEE MMM d yyyy", Locale.ENGLISH);
          entryDate = df.parse(lastEntryMadeOn); 
	    } catch (ParseException e) {
   		  e.printStackTrace();
   	    }
        
        Calendar c = Calendar.getInstance();
        c.set(Calendar.HOUR_OF_DAY, 0);
        c.set(Calendar.MINUTE, 0);
        c.set(Calendar.SECOND, 0);
        c.set(Calendar.MILLISECOND, 0);
        Date today = c.getTime();
        
        if(entryDate.equals(today)) {
        	return true;
	    } else {
	        return false;
	    }
		
	}

}
