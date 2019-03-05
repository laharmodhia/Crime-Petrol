package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class TabFragment1 extends Fragment {
    int position;

    private TextView textView;
    public static final String ARG_SECTION_NUMBER = "section_number";

    public static Fragment getInstance(int position) {
        Bundle bundle = new Bundle();
        bundle.putInt("pos", position);
        TabFragment1 tabFragment = new TabFragment1();
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
                rootView = inflater.inflate(R.layout.activity_profile, container, false);
                break;
            }
            case 2: {
                rootView = inflater.inflate(R.layout.activity_complate, container, false);
                break;
            }

            case 3: {
                rootView = inflater.inflate(R.layout.activity_delete, container, false);
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

        }


    }
}