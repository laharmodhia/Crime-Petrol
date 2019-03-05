package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;

public class TabFragment extends Fragment {
    int position;

    private TextView textView;
    public static final String ARG_SECTION_NUMBER = "section_number";
    public int current_tab = 1;
    public ImageView imgview;
    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragment tabFragment = new TabFragment();
        tabFragment.setArguments(bundle);
        return tabFragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        position = getArguments().getInt("pos");
    }

    View rootView;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        Log.d("section number", String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)));
        switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
            case 1: {
                current_tab = 1;
                rootView = inflater.inflate(R.layout.tabone, container, false);
                break;
            }
            case 2: {
                current_tab = 2;
                rootView = inflater.inflate(R.layout.tabtwo, container, false);
                break;
            }

            case 3: {
                current_tab = 3;
                rootView = inflater.inflate(R.layout.tabthree, container, false);
                break;
            }

        }
//        Log.d("Test", String.valueOf(position+1));
        return rootView;
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
//        textView = (TextView) view.findViewById(R.id.textView);
//
//        textView.setText("Fragment " + (position + 1));


        Log.d("section number", String.valueOf(getArguments().getInt(ARG_SECTION_NUMBER)));
        switch (getArguments().getInt(ARG_SECTION_NUMBER)) {
            case 1: {
                Button browse = view.findViewById(R.id.browser);
                Button submit = view.findViewById(R.id.submit);
                Button cancle = view.findViewById(R.id.cancel);
                imgview = view.findViewById(R.id.ime1);
                final EditText type = view.findViewById(R.id.type);
                final EditText city = view.findViewById(R.id.city);
                final EditText crimeDetails = view.findViewById(R.id.crimedetails);


                int PICK_IMAGE_REQUEST = 1;


                submit.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                        StringRequest sr = new StringRequest(
                                Request.Method.POST,
                                Constants.URL_ADD_CRIME,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.d("response",response);
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            if (!jsonObject.getBoolean("error")){
                                                Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                                Intent it = new Intent(getContext(), Addbutton.class);
                                                startActivity(it);
                                            }else {
                                                Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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
                                }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("Cr_type",type.getText().toString());
                                params.put("Cr_description",crimeDetails.getText().toString());
                                params.put("U_id", String.valueOf(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUserId()));
                                params.put("city",city.getText().toString());
                                return params;
                            }
                        };
                        RequestHandeler.getInstance(getActivity().getApplicationContext()).addToRequestQueue(sr);
                    }
                });
                browse.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
                    }
                });
                cancle.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Cancel ", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(getContext(), Addbutton.class);
                        startActivity(it);
                    }
                });
                break;

            }

            case 2: {
                Button submit2 = view.findViewById(R.id.submittwo);
                Button cancel2 = view.findViewById(R.id.cancletwo);
                final EditText complaindecription = view.findViewById(R.id.description);
                final EditText city = view.findViewById(R.id.et4);
                final EditText type = view.findViewById(R.id.type);


                submit2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                       // Toast.makeText(getContext(), "Submit Complain", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                        StringRequest sr = new StringRequest(
                                Request.Method.POST,
                                Constants.URL_ADD_CRIME,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.d("response",response);
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            if (!jsonObject.getBoolean("error")){
                                                Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                                Intent it = new Intent(getContext(), Addbutton.class);
                                                startActivity(it);
                                            }else {
                                                Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
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
                                }){
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("C_type",type.getText().toString());
                                params.put("C_description",complaindecription.getText().toString());
                                params.put("U_id", String.valueOf(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUserId()));
                                params.put("city",city.getText().toString());
                                return params;
                            }
                        };
                        RequestHandeler.getInstance(getActivity().getApplicationContext()).addToRequestQueue(sr);
                    }
                });

                cancel2.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Cancel ", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(getContext(), Addbutton.class);
                        startActivity(it);
                    }
                });
                break;
            }


            case 3: {
                Button browser3 = view.findViewById(R.id.browser3);
                Button submit3 = view.findViewById(R.id.submit3);
                Button cancle3 = view.findViewById(R.id.cancel3);
                imgview = view.findViewById(R.id.image1);

                final EditText city = view.findViewById(R.id.city);
                final EditText name = view.findViewById(R.id.name);
                final EditText address = view.findViewById(R.id.address);
                final EditText Lastseen = view.findViewById(R.id.lastseen);
                final EditText birthdate =view.findViewById(R.id.birthdate);

                int PICK_IMAGE_REQUEST = 1;

                submit3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        //        Toast.makeText(getContext(), "Submit missing", Toast.LENGTH_SHORT).show();
                        Toast.makeText(getContext(), "test", Toast.LENGTH_SHORT).show();
                        StringRequest sr = new StringRequest(
                                Request.Method.POST,
                                Constants.URL_ADD_CRIME,
                                new Response.Listener<String>() {
                                    @Override
                                    public void onResponse(String response) {
                                        Log.d("response", response);
                                        try {
                                            JSONObject jsonObject = new JSONObject(response);
                                            if (!jsonObject.getBoolean("error")) {
                                                Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                                Intent it = new Intent(getContext(), Addbutton.class);
                                                startActivity(it);
                                            } else {
                                                Toast.makeText(getContext(), jsonObject.getString("message"), Toast.LENGTH_SHORT).show();
                                            }
                                        } catch (JSONException e) {
                                            e.printStackTrace();
                                        }
                                    }
                                },
                                new Response.ErrorListener() {
                                    @Override
                                    public void onErrorResponse(VolleyError error) {
                                        Log.d("error", error.toString());
                                    }
                                }) {
                            @Override
                            protected Map<String, String> getParams() throws AuthFailureError {
                                Map<String, String> params = new HashMap<>();
                                params.put("Mi_name", name.getText().toString());
                                params.put("mi_add", address.getText().toString());
                                params.put("U_id", String.valueOf(SharedPrefManager.getInstance(getActivity().getApplicationContext()).getUserId()));
                                params.put("city", city.getText().toString());
                                params.put("lastseen", Lastseen.getText().toString());
                                params.put("birthdate", birthdate.getText().toString());
                                return params;
                            }
                        };
                        RequestHandeler.getInstance(getActivity().getApplicationContext()).addToRequestQueue(sr);

                    }
                });
                browser3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Intent intent = new Intent();
                        intent.setType("image/*");
                        intent.setAction(Intent.ACTION_GET_CONTENT);
                        startActivityForResult(Intent.createChooser(intent, "Select Image"), 1);
                    }
                });
                cancle3.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        Toast.makeText(getContext(), "Cancel ", Toast.LENGTH_SHORT).show();
                        Intent it = new Intent(getContext(), Addbutton.class);
                        startActivity(it);
                    }
                });
                break;

            }
        }
    }


        @Override
        public void onActivityResult ( int requestCode, int resultCode, Intent data){
            super.onActivityResult(requestCode, resultCode, data);

            if (requestCode == 1 && resultCode == -1 && data != null && data.getData() != null) {
                String realPath;
                // SDK < API11
                if (Build.VERSION.SDK_INT < 11)
                    realPath = RealPathUtil.getRealPathFromURI_BelowAPI11(getContext(), data.getData());

                    // SDK >= 11 && SDK < 19
                else if (Build.VERSION.SDK_INT < 19)
                    realPath = RealPathUtil.getRealPathFromURI_API11to18(getContext(), data.getData());

                    // SDK > 19 (Android 4.4)
                else
                    realPath = RealPathUtil.getRealPathFromURI_API19(getContext(), data.getData());

                Uri uriFromPath = Uri.fromFile(new File(realPath));

                // you have two ways to display selected image

                // ( 1 ) imageView.setImageURI(uriFromPath);

                // ( 2 ) imageView.setImageBitmap(bitmap);
                Bitmap bitmap = null;
                try {
                    bitmap = BitmapFactory.decodeStream(getContext().getContentResolver().openInputStream(uriFromPath));
                } catch (FileNotFoundException e) {
                    e.printStackTrace();
                }
                imgview.setImageBitmap(bitmap);
            }
        }
    }

