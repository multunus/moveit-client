/*
       Licensed to the Apache Software Foundation (ASF) under one
       or more contributor license agreements.  See the NOTICE file
       distributed with this work for additional information
       regarding copyright ownership.  The ASF licenses this file
       to you under the Apache License, Version 2.0 (the
       "License"); you may not use this file except in compliance
       with the License.  You may obtain a copy of the License at

         http://www.apache.org/licenses/LICENSE-2.0

       Unless required by applicable law or agreed to in writing,
       software distributed under the License is distributed on an
       "AS IS" BASIS, WITHOUT WARRANTIES OR CONDITIONS OF ANY
       KIND, either express or implied.  See the License for the
       specific language governing permissions and limitations
       under the License.
 */

package com.multunus.moveit;

import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import com.multunus.moveit.alarms.DailyAlarms;
import com.multunus.moveit.network.NotificationFetcher;

import org.apache.cordova.*;

import java.util.concurrent.ScheduledThreadPoolExecutor;

public class MainActivity extends CordovaActivity
{
    public static final String PREFS_NAME = "MoveItPrefs";
    public static final String FIRST_RUN = "firstRun";


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        super.init();
        
        if(firstRun()){
          setAlarms();
        }
        loadUrl(launchUrl);
        super.appView.addJavascriptInterface(new SharedPreferenceInterface(getApplicationContext()), "SharedPreferenceInterface");

    }

    public void setAlarms(){
      Log.d("moveit", "Setting Alarms");
        Context context = getApplicationContext();
        DailyAlarms dailyAlarms = new DailyAlarms(context);
        dailyAlarms.setUpAlarms();
        didFirstRun();
    }

    public boolean firstRun(){
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        return settings.getBoolean(FIRST_RUN, true);
    }

    public void didFirstRun(){
        Log.d("moveit", "in did first run");
        SharedPreferences settings = getSharedPreferences(PREFS_NAME, 0);
        SharedPreferences.Editor editor = settings.edit();
        editor.putBoolean(FIRST_RUN, false).apply();
    }
}
