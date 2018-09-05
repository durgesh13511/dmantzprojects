package com.ecommerce.Utility;

import android.content.Context;
import android.content.SharedPreferences;

import com.ecommerce.MyApp;

/**
 * Created by ROHIT on 4/4/2018.
 */

public class SharePreferenceUtils {


    private static String PREFERENCE_NAME="ecommerce";
    private static SharePreferenceUtils sharePreferenceUtils;
    private SharedPreferences sharedPreferences;

    private  SharePreferenceUtils(Context context){

        PREFERENCE_NAME = PREFERENCE_NAME+context.getPackageName();
        this.sharedPreferences=context.getSharedPreferences(PREFERENCE_NAME,Context.MODE_PRIVATE);



    }

    public static SharePreferenceUtils getInstance(){

        if(sharePreferenceUtils == null){
            sharePreferenceUtils = new SharePreferenceUtils(MyApp.getContext());
        }
        return sharePreferenceUtils;
    }

    public void  saveString(final String key, final String Val){
        SharedPreferences.Editor editor = sharedPreferences.edit();

        editor.putString(key, Val);
        editor.commit();
    }

        public String getstring (String key,String defval){

        return sharedPreferences.getString(key, defval);
    }
    public String getstring (String key){

        return sharedPreferences.getString(key, "");
    }
    }

