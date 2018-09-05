package com.ecommerce.splash;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.PersistableBundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.ecommerce.R;
import com.ecommerce.Utility.SharePreferenceUtils;
import com.ecommerce.home.HomeActivity;
import com.ecommerce.login.SigninActivity;

/**
 * Created by ROHIT on 4/4/2018.
 */

public class SplashActivity extends AppCompatActivity {


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        init();

    }



    

    public void init(){

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {

                if(SharePreferenceUtils.getInstance().getstring("registered_userr").equalsIgnoreCase("")){

                    Intent intent = new Intent(SplashActivity.this, SigninActivity.class);
                    startActivity(intent);

                }
                    else{
                    Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                    startActivity(intent);

                }
                finish();
            }
        },3000);

    }
}
