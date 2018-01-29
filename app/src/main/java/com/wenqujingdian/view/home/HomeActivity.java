package com.wenqujingdian.view.home;

import android.support.v4.app.FragmentTransaction;
import android.support.v4.content.ContextCompat;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.base.BaseActivity;
import com.wenqujingdian.view.home.fragment.BookShopViewPagerFragment;
import com.wenqujingdian.view.home.fragment.HomeViewPagerFragment;
import com.wenqujingdian.view.home.fragment.MeViewPagerFragment;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/16    下午3:56
 * # 描述：织巢鸟科技
 */

public class HomeActivity extends BaseActivity {

    @Bind(R.id.home_framelayout)
    FrameLayout  homeViewFrag;
    @Bind(R.id.act_home_book_img)
    ImageView    mActHomeBookImg;
    @Bind(R.id.act_home_book_tv)
    TextView     mActHomeBookTv;
    @Bind(R.id.act_home_book_lin)
    LinearLayout mActHomeBookLin;
    @Bind(R.id.act_home_shop_img)
    ImageView    mActHomeShopImg;
    @Bind(R.id.act_home_shop_tv)
    TextView     mActHomeShopTv;
    @Bind(R.id.act_home_shop_lin)
    LinearLayout mActHomeShopLin;
    @Bind(R.id.act_home_me_img)
    ImageView    mActHomeMeImg;
    @Bind(R.id.act_home_me_tv)
    TextView     mActHomeMeTv;
    @Bind(R.id.act_home_me_lin)
    LinearLayout mActHomeMeLin;

    private HomeViewPagerFragment     homeFragment;
    private BookShopViewPagerFragment mBookShopFragment;
    private MeViewPagerFragment       meFragment;
    private boolean meBoolean   = false;
    private boolean homeBoolean = true;
    private boolean bookBoolean = false;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        setState();
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        if (homeFragment == null) {
            homeFragment = new HomeViewPagerFragment();
        }
        transaction.replace(R.id.home_framelayout, homeFragment);
        transaction.commit();

    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();
    }

    private void setState() {
        if (homeBoolean) {
            mActHomeBookTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor));
            mActHomeShopTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor_1));
            mActHomeMeTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor_1));
            mActHomeBookImg.setImageResource(R.drawable.shu);
            mActHomeShopImg.setImageResource(R.drawable.book1);
            mActHomeMeImg.setImageResource(R.drawable.our1);

        } else if (bookBoolean) {
            mActHomeBookTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor_1));
            mActHomeShopTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor));
            mActHomeMeTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor_1));
            mActHomeBookImg.setImageResource(R.drawable.shu1);
            mActHomeShopImg.setImageResource(R.drawable.book);
            mActHomeMeImg.setImageResource(R.drawable.our1);
        } else if (meBoolean) {
            mActHomeBookTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor_1));
            mActHomeShopTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor_1));
            mActHomeMeTv.setTextColor(ContextCompat.getColor(getActivity(), R.color.themeColor));
            mActHomeBookImg.setImageResource(R.drawable.shu1);
            mActHomeShopImg.setImageResource(R.drawable.book1);
            mActHomeMeImg.setImageResource(R.drawable.our);
        }

    }


    @OnClick({R.id.act_home_book_lin, R.id.act_home_shop_lin, R.id.act_home_me_lin})
    public void onViewClicked(View view) {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();

        switch (view.getId()) {
            case R.id.act_home_book_lin:
                if (homeFragment == null) {
                    homeFragment = new HomeViewPagerFragment();
                }
                transaction.replace(R.id.home_framelayout, homeFragment);
                homeBoolean = true;
                bookBoolean = false;
                meBoolean = false;
                setState();

                break;
            case R.id.act_home_shop_lin:
                if (mBookShopFragment == null) {
                    mBookShopFragment = BookShopViewPagerFragment.newInstance();
                }
                transaction.replace(R.id.home_framelayout, mBookShopFragment);
                homeBoolean = false;
                bookBoolean = true;
                meBoolean = false;
                setState();
                break;
            case R.id.act_home_me_lin:
                if (meFragment == null) {
                    meFragment = MeViewPagerFragment.newInstance();

                }
                transaction.replace(R.id.home_framelayout, meFragment);
                homeBoolean = false;
                bookBoolean = false;
                meBoolean = true;
                setState();
                break;
        }
        transaction.commit();
    }
}
