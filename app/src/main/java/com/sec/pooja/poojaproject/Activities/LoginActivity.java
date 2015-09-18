package com.sec.pooja.poojaproject.Activities;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.android.volley.AuthFailureError;
import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.sec.pooja.poojaproject.ApplicationClass.MyAppclass;
import com.sec.pooja.poojaproject.Constants.Constantfun;
import com.sec.pooja.poojaproject.R;

import org.json.JSONException;
import org.json.JSONObject;

import java.util.HashMap;
import java.util.Map;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private Toolbar toolbar;
    String login_url = Constantfun.weburl+"ReadUser.php";
    ProgressDialog PD;
    private String mobile_num;
    private String pass;

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
                showDailog();
                mobile_num = ((EditText) findViewById(R.id.mobilenumber)).getText().toString();
                pass = ((EditText) findViewById(R.id.password)).getText().toString();
                Log.v("Rahul","Do login");
                userLogin();
                break;
        }

    }

    private void userLogin() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, login_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONObject jsonObject = null;
                try {
                    PD.hide();
                    Log.v("Rahul",s);
                    jsonObject = new JSONObject(s);
                    is_logIn = jsonObject.getBoolean("success");
                    if (is_logIn) {
                        rememberMe();
                        Intent intent = new Intent(LoginActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(LoginActivity.this, "Login Error", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                PD.hide();
                Toast.makeText(LoginActivity.this, "Internal Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("USER_NUM", mobile_num);
                params.put("USER_PASS", pass);
                return params;
            }
        };
        MyAppclass.getInstance().addToReqQueue(stringRequest);
    }

    private void showDailog() {
        PD = new ProgressDialog(this);
        PD.setCancelable(false);
        PD.show();
    }

    boolean is_logIn = false;

    private boolean rememberMe() {
        //perform Network operation for verify the login.
        //if valid user then save it into local space for futher login
        //if(net is returning successfull login then save it.
        Log.v("Rahul", "" + is_logIn);
        if (is_logIn) {
            SharedPreferences sp = getApplicationContext().getSharedPreferences(getString(R.string.USER_DATA), MODE_PRIVATE);
            SharedPreferences.Editor editor = sp.edit();
            editor.putString(getString(R.string.user_name), mobile_num);
            editor.putString(getString(R.string.user_pass), pass);
            editor.commit();
            return true;
        }
        return false;
    }
}
