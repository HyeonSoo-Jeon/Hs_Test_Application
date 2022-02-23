package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.KeyEvent;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class NameActivity extends AppCompatActivity implements View.OnClickListener {

    public static Activity nameActivity;

    private EditText userName;
    private TextView titleHi;
    private LinearLayout userInput;

    private long backKeyPressedTime = 0;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_name);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);

        nameActivity = NameActivity.this;


        userName = findViewById(R.id.input);

        titleHi = findViewById(R.id.title_hi);
        userInput = findViewById(R.id.userName);

        findViewById(R.id.answer).setOnClickListener(this);

        Animation moveTop = AnimationUtils.loadAnimation(this, R.anim.title_trans);
        Animation fadeIn = AnimationUtils.loadAnimation(this, R.anim.fadein);
        moveTop.setInterpolator(AnimationUtils.loadInterpolator(this, android.R.anim.accelerate_decelerate_interpolator));


        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                titleHi.startAnimation(moveTop);
            }
        }, 500);
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                userInput.setVisibility(View.VISIBLE);
                userInput.startAnimation(fadeIn);
            }
        }, 1300);
        // 엔터키 방지
        userName.setOnKeyListener(new View.OnKeyListener() {
            @Override
            public boolean onKey(View v, int keyCode, KeyEvent event) {
                if (keyCode == event.KEYCODE_ENTER) {
                    findViewById(R.id.answer).performClick();
                    return true;
                }
                return false;
            }
        });
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.answer:
                String userInput = userName.getText().toString();
                while ( userInput.length() != 0 &&userInput.charAt(0) == ' ') {
                    userInput = userInput.substring(1);
                }

                if (userInput.length() != 0) {
                    Intent intent = new Intent(this, NamePopupActivity.class);
                    intent.putExtra("userName", userInput);
                    startActivity(intent);
                } else {
                    Toast.makeText(this, "이름을 입력해 주세요!", Toast.LENGTH_SHORT).show();
                }
                break;
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        userName.setText(null);
    }

    @Override
    public void onBackPressed() {
        if (System.currentTimeMillis() > backKeyPressedTime + 2000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 2000) {
            finish();
            System.exit(0);
            toast.cancel();
        }
    }
}