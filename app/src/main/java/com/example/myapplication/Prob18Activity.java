package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

// 여기
public class Prob18Activity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> Answers;
    String userName;
    private long backKeyPressedTime=0;
    private Toast toast;
    int answer = 0;
    Button btn1, btn2, btn3, btn4;
    int idx = 17;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 여기
        setContentView(R.layout.activity_prob18);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        Answers = prev_intent.getExtras().getIntegerArrayList("Answers");

        // 여기
        findViewById(R.id.ToLv19).setOnClickListener(this);
        findViewById(R.id.Lv18_1).setOnClickListener(this);
        findViewById(R.id.Lv18_2).setOnClickListener(this);
        findViewById(R.id.Lv18_3).setOnClickListener(this);
        findViewById(R.id.Lv18_4).setOnClickListener(this);
        findViewById(R.id.LV18_back).setOnClickListener(this);

        //여기
        btn1 = findViewById(R.id.Lv18_1);
        btn2 = findViewById(R.id.Lv18_2);
        btn3 = findViewById(R.id.Lv18_3);
        btn4 = findViewById(R.id.Lv18_4);
        int value = Answers.get(idx);
        if (value == 1) {
            btn1.setBackgroundColor(Color.GRAY);
            answer = 1;
        } else if (value == 2) {
            btn2.setBackgroundColor(Color.GRAY);
            answer = 2;
        } else if (value == 3) {
            btn3.setBackgroundColor(Color.GRAY);
            answer = 3;
        } else if (value == 4) {
            btn4.setBackgroundColor(Color.GRAY);
            answer = 4;
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 여기
            case R.id.ToLv19:
                // 여기
                Intent intent = new Intent(this, Prob19Activity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("Answers",Answers);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.horizon_enterleft, R.anim.horizon_exitleft);
                break;
            // 여기
            case R.id.Lv18_1:
                answer = 1;
                Answers.remove(idx);
                Answers.add(idx, answer);
                btn1.setBackgroundColor(Color.GRAY);
                btn2.setBackgroundColor(Color.WHITE);
                btn3.setBackgroundColor(Color.WHITE);
                btn4.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Lv18_2:
                answer = 2;
                Answers.remove(idx);
                Answers.add(idx, answer);
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setBackgroundColor(Color.GRAY);
                btn3.setBackgroundColor(Color.WHITE);
                btn4.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Lv18_3:
                answer = 3;
                Answers.remove(idx);
                Answers.add(idx, answer);
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setBackgroundColor(Color.WHITE);
                btn3.setBackgroundColor(Color.GRAY);
                btn4.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Lv18_4:
                answer = 4;
                Answers.remove(idx);
                Answers.add(idx, answer);
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setBackgroundColor(Color.WHITE);
                btn3.setBackgroundColor(Color.WHITE);
                btn4.setBackgroundColor(Color.GRAY);
                break;
            // 여기
            case R.id.LV18_back:
                // 여기
                Intent intent2 = new Intent(this, Prob17Activity.class);
                intent2.putExtra("userName",userName);
                intent2.putExtra("Answers",Answers);
                startActivity(intent2);
                finish();
                overridePendingTransition(R.anim.horizon_enterright, R.anim.horizon_exitright);
                break;
        }
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
            toast.cancel();
            System.exit(0);

        }
    }
}