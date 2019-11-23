package com.example.seemore;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;

import java.util.ArrayList;

public class SeeMoreActivity extends AppCompatActivity {

    private static final String TAG = "SeeMoreActivity";

    private ArrayList<String> mNames = new ArrayList<>();
    private ArrayList<String> imgURLs = new ArrayList<>();
    private ArrayList<String> mExpDates = new ArrayList<>();
    private ArrayList<String> mQuantities = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_see_more);
        Log.d(TAG,"onCreate: started.");
        initProducts();
        initRecyclerView();
        //initRecyclerView();
    }

    private void  initProducts()
    {
        Log.d(TAG,"initProducts: preparing bitmaps");


        mNames.add("Bananas");
        imgURLs.add("https://c1.staticflickr.com/5/4636/25316407448_de5fbf183d_o.jpg");
        mExpDates.add("30.11.2019");
        mQuantities.add("4");

        mNames.add("Bread");
        imgURLs.add("@mipmap/ic_launcher");
        mExpDates.add("24.11.2019");
        mQuantities.add("2");
/*
        mNames.add("Orange Juice");
        imgURLs.add("https://tipsychickens.com/wp-content/uploads/2018/06/redneck_mimosa.jpg");
        mExpDates.add("02.12.2019");
        mQuantities.add("1");


        mNames.add("Pork");
        imgURLs.add("https://img1.exportersindia.com/product_images/bc-full/2019/2/6139592/pork-meat-1551087120-4747049.jpeg");
        mExpDates.add("28.11.2019");
        mQuantities.add("2");


        mNames.add("Tomatoes");
        imgURLs.add("https://edge.bonnieplants.com/www/uploads/20190122192650/Solanum_MountainMerit_BonniePlants_v2.jpg");
        mExpDates.add("24.11.2019");
        mQuantities.add("5");


        mNames.add("Kiwis");
        imgURLs.add("https://g4.dcdn.lt/images/pix/kiviai-64112496.jpg");
        mExpDates.add("25.11.2019");
        mQuantities.add("10");


        mNames.add("Milk");
        imgURLs.add("https://www.hindustantimes.com/rf/image_size_960x540/HT/p2/2018/09/20/Pictures/_61433f0c-bcb9-11e8-95ec-91800d079bb4.jpg");
        mExpDates.add("30.11.2019");
        mQuantities.add("1");*/
    }

    private void initRecyclerView()
    {
        Log.d(TAG,"initRecyclerView: recyclerview initialization.");
        RecyclerView recyclerView = findViewById(R.id.recyclerViewId);
        RecyclerViewAdapter adapter = new RecyclerViewAdapter(this, mNames,imgURLs,mExpDates,mQuantities);
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
    }
}
