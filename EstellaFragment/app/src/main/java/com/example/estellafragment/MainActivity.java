package com.example.estellafragment;

import android.os.Bundle;

import com.google.android.material.bottomnavigation.BottomNavigationView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.navigation.NavController;
import androidx.navigation.Navigation;
import androidx.navigation.ui.AppBarConfiguration;
import androidx.navigation.ui.NavigationUI;

import com.example.estellafragment.databinding.ActivityMainBinding;


//Activity变成container, 再去装fragments(在bottom navigation icons上方)
public class MainActivity extends AppCompatActivity {

    private ActivityMainBinding binding;
    public static BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);
        //宣告navigation view
        navigationView = findViewById(R.id.nav_view);
        //创建navigation controller
        NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //用 navigationUI 连接起来
        NavigationUI.setupWithNavController(navigationView, navController);




        //binding = ActivityMainBinding.inflate(getLayoutInflater());
        //setContentView(binding.getRoot());

        //BottomNavigationView navView = findViewById(R.id.nav_view);
        // Passing each menu ID as a set of Ids because each
        // menu should be considered as top level destinations.
        //AppBarConfiguration appBarConfiguration = new AppBarConfiguration.Builder(
                // 如果页面非常多，这样列举会增加complexity
                //R.id.navigation_home, R.id.navigation_dashboard, R.id.navigation_notifications)
                //.build();
        //NavController navController = Navigation.findNavController(this, R.id.nav_host_fragment_activity_main);
        //NavigationUI.setupActionBarWithNavController(this, navController, appBarConfiguration);
        //NavigationUI.setupWithNavController(binding.navView, navController);
    }

    //可以使navigation bar 再点击next page换页同时 让它做一个弹出又退下隐藏的动作
    public static void hideBottomNavigationView(BottomNavigationView view){

        view.clearAnimation();
        //往下移动 从而消失
        view.animate().translationY(view.getHeight()).setDuration(300);
    }

    public static void showBottomNavigationView(BottomNavigationView view){

        view.clearAnimation();
        //移动回来，从而再次出现
        view.animate().translationY(0).setDuration(300);
    }

}