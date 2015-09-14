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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.splash_layout);
        Context mContext = getBaseContext();

        if (Utils.checkConnection(mContext)) {
            mCheckConnection = true;
        } else {
            mCheckConnection = false;
        }

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (mCheckConnection) {
                    Toast.makeText(getBaseContext(), "Connection available.Background data loaded", Toast.LENGTH_SHORT).show();
                    Intent intent = new Intent(getBaseContext(), MainActivity.class);
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

