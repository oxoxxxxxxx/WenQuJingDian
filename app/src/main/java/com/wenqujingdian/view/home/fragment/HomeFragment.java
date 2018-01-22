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

public class HomeFragment extends BaseFragment {

//    单实例
    public static HomeFragment newInstance (){
        return new HomeFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        return inflater.inflate(R.layout.frag_home,container,false);
    }
}
