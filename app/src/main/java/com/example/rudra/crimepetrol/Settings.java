package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.SearchView;

public class Settings extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);
        final Button cntry = (Button) findViewById(R.id.btn1);
        final  Button changepw=(Button)findViewById(R.id.changepw);
        final Button btn2=(Button)findViewById(R.id.btn2);

        cntry.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               // Intent temp = new Intent(Settings.this,changecountry.class);
                //startActivity(temp);

            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent ab=new Intent(Settings.this,about.class);
                startActivity(ab);
            }
        });

        changepw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent pw=new Intent(Settings.this,change_password.class);
                startActivity(pw);
            }
        });

    }
}
