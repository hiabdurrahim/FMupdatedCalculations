package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ElectricalActivity extends AppCompatActivity {
    Button FAS,FSS,HP,Cablesize,Amps;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_electrical);
        FAS=findViewById(R.id.button4);
       // FSS=findViewById(R.id.button5);
        HP=findViewById(R.id.button6);
        Amps=findViewById(R.id.button7);
        Cablesize=findViewById(R.id.button8);

        FAS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElectricalActivity.this, FASQuoteActivity.class));

            }
        });
       /* FSS.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElectricalActivity.this, FSSQuoteActivity.class));

            }
        });*/
        HP.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElectricalActivity.this, HPKWAmpActivity.class));

            }
        });
        Amps.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElectricalActivity.this, ThreePhasemotorAmp.class));

            }
        });
        Cablesize.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(ElectricalActivity.this, CablesizeActivity.class));

            }
        });
    }
}