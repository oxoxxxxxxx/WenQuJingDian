package com.wenqujingdian.view.home.fragment.childfragment;

import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/25    下午12:20
 * # 描述：织巢鸟科技
 */

public class BookShopFragmentPagerAdapter extends FragmentPagerAdapter {

    private final ArrayList<Fragment> fragmentList;
    private final ArrayList<String> titles;

    public BookShopFragmentPagerAdapter(FragmentManager fragmentManager, ArrayList<Fragment> fragmentList,ArrayList<String> titles) {
        super(fragmentManager);
        this.fragmentList = fragmentList;
        this.titles = titles;
    }


    @Override
    public Fragment getItem(int position) {
        return fragmentList.get(position);
    }

    @Override
    public int getCount() {
        return fragmentList.size();
    }

    @Nullable
    @Override
    public CharSequence getPageTitle(int position) {
        return titles.get(position);

    }
}
