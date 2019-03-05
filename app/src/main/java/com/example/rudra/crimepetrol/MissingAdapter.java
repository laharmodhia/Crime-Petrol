package com.example.rudra.crimepetrol;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import java.util.List;

public class MissingAdapter extends RecyclerView.Adapter<MissingAdapter.MyViewHolder>{
    private List<missingmodules> missingList;
    private Context con;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView missing_type;
        public Button btnDetails;
        public MyViewHolder(View view) {
            super(view);
            missing_type = (TextView) view.findViewById(R.id.missing_type);
            btnDetails = view.findViewById(R.id.moredetails);
        }
    }
    public MissingAdapter(Context context,List<missingmodules> missingList) {
        this.missingList = missingList;
        this.con = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_missing_around, parent, false);

        return new MissingAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final MissingAdapter.MyViewHolder holder, int position) {
        final missingmodules missing = missingList.get(position);
       holder.missing_type.setText(missing.getMi_name());
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(con,mssingmoredetails.class);
              i.putExtra("missing_id",missing.getMi_id());
                con.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return missingList.size();
    }

}
