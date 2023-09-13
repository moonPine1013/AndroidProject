package com.example.estellafragment.ui.notifications;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.estellafragment.R;
import com.example.estellafragment.databinding.FragmentNotificationsBinding;

public class NotificationsFragment extends Fragment {

    private static View mRoot;
    TextView textView;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        mRoot = inflater.inflate(R.layout.fragment_notifications,container,false);
        initView();
        return mRoot;
    }
    public void initView(){
        //用于查找mRoot是对照谁的
        textView = mRoot.findViewById(R.id.text_notifications);
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
    }
}