package com.example.rudra.crimepetrol;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;
import android.widget.Toast;

public class Feedback extends AppCompatActivity {
    RatingBar ratingBar;

    Button button;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feedback);
        ratingBar = (RatingBar) findViewById(R.id.rating);
        ratingBar.setNumStars(5);
         button = (Button) findViewById(R.id.btn1);

        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float v, boolean b) {

                Toast.makeText(Feedback.this, "Stars:" + v,Toast.LENGTH_SHORT).show();
            }
        });


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(Feedback.this,"Rating submited " + ratingBar.getRating(), Toast.LENGTH_SHORT).show();
            }
        });
    
    }
}
