package com.example.calculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView result_text;
    Button num1, num2, num3, num4, num5, num6, num7, num8, num9, num0, add, minus, multiply, clear, equal, decimal;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_view();
    }

    private void init_view() {
        //TextView
        result_text = findViewById(R.id.result);

        //Button
        num1 = findViewById(R.id.num1);
        num2 = findViewById(R.id.num2);
        num3 = findViewById(R.id.num3);
        num4 = findViewById(R.id.num4);
        num5 = findViewById(R.id.num5);
        num6 = findViewById(R.id.num6);
        num7 = findViewById(R.id.num7);
        num8 = findViewById(R.id.num8);
        num9 = findViewById(R.id.num9);
        num0 = findViewById(R.id.num0);
        add = findViewById(R.id.add);
        minus = findViewById(R.id.minus);
        multiply = findViewById(R.id.multiply);
        decimal = findViewById(R.id.decimal);
        equal = findViewById(R.id.equal);
        clear = findViewById(R.id.clear);

        //监听
        num1.setOnClickListener(actionBtnOnClick);
        num2.setOnClickListener(actionBtnOnClick);
        num3.setOnClickListener(actionBtnOnClick);
        num4.setOnClickListener(actionBtnOnClick);
        num5.setOnClickListener(actionBtnOnClick);
        num6.setOnClickListener(actionBtnOnClick);
        num7.setOnClickListener(actionBtnOnClick);
        num8.setOnClickListener(actionBtnOnClick);
        num9.setOnClickListener(actionBtnOnClick);
        num0.setOnClickListener(actionBtnOnClick);
        add.setOnClickListener(actionBtnOnClick);
        minus.setOnClickListener(actionBtnOnClick);
        multiply.setOnClickListener(actionBtnOnClick);
        decimal.setOnClickListener(actionBtnOnClick);
        equal.setOnClickListener(actionBtnOnClick);
        clear.setOnClickListener(actionBtnOnClick);
    }


    private View.OnClickListener actionBtnOnClick = v -> {
        int viewId = v.getId();

        if (viewId == R.id.num1) {
            // Append "1" to the result_text TextView
            appendToResultText("1");
        } else if (viewId == R.id.num2) {
            // Append "2" to the result_text TextView
            appendToResultText("2");
        } else if (viewId == R.id.num3) {
            // Append "3" to the result_text TextView
            appendToResultText("3");
        } else if (viewId == R.id.num4) {
            // Append "4" to the result_text TextView
            appendToResultText("4");
        } else if (viewId == R.id.num5) {
            // Append "5" to the result_text TextView
            appendToResultText("5");
        } else if (viewId == R.id.num6) {
            // Append "6" to the result_text TextView
            appendToResultText("6");
        } else if (viewId == R.id.num7) {
            // Append "7" to the result_text TextView
            appendToResultText("7");
        } else if (viewId == R.id.num8) {
            // Append "8" to the result_text TextView
            appendToResultText("8");
        } else if (viewId == R.id.num9) {
            // Append "9" to the result_text TextView
            appendToResultText("9");
        } else if (viewId == R.id.num0) {
            // Append "0" to the result_text TextView
            appendToResultText("0");
        } else if (viewId == R.id.add) {
            // Append "+" to the result_text TextView
            appendToResultText("+");
        } else if (viewId == R.id.minus) {
            // Append "-" to the result_text TextView
            appendToResultText("-");
        } else if (viewId == R.id.multiply) {
            // Append "*" to the result_text TextView
            appendToResultText("*");
        } else if (viewId == R.id.decimal) {
            // Append "." to the result_text TextView
            appendToResultText(".");
        } else if (viewId == R.id.equal) {
            // Handle the calculation when the equal button is clicked
            performCalculation();
        } else if (viewId == R.id.clear) {
            // Clear the result_text TextView
            clearResultText();
        }
    };

    private void appendToResultText(String text) {
        String currText = result_text.getText().toString();
        result_text.setText(currText + text);
    }

    private void clearResultText() {
        result_text.setText("");
    }

    private void performCalculation() {
        String expression = result_text.getText().toString();
        double answer = 0;

        if (expression.contains("*")) {
            String[] values = expression.split("\\*");
            answer = 1;

            for (int i = 0; i < values.length; i++) {
                if (Double.parseDouble(values[i].trim()) == 0) {
                    answer = 0;
                } else {
                    answer *= Double.parseDouble(values[i].trim());
                }
            }
        } else if (expression.contains("+")) {
            String[] values = expression.split("\\+");
            answer = Double.parseDouble(values[0].trim());

            for (int i = 1; i < values.length; i++) {
                answer += Double.parseDouble(values[i].trim());
            }
        } else if (expression.contains("-")) {
            // Split by "-" but exclude the first empty string if present
            String[] values = expression.split("(?<=\\d)-");

            if (values.length > 0) {
                answer = Double.parseDouble(values[0].trim());

                for (int i = 1; i < values.length; i++) {
                    answer -= Double.parseDouble(values[i].trim());
                }
            }
        }

        result_text.setText(String.valueOf(answer));
    }
}
