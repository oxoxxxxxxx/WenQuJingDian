package com.wenqujingdian.view.BookMassage;

import android.os.Bundle;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.adapter.BookZhangJieRecyclerviewAdapter;
import com.wenqujingdian.app.Latte;
import com.wenqujingdian.base.BaseActivity;
import com.wenqujingdian.ui.ExpandableTextView;
import com.wenqujingdian.util.InitRefresh;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/31    上午10:27
 * # 描述：织巢鸟科技
 */

public class BookMassageActivity extends BaseActivity {


    @Bind(R.id.title_back_lin)
    LinearLayout       mTitleBackLin;
    @Bind(R.id.title_title)
    TextView           mTitleTitle;
    @Bind(R.id.etv)
    ExpandableTextView mEtv;
    @Bind(R.id.act_book_massage_rec)
    RecyclerView       mActBookMassageRec;
    @Bind(R.id.act_book_massage_down_more)
    TextView           mActBookMassageDownMore;
    @Bind(R.id.book_massage_swipe)
    SwipeRefreshLayout mBookMassageSwipe;

    @Override
    public void initView() {
        super.initView();
        setContentView(R.layout.act_book_massage);
        ButterKnife.bind(this);
        InitRefresh.init(mBookMassageSwipe);
        mTitleBackLin.setVisibility(View.VISIBLE);
        mTitleTitle.setText("图书详情");
        mEtv.setText("拉上大嫁风尚老地方就是垃圾的方式点开链接离开世纪东方了开始就烦死了看姐夫实时路况大嫁风尚六块腹肌牲口了姐夫" +
                "的杀戮空间发生的六块腹肌索拉卡董金峰了开始了跨服斗鸡昆仑决 离开家的烦死了看姐夫克里斯丁就上课了佛塑科技放得开浪" +
                "费身上看交流方式路口附近时肯德基");
        mActBookMassageRec.setLayoutManager(new LinearLayoutManager(Latte.getApplication()));
        BookZhangJieRecyclerviewAdapter adapter = new BookZhangJieRecyclerviewAdapter();
        mActBookMassageRec.setAdapter(adapter);

    }

    @Override
    public void initData() {
        super.initData();
    }

    @Override
    public void initEvent() {
        super.initEvent();

    }




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.title_back_lin, R.id.act_book_massage_down_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.title_back_lin:
                getActivity().finish();
                break;
            case R.id.act_book_massage_down_more:
                break;
        }
    }
}
