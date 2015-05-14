package com.multunus.moveit;


import android.content.Context;
import android.content.SharedPreferences;
import android.webkit.JavascriptInterface;

public class SharedPreferenceInterface {
   Context context;
   public static final String MAIN_SHARED_PREFERENCE = "MOVE_IT";


    public SharedPreferenceInterface(Context context) {
        this.context = context;
    }

    @JavascriptInterface
    public void putString(String key, String value){
        SharedPreferences.Editor editor = this.context.getSharedPreferences(MAIN_SHARED_PREFERENCE, Context.MODE_PRIVATE).edit();
        editor.putString(key, value);
        editor.commit();
    }
}
