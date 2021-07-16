package com.example.clothinghouse;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MenuItem;

import com.google.android.material.navigation.NavigationView;

public class MainActivity extends AppCompatActivity {
    ActionBarDrawerToggle drawer;
//    NavigationView navigationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpViews();
    }

    void setUpViews(){
        setUpDrawerLayout();
    }

    public void setUpDrawerLayout(){
        setSupportActionBar(findViewById(R.id.AppBar));
        drawer = new ActionBarDrawerToggle(MainActivity.this, findViewById(R.id.mainDrawer),R.string.app_name, R.string.app_name);
        drawer.syncState();

    }
//
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (drawer.onOptionsItemSelected(item)) {
            return (true);
        }
        return super.onOptionsItemSelected(item);
    }
}