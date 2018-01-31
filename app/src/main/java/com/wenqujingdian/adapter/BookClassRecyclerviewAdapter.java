package com.wenqujingdian.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.app.Latte;
import com.zhy.autolayout.utils.AutoUtils;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/30    上午10:38
 * # 描述：织巢鸟科技
 */

public class BookClassRecyclerviewAdapter extends RecyclerView.Adapter<BookClassRecyclerviewAdapter.MyViewHolder> {

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    public MyViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(Latte.getApplication()).inflate(R.layout.books_class,parent,false);
        MyViewHolder holder= new MyViewHolder(view);
        return holder;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv;

        public MyViewHolder(View view) {
            super(view);
            AutoUtils.autoSize(view);

        }

    }
}
