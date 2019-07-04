package com.rl.kanmeitu.activity;

import android.os.Bundle;

import com.rl.kanmeitu.util.SharedPrefrenceUtil;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class BaseActivity extends AppCompatActivity {

    protected SharedPrefrenceUtil sp;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public void setContentView(int layoutResID) {
        super.setContentView(layoutResID);
        sp = SharedPrefrenceUtil.getInstance(getApplicationContext());
    }
}
