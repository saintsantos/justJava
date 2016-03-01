package com.saintsantos.edwin.justjava;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;


public class OrderActivity extends AppCompatActivity {

    private final String TAG = "OrderActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order);

        Intent intent = getIntent();
        int displayValue = intent.getIntExtra("displayValue", 0);
        int coffeeCount = intent.getIntExtra("coffeeCount", 0);
        Boolean milk = intent.getIntExtra("milkBool", true);
        Boolean cream = intent.getIntExtra("creamBool", true);
        Boolean sugar = intent.getBooleanExtra("sugarBool", true);
        TextView milkView = (TextView) findViewById(R.id.milk);
        TextView creamView = (TextView) findViewById(R.id.cream);
        TextView sugarView = (TextView) findViewById(R.id.sugar);

        if (milk == true) {
            milkView.setText("Add milk");
        } else {
            milkView.setText("");
        }

        if (cream == true) {
            creamView.setText("Add cream");
        } else {
            creamView.setText("");
        }

        if (sugar == true) {
            sugarView.setText("Add sugar");
        } else {
            sugarView.setText("");
        }

        TextView priceView = (TextView) findViewById(R.id.priceLabel);
        TextView coffeeView = (TextView) findViewById(R.id.coffeeTotal);

        coffeeView.setText("Coffees: " + coffeeCount);

        if (displayValue == 0) {
            TextView total = (TextView) findViewById(R.id.Total);
            total.setText("");
        } else {
            priceView.setText("$" + displayValue);
            Log.d(TAG, "disPlayValue: " + displayValue);
        }


    }

}
