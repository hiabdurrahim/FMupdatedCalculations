package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class AboutActivity extends AppCompatActivity {
    EditText a,b,c;
    Button btn;
    TextView tv;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);

        a=findViewById(R.id.editTextText14);
        b=findViewById(R.id.editTextText13);
        c=findViewById(R.id.editTextText12);
        btn=findViewById(R.id.button10);
        tv=findViewById(R.id.textView11);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String a1=a.getText().toString();
                String b1=b.getText().toString();
                String c1=c.getText().toString();
                if (a1.isEmpty() || b1.isEmpty()|| c1.isEmpty()) {
                    Toast.makeText(AboutActivity.this, "Please fill in all details", Toast.LENGTH_SHORT).show();
                    return;
                }

                double ad = Double.parseDouble(a1);
                double bd = Double.parseDouble(b1);
                double cd = Double.parseDouble(c1);

                double dd=(ad+bd)*cd;
                String result = String.valueOf(dd);
                tv.setText(result);
               // tv.setText((int) dd);

            }
        });
    }
}