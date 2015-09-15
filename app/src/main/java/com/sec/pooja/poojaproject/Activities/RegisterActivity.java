package com.sec.pooja.poojaproject.Activities;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.sec.pooja.poojaproject.R;

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById(R.id.registerbutton).setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.appbar);
        toolbar.setTitle(R.string.register_title);
        setSupportActionBar(toolbar);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.registerbutton:
                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                break;
        }
        finish();
    }
}
