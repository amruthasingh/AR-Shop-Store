package com.example.ar_store_shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.HashMap;
import java.util.Map;
public class CartActivity extends AppCompatActivity {
    //FirebaseAuth auth;
    DatabaseReference databaseReference;
    TextView itemname;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cart);
        Intent i = getIntent();
        String item = i.getStringExtra("Selected Item");
        Log.v("<----Selected item----->: ", item);
        itemname = findViewById(R.id.itemName);
        itemname.setText("Item Name :" + item);
        databaseReference = FirebaseDatabase.getInstance().getReference().child("Users");
    }

    public void gotoItem(View view) {
        Intent i = new Intent(getApplicationContext(), ItemActivity.class);
        startActivity(i);
    }

    public void paynow(View view) {

        Intent i = new Intent(getApplicationContext(), DashboardActivity.class);
        Map userMap=new HashMap();
        userMap.put("itemname","chair");
        userMap.put("price","10");
        userMap.put("quantity","2");
        databaseReference.child("Users").setValue(userMap).addOnCompleteListener(new OnCompleteListener<Void>() {
            @Override
            public void onComplete(@NonNull Task<Void> task) {
                if(task.isSuccessful()){
                    Toast.makeText(CartActivity.this, "Details added successfully", Toast.LENGTH_SHORT).show();
                }
                else{
                    Toast.makeText(CartActivity.this, "Failed...", Toast.LENGTH_SHORT).show();
                }
            }
        } );

        startActivity(i);
    }
}
