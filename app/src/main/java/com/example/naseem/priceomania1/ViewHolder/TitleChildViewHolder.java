package com.example.naseem.priceomania1.ViewHolder;

import android.view.View;
import android.widget.TextView;

import com.bignerdranch.expandablerecyclerview.ViewHolder.ChildViewHolder;
import com.example.naseem.priceomania1.R;


/**
 * Created by User on 3/15/2018.
 */

public class TitleChildViewHolder extends ChildViewHolder {

    public TextView textView,textView1;
    public TitleChildViewHolder(View itemView) {
        super(itemView);
        textView=(TextView)itemView.findViewById(R.id.option1);
        textView1=(TextView)itemView.findViewById(R.id.option2);
    }
}
