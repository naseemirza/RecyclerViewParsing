package com.example.naseem.priceomania1;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.GridView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.naseem.priceomania1.BottomBar.Activity1;
import com.example.naseem.priceomania1.BottomBar.Activity2;
import com.example.naseem.priceomania1.BottomBar.Activity3;
import com.example.naseem.priceomania1.BottomBar.Activity4;
import com.example.naseem.priceomania1.BottomBar.BottomNavigationViewHelper;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class ScrollingActivity extends AppCompatActivity   {
    private Adapter mExampleAdapter1,mExampleAdapter2,mExampleAdapter3,mExampleAdapter4;
    private ArrayList<App> mExampleList1,mExampleList2,mExampleList3,mExampleList4;
    private RequestQueue mRequestQueue1,mRequestQueue2,mRequestQueue3,mRequestQueue4;

    public static final String ORIENTATION="orientation";
    private RecyclerView mRecyclerview1;
    private RecyclerView mRecyclerview2;
    private RecyclerView mRecyclerview3;
    private RecyclerView mRecyclerview4;
    private Boolean mHorizontal;


    // More Categorirs

    private static final String JSON_URL = "http://ae.priceomania.com/mobileappwebservices/getparentcategory";

    private ParentAdapter mExampleAdapter;
    private ArrayList<Parent> mExampleList;
    private RequestQueue mRequestQueue;
    private RecyclerView sRecyclerview;

    GridAdapter adapter;
    GridView gv;


    private final String cat_name_array[] = {
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow",
            "Donut",
            "Eclair",
            "Froyo",
            "Gingerbread",
            "Honeycomb",
            "Ice Cream Sandwich",
            "Jelly Bean",
            "KitKat",
            "Lollipop",
            "Marshmallow"
    };

    private final int cat_image_array[] = {
           R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video,
            R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video,
            R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video, R.drawable.tv_video,
            R.drawable.tv_video, R.drawable.tv_video,
    };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);



        // More Categorirs

        initViews();

//        gv= (GridView) findViewById(R.id.gv);
//
//        adapter=new GridAdapter(this,getData());
//
//        gv.setAdapter(adapter);




//        mExampleList = new ArrayList<>();
//        sRecyclerview=(RecyclerView)findViewById(R.id.recyclerview5);
//        sRecyclerview.setNestedScrollingEnabled(false);
//        sRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
//        mRequestQueue = Volley.newRequestQueue(this);
//        sRecyclerview.setHasFixedSize(true);
//
//        parseJSON();


        //bottombar


//        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.bottomNavView_Bar);
//        BottomNavigationViewHelper.disableShiftMode(bottomNavigationView);
//        Menu menu = bottomNavigationView.getMenu();
//        MenuItem menuItem = menu.getItem(0);
//        menuItem.setChecked(true);
//
//        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
//            @Override
//            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
//                switch (item.getItemId()){
//                    case R.id.ic_arrow:
//
//                        break;
//
//                    case R.id.ic_android:
//                        Intent intent1 = new Intent(ScrollingActivity.this, Activity1.class);
//                        startActivity(intent1);
//                        break;
//
//                    case R.id.ic_books:
//                        Intent intent2 = new Intent(ScrollingActivity.this, Activity2.class);
//                        startActivity(intent2);
//                        break;
//
//                    case R.id.ic_center_focus:
//                        Intent intent3 = new Intent(ScrollingActivity.this, Activity3.class);
//                        startActivity(intent3);
//                        break;
//
//                    case R.id.ic_backup:
//                        Intent intent4 = new Intent(ScrollingActivity.this,Activity4.class);
//                        startActivity(intent4);
//                        break;
//                }
//
//                return false;
//            }
//        });




        //Snap 1

        mExampleList1 = new ArrayList<>();
        mRequestQueue1 = Volley.newRequestQueue(this);

        mRecyclerview1=(RecyclerView)findViewById(R.id.recyclerview1);
        mRecyclerview1.setNestedScrollingEnabled(false);
        mRecyclerview1.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mRecyclerview1.setHasFixedSize(true);

        parseJSON1();

        //Snap 2

        mExampleList2 = new ArrayList<>();
        mRequestQueue2= Volley.newRequestQueue(this);

        mRecyclerview2=(RecyclerView)findViewById(R.id.recyclerview2);
        mRecyclerview2.setNestedScrollingEnabled(false);
        mRecyclerview2.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mRecyclerview2.setHasFixedSize(true);

        parseJSON2();

        //Snap 3

        mExampleList3 = new ArrayList<>();
        mRequestQueue3= Volley.newRequestQueue(this);

        mRecyclerview3=(RecyclerView)findViewById(R.id.recyclerview3);
        mRecyclerview3.setNestedScrollingEnabled(false);
        mRecyclerview3.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mRecyclerview3.setHasFixedSize(true);

        parseJSON3();


       //Snap 4

        mExampleList4 = new ArrayList<>();
        mRequestQueue4= Volley.newRequestQueue(this);

        mRecyclerview4=(RecyclerView)findViewById(R.id.recyclerview4);
        mRecyclerview4.setNestedScrollingEnabled(false);
        mRecyclerview4.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.HORIZONTAL,false));
        mRecyclerview4.setHasFixedSize(true);

        parseJSON4();


    }
        // More Categories


    private void initViews(){
        RecyclerView recyclerView = (RecyclerView)findViewById(R.id.recyclerview5);
        recyclerView.setHasFixedSize(true);
        RecyclerView.LayoutManager layoutManager = new GridLayoutManager(getApplicationContext(), 5, GridLayoutManager.HORIZONTAL, false);

        recyclerView.setLayoutManager(layoutManager);

        ArrayList<GridModel> grdlist = prepareData();
        GridAdapter adapter = new GridAdapter(getApplicationContext(),grdlist);
        recyclerView.setAdapter(adapter);

    }
    private ArrayList<GridModel> prepareData(){

        ArrayList<GridModel> grd = new ArrayList<>();
        for(int i=0;i<cat_name_array.length;i++){
            GridModel androidVersion = new GridModel();
            androidVersion.setName(cat_name_array[i]);
            androidVersion.setImage(cat_image_array[i]);
            grd.add(androidVersion);
        }
        return grd;
    }


//    private void parseJSON() {
//
//        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://ae.priceomania.com/mobileappwebservices/getparentcategory",
//                new Response.Listener<String>() {
//                    @Override
//                    public void onResponse(String response) {
//
//                        try {
//                            Log.e("rootJsonArray",response);
//                            JSONArray rootJsonArray = new JSONArray(response);
//
//                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");
//
//                            for (int i = 0; i < rootJsonArray.length(); i++) {
//                                JSONObject object = rootJsonArray.getJSONObject(i);
//
//                                mExampleList.add(new Parent(object.optString("category_id"),
//                                        object.optString("category_name"),
//                                        object.optString("category_image")));
//                            }
//
//                            Log.e("rootJsonArray",mExampleList.size()+"");
//
//                            mExampleAdapter = new ParentAdapter(ScrollingActivity.this, mExampleList);
//                            sRecyclerview.setAdapter(mExampleAdapter);
//                            mExampleAdapter.notifyDataSetChanged();
//                            sRecyclerview.setHasFixedSize(true);
//
//                        } catch (JSONException e) {
//                            e.printStackTrace();
//                        }
//
//                    }
//                },
//                new Response.ErrorListener() {
//                    @Override
//                    public void onErrorResponse(VolleyError error) {
//                        //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
//                        // Log.e("TAg",error.getMessage());
//                    }
//                });
//
//        mRequestQueue = Volley.newRequestQueue(this);
//        mRequestQueue.add(stringRequest);
//    }

    private void parseJSON1() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://ae.priceomania.com/mobileappwebservices/getfeaturedproducts",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList1.add(new App(object.optString("id"),
                                        object.optString("product_image"),
                                        object.optString("modelno"),
                                        object.optString("currency_type"),
                                        object.optString("price"),
                                        object.optString("store_count")));
                            }

                            Log.e("rootJsonArray",mExampleList1.size()+"");

                           mExampleAdapter1 = new Adapter(ScrollingActivity.this, mExampleList1);
                            mRecyclerview1.setAdapter(mExampleAdapter1);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("TAg",error.getMessage());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        mRequestQueue1.add(stringRequest);
    }

    private void parseJSON2() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://ae.priceomania.com/mobileappwebservices/getMobiles",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList2.add(new App(object.optString("id"),
                                        object.optString("product_image"),
                                        object.optString("modelno"),
                                        object.optString("currency_type"),
                                        object.optString("price"),
                                        object.optString("store_count")));
                            }

                            Log.e("rootJsonArray",mExampleList2.size()+"");

                            mExampleAdapter2 = new Adapter(ScrollingActivity.this, mExampleList2);
                            mRecyclerview2.setAdapter(mExampleAdapter2);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("TAg",error.getMessage());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        mRequestQueue2.add(stringRequest);
    }

    private void parseJSON3() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://ae.priceomania.com/mobileappwebservices/getCamera",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList3.add(new App(object.optString("id"),
                                        object.optString("product_image"),
                                        object.optString("modelno"),
                                        object.optString("currency_type"),
                                        object.optString("price"),
                                        object.optString("store_count")));
                            }

                            Log.e("rootJsonArray",mExampleList3.size()+"");

                            mExampleAdapter3 = new Adapter(ScrollingActivity.this, mExampleList3);
                            mRecyclerview3.setAdapter(mExampleAdapter3);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("TAg",error.getMessage());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        mRequestQueue3.add(stringRequest);
    }


    private void parseJSON4() {

        StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://ae.priceomania.com/mobileappwebservices/getTablets",
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {

                        try {
                            Log.e("rootJsonArray",response);
                            JSONArray rootJsonArray = new JSONArray(response);

                            Log.e("rootJsonArrayLength",rootJsonArray.length()+"");

                            for (int i = 0; i < rootJsonArray.length(); i++) {
                                JSONObject object = rootJsonArray.getJSONObject(i);

                                mExampleList4.add(new App(object.optString("id"),
                                        object.optString("product_image"),
                                        object.optString("modelno"),
                                        object.optString("currency_type"),
                                        object.optString("price"),
                                        object.optString("store_count")));
                            }

                            Log.e("rootJsonArray",mExampleList4.size()+"");

                            mExampleAdapter4 = new Adapter(ScrollingActivity.this, mExampleList4);
                            mRecyclerview4.setAdapter(mExampleAdapter4);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                },
                new Response.ErrorListener() {
                    @Override
                    public void onErrorResponse(VolleyError error) {
                        Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                        Log.e("TAg",error.getMessage());
                    }
                });

        RequestQueue requestQueue = Volley.newRequestQueue(this);
        mRequestQueue4.add(stringRequest);
    }

//    @Override
//    protected void onSaveInstanceState(Bundle outState){
//        super.onSaveInstanceState(outState);
//        outState.putBoolean(ORIENTATION,mHorizontal);
//    }


//    private void setupAdapter() {
//        List<App> apps = getApps();
//        SnapAdapter snapAdapter = new SnapAdapter();
//        snapAdapter.addSnap(new Snap(Gravity.START, "Similar Products", apps));
//        mRecyclerview.setAdapter(snapAdapter);
//
//    }

//    private List<App> getApps(){
//        List<App> apps=new ArrayList<>();
//
//        apps.add(new App("Apple iPhone 7 plus", "AED 2199.00", "38 Online Store(s)", R.drawable.apple7plus));
//        apps.add(new App("Apple iPhone 7 plus", "AED 18190.00", "38 Online Store(s)", R.drawable.apple));
//        apps.add(new App("Apple iPhone 7 plus", "AED 1125.60", "38 Online Store(s)", R.drawable.microlumia));
//        apps.add(new App("Apple iPhone 7 plus", "AED 2199.00", "38 Online Store(s)", R.drawable.apple7plus));
//        apps.add(new App("Apple iPhone 7 plus", "AED 18190.00", "38 Online Store(s)", R.drawable.apple7plus));
//        apps.add(new App("Apple iPhone 7 plus", "AED 1125.60", "38 Online Store(s)", R.drawable.microlumia));
//        apps.add(new App("Apple iPhone 7 plus", "AED 2199.00", "38 Online Store(s)", R.drawable.apple7plus));
//        apps.add(new App("Apple iPhone 7 plus", "AED 18190.00", "38 Online Store(s)", R.drawable.applemini));
//        apps.add(new App("Apple iPhone 7 plus", "AED 1125.60", "38 Online Store(s)", R.drawable.microlumia));
//        apps.add(new App("Apple iPhone 7 plus", "AED 2199.00", "38 Online Store(s)", R.drawable.apple7plus));
//
//
//        return apps;
//    }


}
