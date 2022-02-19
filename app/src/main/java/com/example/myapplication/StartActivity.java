package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    NameActivity NA = (NameActivity) NameActivity.nameActivity;

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_exit);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");



        findViewById(R.id.test).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test:
                Intent intent = new Intent(this, Prob1Activity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("AnswerCnt",0);
                startActivity(intent);
                NA.finish();
                finish();
                break;

        }
    }
}