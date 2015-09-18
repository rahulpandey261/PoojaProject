package com.sec.pooja.poojaproject.Adapters;


import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.sec.pooja.poojaproject.R;

/**
 * Created by RAHUL on 18-Sep-15.
 */
public class ItemDisplayAdapter extends RecyclerView.Adapter<ItemDisplayAdapter.ItemDisplayViewHolder> {

    @Override
    public ItemDisplayViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.product_list_display, parent, false);
        ItemDisplayViewHolder myViewHolder = new ItemDisplayViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(ItemDisplayViewHolder holder, int position) {

    }

    @Override
    public int getItemCount() {
        return 10;
    }

    class ItemDisplayViewHolder extends RecyclerView.ViewHolder {

        public ItemDisplayViewHolder(View itemView) {
            super(itemView);
        }
    }
}