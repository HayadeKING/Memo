package com.example.administrator.memo_20170217.adapter;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.example.administrator.memo_20170217.R;

/**
 * Created by Administrator on 2017/2/17 0017.
 */
public class ViewHolder extends RecyclerView.ViewHolder {

    private TextView textView_content, textView_time;

    private View item_view;

    public ViewHolder(View itemView) {
        super(itemView);
        this.item_view = itemView;
        textView_content = (TextView) itemView.findViewById(R.id.item_content);
        textView_time = (TextView) itemView.findViewById(R.id.item_time);
    }

    public TextView getTextView_content() {
        return textView_content;
    }

    public TextView getTextView_time() {
        return textView_time;
    }

    public View getItem_view() {
        return item_view;
    }
}
