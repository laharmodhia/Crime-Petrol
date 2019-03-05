package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class CrrimeAround extends AppCompatActivity {
    private List<Crime> crimeList = new ArrayList<>();
    private RecyclerView recyclerView;
    private CrimeAdapter cAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crrime_around);

        Button button = (Button) findViewById(R.id.moredetails);


            recyclerView = findViewById(R.id.crime_around_rv);
            cAdapter =  new CrimeAdapter(getApplicationContext(),crimeList);
            RecyclerView.LayoutManager cLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(cLayoutManager);
            recyclerView.setItemAnimator(new DefaultItemAnimator());
            recyclerView.setAdapter(cAdapter);
        getCrimes();

    }


    private void getCrimes() {
        StringRequest sr = new StringRequest(
                Request.Method.GET,
                Constants.URL_GET_CRIME,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("response",response);
                        try {
                            JSONObject jsonObject = new JSONObject(response);
                            if (!jsonObject.getBoolean("error")){
                                JSONArray crimeResList = jsonObject.getJSONArray("crime");
                                for (int i = 0; i< crimeResList.length();i++){
                                    JSONObject crimeObject = crimeResList.getJSONObject(i);
                                    Crime cr = new Crime(crimeObject.getInt("Cr_id"),crimeObject.getString("Cr_type"),crimeObject.getString("Cr_description"),crimeObject.getString("city"));
                                    crimeList.add(cr);
                                }
                                cAdapter.notifyDataSetChanged();
                            }else {

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
                return params;
            }
        };
        RequestHandeler.getInstance(this.getApplicationContext()).addToRequestQueue(sr);
    }
}
