package com.example.estellafragment.ui;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import androidx.lifecycle.ViewModelProvider;

import com.example.estellafragment.MainActivity;
import com.example.estellafragment.R;
import com.example.estellafragment.databinding.FragmentDashboardBinding;
import com.example.estellafragment.ui.SecondFragment;

public class DashboardFragment extends Fragment {

    //private FragmentDashboardBinding binding;

    public static View mRoot;
    TextView textView;
    //initialise button
    Button next_page_btn;
    public static FragmentManager fragmentManager;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        //固定写法:
        //用inflater来接layout，mRoot就是xml的layout的本身
        mRoot = inflater.inflate(R.layout.fragment_dashboard, container, false);
        //必要！！把现在页面的fragManager抓取出来，并存进这个变量中
        //为什么被划掉，是因为版本过时了，但目前还是可用
        fragmentManager = getFragmentManager();
        initView();

        return mRoot;
    }

    public void initView(){
        //用于查找mRoot是对照谁的
        //textView = mRoot.findViewById(R.id.next_page);

        //把default的text更新为Button
        next_page_btn = mRoot.findViewById(R.id.next_page);
        next_page_btn.setOnClickListener(actionBtnOnclick);
    }
    //监听固定写法
    private View.OnClickListener actionBtnOnclick = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.next_page) {
                MainActivity.hideBottomNavigationView(MainActivity.navigationView);
                //创建second fragment， 让它知道其存在
                SecondFragment secondFragment = new SecondFragment().newInstance("id1013");
                //跳转页面的操作
                goNextFragment(secondFragment);
            }
        }
    };

    //跳转页面
    public static void goNextFragment(Fragment fragment){

        FragmentManager mFragmentManager = fragmentManager;
        //transaction 作用于 换/做哪些相关操作 i.e 笔记上的：.addToBackStack
        // .beginTransaction 为了换页准备用到的
        FragmentTransaction mFragmentTransaction = mFragmentManager.beginTransaction();
        //把左边的页面 replace到 右边的页面
        mFragmentTransaction.replace(R.id.nav_host_fragment_activity_main, fragment);
        //写stack的好处: FILO
        mFragmentTransaction.addToBackStack("");
        //必要，完成换页完整动作，进而 进入secondFragment->onCreateView
        mFragmentTransaction.commit();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        //binding = null;
    }
}