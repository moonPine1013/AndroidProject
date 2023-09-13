package com.example.estellafragment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import com.example.estellafragment.R;

public class SecondFragment extends Fragment {

    private static View  mRoot;

    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstance){

        //固定写法，用Inflater来接xml
        mRoot = inflater.inflate(R.layout.fragment_second, container, false);
        return mRoot;

    }
}
