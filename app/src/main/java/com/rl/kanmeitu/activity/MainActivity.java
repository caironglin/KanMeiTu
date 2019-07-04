package com.rl.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rl.kanmeitu.R;
import com.rl.kanmeitu.adapter.ImageAdapter;
import com.rl.kanmeitu.domain.Image;
import com.rl.kanmeitu.util.SharedPrefrenceUtil;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rv.setLayoutManager(layoutManager);

        ArrayList<Image> datas = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            datas.add(new Image(""));
        }
        ImageAdapter imageAdapter = new ImageAdapter(this);
        rv.setAdapter(imageAdapter);
        imageAdapter.setData(datas);
    }

    public void onLogoutClick(View view) {
        sp.setLogin(false);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
