package com.example.administrator.memo_20170217;

import android.content.Intent;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.administrator.memo_20170217.adapter.MemoAdapter;
import com.example.administrator.memo_20170217.db.Memo;
import com.example.administrator.memo_20170217.util.Utils;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private RecyclerView recyclerView;
    //增加便签的按钮
    private FloatingActionButton button;
    //当数据库中没有任何数据的时候显示的提示信息
    private RelativeLayout tips;
    //RecyclerView的适配器
    private MemoAdapter adapter;
    //存储从数据库中查询的全部数据
    private List<Memo> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
        initAction();
    }

    private void initView(){
        button= (FloatingActionButton) findViewById(R.id.button_add);
        tips = (RelativeLayout) findViewById(R.id.tips);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);
    }

    private void initAction(){
        button.setOnClickListener(this);
    }

    /**数据初始化*/
    private void initData(){
        /*先从数据库中查询所有的便签数据，如果有数据的话就显示到recyclerView中，如果没有数据的话
        * 就将无数据提示信息显示出来。
        * */
        list = Utils.queryContentAll();
        if (list.size() == 0){
            recyclerView.setVisibility(View.GONE);
            tips.setVisibility(View.VISIBLE);
        } else {
            adapter = new MemoAdapter(list, MainActivity.this);
            recyclerView.setAdapter(adapter);
        }
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_add:
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.translate_in_right_to_left, R.anim.translate_out_right_to_left);
                break;
        }
    }
}
