package com.example.natha.bluetoothservice2;

import android.content.Intent;
import android.graphics.Color;
import android.os.CountDownTimer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class LoadingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_loading);


        new CountDownTimer(1000, 50) {

            @Override
            public void onTick(long arg0) {
                // TODO Auto-generated method stub

            }

            @Override
            public void onFinish() {
                LoadingActivity.this.startActivity(new Intent(LoadingActivity.this.getApplicationContext(), MainActivity.class));
                LoadingActivity.this.finish();
            }
        }.start();
    }
}
