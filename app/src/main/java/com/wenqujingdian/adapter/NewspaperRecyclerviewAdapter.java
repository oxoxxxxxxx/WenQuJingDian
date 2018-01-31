package com.wenqujingdian.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.wenqujingdian.R;
import com.wenqujingdian.app.Latte;
import com.wenqujingdian.ui.RecyclerOnItemClickListener;
import com.zhy.autolayout.AutoLinearLayout;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/30    上午10:38
 * # 描述：织巢鸟科技
 */

public class NewspaperRecyclerviewAdapter extends RecyclerView.Adapter<NewspaperRecyclerviewAdapter.MyViewHolder> {


    private RecyclerOnItemClickListener mOnItemClickListener;

    public void setOnItemClickListener(RecyclerOnItemClickListener mOnItemClickListener) {
        this.mOnItemClickListener = mOnItemClickListener;
    }

    @Override
    public void onBindViewHolder(final MyViewHolder holder, int position) {
        if (mOnItemClickListener != null) {
            holder.mAutoBook.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    int position = holder.getLayoutPosition();
                    mOnItemClickListener.onItemClick(holder.mAutoBook,position);
                }
            });
        }

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return 12;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Latte.getApplication()).inflate(R.layout.newspaper_item, parent, false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        AutoLinearLayout mAutoBook;

        public MyViewHolder(View view) {
            super(view);
            mAutoBook = view.findViewById(R.id.auto_news);
        }

    }
}
