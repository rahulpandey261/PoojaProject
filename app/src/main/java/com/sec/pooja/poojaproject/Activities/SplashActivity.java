package com.sec.pooja.poojaproject.Activities;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
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
                    Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                    startActivity(intent);
                    finish();
                } else {
                    Toast.makeText(getBaseContext(), "Connection not available. Please retry after some time", Toast.LENGTH_LONG).show();
                    finish();
                }
            }
        }, 4000);


    }
}

