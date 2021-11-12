package com.example.demo3_5_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ShopActivity extends AppCompatActivity implements View.OnClickListener{
    private ItemInfo itemInfo;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shop);
        itemInfo = new ItemInfo("金剑", 100, 20, 20);
        findViewById(R.id.rl).setOnClickListener(this);
        TextView mLifeTv = (TextView) findViewById(R.id.tv_life);
        TextView mNameTv = (TextView) findViewById(R.id.tv_name);
        TextView mSpeedTv = (TextView) findViewById(R.id.tv_speed);
        TextView mAttackTv = (TextView) findViewById(R.id.tv_attack);
        mLifeTv.setText("生命值+" + itemInfo.getLife());
        mNameTv.setText(itemInfo.getName() + "");
        mSpeedTv.setText("敏捷度+" + itemInfo.getSpeed());
        mAttackTv.setText("攻击力+" + itemInfo.getAttack());
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.rl:
                Intent intent = new Intent();
                intent.putExtra("equipment", itemInfo);
                setResult(1, intent);
                finish();
            break;
        }
    }
}
