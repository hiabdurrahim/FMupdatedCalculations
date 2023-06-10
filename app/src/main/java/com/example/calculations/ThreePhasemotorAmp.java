package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

public class ThreePhasemotorAmp extends AppCompatActivity {
    RadioGroup radioGroup;
    RadioButton radioButton;

    EditText Valuehpkw,voltage,powerfactor,efficency;
    TextView showresult;
    Button result;

    Spinner spinner;

    String[] Value = {"HP", "Kw"};


    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_three_phasemotor_amp);
        Valuehpkw=findViewById(R.id.editTextHP);
        voltage=findViewById(R.id.editTextHP4);
        powerfactor=findViewById(R.id.editTextHP5);
        efficency=findViewById(R.id.editTextHP6);
        showresult=findViewById(R.id.showresult);
        spinner = findViewById(R.id.spinner);
        radioGroup=findViewById(R.id.radioGroup);
        radioGroup.check(R.id.Threephase); //to set select Three phase by default

        result=findViewById(R.id.Result);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(ThreePhasemotorAmp.this, android.R.layout.simple_spinner_item, Value);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        result.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int singleorthreephaseradioselected=radioGroup.getCheckedRadioButtonId();
                radioButton=findViewById(singleorthreephaseradioselected);
                String phaseselected=radioButton.getText().toString();
                String ValueValuehpkw = Valuehpkw.getText().toString();
                String Valuevoltage = voltage.getText().toString();
                String Valuepowerfactor = powerfactor.getText().toString();
                String Valueefficency= efficency.getText().toString();
                String MotorValue = spinner.getSelectedItem().toString();
                if (ValueValuehpkw.isEmpty()) {
                    Toast.makeText(ThreePhasemotorAmp.this, "Please enter a Motor Value in HP/KW.", Toast.LENGTH_SHORT).show();
                    return;
                } else if (Valuevoltage.isEmpty()) {

                    Toast.makeText(ThreePhasemotorAmp.this, "Please enter operating voltage", Toast.LENGTH_SHORT).show();
                    return;

                }
                else if (Valuepowerfactor.isEmpty()) {

                    Toast.makeText(ThreePhasemotorAmp.this, "Please enter Motor Power Factor.", Toast.LENGTH_SHORT).show();
                    return;

                }
                else if (Valueefficency.isEmpty()) {

                    Toast.makeText(ThreePhasemotorAmp.this, "Please enter Motor Efficency", Toast.LENGTH_SHORT).show();
                    return;

                } else if (phaseselected.equals("Single Phase") && MotorValue.equals("Kw")) {

                    if (Double.parseDouble(Valuevoltage)<=185||Double.parseDouble(Valuevoltage)>=235) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter operating voltage between 185 to 230", Toast.LENGTH_SHORT).show();
                        return;

                    }else if (Double.parseDouble(Valuepowerfactor)<=0||Double.parseDouble(Valuepowerfactor)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter PF between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else if (Double.parseDouble(Valueefficency)<=0||Double.parseDouble(Valueefficency)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter Efficency between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else {
                     double currentAmp=(Double.parseDouble (ValueValuehpkw)*1000)/(Double.parseDouble(Valuepowerfactor)*Double.parseDouble(Valueefficency)*Double.parseDouble(Valuevoltage));

                        if (currentAmp<=15.5) {
                            String a= "1.5 mm2";

                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);}
                        else if (currentAmp>15.5 && currentAmp<=23) {
                            String a= "2.5 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>23 && currentAmp<=30) {
                            String a= "4 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>30 && currentAmp<=38) {
                            String a= "6 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>38 && currentAmp<=52) {
                            String a= "10 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>52 && currentAmp<=68) {
                            String a= "16 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>68 && currentAmp<=89) {
                            String a= "25 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>89 && currentAmp<=110) {
                            String a= "35 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>110 && currentAmp<=134) {
                            String a= "50 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>134 && currentAmp<=171) {
                            String a= "70 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>171 && currentAmp<=207) {
                            String a= "95 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>207 && currentAmp<=239) {
                            String a= "120 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>239 && currentAmp<=262) {
                            String a= "150 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>262 && currentAmp<=296) {
                            String a= "185 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>296 && currentAmp<=346) {
                            String a= "240 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>346 && currentAmp<=394) {
                            String a= "300 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>394 && currentAmp<=467) {
                            String a= "400 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n "+a+" Cable is Required");

                        }
                        else if (currentAmp>467 && currentAmp<=533) {
                            String a= "500 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>533 && currentAmp<=611) {
                            String a= "600 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else   {
                            String a= "It is Beyond my Knowledge";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n  "+a);

                        }}}

                else if (phaseselected.equals("Single Phase") && MotorValue.equals("HP")) {

                    if (Double.parseDouble(Valuevoltage)<=185||Double.parseDouble(Valuevoltage)>=235) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter operating voltage between 185 to 230", Toast.LENGTH_SHORT).show();
                        return;

                    }else if (Double.parseDouble(Valuepowerfactor)<=0||Double.parseDouble(Valuepowerfactor)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter PF between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else if (Double.parseDouble(Valueefficency)<=0||Double.parseDouble(Valueefficency)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter Efficency between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }else {
                        double currentAmp=(Double.parseDouble (ValueValuehpkw)*746)/(Double.parseDouble(Valuepowerfactor)*Double.parseDouble(Valueefficency)*Double.parseDouble(Valuevoltage));
                        if (currentAmp<=15.5) {
                            String a= "1.5 mm2";

                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);}
                        else if (currentAmp>15.5 && currentAmp<=23) {
                            String a= "2.5 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>23 && currentAmp<=30) {
                            String a= "4 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>30 && currentAmp<=38) {
                            String a= "6 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>38 && currentAmp<=52) {
                            String a= "10 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>52 && currentAmp<=68) {
                            String a= "16 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>68 && currentAmp<=89) {
                            String a= "25 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>89 && currentAmp<=110) {
                            String a= "35 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>110 && currentAmp<=134) {
                            String a= "50 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>134 && currentAmp<=171) {
                            String a= "70 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>171 && currentAmp<=207) {
                            String a= "95 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>207 && currentAmp<=239) {
                            String a= "120 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>239 && currentAmp<=262) {
                            String a= "150 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>262 && currentAmp<=296) {
                            String a= "185 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>296 && currentAmp<=346) {
                            String a= "240 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>346 && currentAmp<=394) {
                            String a= "300 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>394 && currentAmp<=467) {
                            String a= "400 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n "+a+" Cable is Required");

                        }
                        else if (currentAmp>467 && currentAmp<=533) {
                            String a= "500 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>533 && currentAmp<=611) {
                            String a= "600 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else   {
                            String a= "It is Beyond my Knowledge";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n  "+a);

                        }
                        }}



                else if (phaseselected.equals("Three Phase") && MotorValue.equals("HP")) {

                    if (Double.parseDouble(Valuevoltage)<=370||Double.parseDouble(Valuevoltage)>=435) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter operating voltage between 380 to 430", Toast.LENGTH_SHORT).show();
                        return;

                    }else if (Double.parseDouble(Valuepowerfactor)<=0||Double.parseDouble(Valuepowerfactor)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter PF between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else if (Double.parseDouble(Valueefficency)<=0||Double.parseDouble(Valueefficency)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter Efficency between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }else {
                        double sqrt3 = Math.sqrt(3.0);
                        double currentAmp=(Double.parseDouble (ValueValuehpkw)*746)/(sqrt3*Double.parseDouble(Valuepowerfactor)*Double.parseDouble(Valueefficency)*Double.parseDouble(Valuevoltage));
                        if (currentAmp<=15.5) {
                            String a= "1.5 mm2";

                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);}
                        else if (currentAmp>15.5 && currentAmp<=23) {
                            String a= "2.5 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>23 && currentAmp<=30) {
                            String a= "4 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>30 && currentAmp<=38) {
                            String a= "6 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>38 && currentAmp<=52) {
                            String a= "10 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>52 && currentAmp<=68) {
                            String a= "16 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>68 && currentAmp<=89) {
                            String a= "25 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>89 && currentAmp<=110) {
                            String a= "35 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>110 && currentAmp<=134) {
                            String a= "50 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>134 && currentAmp<=171) {
                            String a= "70 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>171 && currentAmp<=207) {
                            String a= "95 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>207 && currentAmp<=239) {
                            String a= "120 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>239 && currentAmp<=262) {
                            String a= "150 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>262 && currentAmp<=296) {
                            String a= "185 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>296 && currentAmp<=346) {
                            String a= "240 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>346 && currentAmp<=394) {
                            String a= "300 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>394 && currentAmp<=467) {
                            String a= "400 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n "+a+" Cable is Required");

                        }
                        else if (currentAmp>467 && currentAmp<=533) {
                            String a= "500 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>533 && currentAmp<=611) {
                            String a= "600 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else   {
                            String a= "It is Beyond my Knowledge";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n  "+a);

                        }
                        }}
                else if (phaseselected.equals("Three Phase") && MotorValue.equals("Kw")) {
                    double voltageValue = Double.parseDouble(Valuevoltage);
                    if (voltageValue <= 370 || voltageValue >= 435) {
                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter operating voltage between 380 to 430", Toast.LENGTH_SHORT).show();
                        return;
                    } else if (Double.parseDouble(Valuepowerfactor)<=0||Double.parseDouble(Valuepowerfactor)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter PF between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }
                    else if (Double.parseDouble(Valueefficency)<=0||Double.parseDouble(Valueefficency)>1) {

                        Toast.makeText(ThreePhasemotorAmp.this, "Please enter Efficency between 0 & 1", Toast.LENGTH_SHORT).show();
                        return;

                    }else {
                        double sqrt3 = Math.sqrt(3.0);
                        double powerFactorValue = Double.parseDouble(Valuepowerfactor);
                        double efficiencyValue = Double.parseDouble(Valueefficency);
                        double motorPowerValue = Double.parseDouble(ValueValuehpkw) * 1000; // Convert kW to watts

                        double currentAmp = motorPowerValue / (sqrt3 * voltageValue * powerFactorValue * efficiencyValue);
                        if (currentAmp<=15.5) {
                            String a= "1.5 mm2";

                        DecimalFormat decimalFormat = new DecimalFormat("#.##");
                        String formattedResult = decimalFormat.format(currentAmp);

                        showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);}
                        else if (currentAmp>15.5 && currentAmp<=23) {
                            String a= "2.5 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>23 && currentAmp<=30) {
                            String a= "4 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>30 && currentAmp<=38) {
                            String a= "6 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>38 && currentAmp<=52) {
                            String a= "10 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>52 && currentAmp<=68) {
                            String a= "16 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>68 && currentAmp<=89) {
                            String a= "25 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>89 && currentAmp<=110) {
                            String a= "35 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>110 && currentAmp<=134) {
                            String a= "50 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>134 && currentAmp<=171) {
                            String a= "70 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>171 && currentAmp<=207) {
                            String a= "95 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>207 && currentAmp<=239) {
                            String a= "120 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>239 && currentAmp<=262) {
                            String a= "150 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>262 && currentAmp<=296) {
                            String a= "185 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>296 && currentAmp<=346) {
                            String a= "240 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>346 && currentAmp<=394) {
                            String a= "300 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>394 && currentAmp<=467) {
                            String a= "400 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n "+a+" Cable is Required");

                        }
                        else if (currentAmp>467 && currentAmp<=533) {
                            String a= "500 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else if (currentAmp>533 && currentAmp<=611) {
                            String a= "600 mm2";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText("Full Load Amps of Motor is: "+ formattedResult + "\n"+"Cable Required for Motor is: "+a);

                        }
                        else   {
                            String a= "It is Beyond my Knowledge";
                            DecimalFormat decimalFormat = new DecimalFormat("#.##");
                            String formattedResult = decimalFormat.format(currentAmp);

                            showresult.setText(formattedResult + "Full Load Amps\n  "+a);

                        }



                    }
                }


               /* double resultValue = 3.141592653589793238462643383279502884197*Double.parseDouble(radiusValue) *Double.parseDouble(radiusValue) *
                        Double.parseDouble(flowrateValue) *
                        Double.parseDouble(proportionValue) *
                        Double.parseDouble(timeValue);

                DecimalFormat decimalFormat = new DecimalFormat("#.##");
                String formattedResult = decimalFormat.format(resultValue);

                showresult.setText(formattedResult);*/
            }
        });
    }
}