package com.example.lesson3;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ListDetailActivity extends AppCompatActivity {

    TextView text;

    String txt = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Bundle bundle = getIntent().getExtras();
        txt = bundle.getString("text");

        init_view();

        text.setText(txt);

    }

    public void init_view(){

        text = findViewById(R.id.text);

    }
}