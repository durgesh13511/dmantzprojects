package com.dmantz.ecommerceapp;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.razorpay.Checkout;
import com.razorpay.PaymentResultListener;

import org.json.JSONException;
import org.json.simple.JSONObject;

public class PaymentClient extends Activity implements PaymentResultListener {


    EditText mAmount;
    Button mPay;

    Long payAmount;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_client);


        mPay=(Button)findViewById(R.id.btn_pay);




    }

    public void startPayment(View view) {
        mAmount=findViewById(R.id.enterAmount);

        payAmount = Long.parseLong(mAmount.getText().toString());
        Log.d("oprion","get amount"+payAmount);
        Checkout checkout = new Checkout();


             final Activity activity=this;

             try {


                org.json.JSONObject options = new org.json.JSONObject();
                 options.put("Description", "Order #123456");
                 options.put("currency", "INR");

                options.put("amount",payAmount*100);
                 Log.d("oprion","get amount"+payAmount);


                 checkout.open(activity,options);
             }

             catch (Exception e){
                 e.printStackTrace();
             }

    }

    @Override
    public void onPaymentSuccess(String s) {

        Toast.makeText(PaymentClient.this,"Payment is succeessful",Toast.LENGTH_LONG).show();

    }

    @Override
    public void onPaymentError(int i, String s) {

        Toast.makeText(PaymentClient.this,"Payment is failed",Toast.LENGTH_LONG).show();

    }
}
