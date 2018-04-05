package com.example.naseem.priceomania1;

import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.PagerSnapHelper;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.github.rubensousa.gravitysnaphelper.GravitySnapHelper;

import java.util.ArrayList;

/**
 * Created by Naseem on 07-02-2018.
 */

public class SnapAdapter extends RecyclerView.Adapter<SnapAdapter.ViewHolder> implements GravitySnapHelper.SnapListener {

    public static final int VERTICAL=0;

    public static final int HORIZONTAL=1;
    private ArrayList<Snap> mSnaps ;



    private View.OnTouchListener mTouchlistener=new View.OnTouchListener(){

        @Override
        public boolean onTouch(View v, MotionEvent event) {
            v.getParent().requestDisallowInterceptTouchEvent(true);
            return false;
        }
    };

    public SnapAdapter(){
        mSnaps=new ArrayList<>();


    }
    public void addSnap(Snap snap){
        mSnaps.add(snap);

    }


    @Override
    public int getItemViewType(int position){
        Snap snap=mSnaps.get(position);

        switch (snap.getGravity()){
            case Gravity.CENTER_VERTICAL:
                return VERTICAL;
            case Gravity.CENTER_HORIZONTAL:
                return HORIZONTAL;
            case Gravity.START:
                return HORIZONTAL;
            case Gravity.TOP:
                return VERTICAL;
            case Gravity.END:
                return HORIZONTAL;
            case Gravity.BOTTOM:
                return VERTICAL;

        }
        return HORIZONTAL;
    }
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view=viewType==VERTICAL ? LayoutInflater.from(parent.getContext())
                .inflate(R.layout.adapter_snap_vertical,parent,false):
                LayoutInflater.from(parent.getContext()).inflate(R.layout.adapter_snap,parent,false);

        if (viewType==VERTICAL){
            view.findViewById(R.id.recyclerview1).setOnTouchListener(mTouchlistener);
        }



        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        Snap snap=mSnaps.get(position);


        holder.snapTextview.setText(snap.getText());



        if (snap.getGravity()==Gravity.START|| snap.getGravity()==Gravity.END)
        {
            holder.recyclerview.setLayoutManager(new LinearLayoutManager(holder.recyclerview.getContext(), LinearLayoutManager.HORIZONTAL,false));

            holder.recyclerview.setOnFlingListener(null);
            new GravitySnapHelper(snap.getGravity(),false,this).attachToRecyclerView(holder.recyclerview);
        }
        else if (snap.getGravity()==Gravity.CENTER_HORIZONTAL)
        {
            holder.recyclerview.setLayoutManager(new LinearLayoutManager(holder.recyclerview.getContext(),snap.getGravity()==Gravity.CENTER_HORIZONTAL?
                    LinearLayoutManager.HORIZONTAL: LinearLayoutManager.VERTICAL,false));
            holder.recyclerview.setOnFlingListener(null);
        }
        else if (snap.getGravity()==Gravity.CENTER){
            holder.recyclerview.setLayoutManager(new LinearLayoutManager(holder.recyclerview.getContext(), LinearLayoutManager.HORIZONTAL,false));

            holder.recyclerview.setOnFlingListener(null);
            new PagerSnapHelper().attachToRecyclerView(holder.recyclerview);

        }else {
            holder.recyclerview.setLayoutManager(new LinearLayoutManager(holder.recyclerview.getContext()));
            holder.recyclerview.setOnFlingListener(null);
            new GravitySnapHelper(snap.getGravity()).attachToRecyclerView(holder.recyclerview);

        }
       // holder.recyclerview.setAdapter(new Adapter(snap.getGravity()==Gravity.START||snap.getGravity()==Gravity.END
                //||snap.getGravity()==Gravity.CENTER_HORIZONTAL,snap.getGravity()==Gravity.CENTER,snap.getApps()));

    }

    @Override
    public int getItemCount() {
        return mSnaps.size();
    }

    @Override
    public void onSnap(int position) {
        Log.d("snapped : ",position+"");

    }



    public class ViewHolder extends RecyclerView.ViewHolder   {


        //private CardView cardView;;

       public TextView snapTextview;
        public RecyclerView recyclerview;

        public ViewHolder(final View itemView) {
            super(itemView);

            //cardView = (CardView) itemView.findViewById(R.id.card_view);
            snapTextview=(TextView)itemView.findViewById(R.id.snapTextview);
            recyclerview=(RecyclerView)itemView.findViewById(R.id.recyclerview1);




        }
    }
}
