package com.example.calculations;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.button.MaterialButton;

import org.mozilla.javascript.Context;
import org.mozilla.javascript.Scriptable;

public class Calculator extends AppCompatActivity implements View.OnClickListener {

    TextView resultTv, solutionTv;
    MaterialButton buttonC, buttonBrackOpenclose, buttonPersentage;
    MaterialButton buttonDivide, buttonMultiply, buttonPlus, buttonMinus, buttonEquals;
    MaterialButton button0, button1, button2, button3, button4, button5, button6, button7, button8, button9;
    MaterialButton buttonAC, buttonDot;
    private boolean isOpenBracket = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        resultTv = findViewById(R.id.result_tv);
        solutionTv = findViewById(R.id.solution_tv);

        buttonC = findViewById(R.id.button_c);
        buttonBrackOpenclose = findViewById(R.id.button_open_bracket);
        buttonPersentage = findViewById(R.id.button_close_bracket);
        buttonDivide = findViewById(R.id.button_divide);
        buttonMultiply = findViewById(R.id.button_multiply);
        buttonPlus = findViewById(R.id.button_plus);
        buttonMinus = findViewById(R.id.button_minus);
        buttonEquals = findViewById(R.id.button_equals);
        button0 = findViewById(R.id.button_0);
        button1 = findViewById(R.id.button_1);
        button2 = findViewById(R.id.button_2);
        button3 = findViewById(R.id.button_3);
        button4 = findViewById(R.id.button_4);
        button5 = findViewById(R.id.button_5);
        button6 = findViewById(R.id.button_6);
        button7 = findViewById(R.id.button_7);
        button8 = findViewById(R.id.button_8);
        button9 = findViewById(R.id.button_9);
        buttonAC = findViewById(R.id.button_ac);
        buttonDot = findViewById(R.id.button_dot);

        buttonC.setOnClickListener(this);
        buttonBrackOpenclose.setOnClickListener(this);
        buttonPersentage.setOnClickListener(this);
        buttonDivide.setOnClickListener(this);
        buttonMultiply.setOnClickListener(this);
        buttonPlus.setOnClickListener(this);
        buttonMinus.setOnClickListener(this);
        buttonEquals.setOnClickListener(this);
        button0.setOnClickListener(this);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
        button4.setOnClickListener(this);
        button5.setOnClickListener(this);
        button6.setOnClickListener(this);
        button7.setOnClickListener(this);
        button8.setOnClickListener(this);
        button9.setOnClickListener(this);
        buttonAC.setOnClickListener(this);
        buttonDot.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        MaterialButton button = (MaterialButton) view;
        String buttonText = button.getText().toString();
        String dataToCalculate = solutionTv.getText().toString();

        if (buttonText.equals("AC")) {
            solutionTv.setText("");
            resultTv.setText("0");
            return;
        } else if (buttonText.equals("=")) {
            solutionTv.setText(resultTv.getText());
            return;
        } else if (buttonText.equals("C")) {
            dataToCalculate = dataToCalculate.substring(0, dataToCalculate.length() - 1);
        } /*else if (buttonText.equals("%")) {

            // Remove the percentage symbol
           String numberString = dataToCalculate.replace("%", "");
            double number = Double.parseDouble(numberString);

            // Calculate the percentage value
            double percentageValue = number / 100 * Double.parseDouble(dataToCalculate);
            String percentageString = String.valueOf(percentageValue);

            dataToCalculate = dataToCalculate + percentageString;
        }*/ else if (buttonText.equals("(")) {

                String buttonTexta = "*(";
                dataToCalculate = dataToCalculate + buttonTexta;
            }
        else {
            dataToCalculate = dataToCalculate + buttonText;
        }
        solutionTv.setText(dataToCalculate);

        String finalResult = calculateResult(dataToCalculate);

        if (!finalResult.equals("Err")) {
            resultTv.setText(finalResult);
        }
    }


    String calculateResult(String data) {
        try {
            Context rhinoContext = Context.enter();
            rhinoContext.setOptimizationLevel(-1);
            Scriptable scriptable = rhinoContext.initStandardObjects();
            Object result = rhinoContext.evaluateString(scriptable, data, "JavaScript", 1, null);
            String finalResult = Context.toString(result);
            if (finalResult.endsWith(".0")) {
                finalResult = finalResult.replace(".0", "");
            }
            return finalResult;
        } catch (Exception e) {
            return "Err";
        } finally {
            Context.exit();
        }
    }

}

