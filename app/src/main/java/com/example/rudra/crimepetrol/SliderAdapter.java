package com.example.rudra.crimepetrol;

import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

public class SliderAdapter extends PagerAdapter
{
    int x=0;
    private static ViewPager mPager1;
    Context context;
    LayoutInflater inflater;

    public int[] imageArray = {R.drawable.image1,R.drawable.image2,R.drawable.image3};
    public String[] titleArray = {"CRIME","COMPLAINT","MISSING PERSON"};
    public String[] descriptionArray = {"Register user will be able to post for 'CRIME' and other users will get aware",
                         "Register user will post 'COMPLAINT' and it will appear on other users timeline",
                         "Register user can post for 'MISSING PERSON' and user will get aware"};

    public int[] backgroundColorArray = {Color.rgb(255,255,255), Color.rgb(255,255,255),Color.rgb(255,255,255)};

    public SliderAdapter(Context context)
    {
        this.context = context;
    }
    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object object)
    {
        return (view==object);
    }

    @Override
    public int getCount() {
        return titleArray.length;
    }

    @Override
    public void destroyItem(@NonNull ViewGroup container, int position, @NonNull Object object)
    {
//        container.removeView(LinearLayout)object;
    }

    @NonNull
    @Override
    public Object instantiateItem(@NonNull ViewGroup container, int position) {
        inflater = (LayoutInflater)context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
        View view =  inflater.inflate(R.layout.slide,container,false);
        LinearLayout linearLayout = view.findViewById(R.id.linearLayout);
        ImageView imageView = view.findViewById(R.id.slideimg);
        TextView t1_title = view.findViewById(R.id.txtTitle);
        TextView t2_desc = view.findViewById(R.id.txtDescription);
        linearLayout.setBackgroundColor(backgroundColorArray[position]);
        imageView.setImageResource(imageArray[position]);
        t1_title.setText(titleArray[position]);
        t2_desc.setText(descriptionArray[position]);
        container.addView(view);
        return view;
    }
}
