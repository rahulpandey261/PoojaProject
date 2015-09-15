package com.sec.pooja.poojaproject.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.sec.pooja.poojaproject.R;
import com.sec.pooja.poojaproject.Utils.Utils;

/**
 * Created by JAIN on 9/14/2015.
 */
public class SplashActivity extends Activity {
    private boolean mCheckConnection = false;
    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        mContext = getApplicationContext();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (Utils.checkConnection(mContext)) {
                    Toast.makeText(getBaseContext(), "Connection available.Background data loaded", Toast.LENGTH_SHORT).show();
                    Intent intent;
                    if (!checklogin()) {
                        intent = new Intent(getBaseContext(), LoginActivity.class);
                    } else {
                        intent = new Intent(getBaseContext(), MainActivity.class);

                    }
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), "Connection not available. Please retry after some time", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }, 4000);


    }

    private boolean checklogin() {
        SharedPreferences sharedPreferences = getApplicationContext().getSharedPreferences(getString(R.string.USER_DATA), MODE_PRIVATE);
        String username = sharedPreferences.getString(getString(R.string.user_name), null);
        String pass = sharedPreferences.getString(getString(R.string.user_pass), null);
        if ((username != null) && (pass != null)) {
            return true;
        }
        return false;
    }
}

