package com.example.rudra.crimepetrol;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

public class CrimeAdapter extends RecyclerView.Adapter<CrimeAdapter.MyViewHolder>{
    private List<Crime> crimeList;
    private Context con;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView crime_type;
        public Button btnDetails;

        public MyViewHolder(View view) {
            super(view);
            crime_type = (TextView) view.findViewById(R.id.crime_type);
            btnDetails = view.findViewById(R.id.moredetails);
        }
    }
    public CrimeAdapter(Context context,List<Crime> crimeList) {
        this.crimeList = crimeList;
        this.con = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_crime_around, parent, false);

        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        final Crime crime = crimeList.get(position);
        holder.crime_type.setText(crime.getCr_type());
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(con,crimemoredetails.class);
                i.putExtra("crime_id",crime.getCr_id());
                con.startActivity(i);
            }
        });
    }



    @Override
    public int getItemCount() {
        return crimeList.size();
    }
}
