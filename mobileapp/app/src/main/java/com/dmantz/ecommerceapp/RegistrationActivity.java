package com.dmantz.ecommerceapp;

import android.content.Intent;
import android.os.StrictMode;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import org.json.simple.JSONObject;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import static android.text.TextUtils.isEmpty;
import static android.view.View.Z;

public class RegistrationActivity extends AppCompatActivity {

    private static final String TAG = "REGISTRATIONACT";
    public UserProfile userProfile;
    public User user;
    public LoginClient2 loginClient2;


    Button button;
    private EditText firstNameEdit,
            lastNameEdit, emailIdEdit, passwordEdit, mobileNumberEdit;
    private ECApplication ecApp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration);


        if (android.os.Build.VERSION.SDK_INT > 9) {
            StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
            StrictMode.setThreadPolicy(policy);
        }


        firstNameEdit = (EditText) findViewById(R.id.first_name);
        lastNameEdit = (EditText) findViewById(R.id.last_name);
        emailIdEdit = (EditText) findViewById(R.id.Email_Input);

        passwordEdit = (EditText) findViewById(R.id.passwordInput);
        mobileNumberEdit = findViewById(R.id.mobileInput);

        ecApp = (ECApplication) getApplication();



    }


    public void registration(View view) throws IOException {




        Log.d(TAG, "Entered into registration");
        String firstName = firstNameEdit.getText().toString();


        Log.d(TAG, "got name" + firstName);

        String lastName = lastNameEdit.getText().toString();
        Log.d(TAG, "got name" + lastName);
        String emailid = emailIdEdit.getText().toString();
        Log.d(TAG, "got name" + emailid);
        String password = passwordEdit.getText().toString();
        Log.d(TAG, "got name" + password);
        String mobileNumber = mobileNumberEdit.getText().toString();
        Log.d(TAG, "got name" + mobileNumberEdit);

        UserProfile newUser = new UserProfile();
        Log.d(TAG, "Into user profile object" + firstName);


        newUser.setFirstName(firstName);
        newUser.setLastName(lastName);
        newUser.setEmailid(emailid);
        newUser.setpassword(password);
        newUser.setMobileNumber(mobileNumber);

        Log.d(TAG, "first name is set" + firstName);


        try {



                if (isEmpty(firstName)) {
                    firstNameEdit.setError("First name required");
                }

                else{


                if (isEmpty(lastName)) {

                    lastNameEdit.setError("Last name required");
                    Log.d(TAG, " name is set" + lastName);
                }
                else{
                if (!emailid.matches("[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+") ){

                    emailIdEdit.setError("Email id required");

                    Log.d(TAG, "email is set" + emailid);
                }
                else{
                if (!password.matches("((?=.*[a-z])(?=.*\\d)(?=.*[A-Z])(?=.*[@#$%!]).{8,40})")) {

                    passwordEdit.setError("Password must contain Alphanumeric and 1 Special Character ");

                    Log.d(TAG, "passwword  is set /n" + password);

                }
                else {
                    if (isEmpty(mobileNumber) && mobileNumber.length() < 9) {
                        mobileNumberEdit.setError("Enter mobile number correctly");

                        Log.d(TAG, "mobile number" + mobileNumber);

                    } else {

                                Log.d(TAG,"Entered into else");







                        Intent intent = new Intent(RegistrationActivity.this, OtpClient.class);
                        startActivity(intent);


                    }

                }}}}
            JSONObject registerrespjson = ecApp.loginClient2.registerUser(firstName, lastName, emailid, password, mobileNumber);

            Log.d("TAG", "Entered into json object" + registerrespjson);


        } catch (Exception e) {
            e.printStackTrace();
        }




    }



    }





