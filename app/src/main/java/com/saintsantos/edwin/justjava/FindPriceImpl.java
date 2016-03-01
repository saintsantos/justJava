package com.saintsantos.edwin.justjava;

import android.widget.TextView;

import com.saintsantos.edwin.justjava.MainActivity;

/**
 * Created by edwin on 2/11/16.
 */
public class FindPriceImpl implements FindPrice  {

    private static final String total = "Total: $";
    private MainActivity main;

    public FindPriceImpl(MainActivity mainAct) {
        //main = mainAct;

    }

    public int calcPrice(int quantity, int price) {
        int finalPrice = quantity * price;
        return finalPrice;
    }



    public void displayAll(int quantity, int price) {
        TextView priceView = (TextView) main.findViewById(R.id.price_text_view);
        TextView quantityView =  (TextView) main.findViewById(R.id.quantity_text_view);
        quantityView.setText("" + quantity);
        int finalPrice = calcPrice(quantity, price);
        priceView.setText(total + finalPrice);
    }
}
