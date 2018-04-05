package com.example.naseem.priceomania1.AdapterForExp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.bignerdranch.expandablerecyclerview.Adapter.ExpandableRecyclerAdapter;
import com.bignerdranch.expandablerecyclerview.Model.ParentObject;
import com.example.naseem.priceomania1.Models.TitleChild;
import com.example.naseem.priceomania1.Models.TitleParent;
import com.example.naseem.priceomania1.R;
import com.example.naseem.priceomania1.ViewHolder.TitleChildViewHolder;
import com.example.naseem.priceomania1.ViewHolder.TitleParentViewHolder;


import java.util.List;

/**
 * Created by User on 3/15/2018.
 */

public class MyAdapter extends ExpandableRecyclerAdapter<TitleParentViewHolder,TitleChildViewHolder> {
    LayoutInflater layoutInflater;
    public MyAdapter(Context context, List<ParentObject> parentItemList) {
        super(context, parentItemList);
        layoutInflater= LayoutInflater.from(context);
    }

    @Override
    public TitleParentViewHolder onCreateParentViewHolder(ViewGroup viewGroup) {
        View view=layoutInflater.inflate(R.layout.card_expand,viewGroup,false);
        return new TitleParentViewHolder(view);
    }

    @Override
    public TitleChildViewHolder onCreateChildViewHolder(ViewGroup viewGroup) {
        View view=layoutInflater.inflate(R.layout.layout_child,viewGroup,false);
        return new TitleChildViewHolder(view);
    }

    @Override
    public void onBindParentViewHolder(TitleParentViewHolder titleParentViewHolder, int i, Object o) {
        TitleParent titleParent=(TitleParent)o;
        titleParentViewHolder.textViewp.setText(titleParent.getTitle());

    }

    @Override
    public void onBindChildViewHolder(TitleChildViewHolder titleChildViewHolder, int i, Object o) {

        TitleChild titleChild=(TitleChild)o;
        titleChildViewHolder.textView.setText(titleChild.getOption1());
        titleChildViewHolder.textView1.setText(titleChild.getOption2());

    }
}
