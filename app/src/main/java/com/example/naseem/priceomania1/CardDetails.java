package com.example.naseem.priceomania1;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.TabLayout;
import android.support.v4.widget.NestedScrollView;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.CardView;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;

import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;
import com.bumptech.glide.Glide;
import com.example.naseem.priceomania1.MoreSites.CardModel;
import com.example.naseem.priceomania1.MoreSites.CustomAdapterSite;
import com.example.naseem.priceomania1.MoreSites.MoreSitesActivity;
import com.github.aakira.expandablelayout.ExpandableRelativeLayout;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class CardDetails extends AppCompatActivity implements Toolbar.OnMenuItemClickListener  {

    //TextView mobilenametext,priceTextd;
    /**
     * The {@link android.support.v4.view.PagerAdapter} that will provide
     * fragments for each of the sections. We use a
     * {@link FragmentPagerAdapter} derivative, which will keep every
     * loaded fragment in memory. If this becomes too memory intensive, it
     * may be best to switch to a
     * {@link android.support.v4.app.FragmentStatePagerAdapter}.
     */
    private SectionsPagerAdapter mSectionsPagerAdapter;

    /**
     * The {@link ViewPager} that will host the section contents.
     */
    private ViewPager mViewPager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_card_details);

//        mobilenametext=(TextView)findViewById(R.id.mobilenametext);
//        priceTextd=(TextView)findViewById(R.id.priceTextd);
//
//        Intent intent=getIntent();
//        String Mname = intent.getExtras().getString("Mname");
//        String Mprice = intent.getExtras().getString("Mprice");
//
//        mobilenametext.setText(Mname);
//        priceTextd.setText(Mprice);



        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        // Create the adapter that will return a fragment for each of the three
        // primary sections of the activity.
        mSectionsPagerAdapter = new SectionsPagerAdapter(getSupportFragmentManager());

        // Set up the ViewPager with the sections adapter.
        mViewPager = (ViewPager) findViewById(R.id.container);
        mViewPager.setAdapter(mSectionsPagerAdapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabs);
        tabLayout.setupWithViewPager(mViewPager);
        tabLayout.setTabTextColors(R.color.colorBlack,R.color.colorBlack);



    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_card_details, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {


        return false;
    }

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        /**
         * The fragment argument representing the section number for this
         * fragment.
         */
        private static final String ARG_SECTION_NUMBER = "section_number";

        public PlaceholderFragment() {
        }

        /**
         * Returns a new instance of this fragment for the given section
         * number.
         */
        public static final String ORIENTATION="orientation";


        private Boolean mHorizontal;
        NestedScrollView scrollView;
        public ImageButton imageButton;
        ExpandableRelativeLayout expandableLayout1;


       private String subCategoryId;
        String image_url;
        public TextView textViewname, textViewcurncy, textViewprice, textViewcount;
        public TextView textViewclr, textViewstrg, textViewntwk;
        public ImageView imageView;

        String ustring,mname,mcrncy,mprice,mimage;
        String color,strg,netwk;

        ViewPager viewPager;
        int images[] = {R.drawable.applemini1, R.drawable.applemini, R.drawable.apple, R.drawable.apple7plus};
        ImageAdapter imageAdapter;


        private CustomAdapterSite mExampleAdapter1;
        private ArrayList<CardModel> mExampleList1;
        private RequestQueue mRequestQueue1;

        private RecyclerView mRecyclerview1;


     // more sites

        private String MORE_SITE_URL="http://ae.priceomania.com/mobileappwebservices/getCompareProductData?pid=";

        private CustomAdapterSite mExampleAdapter;
        private ArrayList<CardModel> mExampleList;
        private RequestQueue mRequestQueue;

        private RecyclerView mRecyclerview;
        String pid;





        public static PlaceholderFragment newInstance(int sectionNumber) {
            PlaceholderFragment fragment = new PlaceholderFragment();
            Bundle args = new Bundle();
            args.putInt(ARG_SECTION_NUMBER, sectionNumber);

            fragment.setArguments(args);
            return fragment;
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {


            if (getArguments().getInt(ARG_SECTION_NUMBER) == 1) {
                View rootView = inflater.inflate(R.layout.activity_tab1, container, false);





                textViewclr = (TextView) rootView.findViewById(R.id.mcolor);
                textViewstrg = (TextView) rootView.findViewById(R.id.mmemory);
                textViewntwk = (TextView) rootView.findViewById(R.id.mnetwork);


                final Intent intent=getActivity().getIntent();
                Bundle b = intent.getExtras();

                if(b!=null)
                {
                    String color =(String) b.get("color");
                    textViewclr.setText(color);
                    String strg =(String) b.get("storage");
                    textViewstrg.setText(strg);
                    String ntwk =(String) b.get("network");
                    textViewntwk.setText(ntwk);

                }


                textViewname = (TextView) rootView.findViewById(R.id.mobilenametext);
                textViewcurncy = (TextView) rootView.findViewById(R.id.crncytype);
                textViewprice = (TextView) rootView.findViewById(R.id.pricetext1);
                imageView = (ImageView) rootView.findViewById(R.id.cardimg);

                SharedPreferences pref = getActivity().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
//
//                color=pref.getString("color","");
//                strg=pref.getString("storag","");
//                netwk=pref.getString("netwk","");
//
//
//                textViewclr.setText(color);
//                textViewstrg.setText(strg);
//                textViewntwk.setText(netwk);


                ustring=pref.getString("usermessage","");
                mname=pref.getString("name","");
                mcrncy=pref.getString("currency","");
                mprice=pref.getString("price","");
                mimage=pref.getString("cardimage","");

                Glide.with(getActivity())
                        .load(mimage)
                        .fitCenter()
                        .into(imageView);

               // Picasso.with(getActivity()).load(mimage).fit().centerInside().into(imageView);
                textViewname.setText(mname);
                textViewprice.setText(mprice);
                textViewcurncy.setText(mcrncy);



                CardView optionCard=(CardView)rootView.findViewById(R.id.optioncard) ;

                optionCard.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        String color=textViewclr.getText().toString();
                        String storage=textViewstrg.getText().toString();
                        String network=textViewntwk.getText().toString();

                        SharedPreferences pref = v.getContext().getSharedPreferences("MyPrefs", Context.MODE_PRIVATE);
                        SharedPreferences.Editor edit = pref.edit();
                        edit.putString("color",color);
                        edit.putString("storag",storage);
                        edit.putString("netwk",network);

                        edit.commit();
                        Intent intent=new Intent(getActivity(),DialogActivity.class);

                        startActivity(intent);


                    }
                });



                ustring=pref.getString("usermessage","");

                //Log.e("responce",ustring);



                pid=pref.getString("usermessage","");

                // Log.e("responce",pid);


                mExampleList = new ArrayList<>();
                mRecyclerview=(RecyclerView)rootView.findViewById(R.id.siterecycl);
                mRecyclerview.setNestedScrollingEnabled(false);
                mRecyclerview.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
                mRequestQueue = Volley.newRequestQueue(getActivity());
                mRecyclerview.setHasFixedSize(true);

                parseJSON1();


//                mExampleList1 = new ArrayList<>();
//                mRequestQueue1 = Volley.newRequestQueue(getActivity());
//
//                mRecyclerview1=(RecyclerView)rootView.findViewById(R.id.recyclerviewsite);
//                mRecyclerview1.setNestedScrollingEnabled(false);
//                mRecyclerview1.setLayoutManager(new LinearLayoutManager(getActivity(),LinearLayoutManager.VERTICAL,false));
//                mRecyclerview1.setHasFixedSize(true);
//
//                parseJSON1();



//                if (savedInstanceState==null){
//                    mHorizontal=true;
//
//                }else {
//                    mHorizontal=savedInstanceState.getBoolean(ORIENTATION);
//                }

                return rootView;
            }




            else if (getArguments().getInt(ARG_SECTION_NUMBER) == 2) {
                View rootView = inflater.inflate(R.layout.activity_tab2, container, false);
                return rootView;
            } else if (getArguments().getInt(ARG_SECTION_NUMBER) == 3) {
                View rootView = inflater.inflate(R.layout.activity_tab3, container, false);
                return rootView;
            } else {

                View rootView = inflater.inflate(R.layout.fragment_card_details, container, false);
                TextView textView = (TextView) rootView.findViewById(R.id.section_label);
                textView.setText(getString(R.string.section_format, getArguments().getInt(ARG_SECTION_NUMBER)));
                return rootView;
            }

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
                                            object.optString("currency_type"),
                                            object.optString("price"),
                                            object.optString("product_url")));

                                }

                                Log.e("rootJsonArray", String.valueOf(mExampleList));

                                mExampleAdapter = new CustomAdapterSite(getActivity(), mExampleList);
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

            mRequestQueue = Volley.newRequestQueue(getActivity());
            mRequestQueue.add(stringRequest);
        }





//        @Override
//        public void onSaveInstanceState(Bundle outState){
//            super.onSaveInstanceState(outState);
//            outState.putBoolean(ORIENTATION,mHorizontal);
//            //((MyAdapter)recyclerView.getAdapter()).onSaveInstanceState(outState);
//        }


    }

    /**
     * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
     * one of the sections/tabs/pages.
     */
    public class SectionsPagerAdapter extends FragmentPagerAdapter {

        public SectionsPagerAdapter(FragmentManager fm) {
            super(fm);
        }

        @Override
        public Fragment getItem(int position) {
            // getItem is called to instantiate the fragment for the given page.
            // Return a PlaceholderFragment (defined as a static inner class below).
            return PlaceholderFragment.newInstance(position + 1);
        }

        @Override
        public int getCount() {
            // Show 3 total pages.
            return 3;
        }

        @Override
        public CharSequence getPageTitle(int position) {
            switch (position) {
                case 0:
                    return "SECTION 1";
                case 1:
                    return "SECTION 2";
                case 2:
                    return "SECTION 3";
            }
            return null;
        }


    }
    @Override
    public boolean onSupportNavigateUp(){
        finish();
        overridePendingTransition(R.anim.slide_in_left, R.anim.slide_out_left);
        return true;
    }

}
