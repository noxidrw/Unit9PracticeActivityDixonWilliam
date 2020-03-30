package com.example.unit9practiceactivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.view.Menu;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.android.material.navigation.NavigationView;

import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;



public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener{

    private AppBarConfiguration mAppBarConfiguration;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                Intent emailIntent = new Intent(Intent.ACTION_SEND);
                emailIntent.setType("*/*");
                emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey, did it work?");
                if(emailIntent.resolveActivity(getPackageManager()) != null){
                    startActivity(emailIntent);
                }
            }
        });

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        mAppBarConfiguration = new AppBarConfiguration.Builder(
                R.id.nav_home, R.id.nav_gallery, R.id.nav_slideshow)
                .setDrawerLayout(drawer)
                .build();
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        NavigationUI.setupActionBarWithNavController(this, navController, mAppBarConfiguration);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item){
        int id = item.getItemId();

        //Setup Menu Actions
        if(id == R.id.action_add){
            Toast.makeText(getApplicationContext(), "Add Study mates not available yet", Toast.LENGTH_LONG)
                    .show();
            return true;
        }if(id == R.id.action_delete){
            Snackbar.make(getWindow().getDecorView(), "Delete Study mates not available yet", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }if(id == R.id.action_email){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("*/*");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey, did it work?");
            if(emailIntent.resolveActivity(getPackageManager()) != null){
                startActivity(emailIntent);
            }
            return true;
        }if(id == R.id.action_settings){
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }if(id == R.id.action_sms){
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:" + getResources().getString(R.string.smsNum)));
            smsIntent.putExtra("sms_body", "Hi");
            // check for SMS APP
            if(smsIntent.resolveActivity(getPackageManager()) != null){
                startActivity(smsIntent);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    @Override
    public boolean onSupportNavigateUp() {
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment);
        return NavigationUI.navigateUp(navController, mAppBarConfiguration)
                || super.onSupportNavigateUp();
    }

    public boolean onNavigationItemSelected(MenuItem item){
        int id = item.getItemId();

        //Setup Menu Actions
        if(id == R.id.nav_action_add) {
            Snackbar.make(getWindow().getDecorView(), "Add Study mates not available yet", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            Toast.makeText(getApplicationContext(), "Add Study mates not available yet", Toast.LENGTH_LONG)
                    .show();
            return true;
        }if(id == R.id.nav_action_delete){
            Snackbar.make(getWindow().getDecorView(), "Delete Study mates not available yet", Snackbar.LENGTH_LONG)
                    .setAction("Action", null).show();
            return true;
        }if(id == R.id.nav_action_email){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setType("*/*");
            emailIntent.putExtra(Intent.EXTRA_SUBJECT, "Hey, did it work?");
            if(emailIntent.resolveActivity(getPackageManager()) != null){
                startActivity(emailIntent);
            }
            return true;
        }if(id == R.id.nav_action_settings){
            Intent settingsIntent = new Intent(this, SettingsActivity.class);
            startActivity(settingsIntent);
            return true;
        }if(id == R.id.nav_action_sms){
            Intent smsIntent = new Intent(Intent.ACTION_VIEW);
            smsIntent.setData(Uri.parse("sms:" + getResources().getString(R.string.smsNum)));
            smsIntent.putExtra("sms_body", "Hi");
            // check for SMS APP
            if(smsIntent.resolveActivity(getPackageManager()) != null){
                startActivity(smsIntent);
            }
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    }
