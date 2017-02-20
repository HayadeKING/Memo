package com.example.administrator.memo_20170217;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Created by Administrator on 2017/2/20 0020.
 */
public class WelcomActivity extends AppCompatActivity {

    private Handler handler = new Handler(){

        public void handleMessage(Message msg){

            switch (msg.what){

                case 0:
                    Intent intent = new Intent(WelcomActivity.this, MainActivity.class);
                    startActivity(intent);
                    finish();
                    overridePendingTransition(R.anim.scal_in_small_to_big, R.anim.scal_out_small_to_big);
                    break;
                default:
                    break;

            }

        }

    };

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);
        handler.sendEmptyMessageDelayed(0, 3000);
    }
}
