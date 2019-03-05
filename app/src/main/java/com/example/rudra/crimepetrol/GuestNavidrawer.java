package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.support.design.widget.NavigationView;
import android.support.design.widget.Snackbar;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class GuestNavidrawer extends AppCompatActivity
     implements NavigationView.OnNavigationItemSelectedListener{



        @Override
        protected void onCreate (Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guest_navidrawer);

        Button button = (Button) findViewById(R.id.crmoredetails);
        Button button1 = (Button) findViewById(R.id.mpmoredetails);
        Button button2 = (Button) findViewById(R.id.cpmoredetails);


        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "User have to register for more detials", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "User have to register for more detials", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar.make(v, "User have to register for more detials", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        //setSupportActionBar(toolbar);

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

        @Override
        public void onBackPressed () {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

        @Override
        public boolean onCreateOptionsMenu (Menu menu){
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.guest_navidrawer, menu);
        return true;
    }

        @Override
        public boolean onOptionsItemSelected (MenuItem item){
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_registration) {

            Intent reg = new Intent(GuestNavidrawer.this, SignupForm.class);
            startActivity(reg);
        }

        return super.onOptionsItemSelected(item);
    }

        @SuppressWarnings("StatementWithEmptyBody")
        @Override
        public boolean onNavigationItemSelected (MenuItem item){
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.home_page) {

            Intent loghome = new Intent(GuestNavidrawer.this, GuestHomepage.class);
            startActivity(loghome);
        } else if (id == R.id.crime_around) {

            Intent it = new Intent(GuestNavidrawer.this, GuestCrimearound.class);
            startActivity(it);

        } else if (id == R.id.missing_person) {

            Intent i = new Intent(GuestNavidrawer.this, GuestMissingperson.class);
            startActivity(i);

        } else if (id == R.id.navi_complain) {

            Intent logcomp = new Intent(GuestNavidrawer.this, GuestComplain.class);
            startActivity(logcomp);

        } else if (id == R.id.registration_form) {

            startActivity(new Intent(GuestNavidrawer.this,SignupForm.class));

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    }

