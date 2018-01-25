package com.wenqujingdian.view.home.fragment;

import android.support.annotation.Nullable;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.AppCompatImageView;
import android.support.v7.widget.AppCompatTextView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenqujingdian.R;
import com.wenqujingdian.base.BaseFragment;
import com.wenqujingdian.view.home.fragment.childfragment.BookFragment;
import com.wenqujingdian.view.home.fragment.childfragment.BookShopFragmentPagerAdapter;
import com.wenqujingdian.view.home.fragment.childfragment.ChildHomeFragment;
import com.wenqujingdian.view.home.fragment.childfragment.ListenBookFragment;
import com.wenqujingdian.view.home.fragment.childfragment.NewspaperFragment;
import com.wenqujingdian.view.home.fragment.childfragment.PeriodicalFragment;

import java.util.ArrayList;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;


/**
 * Created by wanghongwei on 2017/7/3.
 */

public class BookShopFragment extends BaseFragment {
    @Bind(R.id.title_title)
    AppCompatTextView  mTitleTitle;
    @Bind(R.id.frag_book_shop_tab)
    TabLayout          mFragBookShopTab;
    @Bind(R.id.frag_book_shop_vp)
    ViewPager          mFragBookShopVp;
    @Bind(R.id.frag_book_shop_lift_img)
    AppCompatImageView mFragBookShopLiftImg;

    private int position = 0;

    private ChildHomeFragment  mChildHomeFragment  = new ChildHomeFragment();
    private ListenBookFragment mListenBookFragment = new ListenBookFragment();
    private NewspaperFragment  mNewspaperFragment  = new NewspaperFragment();
    private PeriodicalFragment mPeriodicalFragment = new PeriodicalFragment();
    private BookFragment       mBookFragment       = new BookFragment();
    private BookShopFragmentPagerAdapter  mPagerAdapter = null;


//    单实例

    public static BookShopFragment newInstance() {
        return new BookShopFragment();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.frag_book_shop, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        super.initView();
        mFragBookShopTab.addTab(mFragBookShopTab.newTab().setText("首页"));
        mFragBookShopTab.addTab(mFragBookShopTab.newTab().setText("图书"));
        mFragBookShopTab.addTab(mFragBookShopTab.newTab().setText("期刊"));
        mFragBookShopTab.addTab(mFragBookShopTab.newTab().setText("听书"));
        mFragBookShopTab.addTab(mFragBookShopTab.newTab().setText("报纸"));
        ArrayList<Fragment> fragments = new ArrayList<>();
        ArrayList<String> titles = new ArrayList<>();
        titles.add("首页");
        titles.add("图书");
        titles.add("期刊");
        titles.add("听书");
        titles.add("报纸");
        fragments.add(mChildHomeFragment);
        fragments.add(mBookFragment);
        fragments.add(mPeriodicalFragment);
        fragments.add(mListenBookFragment);
        fragments.add(mNewspaperFragment);
        mPagerAdapter = new BookShopFragmentPagerAdapter(getChildFragmentManager(),fragments,titles);
        mFragBookShopVp.setAdapter(mPagerAdapter);
        mFragBookShopTab.setupWithViewPager(mFragBookShopVp);
    }

    @Override
    public void initData() {
        super.initData();
    }


    @Override
    public void initEvent() {
        super.initEvent();
        mFragBookShopTab.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                if (tab.getPosition() != 0) {
                    mTitleTitle.setText("文曲经典书城-" + tab.getText());
                } else {
                    mTitleTitle.setText("文曲经典书城");

                }
                position = tab.getPosition();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });
    }

    @OnClick({R.id.frag_book_shop_lift_img})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.frag_book_shop_lift_img:
                if (position < mFragBookShopTab.getTabCount() - 1) {
                    mFragBookShopTab.setScrollPosition(position += 1, 0, true);
                } else {
                    toast("最后一个啦！");
                }
                break;

        }
    }
}
