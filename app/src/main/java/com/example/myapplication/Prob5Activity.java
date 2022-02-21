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
public class Prob5Activity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> Answers;
    String userName;
    private long backKeyPressedTime=0;
    private Toast toast;
    int answer = 0;
    Button btn1, btn2, btn3, btn4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 여기
        setContentView(R.layout.activity_prob5);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        Answers = prev_intent.getExtras().getIntegerArrayList("Answers");

        // 여기
        findViewById(R.id.ToLv6).setOnClickListener(this);
        findViewById(R.id.Lv5_1).setOnClickListener(this);
        findViewById(R.id.Lv5_2).setOnClickListener(this);
        findViewById(R.id.Lv5_3).setOnClickListener(this);
        findViewById(R.id.Lv5_4).setOnClickListener(this);
        findViewById(R.id.LV5_back).setOnClickListener(this);

        //여기
        btn1 = findViewById(R.id.Lv5_1);
        btn2 = findViewById(R.id.Lv5_2);
        btn3 = findViewById(R.id.Lv5_3);
        btn4 = findViewById(R.id.Lv5_4);
        if (Answers.get(4) == 1) {
            btn1.setBackgroundColor(Color.GRAY);
            answer = 1;
        } else if (Answers.get(4) == 2) {
            btn2.setBackgroundColor(Color.GRAY);
            answer = 2;
        } else if (Answers.get(4) == 3) {
            btn3.setBackgroundColor(Color.GRAY);
            answer = 3;
        } else if (Answers.get(4) == 4) {
            btn4.setBackgroundColor(Color.GRAY);
            answer = 4;
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 여기
            case R.id.ToLv6:
                // 여기
                Intent intent = new Intent(this, Prob6Activity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("Answers",Answers);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.horizon_enterleft, R.anim.horizon_exitleft);
                break;
            // 여기
            case R.id.Lv5_1:
                answer = 1;
                Answers.remove(4);
                Answers.add(4, answer);
                btn1.setBackgroundColor(Color.GRAY);
                btn2.setBackgroundColor(Color.WHITE);
                btn3.setBackgroundColor(Color.WHITE);
                btn4.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Lv5_2:
                answer = 2;
                Answers.remove(4);
                Answers.add(4, answer);
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setBackgroundColor(Color.GRAY);
                btn3.setBackgroundColor(Color.WHITE);
                btn4.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Lv5_3:
                answer = 3;
                Answers.remove(4);
                Answers.add(4, answer);
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setBackgroundColor(Color.WHITE);
                btn3.setBackgroundColor(Color.GRAY);
                btn4.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Lv5_4:
                answer = 4;
                Answers.remove(4);
                Answers.add(4, answer);
                btn1.setBackgroundColor(Color.WHITE);
                btn2.setBackgroundColor(Color.WHITE);
                btn3.setBackgroundColor(Color.WHITE);
                btn4.setBackgroundColor(Color.GRAY);
                break;

            // 여기
            case R.id.LV5_back:
                // 여기
                Intent intent2 = new Intent(this, Prob4Activity.class);
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