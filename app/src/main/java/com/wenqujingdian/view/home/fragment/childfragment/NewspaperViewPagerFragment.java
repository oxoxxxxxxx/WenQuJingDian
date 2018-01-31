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
import com.wenqujingdian.adapter.NewspaperRecyclerviewAdapter;
import com.wenqujingdian.app.Latte;
import com.wenqujingdian.base.BaseViewPagerFragment;
import com.wenqujingdian.ui.GridSpacingItemDecoration;
import com.wenqujingdian.ui.RecyclerOnItemClickListener;
import com.wenqujingdian.util.InitRefresh;

import butterknife.Bind;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/25    上午11:55
 * # 描述：织巢鸟科技
 */

public class NewspaperViewPagerFragment extends BaseViewPagerFragment {

    @Bind(R.id.newspaper_edit_find)
    EditText newspaperEditFind;
    @Bind(R.id.newspaper_sou_tv)
    TextView newspaperSouTv;
    @Bind(R.id.newspaper_recycler)
    RecyclerView newspaperRecycler;
    @Bind(R.id.newspaper_down_more)
    TextView newspaperDownMore;
    @Bind(R.id.newspaper_refresh)
    SwipeRefreshLayout newspaperRefresh;
    private NewspaperRecyclerviewAdapter newspaperAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {

        View view = inflater.inflate(R.layout.child_frag_newspaper, container, false);
        ButterKnife.bind(this, view);
        return view;

    }

    @Override
    protected void initView(){
        InitRefresh.init(newspaperRefresh);
        int spanCount = 3;
        int spacing = 20;
        boolean includeEdge = false;
        newspaperRecycler.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        newspaperAdapter = new NewspaperRecyclerviewAdapter();
        newspaperRecycler.setAdapter(newspaperAdapter);
        newspaperAdapter.setOnItemClickListener(new RecyclerOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {

            }
        });

    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
            log("第一次加载 22");
        }
    }


    @OnClick({R.id.newspaper_sou_tv, R.id.newspaper_down_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.newspaper_sou_tv:
                break;
            case R.id.newspaper_down_more:
                break;
        }
    }
}
