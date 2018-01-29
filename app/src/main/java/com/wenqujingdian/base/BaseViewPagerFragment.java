package com.wenqujingdian.base;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/16    下午3:24
 * # 描述：织巢鸟科技
 */

public abstract class BaseViewPagerFragment extends Fragment {
    protected View rootView;

    //当前Fragment是否处于可见状态标志，防止因ViewPager的缓存机制而导致回调函数的触发
    private boolean isFragmentVisible;
    //是否是第一次开启网络加载
    public boolean isFirst;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        if (rootView == null) {
            rootView = onCreateView(inflater, container);
        }
        initView();
        //可见，但是并没有加载过
        if (isFragmentVisible && !isFirst) {
            onFragmentVisibleChange(true);
            isFirst = true;

        }
        return rootView;
    }


    abstract public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container);



    //初始化view
    protected abstract void initView();

    @Override
    public void setUserVisibleHint(boolean isVisibleToUser) {
        super.setUserVisibleHint(isVisibleToUser);
        if (isVisibleToUser) {
            isFragmentVisible = true;
        }
        if (rootView == null) {
            return;
        }
        //可见，并且没有加载过
        if (!isFirst&&isFragmentVisible) {
            onFragmentVisibleChange(true);
            isFirst = true;
            return;
        }
        //由可见——>不可见 已经加载过
        if (isFragmentVisible) {
            onFragmentVisibleChange(false);
            isFragmentVisible = false;
        }
    }
    /**
     * 当前fragment可见状态发生变化时会回调该方法
     * 如果当前fragment是第一次加载，等待onCreateView后才会回调该方法，其它情况回调时机跟 {@link #setUserVisibleHint(boolean)}一致
     * 在该回调方法中你可以做一些加载数据操作，甚至是控件的操作.
     *
     * @param isVisible true  不可见 -> 可见
     *                  false 可见  -> 不可见
     */
    protected void onFragmentVisibleChange(boolean isVisible) {

    }


    public void startActivity(Class<?> classActivity) {
        startActivity(new Intent(getActivity(), classActivity));
    }

    private Toast mToast;

    public <T> void toast(T data) {
        if (mToast == null) {
            mToast = Toast.makeText(getActivity(), data.toString(), Toast.LENGTH_SHORT);
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
}
