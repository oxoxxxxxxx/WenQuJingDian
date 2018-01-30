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
import com.wenqujingdian.adapter.ReadsRecyclerviewAdapter;
import com.wenqujingdian.app.Latte;
import com.wenqujingdian.base.BaseViewPagerFragment;
import com.wenqujingdian.ui.GridSpacingItemDecoration;
import com.wenqujingdian.util.InitRefresh;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/30    下午5:16
 * # 描述：织巢鸟科技
 */

public class HomeReadFragment extends BaseViewPagerFragment {

    @Bind(R.id.hoem_read)
    RecyclerView       mHoemRead;
    @Bind(R.id.read_down_more)
    TextView           mReadDownMore;
    @Bind(R.id.home_read_swipe)
    SwipeRefreshLayout mHomeReadSwipe;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.home_read_frag, container,false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initView() {

        InitRefresh.init(mHomeReadSwipe);
        int spanCount = 3;
        int spacing = 20;
        boolean includeEdge = false;
        mHoemRead.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        mHoemRead.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mHoemRead.setAdapter(new ReadsRecyclerviewAdapter());
    }


    @OnClick({R.id.read_down_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.read_down_more:
                break;
        }
    }
}
