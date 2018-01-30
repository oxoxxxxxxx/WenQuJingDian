package com.wenqujingdian.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.wenqujingdian.R;
import com.wenqujingdian.app.Latte;
import com.zhy.autolayout.utils.AutoUtils;

import butterknife.Bind;
import butterknife.ButterKnife;

/**
 * # 作者：王宏伟
 * # 时间：2018/1/30    上午10:38
 * # 描述：织巢鸟科技
 */

public class BookRecyclerLinViewAdapter extends RecyclerView.Adapter<BookRecyclerLinViewAdapter.MyViewHolder> {


    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {
        switch (position) {
            case 0:
                holder.mBookRandkingListNum.setBackgroundResource(R.drawable.one_ranking);
                holder.mBookRandkingListNum.setText("01");
                break;
            case 1:
                holder.mBookRandkingListNum.setBackgroundResource(R.drawable.two_ranking);
                holder.mBookRandkingListNum.setText("02");
                break;
            case 2:
                holder.mBookRandkingListNum.setBackgroundResource(R.drawable.three_ranking);
                holder.mBookRandkingListNum.setText("03");
                break;
            case 3:
                holder.mBookRandkingListNum.setBackgroundResource(R.drawable.four_ranking);
                holder.mBookRandkingListNum.setText("04");
                break;
            case 4:
                holder.mBookRandkingListNum.setBackgroundResource(R.drawable.four_ranking);
                holder.mBookRandkingListNum.setText("05");
                break;
            case 5:
                holder.mBookRandkingListNum.setBackgroundResource(R.drawable.four_ranking);
                holder.mBookRandkingListNum.setText("06");
                break;
            default:
                holder.mBookRandkingListNum.setBackgroundResource(R.drawable.four_ranking);
                break;
        }


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

        View view = LayoutInflater.from(Latte.getApplication()).inflate(R.layout.book_ranking_list, parent,false);
        MyViewHolder holder = new MyViewHolder(view);
        return holder;
    }


    class MyViewHolder extends RecyclerView.ViewHolder {
        @Bind(R.id.book_randking_list_num)
        TextView mBookRandkingListNum;
        @Bind(R.id.book_randking_list_name)
        TextView mBookRandkingListName;
        @Bind(R.id.book_randking_list_downnum)
        TextView mBookRandkingListDownnum;

        public MyViewHolder(View view) {
            super(view);
            AutoUtils.autoSize(view);
            ButterKnife.bind(this, itemView);
        }

    }
}
