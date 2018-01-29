package com.wenqujingdian.view.home.fragment.childfragment;

import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenqujingdian.R;
import com.wenqujingdian.base.BaseViewPagerFragment;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/25    上午11:54
 * # 描述：织巢鸟科技
 */

public class PeriodicalViewPagerFragment extends BaseViewPagerFragment {
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {

        return inflater.inflate(R.layout.child_frag_periodical,null);

    }

    @Override
    protected void initView() {

    }


    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible){
            log("第一次加载 11");
        }
    }
}
