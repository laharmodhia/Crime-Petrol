package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class FirstPage extends AppCompatActivity {
    TextView btn1,btn2;
    EditText usname,pwd;
    CheckBox checkBox;
    TextView txt1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_first_page);

        if(SharedPrefManager.getInstance(this).isLoggedIn()){
            finish();
            startActivity(new Intent(this, NaviDrawer.class));
            return;
        }

        usname=(EditText)findViewById(R.id.usname);
        pwd=(EditText)findViewById(R.id.pwd);
        checkBox=(CheckBox)findViewById(R.id.checkbox);
        btn1=(TextView)findViewById(R.id.btn1);
        btn2=(TextView)findViewById(R.id.btn2);
        txt1=(TextView)findViewById(R.id.txt1);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               userlogin();
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(FirstPage.this,SignupForm.class);
                startActivity(i);
            }
        });

//        btn1.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent i = new Intent(FirstPage.this,NaviDrawer.class);
//                startActivity(i);
//
//            }
//        });
        txt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(FirstPage.this,forgotpassword.class);
                startActivity(it);
            }
        });

    }

    private  void userlogin(){

        final  String username = usname.getText().toString().trim();
        final  String password = pwd.getText().toString().trim();
        Toast.makeText(this, "login", Toast.LENGTH_SHORT).show();
        StringRequest stringRequest = new StringRequest(
                Request.Method.POST,
                Constants.URL_LOGIN,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response",response);
                        try{
                            JSONObject obj = new JSONObject(response);
                            if(!obj.getBoolean("error")){
                                JSONObject userData = obj.getJSONObject("user");
                                SharedPrefManager.getInstance(getApplicationContext())
                                        .userlogin(
                                                userData.getInt(("U_id")),
                                                userData.getString("U_Firstname"),
                                                userData.getString("U_email")
                                        );
                                startActivity(new Intent(getApplicationContext(),NaviDrawer.class));
                                finish();
                            }else {
                                Toast.makeText(
                                        getApplicationContext(),
                                        obj.getString("message"),
                                        Toast.LENGTH_LONG
                                ).show();


                            }
                        }catch (JSONException e){
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("error",error.toString());
                    }
                }
        ){
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("U_email",username);
                params.put("password",password);
                return params;
            }
        };

        RequestHandeler.getInstance(this).addToRequestQueue(stringRequest);
    }
}
