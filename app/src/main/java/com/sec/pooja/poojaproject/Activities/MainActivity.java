package com.sec.pooja.poojaproject.Activities;

import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sec.pooja.poojaproject.R;

public class MainActivity extends AppCompatActivity {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.home_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        navigationView = (NavigationView) findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(MenuItem menuItem) {
                if (menuItem.isChecked()) {
                    menuItem.setChecked(false);
                } else {
                    menuItem.setChecked(true);
                }
                drawerLayout.closeDrawers();
                switch (menuItem.getItemId()) {
                    case R.id.inbox:
                        Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.inbox1:
                        Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.inbox2:
                        Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                        return true;
                    case R.id.inbox3:
                        Toast.makeText(MainActivity.this, "Logout", Toast.LENGTH_LONG).show();
                        SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.USER_DATA), MODE_PRIVATE);
                        SharedPreferences.Editor editor = sp.edit();
                        editor.putString(getString(R.string.user_name), null);
                        editor.putString(getString(R.string.user_pass), null);
                        editor.commit();
                        return true;
                }
                return false;
            }
        });

        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, toolbar, R.string.openDrawer, R.string.closeDrawer) {
            @Override
            public void onDrawerClosed(View drawerView) {
                super.onDrawerClosed(drawerView);
            }

            @Override
            public void onDrawerOpened(View drawerView) {
                super.onDrawerOpened(drawerView);
            }
        };
        drawerLayout.setDrawerListener(actionBarDrawerToggle);

        //calling sync state is necessay or else your hamburger icon wont show up
        actionBarDrawerToggle.syncState();
    }
}
