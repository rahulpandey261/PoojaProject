package com.sec.pooja.poojaproject.Adapters;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;

import com.sec.pooja.poojaproject.Fragments.ItemListFragment;

import java.util.Collection;
import java.util.Collections;

/**
 * Created by RAHUL on 18-Sep-15.
 */
public class ItemPagerAdapter extends FragmentStatePagerAdapter {
    String[] mTabsName;

    public ItemPagerAdapter(FragmentManager fm, String[] tabname) {
        super(fm);
        this.mTabsName = tabname;
    }

    @Override
    public Fragment getItem(int position) {
        ItemListFragment itemListFragment = new ItemListFragment();
        return itemListFragment;
    }

    @Override
    public int getCount() {
        return mTabsName.length;
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTabsName[position];
    }
}
