package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class RetryPopupActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_retry_popup);

        findViewById(R.id.closeRetry).setOnClickListener(this);
        findViewById(R.id.confirmRetry).setOnClickListener(this);
        findViewById(R.id.cancelRetry).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.closeRetry:
            case R.id.cancelRetry:
                finish();
                break;
            case R.id.confirmRetry:
                Intent intent = new Intent(this, NameActivity.class);
                startActivity(intent);
                finish();
                finish();
                break;
        }
    }
}