package com.example.demo3_5_2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    private EditText et_passwoerd;
    private Button btn_send;
    private EditText et_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        et_name = (EditText) findViewById(R.id.et_name);
        et_passwoerd = (EditText) findViewById(R.id.et_password);
        btn_send = (Button) findViewById(R.id.btn_send);
        btn_send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                passDate();
            }
        });
    }

    public void passDate() {
        Intent intent = new Intent(this, ShowActivity.class);
        intent.putExtra("name", et_name.getText().toString().trim());
        intent.putExtra("password", et_passwoerd.getText().toString().trim());
        startActivity(intent);
    }


}