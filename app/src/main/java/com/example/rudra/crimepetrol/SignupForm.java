package com.example.rudra.crimepetrol;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
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
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class SignupForm extends AppCompatActivity {

    private EditText fn, ln, email, pwd, ed3;
    private RadioGroup radiogroup;
  private RadioButton male, female;
   private Button submit;

    public String firstname = "";
    public String lastname = "";
    public String gender = "";
   // public String contact = "";
    public String U_email = "";
    public String pass = "";
    public String cpass = "";

 //   ProgressDialog progress = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup_form);

        fn = (EditText) findViewById(R.id.fn);
        ln = (EditText) findViewById(R.id.ln);
         email = (EditText) findViewById(R.id.email);
         pwd = (EditText) findViewById(R.id.pwd);
         ed3 = (EditText) findViewById(R.id.ed3);

        RadioGroup radioGroup = (RadioGroup) findViewById(R.id.radiogroup);

        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                RadioButton rb = findViewById(checkedId);
               gender = rb.getText().toString();
            }
        });

        Button submit = (Button) findViewById(R.id.submit);
        Button back =(Button) findViewById(R.id.back);



        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                firstname = fn.getText().toString();
                lastname = ln.getText().toString();

                U_email = email.getText().toString();
                pass = pwd.getText().toString();
                cpass = ed3.getText().toString();


              Intent i = new Intent(SignupForm.this, NaviDrawer.class);
              startActivity(i);

                if (firstname.length() == 0) {
                    Toast.makeText(SignupForm.this, "Please Insert First Name", Toast.LENGTH_SHORT).show();
                } else if (lastname.length() == 0) {
                    Toast.makeText(SignupForm.this, "Please Insert Last Name", Toast.LENGTH_SHORT).show();
                } else if (gender.length() <= 0) {
                    Toast.makeText(getApplicationContext(), "Please select Gender", Toast.LENGTH_SHORT).show();

                } else if (email.length() == 0) {
                    Toast.makeText(SignupForm.this, "Please Insert Email ID", Toast.LENGTH_SHORT).show();
                } else if (!isValidEmail(U_email)) {
                    Toast.makeText(SignupForm.this, "Please Insert valid Email ID ' @ ' and ' . ' ", Toast.LENGTH_SHORT).show();
                } else if (pass.length() == 0) {
                    Toast.makeText(SignupForm.this, "Please Insert Password", Toast.LENGTH_SHORT).show();
                } else if (!isValidPassword(pass)) {
                    Toast.makeText(SignupForm.this, "Please Insert Minimum 6 Characters", Toast.LENGTH_SHORT).show();
                } else if (cpass.length() == 0) {
                    Toast.makeText(SignupForm.this, "Please Insert confirm Password", Toast.LENGTH_SHORT).show();
                } else if (!pass.equals(cpass)) {
                    Toast.makeText(SignupForm.this, "Not Match Password", Toast.LENGTH_SHORT).show();
                } else {



                    RegisterUser();


                }


            }
        });
       // back.setOnClickListener(new View.OnClickListener() {
           // @Override
     //       public void onClick(View v) {
         //       Toast.makeText(SignupForm.this, "back call", Toast.LENGTH_SHORT).show();
             //   Intent it = new Intent(SignupForm.this, FirstPage.class);
               // startActivity(it);

            //}
        //});

 }
    // validating email id
    private boolean isValidEmail(String email) {
        String EMAIL_PATTERN = "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@"
                + "[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";

        Pattern pattern = Pattern.compile(EMAIL_PATTERN);
        Matcher matcher = pattern.matcher(email);
        return matcher.matches();
    }

    // validating password with retype password
    private boolean isValidPassword(String pass) {
        if (pass != null && pass.length() >= 6) {
            return true;
        }
        return false;
    }
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//        Intent it = new Intent(SignupForm.this, FirstPage.class);
//        startActivity(it);
//    }

   public void hideSoftKeyboard() {
        this.getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_HIDDEN);


    }




    private void RegisterUser() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST,
                Constants.user_details,
                new com.android.volley.Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.d("Response", response);
                            JSONObject jsonObject = new JSONObject(response);
                            if (jsonObject.getBoolean("error")){
                                Toast.makeText(getApplicationContext(), jsonObject.getString("message"), Toast.LENGTH_LONG).show();
                            }else{

                                AlertDialog alertDialog = new AlertDialog.Builder(SignupForm.this).create();
                                alertDialog.setTitle("Information");
                                alertDialog.setMessage("Registration Successfully!!!");
                                alertDialog.setButton(AlertDialog.BUTTON_NEUTRAL, "OK",
                                        new DialogInterface.OnClickListener(){
                                            public void onClick(DialogInterface dialog, int which) {
                                                dialog.dismiss();
                                                startActivity(new Intent(SignupForm.this, NaviDrawer.class));
                                                finish();

                                            }
                                        });
                                alertDialog.show();
                            }


                        } catch (JSONException e) {
                            e.printStackTrace();
                            Log.d("Error", e.getMessage());


                            Toast.makeText(SignupForm.this, "Error", Toast.LENGTH_SHORT).show();
                        }
                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Log.d("Error",error.toString());
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_LONG).show();
                    }
                })
        {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<>();
                params.put("U_Firstname", firstname);
                params.put("U_Lastname", lastname);
                params.put("U_Gender",gender);
                params.put("U_email",U_email);
                params.put("password", pass);
              //  params.put("Cont_No", contact);
                return params;
            }
        };
        RequestHandeler.getInstance(this).addToRequestQueue(stringRequest);
    }
}
