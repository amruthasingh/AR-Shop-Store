package com.example.ar_store_shop;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

class PaymentDetails extends AppCompatActivity {

    TextView txtId,txtAmount, txtStatus;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payment_details);

        txtId = (TextView)findViewById(R.id.txtId);
        txtAmount = (TextView)findViewById(R.id.txtAmount);
        txtStatus = (TextView)findViewById(R.id.txtStatus);

        Intent intent = getIntent();

        try{
            Log.d("Payment Details activity","inside try line 288888888888888888888");
            JSONObject jsonObject = new JSONObject(intent.getStringExtra("PaymentDetails"));
           showDetails(jsonObject.getJSONObject("response"), intent.getStringExtra("PaymentAmount"));

        } catch(JSONException e){
            e.printStackTrace();
        }

    }

    private void showDetails(JSONObject response, String paymentAmount){
        try{
            Log.d("Payment Details activity","inside try line 399999999999999");
            Log.d("line 41","amount is" + paymentAmount);
            Log.d("line 42","id is" + txtId);
            Log.d("line 43","satus is" + txtStatus);
           txtId.setText(response.getString("id"));
           txtStatus.setText(response.getString("status"));
           txtAmount.setText("$"+ paymentAmount);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}
