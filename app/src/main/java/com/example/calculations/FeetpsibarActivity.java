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

public class FeetpsibarActivity extends AppCompatActivity {
    TextView showresult,showresult2;
    EditText feet,gpmtomh;
    Button result,result2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_feetpsibar);
        feet = findViewById(R.id.editTextLength);
        showresult = findViewById(R.id.showresult);
        result = findViewById(R.id.Result);


        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String feeta = feet.getText().toString();

                if (feeta.isEmpty()) {
                    Toast.makeText(FeetpsibarActivity.this, "Please enter Feet value.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double feetaValue = Double.parseDouble(feeta);
                double PsiValue = feetaValue * 0.43341651888775;
                double barValue = feetaValue * 0.029883016988736;

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResultpsi = decimalFormat.format(PsiValue);
                String formattedResultbar = decimalFormat.format(barValue);

                showresult.setText(feetaValue + " Feet of Head = "+ formattedResultpsi+" PSI\n                 & \n" +feetaValue + " Feet of Head = "+ formattedResultbar+" Bar"  );
            }
        });
    }
}