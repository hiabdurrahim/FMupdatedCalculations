package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class FireSuppressionsystem extends AppCompatActivity {
    Button fm200btn,novecbtn,Co2;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fire_suppressionsystem);

        fm200btn=findViewById(R.id.button2);
        novecbtn=findViewById(R.id.button3);
        Co2=findViewById(R.id.button5);


        fm200btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FireSuppressionsystem.this,MainActivity.class));

            }
        });

        novecbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FireSuppressionsystem.this,NovecActivity.class));

            }
        });

        Co2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(FireSuppressionsystem.this,Co2Activity.class));

            }
        });
    }
}