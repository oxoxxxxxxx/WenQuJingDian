package com.wenqujingdian.view.home;

import android.support.annotation.IdRes;
import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.widget.FrameLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;

import com.wenqujingdian.R;
import com.wenqujingdian.base.BaseActivity;
import com.wenqujingdian.view.home.fragment.HomeFragment;
import com.wenqujingdian.view.home.fragment.MeFragment;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/16    下午3:56
 * # 描述：织巢鸟科技
 */

public class HomeActivity extends BaseActivity implements RadioGroup.OnCheckedChangeListener {

    @Bind(R.id.home_framelayout)
    FrameLayout homeViewFrag;
    @Bind(R.id.home_radio_home)
    RadioButton homeRadioHome;
    @Bind(R.id.home_radio_book_shop)
    RadioButton homeRadioShop;
    @Bind(R.id.home_radio_me)
    RadioButton homeRadioMe;
    @Bind(R.id.home_radio_group)
    RadioGroup  homeRadioGroup;

    private HomeFragment homeFragment;
//    private ShopFragment shopFragment;
    private MeFragment   meFragment;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);


    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
        homeRadioGroup.setOnCheckedChangeListener(this);
        setDefaultFragment();
    }

//    初始化 首页状态

    private void setDefaultFragment() {
        homeRadioHome.setChecked(true);
        homeRadioShop.setChecked(false);
        homeRadioMe.setChecked(false);

        if (homeRadioHome.isChecked()){
            setTabState();
            FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
            meFragment = MeFragment.newInstance();
            transaction.replace(R.id.home_framelayout,homeFragment).commit();
        }
    }

    @Override
    public void onCheckedChanged(RadioGroup group, @IdRes int checkedId) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        switch (checkedId) {
            case R.id.home_radio_home:
                if (homeFragment == null){
                    homeFragment = HomeFragment.newInstance();
                }
                transaction.replace(R.id.home_framelayout,homeFragment);

                break;
            case R.id.home_radio_book_shop:
//                if (shopFragment == null){
//                    shopFragment = ShopFragment.newInstance();
//                }
//                transaction.replace(R.id.home_view_frag,shopFragment);

                break;
            case R.id.home_radio_me:
                if (meFragment == null){
                    meFragment = MeFragment.newInstance();

                }
                transaction.replace(R.id.home_framelayout,meFragment);

                break;
        }
        setTabState();
        transaction.commit();
    }

    private void setTabState() {
//        改变导航按钮的状态
        setHomeState();
        setShopState();
        setMeState();
    }

    private void setMeState() {
        if (homeRadioMe.isChecked()){
            homeRadioMe.setTextColor(ContextCompat.getColor(getActivity(),R.color.themeColor));
        }else {
            homeRadioMe.setTextColor(ContextCompat.getColor(getActivity(),R.color.themeColor_1));
        }

    }

    private void setShopState() {
        if (homeRadioShop.isChecked()){
            homeRadioShop.setTextColor(ContextCompat.getColor(getActivity(),R.color.themeColor));
        }else {
            homeRadioShop.setTextColor(ContextCompat.getColor(getActivity(),R.color.themeColor_1 ));
        }

    }

    private void setHomeState() {
        if (homeRadioHome.isChecked()){
            homeRadioHome.setTextColor(ContextCompat.getColor(getActivity(),R.color.themeColor));
        }else {
            homeRadioHome.setTextColor(ContextCompat.getColor(getActivity(),R.color.themeColor_1));
        }

    }

}
