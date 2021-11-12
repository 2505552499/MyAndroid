package com.example.demo4_2_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Map;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private EditText etNumber;
    private EditText etPassword;
    private Button btnLogin;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        Map<String, String> userInfo = FileSaveQQ.getUserInfo(this);
        if(userInfo != null){
            etNumber.setText(userInfo.get("number"));
            etPassword.setText(userInfo.get("password"));
        }
    }

    private void initView() {
        etNumber = (EditText) findViewById(R.id.et_number);
        etPassword = (EditText) findViewById(R.id.et_password);
        btnLogin = (Button) findViewById(R.id.btn_login);
        btnLogin.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        String number = etNumber.getText().toString().trim();
        String password = etPassword.getText().toString().trim();
        if(TextUtils.isEmpty(number)){
            Toast.makeText(this, "请输入QQ账号", Toast.LENGTH_LONG).show();
            return;
        }
        if(TextUtils.isEmpty(password)){
            Toast.makeText(this, "请输入密码", Toast.LENGTH_LONG).show();
            return;
        }
        Toast.makeText(this, "登陆成功", Toast.LENGTH_LONG).show();
        boolean isSaveSucces = FileSaveQQ.saveUserInfo(this, number, password);
        if(isSaveSucces){
            Toast.makeText(this, "保存成功", Toast.LENGTH_LONG).show();
        }else{
            Toast.makeText(this, "保存失败", Toast.LENGTH_LONG).show();
        }
    }
}