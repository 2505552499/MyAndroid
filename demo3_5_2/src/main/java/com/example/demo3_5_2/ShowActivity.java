package com.example.demo3_5_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShowActivity extends AppCompatActivity implements View.OnClickListener {
    private ProgressBar mProgressBar1;
    private ProgressBar mProgressBar2;
    private ProgressBar mProgressBar3;
    private TextView mLifeTv;
    private TextView tv_name;
    private TextView tv_password;
    private TextView mAttackTv;
    private TextView mSpeedTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show);
        Intent intent = getIntent();
        String name = intent.getStringExtra("name");
        String password = intent.getStringExtra("password");
        tv_name = (TextView) findViewById(R.id.tv_name);
        tv_password = (TextView) findViewById(R.id.tv_password);
        tv_name.setText("用户名：" + name);
        tv_password.setText("密    码：" + password);
        mLifeTv = (TextView) findViewById(R.id.tv_life_progress);
        mAttackTv = (TextView) findViewById(R.id.tv_attack_progress);
        mSpeedTv = (TextView) findViewById(R.id.tv_speed_progress);
        initProgress();
        Button button = findViewById(R.id.btn_buy);
        button.setOnClickListener(this);
    }

    private void initProgress() {
        mProgressBar1 = (ProgressBar) findViewById(R.id.progressBar1);
        mProgressBar2 = (ProgressBar) findViewById(R.id.progressBar2);
        mProgressBar3 = (ProgressBar) findViewById(R.id.progressBar3);
        mProgressBar1.setMax(1000);
        mProgressBar2.setMax(1000);
        mProgressBar3.setMax(1000);
    }





    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (data != null) {
            if (requestCode == 1) {
                if (resultCode == 1) {
                    ItemInfo info = (ItemInfo) data.getSerializableExtra("equipment");
                    updateProgress(info);
                }
            }
        }
    }

    private void updateProgress(ItemInfo info) {
        int progress1 = mProgressBar1.getProgress();
        int progress2 = mProgressBar2.getProgress();
        int progress3 = mProgressBar3.getProgress();
        mProgressBar1.setProgress(progress1 + info.getLife());
        mProgressBar2.setProgress(progress2 + info.getAttack());
        mProgressBar3.setProgress(progress3 + info.getSpeed());
        mLifeTv.setText(mProgressBar1.getProgress() + "");
        mAttackTv.setText(mProgressBar2.getProgress() + "");
        mSpeedTv.setText(mProgressBar3.getProgress() + "");


    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ShopActivity.class);
        startActivityForResult(intent, 1);
    }
}
