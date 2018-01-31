package com.wenqujingdian.view.home.homechildfragment;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.adapter.BookRecyclerviewAdapter;
import com.wenqujingdian.app.Latte;
import com.wenqujingdian.base.BaseViewPagerFragment;
import com.wenqujingdian.ui.GridSpacingItemDecoration;
import com.wenqujingdian.ui.RecyclerOnItemClickListener;
import com.wenqujingdian.util.InitRefresh;
import com.wenqujingdian.view.BookMassage.BookMassageActivity;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/30    下午5:16
 * # 描述：织巢鸟科技
 */

public class HomeBookFragment extends BaseViewPagerFragment {

    @Bind(R.id.hoe_books)
    RecyclerView       mHoeBooks;
    @Bind(R.id.home_down_more)
    TextView           mHomeDownMore;
    @Bind(R.id.home_fragment_swipe)
    SwipeRefreshLayout mHomeFragmentSwipe;
    private BookRecyclerviewAdapter bookAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.home_book_frag, container,false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    protected void initView() {
        InitRefresh.init(mHomeFragmentSwipe);
        int spanCount = 3;
        int spacing = 20;
        boolean includeEdge = false;
        mHoeBooks.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        bookAdapter = new BookRecyclerviewAdapter();
        mHoeBooks.setAdapter(bookAdapter);
        bookAdapter.setOnItemClickListener(new RecyclerOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(BookMassageActivity.class);
            }
        });
    }



    @OnClick({R.id.home_down_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.home_down_more:
                break;
        }
    }
}
