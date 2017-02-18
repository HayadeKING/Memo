package com.example.administrator.memo_20170217;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.administrator.memo_20170217.db.Memo;
import com.example.administrator.memo_20170217.util.Utils;

import java.util.List;

/**
 * Created by Administrator on 2017/2/17 0017.
 */
public class DetailActivity extends AppCompatActivity implements View.OnClickListener{

    private Button button_back;

    private TextView textView_time;

    private EditText editText_content;

    private int flag;//标志位，用来区分此次操作是新建便签还是修改便签。0代表新建便签，1代表修改便签。

    private int id;//用来接收从MainActivity传来的id值

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        initView();
        initAction();
    }

    private void initView(){
        button_back = (Button) findViewById(R.id.button_back);
        textView_time = (TextView) findViewById(R.id.text_time);
        editText_content = (EditText) findViewById(R.id.edit_content);
        Intent intent = getIntent();
        id = intent.getIntExtra("id", -1);
        if (id != -1){
            flag = 1;
            List<Memo> list = Utils.queryCertainContent(id);
            textView_time.setText(list.get(0).getTime() + "");
            editText_content.setText(list.get(0).getContent());
            editText_content.setSelection(editText_content.getText().toString().length());
        }
    }

    private void initAction(){
        button_back.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.button_back:
                if (flag == 0){
                    if (!TextUtils.isEmpty(editText_content.getText())){
                    /*如果输入的内容不为空的话，就将内容保存到数据库*/
                        Utils.saveContent(editText_content.getText().toString());
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                    } else {
                    /*如果为空的话，就不做任何操作*/
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                    }
                } else if (flag == 1){
                    /*修改便签*/
                    if (!TextUtils.isEmpty(editText_content.getText()) && !Utils.queryCertainContent(id).get(0).getContent().equals(editText_content.getText().toString())){
                        /*如果输入的内容不为空的话，就修改便签*/
                        Utils.updateCertainContent(id, editText_content.getText().toString());
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                    } else if (TextUtils.isEmpty(editText_content.getText())){
                        /*如果输入的内容为空的话，就删除该便签*/
                        Utils.deleteCertainContent(id);
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                    } else if (!TextUtils.isEmpty(editText_content.getText()) && Utils.queryCertainContent(id).get(0).getContent().equals(editText_content.getText().toString())){
                        /*如果没有对便签做任何改动，不做任何操作*/
                        Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                        startActivity(intent);
                        finish();
                        overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                    }
                }
                break;
            default:
                break;
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            if (flag == 0){
                if (!TextUtils.isEmpty(editText_content.getText())){
                    /*如果输入的内容不为空的话，就将内容保存到数据库*/
                    Utils.saveContent(editText_content.getText().toString());
                    Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                } else {
                    /*如果为空的话，就不做任何操作*/
                    Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                }
            } else if (flag == 1){
                    /*修改便签*/
                if (!TextUtils.isEmpty(editText_content.getText()) && !Utils.queryCertainContent(id).get(0).getContent().equals(editText_content.getText().toString())){
                        /*如果输入的内容不为空的话，就修改便签*/
                    Utils.updateCertainContent(id, editText_content.getText().toString());
                    Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                } else if (TextUtils.isEmpty(editText_content.getText())){
                        /*如果输入的内容为空的话，就删除该便签*/
                    Utils.deleteCertainContent(id);
                    Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                } else if (!TextUtils.isEmpty(editText_content.getText()) && Utils.queryCertainContent(id).get(0).getContent().equals(editText_content.getText().toString())){
                        /*如果没有对便签做任何改动，不做任何操作*/
                    Intent intent = new Intent(DetailActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.translate_in_left_to_right, R.anim.translate_out_left_to_right);
                }
            }
        }
        return true;
    }
}
