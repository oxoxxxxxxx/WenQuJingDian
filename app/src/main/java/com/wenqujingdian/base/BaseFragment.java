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
 * # 时间：2017/8/17    下午2:49
 * # 描述：
 */

public abstract class BaseFragment extends Fragment {
    private View mView;

    public <T> T findView(int id) {
        return (T) getView().findViewById(id);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if (mView == null) {
            mView = onCreateView(inflater, container);
        }
        return mView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        initView();
        initData();
        initEvent();
    }

    abstract public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container);

    public void initView() {
    }

    public void initData() {
    }

    public void initEvent() {
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