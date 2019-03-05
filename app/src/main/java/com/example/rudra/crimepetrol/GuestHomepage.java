package com.example.rudra.crimepetrol;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuestHomepage extends AppCompatActivity {

    private TextView textv1,textv2,textv3,textv4,textv5,textv6,textv7,textv8,textv9;
    private Button crime1,complain1,missing1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_homepage);


        textv1=(TextView)findViewById(R.id.textv1);
        textv2=(TextView)findViewById(R.id.textv2);
        textv3=(TextView)findViewById(R.id.textv3);
        textv4=(TextView)findViewById(R.id.textv4);
        textv5=(TextView)findViewById(R.id.textv5);
        textv6=(TextView)findViewById(R.id.textv6);
        textv7=(TextView)findViewById(R.id.textv7);
        textv8=(TextView)findViewById(R.id.textv8);
        textv9=(TextView)findViewById(R.id.textv9);
        complain1=(Button)findViewById(R.id.complain1);
        crime1=(Button)findViewById(R.id.crime1);
        missing1=(Button)findViewById(R.id.missing1);

        crime1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        complain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

        missing1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
    }
}
