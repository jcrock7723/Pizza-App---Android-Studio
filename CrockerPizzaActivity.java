/*
October 2018
This Pizza Ordering app was created by me, Jeremy Crocker, and I have abided by the GTCC Academic Integrity Policy.
Web 151 - Halsey
 */

package com.example.admin.crockerpizzaapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

import com.example.admin.crockerpizzaapp.R;

import java.text.NumberFormat;
import java.util.ArrayList;

public class CrockerPizzaActivity extends AppCompatActivity {

    // declare the button variables
    ToggleButton mush_toggle;
    ToggleButton olive_toggle;
    ToggleButton pepper_toggle;
    ToggleButton pepperoni_toggle;
    RadioButton small_pizza;
    RadioButton medium_pizza;
    RadioButton large_pizza;

    Button submitOrder;

    double pizzaPrice;
    int numberToppings = 0;
    double totalSale = 0.00;

    TextView orderDetailsTextView;

    // Declare ArrayList
    ArrayList orderDetailsArray = new ArrayList<String>();


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_crocker_pizza);

        // link submit order button
        submitOrder = findViewById(R.id.submit_order);

        // Link the buttons to the id's
        small_pizza = findViewById(R.id.small_pie);
        medium_pizza = findViewById(R.id.medium_pie);
        large_pizza = findViewById(R.id.large_pie);

        // Toggle buttons for toppings
        mush_toggle = findViewById(R.id.mushroom_btn);
        olive_toggle = findViewById(R.id.olive_btn);
        pepper_toggle = findViewById(R.id.pepper_btn);
        pepperoni_toggle = findViewById(R.id.pepperoni_btn);

        // Connect the order details textview to the UI
        orderDetailsTextView = (TextView) findViewById(R.id.order_details);

        // Set listeners for pizza buttons
        small_pizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //reset if new pizza size is selected
                    orderDetailsArray.clear();
                    mush_toggle.setChecked(false);
                    olive_toggle.setChecked(false);
                    pepper_toggle.setChecked(false);
                    pepperoni_toggle.setChecked(false);


                    orderDetailsArray.add("Personal Pie");
                    calcTotalSmall(numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                    displayOrderComplete(" ");
                }
                else {
                    orderDetailsArray.remove("Personal Pie");
                    displayOrder(orderDetailsArray.toString());
                }
            }
        });

        medium_pizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //reset if new pizza size is selected
                    orderDetailsArray.clear();
                    mush_toggle.setChecked(false);
                    olive_toggle.setChecked(false);
                    pepper_toggle.setChecked(false);
                    pepperoni_toggle.setChecked(false);


                    orderDetailsArray.add("Medium Pie");
                    calcTotalMed(numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                    displayOrderComplete(" ");
                }
                else {
                    orderDetailsArray.remove("Medium Pie");
                    displayOrder(orderDetailsArray.toString());
                }
            }
        });

        large_pizza.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    //reset if new pizza size is selected
                    orderDetailsArray.clear();
                    mush_toggle.setChecked(false);
                    olive_toggle.setChecked(false);
                    pepper_toggle.setChecked(false);
                    pepperoni_toggle.setChecked(false);

                    orderDetailsArray.add("Large Pie");
                    calcTotalLarge(numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                    displayOrderComplete(" ");
                }
                else {
                    orderDetailsArray.remove("Large Pie");
                    displayOrder(orderDetailsArray.toString());
                }
            }
        });


        // Set listeners for toppings buttons
        mush_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    orderDetailsArray.add("Mushrooms");
                    numberToppings++;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
                else {
                    orderDetailsArray.remove("Mushrooms");
                    numberToppings--;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
            }
        });

        olive_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    orderDetailsArray.add("Olives");
                    numberToppings++;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
                else {
                    orderDetailsArray.remove("Olives");
                    numberToppings--;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
            }
        });

        pepper_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    orderDetailsArray.add("Peppers");
                    numberToppings++;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
                else {
                    orderDetailsArray.remove("Peppers");
                    numberToppings--;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
            }
        });

        pepperoni_toggle.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if (isChecked) {
                    orderDetailsArray.add("Pepperoni");
                    numberToppings++;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
                else {
                    orderDetailsArray.remove("Pepperoni");
                    numberToppings--;
                    rollCalc(pizzaPrice,numberToppings);
                    displayPrice(totalSale);
                    displayOrder(orderDetailsArray.toString());
                }
            }
        });

        submitOrder.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                displayOrderComplete("Order Complete, Thanks!");
            }
        });

    }

    private void rollCalc(double price, int toppings) {
        if (price == 6.00) {
            calcTotalSmall(toppings);
        } else if (price == 8.00) {
            calcTotalMed(toppings);
        } else if (price == 10.00) {
            calcTotalLarge(toppings);
        }
    }

    private double calcTotalSmall(int toppers) {
        pizzaPrice = 6.00;
        totalSale = pizzaPrice + (.30*numberToppings);
        return totalSale;
    }

    private double calcTotalMed(int toppers) {
        pizzaPrice = 8.00;
        totalSale = pizzaPrice + (.40*numberToppings);
        return totalSale;
    }

    private double calcTotalLarge(int toppers) {
        pizzaPrice = 10.00;
        totalSale = pizzaPrice + (.50*numberToppings);
        return totalSale;
    }

    /**
     * This method displays the total price on the screen.
     */
    private void displayPrice(double number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the order on the screen.
     */
    private void displayOrder(String order) {
        TextView priceTextView = (TextView) findViewById(R.id.order_details);
        priceTextView.setText(order);
    }

    private void displayOrderComplete(String msg) {
        TextView orderCompleteTextView = (TextView) findViewById(R.id.order_complete_text_view);
        orderCompleteTextView.setText(msg);
    }

    /*@Override
    public String toString() {
        return "CrockerPizzaActivity{" +
                "orderDetailsArray=" +
                '}';
    }*/
}
