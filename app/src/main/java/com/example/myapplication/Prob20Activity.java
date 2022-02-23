package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.util.ArrayList;

public class Prob20Activity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> Answers;
    String userName;
    private long backKeyPressedTime=0;
    private Toast toast;
    int answer = 0;
    Button btnO, btnX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout 변경하기
        setContentView(R.layout.activity_prob20);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        Answers = prev_intent.getExtras().getIntegerArrayList("Answers");

        // 다음 레벨 버튼 바꾸기
        findViewById(R.id.ToResult).setOnClickListener(this);
        findViewById(R.id.Lv20_O).setOnClickListener(this);
        findViewById(R.id.Lv20_X).setOnClickListener(this);
        findViewById(R.id.LV20_back).setOnClickListener(this);


        btnO = findViewById(R.id.Lv20_O);
        btnX = findViewById(R.id.Lv20_X);
        if(Answers.get(19)==1){
            btnO.setBackgroundColor(Color.GRAY);
            answer=1;
        }
        else if(Answers.get(19)==2){
            btnX.setBackgroundColor(Color.GRAY);
            answer=2;
        }


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 다음 레벨 버튼 바꾸기
            case R.id.ToResult:
                if (answer == 0) {
                    toast = Toast.makeText(this, "정답을 눌러주세요!", Toast.LENGTH_SHORT);
                    toast.show();
                } else {
                    // 다음 액티비티 바꾸기
                    Intent intent = new Intent(this, GradingActivity.class);
                    intent.putExtra("userName", userName);
                    intent.putExtra("Answers", Answers);
                    startActivity(intent);
                    finish();
//                overridePendingTransition(R.anim.horizon_enterleft, R.anim.horizon_exitleft);
                    break;
                }
            case R.id.Lv20_O:
                answer = 1;
                Answers.remove(19);
                Answers.add(19,answer);
                btnO.setBackgroundColor(Color.GRAY);
                btnX.setBackgroundColor(Color.WHITE);
                break;
            case R.id.Lv20_X:
                answer = 2;
                Answers.remove(19);
                Answers.add(19,answer);
                btnO.setBackgroundColor(Color.WHITE);
                btnX.setBackgroundColor(Color.GRAY);
                break;
            case R.id.LV20_back:
                Intent intent2 = new Intent(this, Prob19Activity.class);
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