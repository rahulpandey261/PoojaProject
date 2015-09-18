package com.sec.pooja.poojaproject.Fragments;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sec.pooja.poojaproject.Adapters.ItemDisplayAdapter;
import com.sec.pooja.poojaproject.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class ItemListFragment extends Fragment {


    private RecyclerView mItemRecyclerView;

    public ItemListFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_item_list, container, false);
        mItemRecyclerView = (RecyclerView) v.findViewById(R.id.item_recycler_view);
        mItemRecyclerView.setLayoutManager(new LinearLayoutManager(getActivity().getApplicationContext()));
        mItemRecyclerView.setAdapter(new ItemDisplayAdapter());
        return v;
    }


}
