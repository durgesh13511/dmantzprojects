package com.ecommerce;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by ROHIT on 4/4/2018.
 */

public class MyApp extends Application {
        private static Context context;

    @Override
    public void onCreate() {
        super.onCreate();
    context = getApplicationContext();
    }


    public static Context getContext(){

        return  context;
    }
}
