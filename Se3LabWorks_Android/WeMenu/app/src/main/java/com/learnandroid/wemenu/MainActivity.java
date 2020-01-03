package com.learnandroid.wemenu;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.PopupWindow;

public class MainActivity extends AppCompatActivity {
PopupWindow popupWindow; //定义PopupWindow
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    //菜单按钮的单击事件
    public void OnMenu(View v){
        //获取自定义菜单的布局文件
        View popupWindow_View = getLayoutInflater().inflate(R.layout.menu, null, false);
        //创建pop up window, 设置菜单的宽度和高度
        popupWindow = new PopupWindow(popupWindow_View, ActionBar.LayoutParams.WRAP_CONTENT, ActionBar.LayoutParams.WRAP_CONTENT);
        //设置菜单显示在按钮的下面
        popupWindow.showAsDropDown(findViewById(R.id.btn_menu),0,0);
        //单击其他位置隐藏菜单
        //不晓得为毛这个function没用的样子
        popupWindow_View.setOnTouchListener(new View.OnTouchListener(){
            @Override
            public boolean onTouch(View v, MotionEvent MEvent){
                if(popupWindow!=null & popupWindow.isShowing()){
                    popupWindow.dismiss();
                    popupWindow = null;
                }
                return false;
            }
        });
    }
}
