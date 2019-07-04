package com.rl.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rl.kanmeitu.R;
import com.rl.kanmeitu.util.SharedPrefrenceUtil;

public class MainActivity extends AppCompatActivity {
    SharedPrefrenceUtil sp = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        sp = SharedPrefrenceUtil.getInstance(getApplicationContext());
    }

    public void onLogoutClick(View view) {
        sp.setLogin(false);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
