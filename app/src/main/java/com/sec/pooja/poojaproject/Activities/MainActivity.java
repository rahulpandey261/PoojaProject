package com.sec.pooja.poojaproject.Activities;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

import com.sec.pooja.poojaproject.Adapters.MainScreenAdapter;
import com.sec.pooja.poojaproject.Model.MainItem;
import com.sec.pooja.poojaproject.R;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements NavigationView.OnNavigationItemSelectedListener, MainScreenAdapter.MainItemClickListener {

    private Toolbar toolbar;
    private NavigationView navigationView;
    private DrawerLayout drawerLayout;
    private boolean isLogin = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        isLogin = true;
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(R.string.home_title);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);

        RecyclerView recList = (RecyclerView) findViewById(R.id.cardList);
        recList.setHasFixedSize(true);
        GridLayoutManager gridLayoutManager = new GridLayoutManager(this, 2);
        recList.setLayoutManager(gridLayoutManager);
        MainScreenAdapter mainScreenAdapter = new MainScreenAdapter(getMainData());
        mainScreenAdapter.setMainItemClickListerner(this);
        recList.setAdapter(mainScreenAdapter);


        navigationView = (NavigationView) findViewById(R.id.navigation);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer);

        navigationView.setNavigationItemSelectedListener(this);

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
        actionBarDrawerToggle.syncState();
    }

    private List<MainItem> getMainData() {
        List<MainItem> list = new ArrayList<>();
        String[] text = getResources().getStringArray(R.array.main_item);
        MainItem mainItem;
        for (int i = 0; i < text.length; i++) {
            mainItem = new MainItem();
            mainItem.setItemName(text[i]);
            mainItem.setThumbnail(R.drawable.baby);
            list.add(mainItem);
        }
        return list;
    }

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
                if (!isLogin) {
                    Intent intent = new Intent(this, LoginActivity.class);
                    startActivity(intent);
                }
                //navigationView.getMenu().getItem(3).setVisible(true);
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
                isLogin = false;
                return true;
            case R.id.inbox4:
                Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                return true;
            case R.id.inbox5:
                Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                return true;
            case R.id.inbox6:
                Toast.makeText(MainActivity.this, "Hello World", Toast.LENGTH_LONG).show();
                return true;
        }
        return false;
    }

    @Override
    public void MainItemClick(View view, int position) {
        Toast.makeText(MainActivity.this, "Click" + position, Toast.LENGTH_LONG).show();
        Intent intent = new Intent(this, DetailListItem.class);
        String[] text = getResources().getStringArray(R.array.main_item);
        switch (position) {
            case 0:
                intent.putExtra("Title", "button" + position);
                intent.putExtra("NAME", text);
                break;
            case 1:
                intent.putExtra("Title", "button" + position);
                intent.putExtra("NAME", text);
                break;
            case 2:
                intent.putExtra("Title", "button" + position);
                intent.putExtra("NAME", text);
                break;
            case 3:
                intent.putExtra("Title", "button" + position);
                intent.putExtra("NAME", text);
                break;
            case 4:
                intent.putExtra("Title", "button" + position);
                intent.putExtra("NAME", text);
                break;
            case 5:
                intent.putExtra("Title", "button" + position);
                intent.putExtra("NAME", text);
                break;
        }
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        switch (item.getItemId()) {
            case R.id.search:
                Toast.makeText(MainActivity.this, "search", Toast.LENGTH_LONG).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
