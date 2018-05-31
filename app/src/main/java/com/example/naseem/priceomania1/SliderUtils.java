package com.example.naseem.priceomania1;

/**
 * Created by User on 14-May-18.
 */

public class SliderUtils {


    String sliderImageUrl;
    String image_path = "http://ae.priceomania.com/backend/ProductImage/";

    public String getSliderImageUrl() {
        return sliderImageUrl;
    }

    public void setSliderImageUrl(String sliderImageUrl) {
        this.sliderImageUrl =image_path+ sliderImageUrl;
    }
}
