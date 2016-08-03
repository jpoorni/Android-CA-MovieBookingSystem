package com.example.student.moviebooking;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class PaymentActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment);


        Button button_paym = (Button) findViewById(R.id.button1_payment);
        button_paym.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(PaymentActivity.this, MainActivity.class);
//                Intent i1 = getIntent();
//                String tid1 = i1.getStringExtra("tid1");
//                i.putExtra("tid1", tid1);
                startActivityForResult(i, 80);
            }
        });
    }




}
