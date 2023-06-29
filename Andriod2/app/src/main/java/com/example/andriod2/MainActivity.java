package com.example.andriod2;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;
public class MainActivity extends AppCompatActivity {

    EditText height_edit, weight_edit;
    TextView result_text, comment,usd, aud;
    Button calculate;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init_view();
    }

    private void init_view(){
        height_edit = findViewById(R.id.height_edit);
        weight_edit = findViewById(R.id.weight_edit);

        result_text = findViewById(R.id.result);
        usd = findViewById(R.id.usd);
        aud = findViewById(R.id.aud);

        calculate = findViewById(R.id.calculate);
        //监听
        calculate.setOnClickListener(actionBtnOnClick);

        imageView = findViewById(R.id.image);
        comment = findViewById(R.id.comment);

        //aud change value corresponding to usd value
    }
    //监听器
    //固定写法
    private View.OnClickListener actionBtnOnClick = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            int viewId = v.getId();

            if (viewId == R.id.calculate) {
                String h = height_edit.getText().toString();
                String w = weight_edit.getText().toString();

                if (h.equals("") || w.equals("")) {
                    Toast.makeText(getApplicationContext(), "Please enter valid data", Toast.LENGTH_SHORT).show();
                } else {
                    double h_d = Double.parseDouble(h);
                    double w_d = Double.parseDouble(w);

                    double result_d = w_d / (h_d * h_d);

                    DecimalFormat df = new DecimalFormat("0.000");
                    String result = df.format(result_d);

                    result_text.setText(result);

                    if (result_d > 20) {
                        imageView.setImageResource(R.drawable.fat);
                        comment.setVisibility(View.VISIBLE);
                    } else {
                        imageView.setImageResource(R.drawable.original);
                        comment.setVisibility(View.GONE);
                    }
                }
            }
        }
    };


}