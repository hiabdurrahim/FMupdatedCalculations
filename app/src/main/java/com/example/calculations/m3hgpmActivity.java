package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class m3hgpmActivity extends AppCompatActivity {

    TextView showresult,showresult2;
    EditText mhtogpm,gpmtomh;
    Button result,result2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_m3hgpm);
        mhtogpm = findViewById(R.id.editTextLength);
        showresult = findViewById(R.id.showresult);
        result = findViewById(R.id.Result);
        gpmtomh = findViewById(R.id.editgpm);
        showresult2 = findViewById(R.id.showresult2);
        result2 = findViewById(R.id.Result2);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String mhtogpma = mhtogpm.getText().toString();
                String gpmtomha = gpmtomh.getText().toString();
                if (mhtogpma.isEmpty()) {
                    Toast.makeText(m3hgpmActivity.this, "Please enter m³/h value.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double m3hValue = Double.parseDouble(mhtogpma);
                double gpmValue = m3hValue * 4.4028679;

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResult = decimalFormat.format(gpmValue);

                showresult.setText(mhtogpma + " m³/h, GPM is: " + formattedResult);
            }
        });
        result2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String gpmtomha = gpmtomh.getText().toString();
                if (gpmtomha.isEmpty()) {
                    Toast.makeText(m3hgpmActivity.this, "Please enter GPM value.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double gpmValue = Double.parseDouble(gpmtomha);
                double m3hValue = gpmValue * 0.227124741;

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResulta = decimalFormat.format(m3hValue);

                showresult2.setText(gpmtomha + " GPM, in m3/h is: " + formattedResulta);
            }
        });
    }
}
