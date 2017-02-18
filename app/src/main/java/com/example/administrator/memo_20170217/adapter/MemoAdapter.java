package com.example.administrator.memo_20170217.adapter;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.administrator.memo_20170217.DetailActivity;
import com.example.administrator.memo_20170217.MainActivity;
import com.example.administrator.memo_20170217.MyApplication;
import com.example.administrator.memo_20170217.R;
import com.example.administrator.memo_20170217.db.Memo;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17 0017.
 */
public class MemoAdapter extends RecyclerView.Adapter<ViewHolder> {

    private List<Memo> list_memo;

    private Context context;

    public MemoAdapter(List<Memo> list_memo, Context context){
        this.list_memo = list_memo;
        this.context = context;
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.activity_item, parent, false);
        ViewHolder viewHolder = new ViewHolder(view);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        final Memo memo = list_memo.get(position);
        holder.getTextView_content().setText(memo.getContent());
        holder.getTextView_time().setText(memo.getTime());
        holder.getItem_view().setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(context, DetailActivity.class);
                intent.putExtra("id", memo.getId());
                context.startActivity(intent);
                ((MainActivity) context).finish();
                ((MainActivity) context).overridePendingTransition(R.anim.translate_in_right_to_left, R.anim.translate_out_right_to_left);
            }
        });
    }

    @Override
    public int getItemCount() {
        return list_memo.size();
    }
}
