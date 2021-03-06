package com.wenqujingdian.myapplication;

import android.app.Activity;
import android.app.Application;

import com.wenqujingdian.app.Latte;
import com.zhy.autolayout.config.AutoLayoutConifg;

import java.util.LinkedList;
import java.util.List;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/16    下午3:26
 * # 描述：织巢鸟科技
 */

public class MyApplication extends Application {


    public static List<Activity> activityList ;


    @Override
    public void onCreate() {
        super.onCreate();
        activityList  = new LinkedList<Activity>();
        Latte.init(this)
                .withApiHost("http://www.99emall.com/shop/")
                .configure();
        AutoLayoutConifg.getInstance().useDeviceSize();
    }

    /**
     * 添加到Activity容器中
     */
    public static void addActivity(Activity activity) {
        if (!activityList.contains(activity)) {
            activityList.add(activity);
        }
    }

    /**
     * 便利所有Activigty并finish
     */
    public static void finishActivity() {
        for (Activity activity : activityList) {
            activity.finish();
        }
    }

    /**
     * 结束指定的Activity
     */
    public static void finishSingleActivity(Activity activity) {
        if (activity != null) {
            if (activityList.contains(activity)) {
                activityList.remove(activity);
            }
            activity.finish();
            activity = null;
        }
    }

    /**
     * 结束指定类名的Activity 在遍历一个列表的时候不能执行删除操作，所有我们先记住要删除的对象，遍历之后才去删除。
     */
    public static void finishSingleActivityByClass(Class<?> cls) {
        Activity tempActivity = null;
        for (Activity activity : activityList) {
            if (activity.getClass().equals(cls)) {
                tempActivity = activity;
            }
        }

        finishSingleActivity(tempActivity);
    }

}
