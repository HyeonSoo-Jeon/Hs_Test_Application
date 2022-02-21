package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.AudioManager;
import android.media.SoundPool;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.Toast;

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

        Animation popAnim = AnimationUtils.loadAnimation(this, R.anim.pop);
        popAnim.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.overshoot_interpolator));

        SoundPool soundPool = new SoundPool(4, AudioManager.STREAM_MUSIC, 0);
        int soundPlay1 = soundPool.load(this, R.raw.en1, 1);
        int soundPlay2 = soundPool.load(this, R.raw.en2, 1);
        int soundPlay3 = soundPool.load(this, R.raw.en3, 1);
        int soundPlay4 = soundPool.load(this, R.raw.en4, 1);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView1.setVisibility(View.VISIBLE);
                ImgView1.startAnimation(popAnim);
                soundPool.play(soundPlay1, 1f, 1f, 0, 0, 1f);
            }
        }, 300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView2.setVisibility(View.VISIBLE);
                ImgView2.startAnimation(popAnim);
                soundPool.play(soundPlay2, 1f, 1f, 0, 0, 1f);


            }
        }, 800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView3.setVisibility(View.VISIBLE);
                ImgView3.startAnimation(popAnim);
                soundPool.play(soundPlay3, 1f, 1f, 0, 0, 1f);


            }
        }, 1300);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                ImgView4.setVisibility(View.VISIBLE);
                ImgView4.startAnimation(popAnim);
                soundPool.play(soundPlay4, 1f, 1f, 0, 0, 1f);


            }
        }, 1800);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(EnterActivity.this, NameActivity.class);
                startActivity(intent);
                finish();
            }
        }, 2200);
    }

    @Override
    public void onBackPressed() {
    }


}