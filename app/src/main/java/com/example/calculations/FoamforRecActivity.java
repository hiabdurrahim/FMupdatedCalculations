package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class FoamforRecActivity extends AppCompatActivity {

    EditText radius,width;
    TextView showresult;
    Button result;

    Spinner spinner, proportionspinner, Timespinner;
    String[] flowrate = {"0.1", "0.16", "0.2"};
    String[] proportionratio = {"0.3", "0.6"};
    String[] timeduration = {"15", "30", "45", "60"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foamfor_rec);

        spinner = findViewById(R.id.spinner);
        proportionspinner = findViewById(R.id.Propotionspinner);
        Timespinner = findViewById(R.id.Timespinner);
        radius = findViewById(R.id.editTextLength);
        showresult = findViewById(R.id.showresult);
        result = findViewById(R.id.Result);
        width=findViewById(R.id.editTextwidth);
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(FoamforRecActivity.this, android.R.layout.simple_spinner_item, flowrate);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        ArrayAdapter<String> padapter = new ArrayAdapter<String>(FoamforRecActivity.this, android.R.layout.simple_spinner_item, proportionratio);
        padapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        proportionspinner.setAdapter(padapter);

        ArrayAdapter<String> tadapter = new ArrayAdapter<String>(FoamforRecActivity.this, android.R.layout.simple_spinner_item, timeduration);
        tadapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        Timespinner.setAdapter(tadapter);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String radiusValue = radius.getText().toString();
                String widthValue = width.getText().toString();
                if (radiusValue.isEmpty()) {
                    Toast.makeText(FoamforRecActivity.this, "Please enter Lenght value.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (widthValue.isEmpty()) {
                    Toast.makeText(FoamforRecActivity.this, "Please enter Width value.", Toast.LENGTH_SHORT).show();
                    return;

                }

                String flowrateValue = spinner.getSelectedItem().toString();
                String proportionValue = proportionspinner.getSelectedItem().toString();
                String timeValue = Timespinner.getSelectedItem().toString();

                double resultValue = Double.parseDouble(radiusValue) *Double.parseDouble(widthValue) *
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