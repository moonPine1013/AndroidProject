package com.example.estellafragment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.Navigation;

import com.example.estellafragment.MainActivity;
import com.example.estellafragment.R;

public class SecondFragment extends Fragment {

    private static View mRoot;

    public TextView txt;
    public Button back_btn;
    public String temp = "";

    public static SecondFragment newInstance(String id){
        SecondFragment frag = new SecondFragment();
        Bundle args = new Bundle();

        args.putString("id", id);
        frag.setArguments(args);
        return frag;
    }
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState){

        //固定写法，用Inflater来接xml
        mRoot = inflater.inflate(R.layout.fragment_second, container, false);
        temp = getArguments().getString("id");
        initView();
        txt.setText(temp);
        return mRoot;
    }

    public void initView(){
        txt = mRoot.findViewById(R.id.txt);
        //因为back_btn是一个fragment,而不是activity，所以要用 = mRoot.find，而不是直接用 = findView...
        back_btn = mRoot.findViewById(R.id.back_btn);
        back_btn.setOnClickListener(actionBtnOnclick);
    }

    //监听
    private View.OnClickListener actionBtnOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            int id = view.getId();
            if (id == R.id.back_btn) {
                MainActivity.showBottomNavigationView(MainActivity.navigationView);
                getParentFragmentManager().popBackStackImmediate();
            }
        }
    };
}
