package com.rl.kanmeitu.util;

import android.content.Context;
import android.content.SharedPreferences;

public class SharedPrefrenceUtil {
    private static final String TAG = "TAG";
    private static final String KEY_LOGIN = "KEY_LOGIN";

    private static SharedPreferences mPreferences;
    private static SharedPreferences.Editor mEditor;
    private static SharedPrefrenceUtil mSharedPreferencesUtil;
    private final Context context;

    public SharedPrefrenceUtil(Context context){
        this.context = context.getApplicationContext();
        mPreferences = this.context.getSharedPreferences(TAG,Context.MODE_PRIVATE);
        mEditor = mPreferences.edit();
    }

    public static SharedPrefrenceUtil getInstance(Context context){
        if (mSharedPreferencesUtil == null){
            mSharedPreferencesUtil = new SharedPrefrenceUtil(context);
        }
        return mSharedPreferencesUtil;
    }
    public boolean isLogin(){
        return getBoolean(KEY_LOGIN,false);
    }

    public void setLogin(boolean value){
        putBoolean(KEY_LOGIN,value);
    }

    private void putBoolean(String key,boolean value){
        mEditor.putBoolean(key,value);
        mEditor.commit();
    }

    private boolean getBoolean(String keyLogin, boolean b) {
        return mPreferences.getBoolean(keyLogin,b);
    }
    private void put(String key, String value){
        mEditor.putString(key,value);
        mEditor.commit();
    }

    private String get(String key){
        return mPreferences.getString(key,"");
    }

    private void putInt(String key, int value){
        mEditor.putInt(key,value);
        mEditor.apply();
    }
    private int getInt(String key, int value){
        return mPreferences.getInt(key,value);
    }
}
