package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class CablesizeActivity extends AppCompatActivity {
    Spinner spinner;
    String[] Value = {"","0.5", "0.75","1.0", "1.5","2.0", "3","5", "7.5","10", "12.5","15", "20","25", "30","40", "50", "60","75", "100","120", "150","175", "200"};
    Button result;
    TextView textViewMotorPowerKWB,textViewPhaseCurrentB,textViewStarterTypeB,textViewCircuitBreakerB,textViewContactorSizeB,textViewOverloadRelayB,textViewRequiredCableB,textViewRecommendedCableB,textViewCableLugB;


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cablesize);
        spinner = findViewById(R.id.spinner);
        result=findViewById(R.id.resultbtn);
        textViewMotorPowerKWB=findViewById(R.id.textViewMotorPowerKWB);
        textViewPhaseCurrentB=findViewById(R.id.textViewPhaseCurrentB);
        textViewStarterTypeB=findViewById(R.id.textViewStarterTypeB);
        textViewCircuitBreakerB=findViewById(R.id.textViewCircuitBreakerB);
        textViewContactorSizeB=findViewById(R.id.textViewContactorSizeB);
        textViewOverloadRelayB=findViewById(R.id.textViewOverloadRelayB);
        textViewRequiredCableB=findViewById(R.id.textViewRequiredCableB);
        textViewRecommendedCableB=findViewById(R.id.textViewRecommendedCableB);
        textViewCableLugB=findViewById(R.id.textViewCableLugB);








        ArrayAdapter<String> adapter = new ArrayAdapter<String>(CablesizeActivity.this, android.R.layout.simple_spinner_item, Value);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String MotorValue = spinner.getSelectedItem().toString();
                if (MotorValue.isEmpty()) {
                    Toast.makeText(CablesizeActivity.this, "Please Select Motor Value form Drop Down Box.", Toast.LENGTH_SHORT).show();
                    return;
                }else if (MotorValue.equals("0.5")) {

                    textViewMotorPowerKWB.setText("0.37");
                    textViewPhaseCurrentB.setText("0.6");
                    textViewCircuitBreakerB.setText("1.6");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("6");
                    textViewOverloadRelayB.setText("1.1 to 1.6");
                    textViewRequiredCableB.setText("1.5");
                    textViewRecommendedCableB.setText("2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("0.75")) {

                    textViewMotorPowerKWB.setText("0.55");
                    textViewPhaseCurrentB.setText("0.76");
                    textViewCircuitBreakerB.setText("2.4 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("6");
                    textViewOverloadRelayB.setText("0.75 – 1.1");
                    textViewRequiredCableB.setText("3Cx1.5");
                    textViewRecommendedCableB.setText("3Cx2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("1.0")) {

                    textViewMotorPowerKWB.setText("0.75");
                    textViewPhaseCurrentB.setText("1.3");
                    textViewCircuitBreakerB.setText("2.4 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("6");
                    textViewOverloadRelayB.setText("1.1 to 1.6");
                    textViewRequiredCableB.setText("3Cx1.5");
                    textViewRecommendedCableB.setText("3Cx2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("1.5")) {

                    textViewMotorPowerKWB.setText("1.1");
                    textViewPhaseCurrentB.setText("1.9");
                    textViewCircuitBreakerB.setText("2.4 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("6");
                    textViewOverloadRelayB.setText("1.5 to 3");
                    textViewRequiredCableB.setText("3Cx1.5");
                    textViewRecommendedCableB.setText("3Cx2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("2")) {

                    textViewMotorPowerKWB.setText("1.5");
                    textViewPhaseCurrentB.setText("2.6");
                    textViewCircuitBreakerB.setText("3.2 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("12");
                    textViewOverloadRelayB.setText("1.5 to 3.2");
                    textViewRequiredCableB.setText("3Cx1.5");
                    textViewRecommendedCableB.setText("3Cx2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("3")) {

                    textViewMotorPowerKWB.setText("2.2");
                    textViewPhaseCurrentB.setText("4");
                    textViewCircuitBreakerB.setText("6 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("16");
                    textViewOverloadRelayB.setText("3.2 to 5");
                    textViewRequiredCableB.setText("3Cx1.5");
                    textViewRecommendedCableB.setText("3Cx2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("5")) {

                    textViewMotorPowerKWB.setText("3.7");
                    textViewPhaseCurrentB.setText("6.4");
                    textViewCircuitBreakerB.setText("8 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("16");
                    textViewOverloadRelayB.setText("5 to 8");
                    textViewRequiredCableB.setText("3Cx2.5");
                    textViewRecommendedCableB.setText("3Cx2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("7.5")) {

                    textViewMotorPowerKWB.setText("5.5");
                    textViewPhaseCurrentB.setText("9.7");
                    textViewCircuitBreakerB.setText("16 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("25");
                    textViewOverloadRelayB.setText("10 to 13");
                    textViewRequiredCableB.setText("3Cx2.5");
                    textViewRecommendedCableB.setText("3Cx2.5");
                    textViewCableLugB.setText("2.5");

                }
                else if (MotorValue.equals("10")) {

                    textViewMotorPowerKWB.setText("7.5");
                    textViewPhaseCurrentB.setText("13");
                    textViewCircuitBreakerB.setText("16 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("32");
                    textViewOverloadRelayB.setText("10 to 13");
                    textViewRequiredCableB.setText("3Cx2.5");
                    textViewRecommendedCableB.setText("3Cx4");
                    textViewCableLugB.setText("4");

                }
                else if (MotorValue.equals("12.5")) {

                    textViewMotorPowerKWB.setText("9.3");
                    textViewPhaseCurrentB.setText("17");
                    textViewCircuitBreakerB.setText("20 ");
                    textViewStarterTypeB.setText("DOL");
                    textViewContactorSizeB.setText("32");
                    textViewOverloadRelayB.setText("16 to 22");
                    textViewRequiredCableB.setText("3Cx4");
                    textViewRecommendedCableB.setText("3Cx4");
                    textViewCableLugB.setText("4");

                }
                else if (MotorValue.equals("15")) {

                    textViewMotorPowerKWB.setText("11");
                    textViewPhaseCurrentB.setText("19");
                    textViewCircuitBreakerB.setText("25 ");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("32");
                    textViewOverloadRelayB.setText("18 to 25");
                    textViewRequiredCableB.setText("2x3Cx4");
                    textViewRecommendedCableB.setText("2x3Cx4");
                    textViewCableLugB.setText("4");

                }
                else if (MotorValue.equals("20")) {

                    textViewMotorPowerKWB.setText("15");
                    textViewPhaseCurrentB.setText("26");
                    textViewCircuitBreakerB.setText("32 ");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("32");
                    textViewOverloadRelayB.setText("23 – 28");
                    textViewRequiredCableB.setText("2x3Cx10");
                    textViewRecommendedCableB.setText("2x3Cx10");
                    textViewCableLugB.setText("4");

                }
                else if (MotorValue.equals("25")) {

                    textViewMotorPowerKWB.setText("18.5");
                    textViewPhaseCurrentB.setText("32");
                    textViewCircuitBreakerB.setText("32 ");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("40");
                    textViewOverloadRelayB.setText("30 – 36");
                    textViewRequiredCableB.setText("2x3Cx16");
                    textViewRecommendedCableB.setText("2x3Cx16");
                    textViewCableLugB.setText("16");

                }
                else if (MotorValue.equals("30")) {

                    textViewMotorPowerKWB.setText("22");
                    textViewPhaseCurrentB.setText("38.9");
                    textViewCircuitBreakerB.setText("40 ");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("50");
                    textViewOverloadRelayB.setText("36 – 45");
                    textViewRequiredCableB.setText("2x3Cx25");
                    textViewRecommendedCableB.setText("2x3Cx25");
                    textViewCableLugB.setText("25");

                }
                else if (MotorValue.equals("40")) {

                    textViewMotorPowerKWB.setText("30");
                    textViewPhaseCurrentB.setText("52");
                    textViewCircuitBreakerB.setText("63 ");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("65");
                    textViewOverloadRelayB.setText("47 – 57");
                    textViewRequiredCableB.setText("2x3Cx35");
                    textViewRecommendedCableB.setText("2x3Cx35");
                    textViewCableLugB.setText("35");

                }
                else if (MotorValue.equals("50")) {

                    textViewMotorPowerKWB.setText("37.5");
                    textViewPhaseCurrentB.setText("64.3");
                    textViewCircuitBreakerB.setText("63A to 125A");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("70");
                    textViewOverloadRelayB.setText("62 – 73");
                    textViewRequiredCableB.setText("2x3Cx50");
                    textViewRecommendedCableB.setText("2x3Cx50");
                    textViewCableLugB.setText("50");

                }
                else if (MotorValue.equals("60")) {

                    textViewMotorPowerKWB.setText("45");
                    textViewPhaseCurrentB.setText("78.3");
                    textViewCircuitBreakerB.setText("125");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("75");
                    textViewOverloadRelayB.setText("70 – 95");
                    textViewRequiredCableB.setText("2x3Cx50");
                    textViewRecommendedCableB.setText("2x3Cx50");
                    textViewCableLugB.setText("50");

                }
                else if (MotorValue.equals("75")) {

                    textViewMotorPowerKWB.setText("55");
                    textViewPhaseCurrentB.setText("90");
                    textViewCircuitBreakerB.setText("160");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("75");
                    textViewOverloadRelayB.setText("85 – 105");
                    textViewRequiredCableB.setText("2x3Cx70");
                    textViewRecommendedCableB.setText("2x3Cx70");
                    textViewCableLugB.setText("70");

                }
                else if (MotorValue.equals("100")) {

                    textViewMotorPowerKWB.setText("75");
                    textViewPhaseCurrentB.setText("132");
                    textViewCircuitBreakerB.setText("250");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("140");
                    textViewOverloadRelayB.setText("132-170");
                    textViewRequiredCableB.setText("2x3Cx70");
                    textViewRecommendedCableB.setText("2x3Cx70");
                    textViewCableLugB.setText("70");

                }
                else if (MotorValue.equals("125")) {

                    textViewMotorPowerKWB.setText("90");
                    textViewPhaseCurrentB.setText("155");
                    textViewCircuitBreakerB.setText("250");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("170");
                    textViewOverloadRelayB.setText("115 – 180");
                    textViewRequiredCableB.setText("2x3Cx95");
                    textViewRecommendedCableB.setText("2x3Cx120");
                    textViewCableLugB.setText("120");

                }
                else if (MotorValue.equals("150")) {

                    textViewMotorPowerKWB.setText("110");
                    textViewPhaseCurrentB.setText("178");
                    textViewCircuitBreakerB.setText("400");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("205");
                    textViewOverloadRelayB.setText("160 – 250");
                    textViewRequiredCableB.setText("2x3Cx120");
                    textViewRecommendedCableB.setText("2x3Cx150");
                    textViewCableLugB.setText("150");

                }
                else if (MotorValue.equals("175")) {

                    textViewMotorPowerKWB.setText("132");
                    textViewPhaseCurrentB.setText("233.5");
                    textViewCircuitBreakerB.setText("400");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("250");
                    textViewOverloadRelayB.setText("200 – 320");
                    textViewRequiredCableB.setText("2x3Cx150");
                    textViewRecommendedCableB.setText("2x3Cx150");
                    textViewCableLugB.setText("150");

                }
                else if (MotorValue.equals("200")) {

                    textViewMotorPowerKWB.setText("150");
                    textViewPhaseCurrentB.setText("259.5");
                    textViewCircuitBreakerB.setText("400");
                    textViewStarterTypeB.setText("Star/Delta");
                    textViewContactorSizeB.setText("300");
                    textViewOverloadRelayB.setText("250 – 400");
                    textViewRequiredCableB.setText("2x3Cx150");
                    textViewRecommendedCableB.setText("2x3Cx185");
                    textViewCableLugB.setText("185");

                }
            }
        });
    }
}