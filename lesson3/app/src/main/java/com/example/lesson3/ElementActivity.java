package com.example.lesson3;

import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.text.DecimalFormat;

public class ElementActivity extends AppCompatActivity {

    EditText height_edit, weight_edit, usd;
    TextView result_text, comment, aud;
    Button calculate;
    ImageView imageView, imageView2;
    LinearLayout bmi_layout;

    String style= "";
    int weight = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_element);


        Bundle bundle = getIntent().getExtras();
        style = bundle.getString("style");
        weight = bundle.getInt("weight");

        init_View();

        if (style.equals("original")){
            // original
            bmi_layout.setVisibility(View.VISIBLE);

        }else if(style.equals("no_bmi")){
            // no_bmi
            bmi_layout.setVisibility(View.GONE);

        }else if(style.equals("123")){

        }


    }

    private void init_View(){

        bmi_layout = findViewById(R.id.bmi_layout);

        imageView2 = findViewById(R.id.back);
        imageView2.setOnClickListener(actionBtnOnClick);

        height_edit = findViewById(R.id.height_edit);
        weight_edit = findViewById(R.id.weight_edit);
        result_text = findViewById(R.id.result);
        calculate = findViewById(R.id.calculate);
        calculate.setOnClickListener(actionBtnOnClick);

        comment = findViewById(R.id.comment);
        imageView = findViewById(R.id.image);

        usd = findViewById(R.id.usd);
        aud = findViewById(R.id.aud);


        usd.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence s, int i, int i1, int i2) {

                String temp = usd.getText().toString();
                Double temp_d = Double.parseDouble(temp);

                temp_d = temp_d * 1.5;

                DecimalFormat df = new DecimalFormat("0.000");
                String result = df.format(temp_d) + "    AUD";

                aud.setText(result);


//                if (s.equals(".")){
//                    s = "";
//                }

            }

            @Override
            public void afterTextChanged(Editable editable) {

            }
        });


    }


    private View.OnClickListener actionBtnOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {
            int viewId = view.getId();

                if (viewId == R.id.back) {

                    Intent intent = new Intent();
                    intent.setClass(ElementActivity.this, MainActivity.class);
                    startActivity(intent);
                }else if(viewId == R.id.calculate) {

                    String h = height_edit.getText().toString();
                    String w = weight_edit.getText().toString();

                    if (h.equals("") || w.equals("")) {

                        Toast.makeText(getApplicationContext(), "Please enter valid data!!!", Toast.LENGTH_SHORT).show();

                    } else {

                        double h_d = Double.parseDouble(h);
                        double w_d = Double.parseDouble(w);

                        double result_d = w_d / (h_d * h_d);

                        DecimalFormat df = new DecimalFormat("0.000");
                        String result = df.format(result_d);

                        result_text.setText(result);

                        if (result_d > 20) {

                            comment.setVisibility(View.VISIBLE);
                            imageView.setImageResource(R.drawable.fat);
                        } else {
                            comment.setVisibility(View.GONE);
                            imageView.setImageResource(R.drawable.original);
                        }
                    }
                }
        }
    };



}