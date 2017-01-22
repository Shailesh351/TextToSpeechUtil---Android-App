package me.shell.texttospeechutil;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;

/**
 * Created by shell on 21/1/17.
 */

public class ServiceState {

    public static final String PREF_NAME = "TTSU";
    public static final String IS_SERVICE_ON = "is_logged_in";
    public static final int PRIVATE_MODE = 0;

    private SharedPreferences mSharedPreference;
    private SharedPreferences.Editor mEditor;

    ServiceState(Context context){
        mSharedPreference = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE);
        mEditor = mSharedPreference.edit();
    }

    public boolean isServiceOn(){
        String state = mSharedPreference.getString(IS_SERVICE_ON,null);
        if(state != null){
            if (state.equals("true")) {
                return true;
            }
        }
        return false;
    }

    public static boolean isServiceOn(Context context){
        String state = context.getSharedPreferences(PREF_NAME,PRIVATE_MODE).getString(IS_SERVICE_ON,null);
        if(state != null){
            if (state.equals("true")) {
                return true;
            }
        }
        return false;
    }

    public void setServiveState(boolean state){
        mEditor.clear().commit();
        if(state == true){
            mEditor.putString(IS_SERVICE_ON,"true");
            mEditor.commit();
        }else {
            mEditor.putString(IS_SERVICE_ON,"false");
            mEditor.commit();
        }
    }
}
