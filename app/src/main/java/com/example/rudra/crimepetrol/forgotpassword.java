package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class forgotpassword extends AppCompatActivity {
    private EditText passwordEmail;
    private Button Resetpasswrod;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgotpassword);

        passwordEmail=(EditText)findViewById(R.id.edittext);
        Resetpasswrod=(Button)findViewById(R.id.btnpasswordreset);
        // firebaseAuth=FirebaseAuth.getInstance();

        Resetpasswrod.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String useremail=passwordEmail.getText().toString().trim();

                if(useremail.equals("")){
                    Toast.makeText(forgotpassword.this,"Please enter your Register Id",Toast.LENGTH_SHORT).show();
                    // finish();
                }
                else {
                    Intent it = new Intent(forgotpassword.this, FirstPage.class);
                    startActivity(it);
                }
            }
        });
    }
}
