package com.dmantz.ecommerceapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class AfterItemSelected extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_after_item_selected);
    }

    public void addtocart(View view) {

        Intent i = new Intent(this,CartActivity.class);
                startActivity(i);



    }

    public void buyNow(View view) {




                                       Intent i = new Intent(AfterItemSelected.this,PaymentClient.class);
                                       startActivity(i);





    }
}
