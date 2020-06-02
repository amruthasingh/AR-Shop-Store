package com.example.ar_store_shop;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;

public class ItemActivity extends AppCompatActivity {



    RecyclerView recyclerView;
    ShopAdapter shopAdapter;
    ArrayList<ShopItems> shopItems = new ArrayList<ShopItems>();

    public static final String[] ShopItems= {"Arm Chair","Chair","Cycle","Ficus Plant","Living room Lamp","Antique Sofa","Tulip Vase","Wooden Coffee Table"};
    public static final int[] ItemImg = {R.drawable.armchair,R.drawable.chair,R.drawable.cycle,R.drawable.ficus,R.drawable.living_lamp,R.drawable.antique_sofa,R.drawable.tulip_vase,R.drawable.cof_table};
    public static final String[] Cost = {"100$","50$","159$","20$","49$","300$","69$","500$"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_item);

        for(int i=0;i<ShopItems.length;i++)
        {
            ShopItems items = new ShopItems();

            items.setShopItems(ShopItems[i]);
            items.setImgItems(ItemImg[i]);
            items.setAmount(Cost[i]);

            shopItems.add(items);
        }


        shopAdapter = new ShopAdapter(shopItems);

        recyclerView = (RecyclerView)findViewById(R.id.items);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(shopAdapter);
    }



}













