package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class FASQuoteActivity extends AppCompatActivity {
    EditText PanelQ,SDQ,HDQ,MCPQ,SFQ,InstPERUNIT,PRS,SDRS,HDRS,MCPRS,SFRS,GSTPRODUCT,GSTINST;
    TextView EQPResult,InstQResult,gaTotal;
    Button eqptotal,insttotal,Gtotal;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fasquote);

        PanelQ=findViewById(R.id.textView10);
        SDQ=findViewById(R.id.textView17);
        HDQ=findViewById(R.id.textView18);
        MCPQ=findViewById(R.id.textView23);
        SFQ=findViewById(R.id.textView12);
        InstPERUNIT=findViewById(R.id.textView29);
        PRS=findViewById(R.id.editTextText);
        SDRS=findViewById(R.id.editTextText6);
        HDRS=findViewById(R.id.editTextText7);
        MCPRS=findViewById(R.id.editTextText9);
        SFRS=findViewById(R.id.editTextText10);
        GSTPRODUCT=findViewById(R.id.editTextText8);
        GSTINST=findViewById(R.id.editTextText11);
        EQPResult=findViewById(R.id.textView32);
        InstQResult=findViewById(R.id.textView34);
        gaTotal=findViewById(R.id.textView26);
        eqptotal=findViewById(R.id.btnView31);
        insttotal=findViewById(R.id.textView33);
        Gtotal=findViewById(R.id.textView24);
        eqptotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Get the input prices as strings
                String Panelqty = PanelQ.getText().toString();
                String Panelpri = PRS.getText().toString();
               String SDqty = SDQ.getText().toString().trim();
                String SDpri = SDRS.getText().toString().trim();
               String HDDqty = HDQ.getText().toString().trim();
                String HDpri = HDRS.getText().toString().trim();
                String MCPqty = MCPQ.getText().toString().trim();
                String MCPpri = MCPRS.getText().toString().trim();
                String SFqty = SFQ.getText().toString().trim();
                String SFpri = SFRS.getText().toString().trim();
                //String Instperunit = InstPERUNIT.getText().toString().trim();
                String GSTproperstage = GSTPRODUCT.getText().toString().trim();
               // String GSTinstperstage = GSTINST.getText().toString().trim();




                if (Panelqty.isEmpty() || Panelpri.isEmpty() || SDqty.isEmpty() || SDpri.isEmpty() ||
                        HDDqty.isEmpty() || HDpri.isEmpty() || MCPqty.isEmpty() || MCPpri.isEmpty() ||
                        SFqty.isEmpty() || SFpri.isEmpty()|| GSTproperstage.isEmpty()) {
                    Toast.makeText(FASQuoteActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                    return;
                }


                double panelQtya = Double.parseDouble(Panelqty);
                double panelPria = Double.parseDouble(Panelpri);
                double sdQtya = Double.parseDouble(SDqty);
                double sdPria = Double.parseDouble(SDpri);
                double hddQtya = Double.parseDouble(HDDqty);
                double hdPria = Double.parseDouble(HDpri);
                double mcpQtya = Double.parseDouble(MCPqty);
                double mcpPria = Double.parseDouble(MCPpri);
                double sfQtya = Double.parseDouble(SFqty);
                double sfPria = Double.parseDouble(SFpri);
                //double instPerUnit = Double.parseDouble(InstPERUNIT.getText().toString().trim());
                double gstProperStage = Double.parseDouble(GSTPRODUCT.getText().toString().trim());
            //    double gstInstPerStage = Double.parseDouble(GSTINST.getText().toString().trim());




                double eqpatotat= (panelQtya*panelPria)+(sdQtya*sdPria)+(hddQtya*hdPria)+(sfQtya*sfPria)+(mcpQtya*mcpPria);
                double eqptotalpluspercetage=eqpatotat*(gstProperStage/100);
                double prototal=eqpatotat+eqptotalpluspercetage;
               // EQPResult.setText(String.format("%.2f", eqpatotat));

                String result = String.valueOf(prototal);
                EQPResult.setText(result);






                // Display the inflation percentage in the result TextView

            }

        });
        insttotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // Get the input prices as strings
                String Panelqty = PanelQ.getText().toString();

                String SDqty = SDQ.getText().toString().trim();

                String HDDqty = HDQ.getText().toString().trim();

                String MCPqty = MCPQ.getText().toString().trim();

                String SFqty = SFQ.getText().toString().trim();

                String Instperunit = InstPERUNIT.getText().toString().trim();
                 String GSTinstperstage = GSTINST.getText().toString().trim();




                if (Panelqty.isEmpty() ||  SDqty.isEmpty() ||
                        HDDqty.isEmpty()  || MCPqty.isEmpty() ||
                        SFqty.isEmpty() || Instperunit.isEmpty()|| GSTinstperstage.isEmpty()) {
                    Toast.makeText(FASQuoteActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                    return;
                }


                double panelQtya = Double.parseDouble(Panelqty);

                double sdQtya = Double.parseDouble(SDqty);

                double hddQtya = Double.parseDouble(HDDqty);

                double mcpQtya = Double.parseDouble(MCPqty);

                double sfQtya = Double.parseDouble(SFqty);

                double instPerUnit = Double.parseDouble(InstPERUNIT.getText().toString().trim());

                double gstInstPerStage = Double.parseDouble(GSTINST.getText().toString().trim());




                double instpoints= (panelQtya+sdQtya+hddQtya+sfQtya+mcpQtya)*instPerUnit;
                double insttotalpluspercetage=instpoints*(gstInstPerStage/100);
                double instatotal=instpoints+insttotalpluspercetage;
                // EQPResult.setText(String.format("%.2f", eqpatotat));

                String result = String.valueOf(instatotal);
                InstQResult.setText(result);






                // Display the inflation percentage in the result TextView

            }
        });

        Gtotal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String Panelqty = PanelQ.getText().toString();
                String Panelpri = PRS.getText().toString();
                String SDqty = SDQ.getText().toString().trim();
                String SDpri = SDRS.getText().toString().trim();
                String HDDqty = HDQ.getText().toString().trim();
                String HDpri = HDRS.getText().toString().trim();
                String MCPqty = MCPQ.getText().toString().trim();
                String MCPpri = MCPRS.getText().toString().trim();
                String SFqty = SFQ.getText().toString().trim();
                String SFpri = SFRS.getText().toString().trim();
                String Instperunit = InstPERUNIT.getText().toString().trim();
                String GSTproperstage = GSTPRODUCT.getText().toString().trim();
                String GSTinstperstage = GSTINST.getText().toString().trim();


                if (Panelqty.isEmpty() || Panelpri.isEmpty() || SDqty.isEmpty() || SDpri.isEmpty() ||
                        HDDqty.isEmpty() || HDpri.isEmpty() || MCPqty.isEmpty() || MCPpri.isEmpty() ||
                        SFqty.isEmpty() || SFpri.isEmpty()|| GSTproperstage.isEmpty() || Instperunit.isEmpty()|| GSTinstperstage.isEmpty()) {
                    Toast.makeText(FASQuoteActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                    return;
                }








                double panelQtya = Double.parseDouble(Panelqty);
                double panelPria = Double.parseDouble(Panelpri);
                double sdQtya = Double.parseDouble(SDqty);
                double sdPria = Double.parseDouble(SDpri);
                double hddQtya = Double.parseDouble(HDDqty);
                double hdPria = Double.parseDouble(HDpri);
                double mcpQtya = Double.parseDouble(MCPqty);
                double mcpPria = Double.parseDouble(MCPpri);
                double sfQtya = Double.parseDouble(SFqty);
                double sfPria = Double.parseDouble(SFpri);
                double instPerUnit = Double.parseDouble(InstPERUNIT.getText().toString().trim());
                double gstProperStage = Double.parseDouble(GSTPRODUCT.getText().toString().trim());
                 double gstInstPerStage = Double.parseDouble(GSTINST.getText().toString().trim());




                double eqpatotat= (panelQtya*panelPria)+(sdQtya*sdPria)+(hddQtya*hdPria)+(sfQtya*sfPria)+(mcpQtya*mcpPria);
                double eqptotalpluspercetage=eqpatotat*(gstProperStage/100);
                double prototal=eqpatotat+eqptotalpluspercetage;






// Get the input prices as strings











               // double instPerUnit = Double.parseDouble(InstPERUNIT.getText().toString().trim());

              //  double gstInstPerStage = Double.parseDouble(GSTINST.getText().toString().trim());




                double instpoints= (panelQtya+sdQtya+hddQtya+sfQtya+mcpQtya)*instPerUnit;
                double insttotalpluspercetage=instpoints*(gstInstPerStage/100);
                double instatotal=instpoints+insttotalpluspercetage;
                // EQPResult.setText(String.format("%.2f", eqpatotat));

                double gtotala = instatotal+prototal;
                String resultab = String.valueOf(gtotala);
                gaTotal.setText(resultab);


                // Display the inflation percentage in the result TextView

            }
        });


    }
}