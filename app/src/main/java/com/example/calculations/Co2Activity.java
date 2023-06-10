package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class Co2Activity extends AppCompatActivity {

    EditText Clenght,Cwidth,Cheight,Caltitude,Ctemp;
    TextView Cresult;
    Button Cclickbutton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_co2);
        Clenght=findViewById(R.id.editTextLenght);
        Cwidth=findViewById(R.id.editTextText2);
        Cheight=findViewById(R.id.editTextText3);
        Caltitude=findViewById(R.id.editTextText4);
        Ctemp=findViewById(R.id.editTextText5);
        Cresult=findViewById(R.id.textView7);
        Cclickbutton=findViewById(R.id.button);

        Cclickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lengthText = Clenght.getText().toString();
                String widthText = Cwidth.getText().toString();
                String heightText = Cheight.getText().toString();


                if (lengthText.isEmpty() || widthText.isEmpty() || heightText.isEmpty()) {
                    Toast.makeText(Co2Activity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();

                } else {
                    double lengthInFeet = Double.parseDouble(Clenght.getText().toString());
                    double widthInFeet = Double.parseDouble(Cwidth.getText().toString());
                    double heightInFeet = Double.parseDouble(Cheight.getText().toString());

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

                    double mtrfactor=Fresult*.0283*1.35;
                    String formattedResult = String.format("%.2f", mtrfactor);



                    Cresult.setText("Agent required is: "+ formattedResult +"KG"); }
            }
        });
    }



}
