package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
import java.util.HashMap;
import java.util.Map;

public class MainActivity extends AppCompatActivity {
    private  Map<Integer, Double> altitudeMap;
    private Map<String, Double> mappingTable;
    EditText fmLength, fmWidth, fmHeight, fmtemp, fmconcentration,fmAltitude;
    TextView fmResult;
    Button fmClickButton;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initializeMappingTable();
        initializealtitudeMap();

        fmLength = findViewById(R.id.editTextLength);
        fmWidth = findViewById(R.id.editTextText2);
        fmHeight = findViewById(R.id.editTextText3);
        fmResult = findViewById(R.id.textView7);
        fmClickButton = findViewById(R.id.button);
        fmtemp = findViewById(R.id.editTextText5);
        fmconcentration = findViewById(R.id.textView6);
        fmAltitude=findViewById(R.id.editTextText4);

        fmClickButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String lengthText = fmLength.getText().toString();
                String widthText = fmWidth.getText().toString();
                String heightText = fmHeight.getText().toString();
                String TempText = fmtemp.getText().toString();
                String concentrationText = fmconcentration.getText().toString();
                String AltitudeText = fmAltitude.getText().toString();

                if (lengthText.isEmpty() || widthText.isEmpty() || heightText.isEmpty() ||
                        TempText.isEmpty() || concentrationText.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!AltitudeText.equals("0") && !AltitudeText.equals("500") && !AltitudeText.equals("1000") && !AltitudeText.equals("1500") &&
                        !AltitudeText.equals("2000") && !AltitudeText.equals("2500") && !AltitudeText.equals("3000") && !AltitudeText.equals("3500") &&
                        !AltitudeText.equals("4000") && !AltitudeText.equals("4500")) {
                    Toast.makeText(MainActivity.this, "Acceptable Altitude Values are\n 0, 500 ,1000, 1500 ,  2000 ,2500,\n3000, 3500, 4000, 4500", Toast.LENGTH_SHORT).show();
                    return;
                }





                int fmtemp;
                try {
                    fmtemp = Integer.parseInt(TempText);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid fmtemp value", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!TempText.equals("5") && !TempText.equals("10") && !TempText.equals("15") && !TempText.equals("20") &&
                        !TempText.equals("25") && !TempText.equals("30") && !TempText.equals("35") && !TempText.equals("40") &&
                        !TempText.equals("45") && !TempText.equals("50")) {
                    Toast.makeText(MainActivity.this, "Acceptable Temp Values are\n 5,10,15,20,25,30,35,40,45 or 50", Toast.LENGTH_SHORT).show();
                    return;
                }

                double fmconcentration;
                try {
                    fmconcentration = Double.parseDouble(concentrationText);
                } catch (NumberFormatException e) {
                    Toast.makeText(MainActivity.this, "Invalid fmconcentration value", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (!concentrationText.equals("6.20") && !concentrationText.equals("6.40") && !concentrationText.equals("6.60") && !concentrationText.equals("6.80") &&
                        !concentrationText.equals("7") && !concentrationText.equals("7.17") && !concentrationText.equals("7.20") && !concentrationText.equals("7.40") &&
                        !concentrationText.equals("7.60") && !concentrationText.equals("7.80")&& !concentrationText.equals("8")) {
                    Toast.makeText(MainActivity.this, "Acceptable Concentration Values are\n 6.20,6.40,6.60,6.80,7,7.20,7.40,7.60,7.80 or 8", Toast.LENGTH_SHORT).show();
                    return;
                }



                String key = fmtemp + "-" + String.format("%.2f", fmconcentration);


                if (mappingTable.containsKey(key)) {

                    double result = mappingTable.get(key);
                    int AltitudeTexta=Integer.parseInt(AltitudeText);
                    double y=altitudeMap.get(AltitudeTexta);
                    //Toast.makeText(MainActivity.this, "Result: " + y, Toast.LENGTH_SHORT).show();
                    double lengthInFeet = Double.parseDouble(lengthText);
                    double widthInFeet = Double.parseDouble(widthText);
                    double heightInFeet = Double.parseDouble(heightText);

                    int lengthFeet = (int) lengthInFeet;
                    double lengthInches = (lengthInFeet - lengthFeet) / 12;

                    int widthFeet = (int) widthInFeet;
                    double widthInches = (widthInFeet - widthFeet) / 12;

                    int heightFeet = (int) heightInFeet;
                    double heightInches = (heightInFeet - heightFeet) / 12;

                    double resultbb = (lengthFeet + lengthInches) * (widthFeet + widthInches) * (heightFeet + heightInches);
                    int resulta = (int) resultbb;
                    double resultb = (resultbb - resulta) * 12;
                    double Fresult = resulta + resultb;
                    //Toast.makeText(MainActivity.this, "Result: " + Fresult , Toast.LENGTH_SHORT).show();

                    double mtrfactor = Fresult * 0.0283 * result*y;
                    String formattedResult = String.format("%.2f", mtrfactor);

                    fmResult.setText("Agent required is: " + formattedResult + "KG");
                } else {
                    Toast.makeText(MainActivity.this, "No matching result found for the given fmtemp and fmconcentration", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
    private void initializealtitudeMap() {
        // Fill in the mapping table with the desired values
        altitudeMap = new HashMap<>();
        altitudeMap.put(0, 1.0);
        altitudeMap.put(500, .94);
        altitudeMap.put(1000, .885);
        altitudeMap.put(1500, .830);
        altitudeMap.put(2000, .785);
        altitudeMap.put(2500, .735);
        altitudeMap.put(3000, .690);
        altitudeMap.put(3500, .650);
        altitudeMap.put(4000, .610);
        altitudeMap.put(4500, .565);
    }

    private void initializeMappingTable() {
        // Fill in the mapping table with the desired values
        mappingTable = new HashMap<>();
        mappingTable.put("5-6.20", .5105);
        mappingTable.put("5-6.40", .5281);
        mappingTable.put("5-6.60", .5458);
        mappingTable.put("5-6.80", .5636);
        mappingTable.put("5-7.00", .5814);
        mappingTable.put("5-7.17", .5966);
        mappingTable.put("5-7.20", .5993);
        mappingTable.put("5-7.40", .6123);
        mappingTable.put("5-7.60", .6360);
        mappingTable.put("5-7.80", .6520);
        mappingTable.put("5-8.00", .6717);

        mappingTable.put("10-6.20", .5006);
        mappingTable.put("10-6.40", .5179);
        mappingTable.put("10-6.60", .5352);
        mappingTable.put("10-6.80", .5526);
        mappingTable.put("10-7.00", .5701);
        mappingTable.put("10-7.17", .5850);
        mappingTable.put("10-7.20", .5876);
        mappingTable.put("10-7.40", .6021);
        mappingTable.put("10-7.60", .6241);
        mappingTable.put("10-7.80", .6380);
        mappingTable.put("10-8.00", .6586);

        //  mappingTable.put("20-7.17", .576);

        mappingTable.put("15-6.20", .492);
        mappingTable.put("15-6.40", .509);
        mappingTable.put("15-6.60", .523);
        mappingTable.put("15-6.80", .542);
        mappingTable.put("15-7.00", .560);
        mappingTable.put("15-7.17", .569);
        mappingTable.put("15-7.20", .577);
        mappingTable.put("15-7.40", .594);
        mappingTable.put("15-7.60", .612);
        mappingTable.put("15-7.80", .630);
        mappingTable.put("15-8.00", .647);

        mappingTable.put("20-6.20", .482);
        mappingTable.put("20-6.40", .499);
        mappingTable.put("20-6.60", .515);
        mappingTable.put("20-6.80", .532);
        mappingTable.put("20-7.00", .549);
        mappingTable.put("20-7.17", .556);
        mappingTable.put("20-7.20", .566);
        mappingTable.put("20-7.40", .583);
        mappingTable.put("20-7.60", .600);
        mappingTable.put("20-7.80", .610);
        mappingTable.put("20-8.00", .634);

        mappingTable.put("25-6.20", .474);
        mappingTable.put("25-6.40", .490);
        mappingTable.put("25-6.60", .505);
        mappingTable.put("25-6.80", .523);
        mappingTable.put("25-7.00", .539);
        mappingTable.put("25-7.17", .546);
        mappingTable.put("25-7.20", .556);
        mappingTable.put("25-7.40", .572);
        mappingTable.put("25-7.60", .589);
        mappingTable.put("25-7.80", .600);
        mappingTable.put("25-8.00", .623);


        mappingTable.put("30-6.20", .465);
        mappingTable.put("30-6.40", .481);
        mappingTable.put("30-6.60", .499);
        mappingTable.put("30-6.80", .513);
        mappingTable.put("30-7.00", .529);
        mappingTable.put("30-7.17", .538);
        mappingTable.put("30-7.20", .546);
        mappingTable.put("30-7.40", .562);
        mappingTable.put("30-7.60", .579);
        mappingTable.put("30-7.80", .590);
        mappingTable.put("30-8.00", .612);

        mappingTable.put("35-6.20", .457);
        mappingTable.put("35-6.40", .473);
        mappingTable.put("35-6.60", .490);
        mappingTable.put("35-6.80", .504);
        mappingTable.put("35-7.00", .520);
        mappingTable.put("35-7.17", .528);
        mappingTable.put("35-7.20", .536);
        mappingTable.put("35-7.40", .552);
        mappingTable.put("35-7.60", .575);
        mappingTable.put("35-7.80", .586);
        mappingTable.put("35-8.00", .601);


        mappingTable.put("40-6.20", .449);
        mappingTable.put("40-6.40", .464);
        mappingTable.put("40-6.60", .468);
        mappingTable.put("40-6.80", .495);
        mappingTable.put("40-7.00", .511);
        mappingTable.put("40-7.17", .515);
        mappingTable.put("40-7.20", .527);
        mappingTable.put("40-7.40", .543);
        mappingTable.put("40-7.60", .558);
        mappingTable.put("40-7.80", .576);
        mappingTable.put("40-8.00", .590);


        mappingTable.put("45-6.20", .441);
        mappingTable.put("45-6.40", .456);
        mappingTable.put("45-6.60", .469);
        mappingTable.put("45-6.80", .487);
        mappingTable.put("45-7.00", .502);
        mappingTable.put("45-7.17", .510);
        mappingTable.put("45-7.20", .518);
        mappingTable.put("45-7.40", .533);
        mappingTable.put("45-7.60", .549);
        mappingTable.put("45-7.80", .565);
        mappingTable.put("45-8.00", .580);

        mappingTable.put("50-6.20", .434);
        mappingTable.put("50-6.40", .449);
        mappingTable.put("50-6.60", .462);
        mappingTable.put("50-6.80", .479);
        mappingTable.put("50-7.00", .494);
        mappingTable.put("50-7.17", .500);
        mappingTable.put("50-7.20", .509);
        mappingTable.put("50-7.40", .524);
        mappingTable.put("50-7.60", .540);
        mappingTable.put("50-7.80", .558);
        mappingTable.put("50-8.00", .571);

       /* mappingTable.put("55-6.20", 'a');
        mappingTable.put("55-6.40", 'a');
        mappingTable.put("55-6.60", 'a');
        mappingTable.put("55-6.80", 'a');
        mappingTable.put("55-7.00", 'a');
        mappingTable.put("55-7.17", 'a');
        mappingTable.put("55-7.20", 'a');
        mappingTable.put("55-7.40", 'a');
        mappingTable.put("55-7.60", 'a');
        mappingTable.put("55-7.80", 'a');
        mappingTable.put("55-8.00", 'a');

        mappingTable.put("60-6.20", 'a');
        mappingTable.put("60-6.40", 'a');
        mappingTable.put("60-6.60", 'a');
        mappingTable.put("60-6.80", 'a');
        mappingTable.put("60-7.00", 'a');
        mappingTable.put("60-7.17", 'a');
        mappingTable.put("60-7.20", 'a');
        mappingTable.put("60-7.40", 'a');
        mappingTable.put("60-7.60", 'a');
        mappingTable.put("60-7.80", 'a');
        mappingTable.put("60-8.00", 'a');
*/


    }
}
