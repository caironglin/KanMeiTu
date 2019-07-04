package com.rl.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.view.WindowManager;

import com.rl.kanmeitu.R;
import com.rl.kanmeitu.util.SharedPrefrenceUtil;

public class SplashActivity extends AppCompatActivity {

    public Handler handler = new Handler(){
        @Override
        public void handleMessage(Message msg) {
            super.handleMessage(msg);
            next();
        }
    };
    private SharedPrefrenceUtil sp;


    private void next() {
        Intent intent = null;
        if (sp.isLogin()){
            intent = new Intent(this,MainActivity.class);
        }else {
            intent = new Intent(this,LoginActivity.class);
        }
        startActivity(intent);
        finish();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                handler.sendEmptyMessage(0);
            }
        },3000);

        sp = SharedPrefrenceUtil.getInstance(getApplicationContext());
    }
}
