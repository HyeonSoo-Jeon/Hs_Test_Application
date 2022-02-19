package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText userName;
    private TextView titleHi;
    private LinearLayout userInput;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);


        userName = (EditText) findViewById(R.id.input);
        Button mButton = (Button) findViewById(R.id.answer);
        titleHi = findViewById(R.id.title_hi);
        userInput = findViewById(R.id.userName);

        findViewById(R.id.answer).setOnClickListener(this);

        Animation moveTop = AnimationUtils.loadAnimation(this,R.anim.title_trans);
        Animation fadeIn = AnimationUtils.loadAnimation(this,R.anim.fadein);
        moveTop.setInterpolator(AnimationUtils.loadInterpolator(this,android.R.anim.accelerate_decelerate_interpolator));


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
        }, 1000);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.answer:
                String answer = "hi";
                String userInput = userName.getText().toString();
                int answerCount = 0;

                if(answer.equals(userInput)) {
                    Intent intent = new Intent(this, Second.class);
                    intent.putExtra("AnswerCount",answerCount);
                    startActivity(intent);
                    finish();


                }
                else{
                    Toast.makeText(this, "input : "+userInput+"\nanswer : "+answer, Toast.LENGTH_SHORT).show();
                }
        }
    }
}