package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
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

        Animation popAnim = AnimationUtils.loadAnimation(this,R.anim.pop);
        popAnim.setInterpolator(AnimationUtils.loadInterpolator(this,android.R.anim.overshoot_interpolator));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView1.setVisibility(View.VISIBLE);
                ImgView1.startAnimation(popAnim);

            }
        }, 200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView2.setVisibility(View.VISIBLE);
                ImgView2.startAnimation(popAnim);
            }
        }, 700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView3.setVisibility(View.VISIBLE);
                ImgView3.startAnimation(popAnim);
            }
        }, 1200);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView4.setVisibility(View.VISIBLE);
                ImgView4.startAnimation(popAnim);
            }
        }, 1700);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EnterActivity.this, MainActivity.class);
                startActivity(intent);
            }
        }, 2000);
    }

}