package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuestCrimearound extends AppCompatActivity {

    private TextView tv1,tv2;
    private Button moredetails1,moredetails2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_crimearound);

        tv1=(TextView)findViewById(R.id.tv1);
        tv2=(TextView)findViewById(R.id.tv2);
        moredetails1=(Button)findViewById(R.id.moredetails1);
        moredetails2=(Button)findViewById(R.id.moredetails2);

        moredetails1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        moredetails2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Snackbar.make(v, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();



            }
        });


    }
}
