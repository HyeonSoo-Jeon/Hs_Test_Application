package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class StartActivity extends AppCompatActivity implements View.OnClickListener {

    NameActivity NA = (NameActivity) NameActivity.nameActivity;

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        overridePendingTransition(R.anim.horizon_enterleft, R.anim.horizon_exitleft);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");



        findViewById(R.id.test).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.test:
                ArrayList<Integer> answers = new ArrayList<>();
                for(int i =0;i<20;i++){
                    answers.add(0);
                }
                Intent intent = new Intent(this, Prob1Activity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("Answers",answers);
                startActivity(intent);
                NA.finish();
                finish();
                overridePendingTransition(R.anim.horizon_enterleft, R.anim.horizon_exitleft);
                break;

        }
    }
}