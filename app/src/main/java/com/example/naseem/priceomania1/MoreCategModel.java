package com.example.naseem.priceomania1;

/**
 * Created by User on 29-May-18.
 */

public class MoreCategModel {
    String catname;
    int image;

    public MoreCategModel(String catname, int image) {
        this.catname = catname;
        this.image = image;
    }

    public String getCatname() {
        return catname;
    }

    public void setCatname(String catname) {
        this.catname = catname;
    }

    public int getImage() {
        return image;
    }

    public void setImage(int image) {
        this.image = image;
    }
}
