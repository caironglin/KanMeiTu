package com.rl.kanmeitu.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.rl.kanmeitu.R;
import com.rl.kanmeitu.util.Constants;
import com.rl.kanmeitu.util.SharedPrefrenceUtil;

public class LoginActivity extends BaseActivity implements View.OnClickListener {


    private EditText et_username;
    private EditText et_password;
    private Button bt_login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        et_username = findViewById(R.id.et_username);
        et_password = findViewById(R.id.et_password);
        bt_login = findViewById(R.id.bt_login);

        bt_login.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.bt_login:
                login();
                break;
        }
    }

    private void login() {
        String username = et_username.getText().toString().trim();
        if(TextUtils.isEmpty(username)){
            Toast.makeText(this,R.string.email_hint,Toast.LENGTH_SHORT).show();
            return;
        }
        // 正则表达式判断邮箱是否正确

        String password = et_password.getText().toString().trim();
        if (TextUtils.isEmpty(password)){
            Toast.makeText(this,R.string.password_hint,Toast.LENGTH_SHORT).show();
        }
        if (password.length()<6 || password.length()>15){
            Toast.makeText(this,R.string.password_length_error,Toast.LENGTH_SHORT).show();
        }
        if (Constants.USERNAME.equals(username) && Constants.PASSWORD.equals(password)){
            sp.setLogin(true);

            Intent intent = new Intent(this,MainActivity.class);
            startActivity(intent);
            finish();
        }else {
            Toast.makeText(this,R.string.username_or_password_error,Toast.LENGTH_SHORT).show();
        }
    }
}
