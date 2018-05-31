package com.example.naseem.priceomania1.MoreSites;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.example.naseem.priceomania1.R;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MoreSitesActivity extends AppCompatActivity {

    private String MORE_SITE_URL="http://ae.priceomania.com/mobileappwebservices/getCompareProductData?pid=";

    private CustomAdapterSite mExampleAdapter;
    private ArrayList<CardModel> mExampleList;
    private RequestQueue mRequestQueue;

    private RecyclerView mRecyclerview;
    String pid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_more_sites);

        SharedPreferences pref = getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
        pid=pref.getString("usermessage","");

       // Log.e("responce",pid);


                mExampleList = new ArrayList<>();
                mRecyclerview=(RecyclerView)findViewById(R.id.siterecycl);
                mRecyclerview.setNestedScrollingEnabled(false);
                mRecyclerview.setLayoutManager(new LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false));
                mRequestQueue = Volley.newRequestQueue(this);
                mRecyclerview.setHasFixedSize(true);

                parseJSON1();

    }

    private void parseJSON1() {

            StringRequest stringRequest = new StringRequest(Request.Method.GET, "http://ae.priceomania.com/mobileappwebservices/getCompareProductData?pid="+pid,
                    new Response.Listener<String>() {
                        @Override
                        public void onResponse(String response) {

                            Log.e("responce",response );


                            try {

                                JSONObject rootJsonObject = new JSONObject(response);

                                JSONArray subCategoryArray = rootJsonObject.getJSONArray("websitedata");
                                //Log.e("subCategoryArray", subCategoryArray.length() + "");

                                for (int i = 0; i < subCategoryArray.length(); i++) {
                                    JSONObject object = subCategoryArray.getJSONObject(i);

                                    mExampleList.add(new CardModel(object.optString("id"),
                                            object.optString("product_name"),
                                            object.optString("website_name"),
                                            object.optString("website_logo"),
                                            object.optString("website_url"),
                                            object.optString("currency_type"),
                                            object.optString("price")));
                                }

                                Log.e("rootJsonArray", String.valueOf(mExampleList));

                                mExampleAdapter = new CustomAdapterSite(MoreSitesActivity.this, mExampleList);
                                mRecyclerview.setAdapter(mExampleAdapter);
                                mExampleAdapter.notifyDataSetChanged();
                                mRecyclerview.setHasFixedSize(true);

                            } catch (JSONException e) {
                                e.printStackTrace();
                            }

                        }
                    },
                    new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            //Toast.makeText(getApplicationContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                            //Log.e("TAg",error.getMessage());
                        }
                    });

            mRequestQueue = Volley.newRequestQueue(this);
            mRequestQueue.add(stringRequest);
        }
}
