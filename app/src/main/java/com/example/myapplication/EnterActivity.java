package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;

public class EnterActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_enter);

        ImageView ImgView1, ImgView2, ImgView3, ImgView4;

        ImgView1 = findViewById(R.id.str1);
        ImgView2 = findViewById(R.id.str2);
        ImgView3 = findViewById(R.id.str3);
        ImgView4 = findViewById(R.id.str4);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView1.setVisibility(View.VISIBLE);
            }
        }, 400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView2.setVisibility(View.VISIBLE);
            }
        }, 900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView3.setVisibility(View.VISIBLE);
            }
        }, 1400);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView4.setVisibility(View.VISIBLE);
            }
        }, 1900);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EnterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2300);
    }

}