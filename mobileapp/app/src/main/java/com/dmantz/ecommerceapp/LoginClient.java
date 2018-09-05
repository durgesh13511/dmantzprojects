package com.dmantz.ecommerceapp;

import android.content.Context;
import android.util.Log;

import static android.content.ContentValues.TAG;

public class LoginClient {

    private  static LoginClient loginClient;
    private LoginClient() {

        Log.d(TAG, "Entered client");
    }

    public static LoginClient getLoginClient(){
        if (loginClient == null){
            loginClient = new LoginClient();
        }
        return loginClient;
    }
}
