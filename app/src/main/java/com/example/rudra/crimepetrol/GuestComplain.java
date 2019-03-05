package com.example.rudra.crimepetrol;

import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GuestComplain extends AppCompatActivity {

    private TextView text1,text2,text3,text4,text5,text6;
    private Button complain1,complain2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_complain);

        text1=(TextView)findViewById(R.id.text1);
        text2=(TextView)findViewById(R.id.text2);
        text3=(TextView)findViewById(R.id.text3);
        text4=(TextView)findViewById(R.id.text4);
        text5=(TextView)findViewById(R.id.text5);
        text6=(TextView)findViewById(R.id.text6);
        complain1=(Button)findViewById(R.id.complain1);
        complain2=(Button)findViewById(R.id.complain2);

        complain1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        complain2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Snackbar.make(view, "User have to register for more details", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });

    }
}
