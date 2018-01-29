package com.wenqujingdian.view.home.fragment.childfragment;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenqujingdian.R;
import com.wenqujingdian.base.BaseViewPagerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/25    上午11:52
 * # 描述：织巢鸟科技
 */

public class ChildHomeViewPagerFragment extends BaseViewPagerFragment {

    @Bind(R.id.srll_layout)
    SwipeRefreshLayout mSrllLayout;



    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.child_frag_home, null);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        initRefreshLayout();
    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible){
            log("第一次加载 44");
        }
    }

    //    @Override
//    public void initData() {
//        super.initData();
//        RestClient.sBuilder().url("productAndroid!product_hot").success(new ISuccess() {
//            @Override
//            public void onSuccess(String response) {
//
//            }
//        }).build().get();
//    }

    private void initRefreshLayout(){
        mSrllLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSrllLayout.setProgressViewOffset(true,120,300);
    }
}
