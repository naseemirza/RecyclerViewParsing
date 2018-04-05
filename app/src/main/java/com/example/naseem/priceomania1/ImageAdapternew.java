package com.example.naseem.priceomania1;


import android.content.Context;
import android.graphics.Bitmap;
import android.support.v4.util.LruCache;

import com.android.volley.Cache;
import com.android.volley.Network;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.BasicNetwork;
import com.android.volley.toolbox.DiskBasedCache;
import com.android.volley.toolbox.HurlStack;
import com.android.volley.toolbox.ImageLoader;

;

/**
 * Created by User on 4/3/2018.
 */

public class ImageAdapternew {

    public static ImageAdapternew imageAdapternew;

    public Network networkOBJ ;

    public RequestQueue requestQueue1;

    public ImageLoader Imageloader1;

    public Cache cache1 ;

    public static Context context1;

    LruCache<String, Bitmap> LRUCACHE = new LruCache<String, Bitmap>(30);

    private ImageAdapternew(Context context) {

        this.context1 = context;

        this.requestQueue1 = RequestQueueFunction();

        Imageloader1 = new ImageLoader(requestQueue1, new ImageLoader.ImageCache() {

            @Override
            public Bitmap getBitmap(String URL) {

                return LRUCACHE.get(URL);
            }

            @Override
            public void putBitmap(String url, Bitmap bitmap) {

                LRUCACHE.put(url, bitmap);
            }
        });
    }

    public ImageLoader getImageLoader() {

        return Imageloader1;
    }

    public static ImageAdapternew getInstance(Context SynchronizedContext) {

        if (imageAdapternew == null) {

            imageAdapternew = new ImageAdapternew(SynchronizedContext);
        }
        return imageAdapternew;
    }

    public RequestQueue RequestQueueFunction() {

        if (requestQueue1 == null) {

            cache1 = new DiskBasedCache(context1.getCacheDir());

            networkOBJ = new BasicNetwork(new HurlStack());

            requestQueue1 = new RequestQueue(cache1, networkOBJ);

            requestQueue1.start();
        }
        return requestQueue1;
    }
}
