package com.sec.pooja.poojaproject.Activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Toast;

import com.sec.pooja.poojaproject.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        toolbar = (Toolbar) findViewById(R.id.appbar);
        toolbar.setTitle(R.string.login_title);
        setSupportActionBar(toolbar);

        findViewById(R.id.register).setOnClickListener(this);
        findViewById(R.id.loginbutton).setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.register:
                Intent intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.loginbutton:
                checkLogin();
                break;
        }

    }

    private void checkLogin() {
        Toast.makeText(LoginActivity.this, "Login", Toast.LENGTH_SHORT).show();
        //perform Network operation for verify the login.
        //if valid user then save it into local space for futher login

        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}
