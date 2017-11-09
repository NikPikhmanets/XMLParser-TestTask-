package com.pikhmanets.testtask;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class RvAdapter extends RecyclerView.Adapter<RvAdapter.RvViewHolder> {

    private OnItemTitleClickListener listener;
    private List<ItemPost> mTitleList = new ArrayList<>();

    RvAdapter(List<ItemPost> titleList) {
        mTitleList = titleList;
    }

    @Override
    public RvViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_rv, parent, false);
        return new RvViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RvViewHolder holder, int position) {
        holder.bind(mTitleList.get(position));
    }

    @Override
    public int getItemCount() {
        return mTitleList == null ? 0 : mTitleList.size();
    }


    class RvViewHolder extends RecyclerView.ViewHolder {

        private final TextView titleText;
        private final TextView timeText;

        RvViewHolder(View itemView) {
            super(itemView);

            titleText = itemView.findViewById(R.id.textItemTitle);
            timeText = itemView.findViewById(R.id.textItemPostTime);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (listener != null) {
                        listener.onItemTitleClick(mTitleList.get(getAdapterPosition()));
                    }
                }
            });
        }

        void bind(ItemPost mTitle) {
            titleText.setText(mTitle.getItemTitle());
            timeText.setText(mTitle.getItemPostTime());
        }
    }

    public void setListener(OnItemTitleClickListener listener) {
        this.listener = listener;
    }
}