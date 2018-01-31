package com.wenqujingdian.view.home.fragment.childfragment;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.adapter.BookClassRecyclerviewAdapter;
import com.wenqujingdian.adapter.ReadsRecyclerviewAdapter;
import com.wenqujingdian.app.Latte;
import com.wenqujingdian.base.BaseViewPagerFragment;
import com.wenqujingdian.ui.GridSpacingItemDecoration;
import com.wenqujingdian.ui.RecyclerOnItemClickListener;
import com.wenqujingdian.util.InitRefresh;
import com.wenqujingdian.view.ReadMassage.ReadMassageActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/25    上午11:54
 * # 描述：织巢鸟科技
 */

public class ListenBookViewPagerFragment extends BaseViewPagerFragment {

    @Bind(R.id.listen_edit_find)
    EditText           mListenEditFind;
    @Bind(R.id.listen_class)
    TextView           mListenClass;
    @Bind(R.id.listen_sou_tv)
    TextView           mListenSouTv;
    @Bind(R.id.listen_reading)
    RecyclerView       mListenReading;
    @Bind(R.id.listen_down_more)
    TextView           mListenDownMore;
    @Bind(R.id.liston_class)
    RecyclerView       mListonClass;
    @Bind(R.id.listen_srll_layout)
    SwipeRefreshLayout mListenSrllLayout;
    private ReadsRecyclerviewAdapter readingAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {

        View view = inflater.inflate(R.layout.child_frag_listonbook, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    protected void initView() {
        InitRefresh.init(mListenSrllLayout);
        int spanCount = 3;
        int spacing = 20;
        boolean includeEdge = false;
        mListenReading.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        readingAdapter =new ReadsRecyclerviewAdapter();
        mListenReading.setAdapter(readingAdapter);
        readingAdapter.setOnItemClickListener(new RecyclerOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(ReadMassageActivity.class);
            }
        });
        mListonClass.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        mListonClass.setAdapter( new BookClassRecyclerviewAdapter());

    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
            log("第一次加载 33");
        }
    }

    @OnClick({R.id.listen_class, R.id.listen_sou_tv, R.id.listen_down_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.listen_class:
                break;
            case R.id.listen_sou_tv:
                break;
            case R.id.listen_down_more:
                break;
        }
    }
}
