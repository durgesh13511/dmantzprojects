package com.dmantz.ecommerceapp;

import android.app.Application;
import android.os.StrictMode;
import android.util.Log;

public class ECApplication extends Application {


        public LoginClient2 loginClient2;
        public CatalogClient catalogClient;


    @Override
    public void onCreate() {
        super.onCreate();


        if (android.os.Build.VERSION.SDK_INT > 9)
        {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }

        loginClient2 = LoginClient2.getLoginClient2();
        catalogClient = CatalogClient.getCatalogClient();




    }
}
