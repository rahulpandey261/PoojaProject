package com.sec.pooja.poojaproject.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sec.pooja.poojaproject.Adapters.ItemPagerAdapter;
import com.sec.pooja.poojaproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PagerTabFragment extends Fragment {


    private ViewPager mViewPager;
    private FragmentManager mFragmentManager;
    String[] mtabTitle;

    public PagerTabFragment() {

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pager_tab, container, false);
        mViewPager = (ViewPager) v.findViewById(R.id.pager);
        mtabTitle = getArguments().getStringArray("TITLEARRAY");
        mViewPager.setAdapter(new ItemPagerAdapter(getActivity().getSupportFragmentManager(), mtabTitle));
        return v;
    }


}
