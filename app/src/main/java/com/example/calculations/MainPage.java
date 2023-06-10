package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainPage extends AppCompatActivity {

    Button fireSupbtn,Elect,Mech,Inflation,About,calcultor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        fireSupbtn=findViewById(R.id.button2);

        Elect=findViewById(R.id.button5);
        Mech=findViewById(R.id.button7);
        Inflation=findViewById(R.id.button9);
        calcultor=findViewById(R.id.button1a);
        About=findViewById(R.id.button8);

        calcultor.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,Calculator.class));

            }
        });

        fireSupbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,FireSuppressionsystem.class));

            }
        });


        Elect.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,ElectricalActivity.class));

            }
        });
        Mech.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,MechanicalActivity.class));

            }
        });
        Inflation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,InflationActivity.class));

            }
        });
        About.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MainPage.this,AboutActivity.class));

            }
        });
    }
}