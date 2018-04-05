package com.example.naseem.priceomania1;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

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


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);



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

//        mRecyclerview.addOnItemTouchListener(new CustomRVItemTouchListener(this, mRecyclerview, new RecyclerViewItemClickListener() {
//            @Override
//            public void onClick(View view, int pos) {
//
//                ImageView imageview=(ImageView)findViewById(R.id.imageview);
//                TextView nameTextview=(TextView)findViewById(R.id.nameTextview);
//                TextView onlinestoreTextview2=(TextView)findViewById(R.id.onlinestoreTextview2);
//
//                Intent intent=new Intent(ScrollingActivity.this,CardDetails.class);
//
//
//                intent.putExtra("Mname",nameTextview.getText().toString());
//                intent.putExtra("Mprice",onlinestoreTextview2.getText().toString());
//
//
//                startActivity(intent);
//            }
//        }));

        //setupAdapter();

    }

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

                                mExampleList1.add(new App(object.optString("product_image"),
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

                                mExampleList2.add(new App(object.optString("product_image"),
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

                                mExampleList3.add(new App(object.optString("product_image"),
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

                                mExampleList4.add(new App(object.optString("product_image"),
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

    @Override
    protected void onSaveInstanceState(Bundle outState){
        super.onSaveInstanceState(outState);
        outState.putBoolean(ORIENTATION,mHorizontal);
    }


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
