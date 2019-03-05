package com.example.rudra.crimepetrol;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuestMissingperson extends AppCompatActivity {
    private TextView tx1,tx2,tx3,tx4,tx5,tx6;
    private Button missing1,missing2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_missingperson);

        tx1=(TextView)findViewById(R.id.tx1);
        tx2=(TextView)findViewById(R.id.tx2);
        tx3=(TextView)findViewById(R.id.tx3);
        tx4=(TextView)findViewById(R.id.tx4);
        tx5=(TextView)findViewById(R.id.tx5);
        tx6=(TextView)findViewById(R.id.tx6);
        missing1=(Button)findViewById(R.id.missing1);
        missing2=(Button)findViewById(R.id.missing2);

        missing1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

        missing2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });

    }
}
