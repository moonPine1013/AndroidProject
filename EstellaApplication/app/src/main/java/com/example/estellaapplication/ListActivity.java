package com.example.estellaapplication;

import android.content.Context;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.estellaapplication.adapter.ListAdapter;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    //创建context attribute
    private Context context;
    public RecyclerView recyclerView;
    public ListAdapter listAdapter;
    public ArrayList<String> mData = new ArrayList<>();
    public ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        // this代表整个activity,存进context
        context = this;

        String json1 = "{\n" +
                " \"name\":\"呜哇嘿\",\n"+
                " \"content\":\"123\"\n" +
                "}";

        String json2 = "{\n" +
                " \"name\":\"Estella\",\n"+
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
        //相应的，增加context的argument进ListAdapter里面
        listAdapter = new ListAdapter(listArray,context);

        recyclerView.setAdapter(listAdapter);
    }


}