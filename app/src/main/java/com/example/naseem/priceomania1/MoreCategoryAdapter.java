package com.example.naseem.priceomania1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 29-May-18.
 */

public class MoreCategoryAdapter extends RecyclerView.Adapter<MoreCategoryAdapter.ViewHolder> {

    private List<MoreCategModel> list;
    private Context mCtx;

    public MoreCategoryAdapter(List<MoreCategModel> list, Context mCtx) {
        this.list = list;
        this.mCtx = mCtx;
    }


    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.morecategory, parent, false);
        return new ViewHolder(v);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        MoreCategModel myList = list.get(position);
        holder.textViewname.setText(myList.getCatname());
        holder.imageView.setImageResource(myList.getImage());


    }


    @Override
    public int getItemCount() {
        return list.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView textViewname;
        public ImageView imageView;

        public ViewHolder(View itemView) {
            super(itemView);

            textViewname = (TextView) itemView.findViewById(R.id.textViewname);
            imageView = (ImageView) itemView.findViewById(R.id.imageViewName);

        }
    }
}
