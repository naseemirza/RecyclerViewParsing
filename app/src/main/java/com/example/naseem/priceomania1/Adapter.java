package com.example.naseem.priceomania1;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.toolbox.ImageLoader;
import com.android.volley.toolbox.NetworkImageView;
import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Naseem on 07-02-2018.
 */

public class Adapter extends RecyclerView.Adapter<Adapter.ViewHolder>  {
    private List<App> mApps;
    private boolean mHorizontal;
    private boolean mPager;
    private Context mContext;

//    ImageLoader imageLoader;
//
//    Context c;

              //,boolean horizontal,boolean pager, after context
    public Adapter(Context context,List<App> apps){
        mContext=context;
        mApps=apps;
//        mHorizontal=horizontal;
//        mPager=pager;

    }



    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View v = LayoutInflater.from(mContext).inflate(R.layout.adapter, parent, false);
        return new ViewHolder(v);
//        if (mPager){
//            return new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_pager,parent,false));
//
//        }else {
//            return mHorizontal ? new ViewHolder(LayoutInflater.from(mContext).inflate(R.layout.adapter,parent,false)):
//                    new ViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_vertical,parent,false));
//        }

    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        App app=mApps.get(position);


        String imageUrl = app.getmImageUrl();
        String productName = app.getmName();
        String currencyType = app.getmCurrency();
        String totalPrice = app.getmPrice();
        String totalCount = app.getmCount();

        holder.mTextViewName.setText(productName);
        holder.mTextViewCurrency.setText(currencyType);
        holder.mTextViewPrice.setText(totalPrice);
        holder.mTextViewCount.setText(totalCount+" Online Store(s)");
        Picasso.with(mContext).load(imageUrl).fit().centerInside().into(holder.mImageView);



    }

    @Override
    public int getItemViewType(int position){

        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return mApps.size();
    }


    public class ViewHolder extends RecyclerView.ViewHolder {

        public ImageView mImageView;
        public TextView mTextViewName;
        public TextView mTextViewCurrency;
        public TextView mTextViewCount;
        public TextView mTextViewPrice;

        public ViewHolder(View itemView ) {

            super(itemView);
            mImageView=(ImageView)itemView.findViewById(R.id.imageview);
            mTextViewName=(TextView) itemView.findViewById(R.id.nameTextview);
            mTextViewCurrency=(TextView) itemView.findViewById(R.id.crncytype);
            mTextViewPrice=(TextView) itemView.findViewById(R.id.pricetext1);
            mTextViewCount=(TextView) itemView.findViewById(R.id.countext);


        }
    }
}
