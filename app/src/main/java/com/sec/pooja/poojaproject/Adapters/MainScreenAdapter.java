package com.sec.pooja.poojaproject.Adapters;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.sec.pooja.poojaproject.Model.MainItem;
import com.sec.pooja.poojaproject.R;

import java.util.List;

/**
 * Created by RAHUL on 17-Sep-15.
 */
public class MainScreenAdapter extends RecyclerView.Adapter<MainScreenAdapter.MyViewHolder> {

    private List<MainItem> mItemList;
    private MainItemClickListener mainItemClickListener;

    public MainScreenAdapter(List<MainItem> itemList) {
        this.mItemList = itemList;
    }

    @Override
    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.main_card_view, parent, false);
        MyViewHolder myViewHolder = new MyViewHolder(v);
        return myViewHolder;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        MainItem currentItem = mItemList.get(position);
        //holder.imageView.setImageResource(currentItem.getThumbnail());
        holder.rl.setBackgroundResource(currentItem.getThumbnail());
        holder.textView.setText(currentItem.getItemName());

    }

    public void setMainItemClickListerner(MainScreenAdapter.MainItemClickListener mainItemClickListener) {
        this.mainItemClickListener = mainItemClickListener;
    }

    @Override
    public int getItemCount() {
        return mItemList.size();
    }

    public interface MainItemClickListener {
        public void MainItemClick(View view, int position);
    }

    class MyViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        //private final ImageView imageView;
        private final TextView textView;
        private final RelativeLayout rl;

        public MyViewHolder(View itemView) {
            super(itemView);
            itemView.setOnClickListener(this);
            //imageView = (ImageView) itemView.findViewById(R.id.card_id);
            textView = (TextView) itemView.findViewById(R.id.card_text);
            rl = (RelativeLayout) itemView.findViewById(R.id.top_layout);
        }

        @Override
        public void onClick(View v) {
            if (mainItemClickListener != null) {
                mainItemClickListener.MainItemClick(v, getLayoutPosition());
            }
        }
    }
}
