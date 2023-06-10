package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    EditText fmLength, fmWidth, fmHeight;
    TextView fmResult;
    Button fmClickButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        fmLength = findViewById(R.id.editTextLength);
        fmWidth = findViewById(R.id.editTextText2);
        fmHeight = findViewById(R.id.editTextText3);
        fmResult = findViewById(R.id.textView7);
        fmClickButton = findViewById(R.id.button);

        fmClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lengthText = fmLength.getText().toString();
                String widthText = fmWidth.getText().toString();
                String heightText = fmHeight.getText().toString();


                if (lengthText.isEmpty() || widthText.isEmpty() || heightText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();

                } else {
                double lengthInFeet = Double.parseDouble(fmLength.getText().toString());
                double widthInFeet = Double.parseDouble(fmWidth.getText().toString());
                double heightInFeet = Double.parseDouble(fmHeight.getText().toString());

                int lengthFeet = (int) lengthInFeet;
                double lengthInches = (lengthInFeet - lengthFeet) / 12;

                int widthFeet = (int) widthInFeet;
                double widthInches = (widthInFeet - widthFeet) / 12;

                int heightFeet = (int) heightInFeet;
                double heightInches = (heightInFeet - heightFeet) / 12;

                double result = (lengthFeet+lengthInches) * (widthFeet+widthInches) * (heightFeet+heightInches);
                int resulta = (int) result;
                double resultb = (result - resulta) * 12;
                double Fresult=resulta +resultb;

                double mtrfactor=Fresult*.0283*.576;
                String formattedResult = String.format("%.2f", mtrfactor);



                fmResult.setText("Agent required is: "+ formattedResult +"KG"); }
            }
        });
    }
}