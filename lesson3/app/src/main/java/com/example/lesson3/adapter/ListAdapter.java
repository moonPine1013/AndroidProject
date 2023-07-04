package com.example.lesson3.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.lesson3.R;

import org.jetbrains.annotations.NonNls;
import org.json.JSONException;
import org.json.JSONObject;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class ListAdapter extends RecyclerView.Adapter<ListAdapter.ViewHolder> {

    //store Data
    public String[] listData;
    ArrayList<String> mContent = new ArrayList<>();
    ArrayList<String> mName = new ArrayList<>();


    class ViewHolder extends RecyclerView.ViewHolder{

        TextView name, content;
        ImageView msgSelfie;
        LinearLayout msg_item;

        public ViewHolder(@NonNull View itemView){
            super(itemView);

            //declare itemView
            name = itemView.findViewById(R.id.message_name);
            content = itemView.findViewById(R.id.message_content);
            msgSelfie = itemView.findViewById(R.id.message_selfie);

            //只有按下图片区域才会显示text
            msgSelfie.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    content.setText("1233gg");
                }
            });

//            msg_item = itemView.findViewById(R.id.message_item);
//            msg_item.setOnClickListener(new View.OnClickListener() {
 //               @Override
 //               public void onClick(View view) {
 //                   content.setText("XXXXX");
 //               }
 //           });

        }

    }

    public ListAdapter(String[] listData){
        this.listData = listData;

        //Get the data from activity and put them into the list by position
        processData();
    }


    @NonNull
    @Override
    public ListAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        //Tell which list item view will be connected.
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item,parent,false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {

        //Set value tp textView by position
        holder.name.setText(mName.get(position));
        holder.content.setText(mContent.get(position));

    }

    @Override
    public int getItemCount() {
        return listData.length;
    }

    private void processData(){
        if(listData != null && listData.length > 0){
            for(int i = 0;i < listData.length; i++){

                try{
                    JSONObject jsonObject =  new JSONObject(listData[i]);

                    String sub_name = jsonObject.getString("name");
                    String sub_content = jsonObject.getString("content");

                    mName.add(sub_name);
                    mContent.add(sub_content);

                } catch (JSONException e){

                    e.printStackTrace();
                }
            }
        }

    }


}
