package com.example.naseem.priceomania1.Models;

import android.content.Context;

import com.example.naseem.priceomania1.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by User on 3/15/2018.
 */

public class TitleCreater  {
    static TitleCreater _titleCreater;
    List<TitleParent> _titleParents;

    public TitleCreater(Context context) {
        _titleParents=new ArrayList<>();
        for (int i=1;i<4;i++){
            TitleParent title=new TitleParent(String.format("MoreInfo+"));
            _titleParents.add(title);

        }
    }

    public static TitleCreater get(Context context) {
        if (_titleCreater == null)
            _titleCreater = new TitleCreater(context);

            return _titleCreater;


    }

    public List<TitleParent> getAll() {
        return _titleParents;
    }
}
