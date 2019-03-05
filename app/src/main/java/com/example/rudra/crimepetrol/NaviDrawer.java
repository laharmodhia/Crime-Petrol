package com.example.rudra.crimepetrol;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
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
import android.widget.Toast;

public class NaviDrawer extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_navi_drawer);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
       // setSupportActionBar(toolbar);
        Button button = (Button) findViewById(R.id.moredetails);
        Button button1 = (Button) findViewById(R.id.moredetails1);
        Button button2 = (Button) findViewById(R.id.moredetails2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(NaviDrawer.this, crimemoredetails.class);
                startActivity(it);

            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent it = new Intent(NaviDrawer.this, mssingmoredetails.class);
                startActivity(it);

            }
        });
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent it = new Intent(NaviDrawer.this, complainmoredetails.class);
                startActivity(it);
            }
        });


        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Toast.makeText(NaviDrawer.this, "ADD", Toast.LENGTH_SHORT).show();
                Intent addButtonIntent = new Intent(NaviDrawer.this,Addbutton.class);
                startActivity(addButtonIntent);
            }
        });


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.navi_drawer, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
//        if (id == R.id.action_settings) {
//            return true;
//        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_profile) {
           Intent it1 = new Intent(NaviDrawer.this, ProfilePager.class);
           startActivity(it1);

        }else if (id== R.id.nav_home_page){
            Intent i = new Intent(NaviDrawer.this,HomePage.class);

        } else if (id == R.id.nav_crime_around) {
            Intent it1 = new Intent(NaviDrawer.this, CrrimeAround.class);
            startActivity(it1);


        } else if (id == R.id.nav_missing_person) {
            Intent it2 = new Intent(NaviDrawer.this, Missing.class);
            startActivity(it2);


        } else if (id == R.id.nav_complain) {
            Intent it = new Intent(NaviDrawer.this, Complain.class);
            startActivity(it);

        } else if (id == R.id.nav_feedback) {
            Intent gofeedback = new Intent(NaviDrawer.this, Feedback.class);
            startActivity(gofeedback);

        } else if (id == R.id.nav_settings) {
            Intent gosetting = new Intent(NaviDrawer.this, Settings.class);
            startActivity(gosetting);

        } else if (id == R.id.nav_logout) {
            Toast.makeText(this, "logout", Toast.LENGTH_SHORT).show();
            SharedPrefManager.getInstance(this).logout();
             startActivity(new Intent(NaviDrawer.this,FirstPage.class));
//            Intent log = new Intent(NaviDrawer.this,FirstPage.class);
//            startActivity(log);
        }


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
