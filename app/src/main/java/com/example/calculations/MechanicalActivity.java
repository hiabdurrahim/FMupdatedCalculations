package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MechanicalActivity extends AppCompatActivity {
    Button Foambtnroundarea,Foambtnsquarea,m3htogpm,ftbarpsi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mechanical);
        Foambtnroundarea=findViewById(R.id.Foambtnroundare);
        Foambtnsquarea=findViewById(R.id.Foambtnsqur);
        m3htogpm=findViewById(R.id.button4);
        ftbarpsi=findViewById(R.id.button5);

        Foambtnroundarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MechanicalActivity.this,FoamActivity.class));

            }
        });
        Foambtnsquarea.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MechanicalActivity.this,FoamforRecActivity.class));

            }
        });
        m3htogpm.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MechanicalActivity.this,m3hgpmActivity.class));

            }
        });
        ftbarpsi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(MechanicalActivity.this,FeetpsibarActivity.class));

            }
        });
    }
}