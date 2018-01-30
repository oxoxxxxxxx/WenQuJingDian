package com.wenqujingdian.view.home.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.base.BaseFragment;
import com.wenqujingdian.view.home.fragment.childfragment.BookShopFragmentPagerAdapter;
import com.wenqujingdian.view.home.homechildfragment.HomeBookFragment;
import com.wenqujingdian.view.home.homechildfragment.HomeReadFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;


/**
 * Created by wanghongwei on 2017/7/3.
 */

public class HomeViewPagerFragment extends BaseFragment {


    @Bind(R.id.title_back_lin)
    LinearLayout mTitleBackLin;
    @Bind(R.id.title_title)
    TextView     mTitleTitle;
    @Bind(R.id.frag_home_tab)
    TabLayout    mFragHomeTab;
    @Bind(R.id.frag_home_vp)
    ViewPager    mFragHomeVp;

    private HomeBookFragment mHomeBookFragment  = new HomeBookFragment();
    private HomeReadFragment mHomeReadFragment = new HomeReadFragment();
    private BookShopFragmentPagerAdapter mPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.frag_home, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        super.initView();
        mTitleTitle.setText("书架");
        mFragHomeTab.addTab(mFragHomeTab.newTab().setText("图书"));
        mFragHomeTab.addTab(mFragHomeTab.newTab().setText("听书"));
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        titles.add("图书");
        titles.add("听书");
        fragments.add(mHomeBookFragment);
        fragments.add(mHomeReadFragment);
        mPagerAdapter = new BookShopFragmentPagerAdapter(getChildFragmentManager(),fragments,titles);
        mFragHomeVp.setAdapter(mPagerAdapter);
        mFragHomeTab.setupWithViewPager(mFragHomeVp);
    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }
}
