package com.example.lesson3;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson3.adapter.ListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {


    public RecyclerView recyclerView;
    public ListAdapter listAdapter;
    public ArrayList<String> mData = new ArrayList<>();
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String json1 = "{\n" +
                " \"name\":\"呱呱呱\",\n"+
                " \"content\":\"123\"\n" +
                "}";

        String json2 = "{\n" +
                " \"name\":\"Nova\",\n"+
                " \"content\":\"ong\"\n" +
                "}";

        for (int i = 1; i < 10; i++){
            mData.add(json1);
            mData.add(json2);
        }


        init_View();
    }

    private void init_View(){



        recyclerView = findViewById(R.id.list);
        //set LayoutManager
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        String[] listArray = mData.toArray(new String[0]);
        listAdapter = new ListAdapter(listArray);

        recyclerView.setAdapter(listAdapter);
    }


}