package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class change_password extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_change_password);

        final Button btnsave = (Button) findViewById(R.id.btnsave);
        final  Button btncancel=(Button)findViewById(R.id.btncancel);

        btnsave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pw=new Intent(change_password.this,Settings.class);
                startActivity(pw);
                Toast.makeText(change_password.this, "save ", Toast.LENGTH_SHORT).show();
            }
        });
        btncancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent pw=new Intent(change_password.this,Settings.class);
                startActivity(pw);
                Toast.makeText(change_password.this, "cancel ", Toast.LENGTH_SHORT).show();
            }
        });

    }
}
