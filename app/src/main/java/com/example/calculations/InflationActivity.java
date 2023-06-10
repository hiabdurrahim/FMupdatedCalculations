package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class InflationActivity extends AppCompatActivity {

    EditText oldprice, newprice,oldpricetwo;
    TextView result,resulttwo;
    Button showResultBtn,showresultbtntwo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inflation);

        oldprice = findViewById(R.id.editTextoldprice);
        newprice = findViewById(R.id.editTextNewprice);
        result = findViewById(R.id.textshowresult);
        showResultBtn = findViewById(R.id.resultbutton);
        oldpricetwo=findViewById(R.id.editTextoldprice3);
        resulttwo=findViewById(R.id.textshowresult2);
        showresultbtntwo = findViewById(R.id.resultbutton2);



        showResultBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplayInflation();
            }
        });

        showresultbtntwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calculateAndDisplaySecondResult();
            }
        });
    }

    private void calculateAndDisplayInflation() {
        // Get the input prices as strings
        String oldPriceStr = oldprice.getText().toString().trim();
        String newPriceStr = newprice.getText().toString().trim();

        if (oldPriceStr.isEmpty() || newPriceStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert the input prices to numbers
        double oldPrice = Double.parseDouble(oldPriceStr);
        double newPrice = Double.parseDouble(newPriceStr);

        // Calculate the inflation percentage
        double inflationPercentage = ((newPrice - oldPrice) / oldPrice) * 100;

        // Display the inflation percentage in the result TextView
        result.setText(String.format("Inflation Percentage: %.2f%%", inflationPercentage));
    }
    private void calculateAndDisplaySecondResult() {
        // Get the input old price and inflation percentage as strings
        String oldPriceStr = oldpricetwo.getText().toString().trim();
        String inflationPercentageStr = result.getText().toString().trim();

        // Check if any input field is empty
        if (oldPriceStr.isEmpty() || inflationPercentageStr.isEmpty()) {
            Toast.makeText(this, "Please fill in all details", Toast.LENGTH_SHORT).show();
            return;
        }

        // Convert the input old price and inflation percentage to numbers
        double oldPrice = Double.parseDouble(oldPriceStr);
        double inflationPercentage = Double.parseDouble(inflationPercentageStr.replaceAll("[^\\d.]", ""));

        // Calculate the new price
        double newPrice = oldPrice + (oldPrice * (inflationPercentage / 100));

        // Display the new price in the resulttwo TextView
        resulttwo.setText(String.format("New Price: %.2f", newPrice));
    }
}
