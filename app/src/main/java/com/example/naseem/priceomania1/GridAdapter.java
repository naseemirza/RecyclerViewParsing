package com.example.naseem.priceomania1;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

/**
 * Created by User on 23-May-18.
 */

public class GridAdapter extends RecyclerView.Adapter<GridAdapter.ViewHolder>  {

    private ArrayList<GridModel> glist;
    private Context context;

    public GridAdapter(Context context,ArrayList<GridModel> glist) {
        this.glist = glist;
        this.context = context;
    }

    @Override
    public GridAdapter.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int i) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.morecategory, viewGroup, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(GridAdapter.ViewHolder viewHolder, int i) {

        viewHolder.catname.setText(glist.get(i).getName());
        Picasso.with(context).load(glist.get(i).getImage()).resize(240, 120).into(viewHolder.catimage);
    }

    @Override
    public int getItemCount() {
        return glist.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private TextView catname;
        private ImageView catimage;
        public ViewHolder(View view) {
            super(view);

            catname = (TextView)view.findViewById(R.id.textViewname);
            catimage = (ImageView) view.findViewById(R.id.imageViewName);
        }
    }

}

