package com.wenqujingdian.view.home.fragment;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenqujingdian.R;
import com.wenqujingdian.base.BaseFragment;


/**
 * Created by wanghongwei on 2017/7/3.
 */

public class MeFragment extends BaseFragment  {


    //    单实例
    public static MeFragment newInstance() {
        return new MeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.frag_me, null);
        return view;
    }
}
