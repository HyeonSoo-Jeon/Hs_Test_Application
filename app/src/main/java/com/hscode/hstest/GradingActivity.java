package com.hscode.hstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.TextView;

import java.util.ArrayList;

public class GradingActivity extends AppCompatActivity {

    ArrayList<Integer> Answers;
    String userName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grading);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        Answers = prev_intent.getExtras().getIntegerArrayList("Answers");
        TextView loading = findViewById(R.id.loadingText);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText(". .");
            }
        }, 500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText(". . .");
            }
        }, 1000);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                loading.setText(". . . .");
            }
        }, 1500);


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(GradingActivity.this, ResultActivity.class);
                intent.putExtra("userName", userName);
                intent.putExtra("Answers", Answers);
                startActivity(intent);
                finish();
            }
        }, 2000);

    }

    @Override
    public void onBackPressed() {

    }
}