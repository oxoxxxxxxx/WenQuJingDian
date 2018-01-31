package com.wenqujingdian.view.home.fragment.childfragment;

import android.support.annotation.Nullable;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.widget.AppCompatEditText;
import android.support.v7.widget.AppCompatTextView;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.adapter.BookClassRecyclerviewAdapter;
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
 * # 时间：2018/1/25    上午11:53
 * # 描述：织巢鸟科技
 */

public class BookViewPagerFragment extends BaseViewPagerFragment {
    @Bind(R.id.child_book_edit_find)
    AppCompatEditText  mChildBookEditFind;
    @Bind(R.id.child_book_class)
    AppCompatTextView  mChildBookClass;
    @Bind(R.id.child_book_sou_tv)
    AppCompatTextView  mChildBookSouTv;
    @Bind(R.id.child_book_num)
    TextView           mChildBookNum;
    @Bind(R.id.child_books)
    RecyclerView       mChildBooks;
    @Bind(R.id.child_book_down_more)
    TextView           mChildBookDownMore;
    @Bind(R.id.child_books_class)
    RecyclerView       mChildBooksClass;
    @Bind(R.id.book_srll_layout)
    SwipeRefreshLayout mBookSrllLayout;
    private BookRecyclerviewAdapter mChildBooksAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container) {
        View view = inflater.inflate(R.layout.child_frag_book, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    protected void initView() {
        InitRefresh.init(mBookSrllLayout);
        int spanCount = 3;
        int spacing = 20;
        boolean includeEdge = false;
        mChildBooks.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        mChildBooks.addItemDecoration(new GridSpacingItemDecoration(spanCount, spacing, includeEdge));
        mChildBooksAdapter = new BookRecyclerviewAdapter();
        mChildBooks.setAdapter(mChildBooksAdapter);
        mChildBooksAdapter.setOnItemClickListener(new RecyclerOnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                startActivity(BookMassageActivity.class);
            }
        });
        mChildBooksClass.setLayoutManager(new GridLayoutManager(Latte.getApplication(), 3));
        mChildBooksClass.setAdapter(new BookClassRecyclerviewAdapter());


    }

    @Override
    protected void onFragmentVisibleChange(boolean isVisible) {
        if (isVisible) {
            log("第一次加载 55");
        }
    }


    @OnClick({R.id.child_book_class, R.id.child_book_sou_tv, R.id.child_book_down_more})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.child_book_class:
                break;
            case R.id.child_book_sou_tv:
                break;
            case R.id.child_book_down_more:
                break;
        }
    }
}
