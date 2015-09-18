package com.sec.pooja.poojaproject.Activities;

import android.app.ProgressDialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
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

public class RegisterActivity extends AppCompatActivity implements View.OnClickListener {
    private Toolbar toolbar;
    private ProgressDialog PD;
    private String userID;
    private String emailID;
    private String userPass;
    private String userAdd;
    String register_url = Constantfun.weburl+"register.php";
    private boolean is_logIn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        findViewById(R.id.registerbutton).setOnClickListener(this);
        toolbar = (Toolbar) findViewById(R.id.appbar);
        toolbar.setTitle(R.string.register_title);
        setSupportActionBar(toolbar);
    }

    private void getInputValue() {
        userID = ((EditText) findViewById(R.id.user_id)).getText().toString();
        userPass = ((EditText) findViewById(R.id.user_password)).getText().toString();
        emailID = ((EditText) findViewById(R.id.email)).getText().toString();
        userAdd = ((EditText) findViewById(R.id.address1)).getText().toString() + ((EditText) findViewById(R.id.address2)).getText().toString();
    }

    @Override
    public void onClick(View v) {
        showDailog();
        switch (v.getId()) {
            case R.id.registerbutton:
                getInputValue();
                register();
                break;
        }
        finish();
    }

    private void register() {
        StringRequest stringRequest = new StringRequest(Request.Method.POST, register_url, new Response.Listener<String>() {
            @Override
            public void onResponse(String s) {
                JSONObject jsonObject = null;
                try {
                    PD.hide();
                    jsonObject = new JSONObject(s);
                    is_logIn = jsonObject.getBoolean("success");
                    Log.v("Rahul", "" + is_logIn);
                    if (is_logIn) {
                        Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                    } else {
                        Toast.makeText(RegisterActivity.this, "Register Error", Toast.LENGTH_SHORT).show();
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }
            }
        }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError volleyError) {
                PD.hide();
                Toast.makeText(RegisterActivity.this, "Internal Error", Toast.LENGTH_SHORT).show();
            }
        }) {
            @Override
            protected Map<String, String> getParams() throws AuthFailureError {
                Map<String, String> params = new HashMap<String, String>();
                params.put("USER_NUM", userID);
                params.put("USER_PASS", userPass);
                params.put("USER_EMAIL", emailID);
                params.put("USER_ADD", userAdd);
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
}
