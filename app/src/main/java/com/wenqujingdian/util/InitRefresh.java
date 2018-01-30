package com.wenqujingdian.util;

import android.support.v4.widget.SwipeRefreshLayout;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/30    下午4:27
 * # 描述：织巢鸟科技
 */

public class InitRefresh {
    public static final void init (SwipeRefreshLayout mSrllLayout){
        mSrllLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSrllLayout.setProgressViewOffset(true, 120, 300);
    }
}
