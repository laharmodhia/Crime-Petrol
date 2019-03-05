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

public class ComplainAdapter  extends RecyclerView.Adapter<ComplainAdapter.MyViewHolder>{
    private List<Complainmodules> complainList;
    private Context con;
    public class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView complain_type;
        public Button btnDetails;

        public MyViewHolder(View view) {
            super(view);
            complain_type = (TextView) view.findViewById(R.id.complain_type);
            btnDetails = view.findViewById(R.id.moredetails);
        }
    }
    public ComplainAdapter(Context context,List<Complainmodules> complainList) {
        this.complainList = complainList;
        this.con = context;
    }
    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.content_complain_around, parent, false);

        return new ComplainAdapter.MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(final ComplainAdapter.MyViewHolder holder, int position) {
        final Complainmodules complain = complainList.get(position);
        holder.complain_type.setText(complain.getC_type());
        holder.btnDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(con,complainmoredetails.class);
                i.putExtra("complain_id",complain.getC_id());
                con.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return complainList.size();
    }

}
