package com.sec.pooja.poojaproject.Activities;

import android.app.ProgressDialog;
import android.os.Handler;
import android.support.v4.app.NavUtils;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;

import com.sec.pooja.poojaproject.Fragments.PagerTabFragment;
import com.sec.pooja.poojaproject.R;

public class DetailListItem extends AppCompatActivity {

    private Toolbar toolbar;
    private ViewPager mViewPager;
    private ProgressDialog PD;
    String[] titleText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_list_item);
        toolbar = (Toolbar) findViewById(R.id.toolbar);
        toolbar.setTitle(getIntent().getStringExtra("Title"));
        titleText = getIntent().getStringArrayExtra("NAME");
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        showDailog();
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                PD.hide();
                PagerTabFragment pagerTabFragment = new PagerTabFragment();
                Bundle bundle = new Bundle();
                bundle.putStringArray("TITLEARRAY",getTabTitle());
                pagerTabFragment.setArguments(bundle);
                getSupportFragmentManager().beginTransaction().add(R.id.container, pagerTabFragment).commit();
            }
        }, 5000);


    }

    public String[] getTabTitle() {
        return titleText;
    }

    private void showDailog() {
        PD = new ProgressDialog(this);
        PD.setCancelable(false);
        PD.show();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                NavUtils.navigateUpFromSameTask(this);
                return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
