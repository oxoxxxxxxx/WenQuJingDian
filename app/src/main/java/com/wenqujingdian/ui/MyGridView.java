package com.wenqujingdian.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.widget.GridView;

/**
 * Created by wanghong on 2017/3/20.
 * 解决冲突View
 */

public class MyGridView extends GridView {
    /**
     * 自定义gridview，解决ListView中嵌套gridview显示不正常的问题（1行半）
     *
     * @author wangyx
     * @version 1.0.0 2012-9-14
     */
        public MyGridView(Context context, AttributeSet attrs) {
            super(context, attrs);
        }


        public MyGridView(Context context) {
            super(context);
        }


        public MyGridView(Context context, AttributeSet attrs, int defStyle) {
            super(context, attrs, defStyle);
        }


        @Override
        public void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {

            int expandSpec = MeasureSpec.makeMeasureSpec(Integer.MAX_VALUE >> 2,
                    MeasureSpec.AT_MOST);
            super.onMeasure(widthMeasureSpec, expandSpec);
        }
    }

