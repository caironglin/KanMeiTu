package com.rl.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.rl.kanmeitu.R;
import com.rl.kanmeitu.adapter.ImageAdapter;
import com.rl.kanmeitu.api.Api;
import com.rl.kanmeitu.domain.Image;
import com.rl.kanmeitu.domain.response.ListResponse;
import com.rl.kanmeitu.util.SharedPrefrenceUtil;

import java.util.ArrayList;

public class MainActivity extends BaseActivity {

    private ImageAdapter imageAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RecyclerView rv = findViewById(R.id.rv);
        rv.setHasFixedSize(true);

        final GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        rv.setLayoutManager(layoutManager);

        ArrayList<Image> datas = new ArrayList<>();
        for (int i = 1; i < 10; i++) {
            datas.add(new Image(String.format("http://dev-courses-quick.oss-cn-beijing.aliyuncs.com/%d.jpg",i)));
        }
//        fetchData(); // bug
        imageAdapter = new ImageAdapter(this);
        rv.setAdapter(imageAdapter);
        imageAdapter.setData(datas);
    }

    private void fetchData() {
        Api.getInstance()
                .images()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(new Observer<ListResponse<Image>>() {
                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ListResponse<Image> imageListResponse) {
                        imageAdapter.setData(imageListResponse.getData());
                    }

                    @Override
                    public void onError(Throwable e) {
                        e.printStackTrace();
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }

    public void onLogoutClick(View view) {
        sp.setLogin(false);
        Intent intent = new Intent(this,LoginActivity.class);
        startActivity(intent);
        finish();
    }
}
