package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FoamActivity extends AppCompatActivity {

    EditText radius;
    TextView showresult;
    Button result;

    Spinner spinner, proportionspinner, Timespinner;
    String[] flowrate = {"0.1", "0.16", "0.2"};
    String[] proportionratio = {"0.3", "0.6"};
    String[] timeduration = {"15", "30", "45", "60"};

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foam);

        spinner = findViewById(R.id.spinner);
        proportionspinner = findViewById(R.id.Propotionspinner);
        Timespinner = findViewById(R.id.Timespinner);
        radius = findViewById(R.id.editTextLength);
        showresult = findViewById(R.id.showresult);
        result = findViewById(R.id.Result);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FoamActivity.this, android.R.layout.simple_spinner_item, flowrate);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> padapter = new ArrayAdapter<String>(FoamActivity.this, android.R.layout.simple_spinner_item, proportionratio);
        padapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        proportionspinner.setAdapter(padapter);

        ArrayAdapter<String> tadapter = new ArrayAdapter<String>(FoamActivity.this, android.R.layout.simple_spinner_item, timeduration);
        tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Timespinner.setAdapter(tadapter);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radiusValue = radius.getText().toString();
                if (radiusValue.isEmpty()) {
                    Toast.makeText(FoamActivity.this, "Please enter a radius value.", Toast.LENGTH_SHORT).show();
                    return;
                }

                String flowrateValue = spinner.getSelectedItem().toString();
                String proportionValue = proportionspinner.getSelectedItem().toString();
                String timeValue = Timespinner.getSelectedItem().toString();

                double resultValue = 3.141592653589793238462643383279502884197*Double.parseDouble(radiusValue) *Double.parseDouble(radiusValue) *
                        Double.parseDouble(flowrateValue) *
                        Double.parseDouble(proportionValue) *
                        Double.parseDouble(timeValue);

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResult = decimalFormat.format(resultValue);

                showresult.setText(formattedResult);
            }
        });
    }
}
