package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class NovecActivity extends AppCompatActivity {

    EditText Nlenght,Nwidth,Nheight,Naltitude,Ntemp;
    TextView Nresult;
    Button Nclickbutton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_novec);
        Nlenght=findViewById(R.id.editTextLenght);
        Nwidth=findViewById(R.id.editTextText2);
        Nheight=findViewById(R.id.editTextText3);
        Naltitude=findViewById(R.id.editTextText4);
        Ntemp=findViewById(R.id.editTextText5);
        Nresult=findViewById(R.id.textView7);
        Nclickbutton=findViewById(R.id.button);

        Nclickbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lengthText = Nlenght.getText().toString();
                String widthText = Nwidth.getText().toString();
                String heightText = Nheight.getText().toString();


                if (lengthText.isEmpty() || widthText.isEmpty() || heightText.isEmpty()) {
                    Toast.makeText(NovecActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();

                } else {
                    double lengthInFeet = Double.parseDouble(Nlenght.getText().toString());
                    double widthInFeet = Double.parseDouble(Nwidth.getText().toString());
                    double heightInFeet = Double.parseDouble(Nheight.getText().toString());

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

                    double mtrfactor=Fresult*.0283*.673;
                    String formattedResult = String.format("%.2f", mtrfactor);



                    Nresult.setText("Agent required is: "+ formattedResult +"KG"); }
            }
        });
    }
}