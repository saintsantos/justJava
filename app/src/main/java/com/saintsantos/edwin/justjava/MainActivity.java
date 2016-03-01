package com.saintsantos.edwin.justjava;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;
import com.saintsantos.edwin.justjava.FindPrice;
import com.saintsantos.edwin.justjava.FindPriceImpl;

/**
 * This app displays a form to order coffee
 */

public class MainActivity extends AppCompatActivity {

    private int coffeeNumber;
    private final String TAG = "coffee";
    private FindPrice findMyPrice;
    private int cost = 5;
    private Boolean cream = false;
    private boolean milk = false;
    private boolean sugar = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findMyPrice = new FindPriceImpl(this);
    }

    /**
     * This method is called when the order button is clicked.
     */

    public void submitOrder(View view) {
        Log.d(TAG, "Your order has been submitted!");
        //Toast.makeText(getApplicationContext(), "Your order has been successfully submitted!", Toast.LENGTH_SHORT).show();
        int finalPrice = findMyPrice.calcPrice(coffeeNumber, cost);
        Intent intent = new Intent(this, OrderActivity.class);
    }

    public void addOne(View view) {
        Log.d(TAG, "Adding one");
        coffeeNumber++;
        findMyPrice.displayAll(coffeeNumber, cost);
    }

    public void subOne(View view) {
        if (coffeeNumber != 0) {
            Log.d(TAG, "Subtracting one");
            coffeeNumber--;
        } else {
            Log.d(TAG, "Can't subtract, already a at 0");
        }
        findMyPrice.displayAll(coffeeNumber, cost);
    }

    public void reset(View view) {

        coffeeNumber = 0;
        findMyPrice.displayAll(coffeeNumber, cost);
        TextView priceView = (TextView) findViewById(R.id.price_text_view);
        CheckBox milkBox = (CheckBox) findViewById(R.id.milkBox);
        CheckBox creamBox = (CheckBox) findViewById(R.id.creamBox);
        CheckBox sugarBox = (CheckBox) findViewById(R.id.sugarBox);
        if(milkBox.isChecked()) {
            milkBox.toggle();
        }

        if(creamBox.isChecked()) {
            creamBox.toggle();
        }

        if(sugarBox.isChecked()) {
            sugarBox.toggle();
        }


        priceView.setText("");
    }

    public void wantCream(View view) {
        if (cream == false) {
            cream = true;
        } else {
            cream = false;
        }

    }

    public void wantMilk(View view) {
        if (milk == false) {
            milk = true;
        } else {
            milk = false;
        }
    }

    public void wantSugar(View view) {
        if (sugar == true) {
            sugar = false;
        } else {
            sugar = true;
        }
    }


}
