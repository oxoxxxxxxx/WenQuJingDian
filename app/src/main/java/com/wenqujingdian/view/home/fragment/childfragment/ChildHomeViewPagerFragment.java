package com.wenqujingdian.view.home.fragment.childfragment;

import android.graphics.Color;
import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.adapter.BookRecyclerLinViewAdapter;
import com.wenqujingdian.adapter.BookRecyclerviewAdapter;
import com.wenqujingdian.app.Latte;
import com.wenqujingdian.base.BaseViewPagerFragment;
import com.wenqujingdian.ui.GridSpacingItemDecoration;
import com.wenqujingdian.util.InitRefresh;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/25    上午11:52
 * # 描述：织巢鸟科技
 */

public class ChildHomeViewPagerFragment extends BaseViewPagerFragment {

    @Bind(R.id.srll_layout)
    SwipeRefreshLayout mSrllLayout;
    @Bind(R.id.child_home_edit_find)
    EditText           mChildHomeEditFind;
    @Bind(R.id.child_home_class)
    TextView  mChildHomeClass;
    @Bind(R.id.child_home_sou_tv)
    TextView  mChildHomeSouTv;
    @Bind(R.id.child_home_recommended_books)
    RecyclerView       mChildHomeRecommendedBooks;
    @Bind(R.id.child_home_recommended_reading)
    RecyclerView       mChildHomeRecommendedReading;
    @Bind(R.id.child_home_ranking_books)
    TextView           mChildHomeRankingBooks;
    @Bind(R.id.child_home_ranking_reading)
    TextView           mChildHomeRankingReading;
    @Bind(R.id.child_home_ranking_day)
    TextView           mChildHomeRankingDay;
    @Bind(R.id.child_home_ranking_week)
    TextView           mChildHomeRankingWeek;
    @Bind(R.id.child_home_ranking_month)
    TextView           mChildHomeRankingMonth;
    @Bind(R.id.child_home_ranking_list)
    RecyclerView       mChildHomeRankingList;
    @Bind(R.id.child_home_new_books)
    RecyclerView       mChildHomeNewBooks;

    //    电子书
    private int bookClass = 1;
    private int times = 1;


    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.child_frag_home, container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void initView() {
        InitRefresh.init(mSrllLayout);
        int spanCount = 3;
        int spacing = 20;
        boolean includeEdge = false;
        mChildHomeRecommendedBooks.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        mChildHomeRecommendedBooks.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mChildHomeRecommendedBooks.setAdapter(new BookRecyclerviewAdapter());

        mChildHomeRecommendedReading.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        mChildHomeRecommendedReading.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mChildHomeRecommendedReading.setAdapter(new BookRecyclerviewAdapter());

        mChildHomeNewBooks.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        mChildHomeNewBooks.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mChildHomeNewBooks.setAdapter(new BookRecyclerviewAdapter());

        mChildHomeRankingList.setLayoutManager(new LinearLayoutManager(Latte.getApplication()));
        mChildHomeRankingList.setAdapter(new BookRecyclerLinViewAdapter());


    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
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

    private void initRefreshLayout() {
        mSrllLayout.setColorSchemeResources(android.R.color.holo_blue_bright,
                android.R.color.holo_orange_light,
                android.R.color.holo_red_light);
        mSrllLayout.setProgressViewOffset(true, 120, 300);
    }

    @OnClick({R.id.child_home_class, R.id.child_home_sou_tv, R.id.child_home_ranking_books, R.id.child_home_ranking_reading, R.id.child_home_ranking_day, R.id.child_home_ranking_week, R.id.child_home_ranking_month})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.child_home_class:
                break;
            case R.id.child_home_sou_tv:
                break;
            case R.id.child_home_ranking_books:
                if (bookClass == 2){
                    mChildHomeRankingBooks.setBackgroundResource(R.color.themeColor);
                    mChildHomeRankingReading.setBackgroundResource(R.color.backgroad_e6);
                    mChildHomeRankingBooks.setTextColor(Color.parseColor("#FFFFFF"));
                    mChildHomeRankingReading.setTextColor(Color.parseColor("#333333"));
                    bookClass =1;
                }

                break;
            case R.id.child_home_ranking_reading:
                if (bookClass == 1){
                    mChildHomeRankingBooks.setBackgroundResource(R.color.backgroad_e6);
                    mChildHomeRankingReading.setBackgroundResource(R.color.themeColor);
                    mChildHomeRankingBooks.setTextColor(Color.parseColor("#333333"));
                    mChildHomeRankingReading.setTextColor(Color.parseColor("#FFFFFF"));
                    bookClass =2;
                }

                break;
            case R.id.child_home_ranking_day:
                if (times!=1){
                    mChildHomeRankingDay.setBackgroundResource(R.drawable.fillet_backgrid_text_lift_shape);
                    mChildHomeRankingWeek.setBackgroundResource(R.color.backgroad_e6);
                    mChildHomeRankingMonth.setBackgroundResource(R.drawable.fillet_backgrid_text_right_shape_hui);
                    mChildHomeRankingDay.setTextColor(Color.parseColor("#FFFFFF"));
                    mChildHomeRankingWeek.setTextColor(Color.parseColor("#333333"));
                    mChildHomeRankingMonth.setTextColor(Color.parseColor("#333333"));
                    times = 1;
                }
                break;
            case R.id.child_home_ranking_week:
                if (times!=2){
                    mChildHomeRankingDay.setBackgroundResource(R.drawable.fillet_backgrid_text_lift_shape_hui);
                    mChildHomeRankingWeek.setBackgroundResource(R.color.themeColor);
                    mChildHomeRankingMonth.setBackgroundResource(R.drawable.fillet_backgrid_text_right_shape_hui);
                    mChildHomeRankingDay.setTextColor(Color.parseColor("#333333"));
                    mChildHomeRankingWeek.setTextColor(Color.parseColor("#FFFFFF"));
                    mChildHomeRankingMonth.setTextColor(Color.parseColor("#333333"));
                    times = 2;
                }
                break;
            case R.id.child_home_ranking_month:
                if (times!=3){
                    mChildHomeRankingDay.setBackgroundResource(R.drawable.fillet_backgrid_text_lift_shape_hui);
                    mChildHomeRankingWeek.setBackgroundResource(R.color.backgroad_e6);
                    mChildHomeRankingMonth.setBackgroundResource(R.drawable.fillet_backgrid_text_right_shape);
                    mChildHomeRankingDay.setTextColor(Color.parseColor("#333333"));
                    mChildHomeRankingWeek.setTextColor(Color.parseColor("#333333"));
                    mChildHomeRankingMonth.setTextColor(Color.parseColor("#FFFFFF"));
                    times = 3;
                }
                break;
        }
    }
}
