package com.wenqujingdian.base;

import android.annotation.TargetApi;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.KeyCharacterMap;
import android.view.KeyEvent;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewConfiguration;
import android.view.Window;
import android.view.WindowManager;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.wenqujingdian.myapplication.MyApplication;
import com.zhy.autolayout.AutoLayoutActivity;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/16    下午1:53
 * # 描述：织巢鸟科技
 */

public class BaseActivity extends AutoLayoutActivity {

    private Toast mToast;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        MyApplication.addActivity(this);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        initView();
        initData();
        initEvent();
        setStatusBarColor("#00bb99");
        checkDeviceHasNavigationBar(getActivity());
    }

    public void initView() {

    }

    public void initData() {

    }

    public void initEvent() {
    }

    public String getText( TextView text){
        return text.getText().toString().trim();
    }

    public void startActivity(Class<?> activityClass) {
        startActivity(new Intent(this, activityClass));
    }

    public BaseActivity getActivity() {
        return this;
    }


    public <T> void toast(T data) {
        if (mToast == null) {
            mToast = Toast.makeText(getApplicationContext(), data.toString(), Toast.LENGTH_SHORT);
        } else {
            mToast.setText(data.toString());
            mToast.setDuration(Toast.LENGTH_SHORT);
        }
        mToast.show();
    }

    public <T> void log(T t) {
        String data = null;
        if (t == null) {
            data = "null";
        } else {
            data = t.toString();
        }
        android.util.Log.i(this.getClass().getSimpleName(), data);
    }

    /**
     * 判断设备是否有navigation bar
     * @param activity
     * @return
     */
    public static boolean checkDeviceHasNavigationBar(Context activity) {
        //通过判断设备是否有返回键、菜单键(不是虚拟键,是手机屏幕外的按键)来确定是否有navigation bar
        boolean hasMenuKey = ViewConfiguration.get(activity)
                .hasPermanentMenuKey();
        boolean hasBackKey = KeyCharacterMap.deviceHasKey(KeyEvent.KEYCODE_BACK);

        if (!hasMenuKey && !hasBackKey) {
            // 做任何自己需要做的,这个设备有一个导航栏

            return true;
        }
        return false;
    }


    //设置沉浸式
    @TargetApi(19)
    public void setStatusBarColor(String color) {
        if (color == null) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            } else if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION);
            }
        } else {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                Window window = this.getWindow();
                window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                window.setStatusBarColor(Color.parseColor(color));
            }
        }
    }

    /**
     * 控制edtiText 隐藏 虚拟键盘
     * @param ev
     * @return
     */
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {
                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0);
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }

    /**
     *  控制edtiText 隐藏 虚拟键盘
     * @param v
     * @param event
     * @return
     */
    public boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = {0, 0};
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
    }
}
