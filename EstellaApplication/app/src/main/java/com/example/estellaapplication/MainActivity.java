package com.example.estellaapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.PopupWindow;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView left_text, right_text;
    Button left_btn, right_btn, next, element_page,element_no_bmi_page, list_page;

    //declare PopupWindow (container)
    private PopupWindow popupWindow;
    //declare PopupView (content,context)
    private View popupView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //ActionBar actionBar = getSupportActionBar();
        //if(actionBar != null){
        //  actionBar.hide();
        //  }

        init_View();
    }

    private void init_View(){

        // match with figure 1 on each side of the window
        left_text = findViewById(R.id.left_text);
        right_text = findViewById(R.id.right_text);

        // match with button name on each side of the window
        left_btn = findViewById(R.id.left_btn);
        right_btn = findViewById(R.id.right_btn);
        next = findViewById(R.id.next);

        //监听
        left_btn.setOnClickListener(actionBtnOnClick);
        right_btn.setOnClickListener(actionBtnOnClick);
        next.setOnClickListener(actionBtnOnClick);

        //到小分页,也是popupView
        go_to_next_page();
    }

    //固定格式 监听器
    private View.OnClickListener actionBtnOnClick = new View.OnClickListener(){

        @Override
        public void onClick(View view) {

            int id = view.getId();
            if (id == R.id.left_btn) {
                String temp = left_text.getText().toString();
                int temp_int = Integer.parseInt(temp);
                temp_int = temp_int + 1;
                temp = String.valueOf(temp_int);
                left_text.setText(temp);
            } else if (id == R.id.right_btn) {
                int temp_int;
                String temp;
                temp = right_text.getText().toString();
                temp_int = Integer.parseInt(temp);
                temp_int = temp_int + 1;
                temp = String.valueOf(temp_int);
                right_text.setText(temp);
            } else if (id == R.id.next) {
                popWindow(popupView);
            } else if (id == R.id.element_page) {
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                intent.setClass(MainActivity.this, ElementActivity.class);
                // title , content
                bundle.putString("style", "original");
                //也可以传入空的 i.e 0
                bundle.putInt("weight", 0);
                intent.putExtras(bundle);

                startActivity(intent);

                WindowManager.LayoutParams lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
                popupWindow.dismiss();
            } else if (id == R.id.element_no_bmi_page) {
                WindowManager.LayoutParams lp;
                Bundle bundle;
                Intent intent;
                intent = new Intent();
                bundle = new Bundle();
                intent.setClass(MainActivity.this, ElementActivity.class);
                // title , content
                bundle.putString("style", "no_bmi");
                //对应接口1v1
                bundle.putInt("weight", 123);
                intent.putExtras(bundle);
                startActivity(intent);

                lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
                popupWindow.dismiss();
            } else if (id == R.id.list_page) {
                WindowManager.LayoutParams lp;
                Intent intent;
                intent = new Intent();
                intent.setClass(MainActivity.this, ListActivity.class);
                startActivity(intent);

                lp = getWindow().getAttributes();
                lp.alpha = 1f;
                getWindow().setAttributes(lp);
                popupWindow.dismiss();
            }
        }
    };


    //模板格式,定义弹出的小分页
    private void go_to_next_page(){

        //衔接桥梁
        //为了让popupView小分页和主页面衔接在一起
        LayoutInflater layoutInflater = (LayoutInflater) getBaseContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //tip: ctrl + B 跳转到对应的attribute
        popupView = layoutInflater.inflate(R.layout.popupview_message,null);

        element_page = popupView.findViewById(R.id.element_page);
        element_page.setOnClickListener(actionBtnOnClick);

        element_no_bmi_page = popupView.findViewById(R.id.element_no_bmi_page);
        element_no_bmi_page.setOnClickListener(actionBtnOnClick);

        list_page = popupView.findViewById(R.id.list_page);
        list_page.setOnClickListener(actionBtnOnClick);

    }

    //呼叫popupView窗口
    private void popWindow(final View popupView){

        //可以按模板
        popupWindow = new PopupWindow(
                popupView,                               //要创建/修改的popupView
                LinearLayout.LayoutParams.MATCH_PARENT,  //width 先宽度
                LinearLayout.LayoutParams.MATCH_PARENT);  //height 再高度

        //Determine the location of the popupView
        popupWindow.showAtLocation(this.findViewById(R.id.main), Gravity.BOTTOM | Gravity.CENTER_HORIZONTAL,0,0);

        //让popupWindow外部可以 被点击 进行操作，按一下外部就关闭
        popupWindow.setOutsideTouchable(true);

        WindowManager.LayoutParams lp = getWindow().getAttributes();
        // 亮度参数： 100 % => 1f, 0 % => 0.0f

        //分页弹出，外部变暗
        lp.alpha = 0.6f;
        //更改
        getWindow().setAttributes(lp);

        popupView.setOnTouchListener(new View.OnTouchListener() { //如果触摸位置在窗口外面则销毁

            //监测按钮
            @Override
            public boolean onTouch(View v, MotionEvent event){
                // TODO Auto-generated method stub

                //弹出后，弹窗topMargin和外部暗色的边界
                //height = y-coordinate from the top of the window

                //Window的x-y左边从左上角开始，x越往左越大，y越往下越大
                int height = popupView.findViewById(R.id.id_pop_layout).getTop();

                int y = (int) event.getY();

                //鼠标按下：action_down 鼠标弹起:action_up  两个动作
                //鼠标弹起的一瞬间，弹窗弹出
                if(event.getAction() == MotionEvent.ACTION_UP){
                    //点击外部
                    if(y < height){
                        //萤幕变亮
                        lp.alpha = 1f;
                        getWindow().setAttributes(lp);
                        //弹窗消失
                        popupWindow.dismiss();
                    }
                }
                return true;

            }

        });

    }

}