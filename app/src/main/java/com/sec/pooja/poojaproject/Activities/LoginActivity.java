package com.sec.pooja.poojaproject.Activities;

import android.app.Activity;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
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
        Intent intent;
        switch (v.getId()) {
            case R.id.register:
                intent = new Intent(LoginActivity.this, RegisterActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.loginbutton:
                if (checkLogin()) {
                    intent = new Intent(LoginActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }

    private boolean checkLogin() {
        String mobile_num = ((EditText) findViewById(R.id.mobilenumber)).getText().toString();
        String pass = ((EditText) findViewById(R.id.password)).getText().toString();
        //perform Network operation for verify the login.
        //if valid user then save it into local space for futher login
        //if(net is returning successfull login then save it.
        SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.USER_DATA), MODE_PRIVATE);
        SharedPreferences.Editor editor = sp.edit();
        editor.putString(getString(R.string.user_name), mobile_num);
        editor.putString(getString(R.string.user_pass), pass);
        editor.commit();
        return true;
    }
}
