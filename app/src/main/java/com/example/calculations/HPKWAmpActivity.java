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

public class HPKWAmpActivity extends AppCompatActivity {
    TextView showresult,showresult2;
    EditText HP,Kw;
    Button result,result2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hpkwamp);
        HP = findViewById(R.id.editTextHP);
        showresult = findViewById(R.id.showresult);
        result = findViewById(R.id.Result);

        Kw = findViewById(R.id.editTextKw);
        showresult2 = findViewById(R.id.showresult2);
        result2 = findViewById(R.id.Result2);



        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String HPa = HP.getText().toString();

                if (HPa.isEmpty()) {
                    Toast.makeText(HPKWAmpActivity.this, "Please enter HP value.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double HPaValue = Double.parseDouble(HPa);
                double KwValue = HPaValue * 0.7457;
                double sqrt3 = Math.sqrt(3.0);
                double AmpValue = (KwValue * 1000)/(sqrt3*400);

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResultKw = decimalFormat.format(KwValue);
                String formattedResultAmp = decimalFormat.format(AmpValue);

                showresult.setText(HPaValue + " HP of 3 Phase Motor = "+ formattedResultKw +" KW\n                 & \n" +HPaValue + " HP of 3 Phase Motor has "+ formattedResultAmp+" Amp"  );
            }
        });


        result2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Kwa = Kw.getText().toString();

                if (Kwa.isEmpty()) {
                    Toast.makeText(HPKWAmpActivity.this, "Please enter HP value.", Toast.LENGTH_SHORT).show();
                    return;
                }
                double KwaValue = Double.parseDouble(Kwa);
                double HPValue = KwaValue / 0.7457;
                double sqrt3 = Math.sqrt(3.0);
                double AmpValue = (KwaValue * 1000)/(sqrt3*400);

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResultHP = decimalFormat.format(HPValue);
                String formattedResultAmp = decimalFormat.format(AmpValue);

                showresult2.setText(KwaValue + " KW of 3 Phase Motor = "+ formattedResultHP +" HP\n                 & \n" +KwaValue + " KW of 3 Phase Motor has "+ formattedResultAmp+" Amp"  );
            }
        });
    }
}