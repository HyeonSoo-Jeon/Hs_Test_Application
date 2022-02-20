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
public class Prob10Activity extends AppCompatActivity implements View.OnClickListener {

    ArrayList<Integer> Answers;
    String userName;
    private long backKeyPressedTime=0;
    private Toast toast;
    int answer = 0;
    Button btnO, btnX;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 여기
        setContentView(R.layout.activity_prob10);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        Answers = prev_intent.getExtras().getIntegerArrayList("Answers");

        // 여기
        findViewById(R.id.ToLv11).setOnClickListener(this);
        findViewById(R.id.Lv10_O).setOnClickListener(this);
        findViewById(R.id.Lv10_X).setOnClickListener(this);
        findViewById(R.id.LV10_back).setOnClickListener(this);

        //여기
        btnO = findViewById(R.id.Lv10_O);
        btnX = findViewById(R.id.Lv10_X);
        if(Answers.get(2)==1){
            btnO.setBackgroundColor(Color.GRAY);
            answer=1;
        }
        else if(Answers.get(2)==2){
            btnX.setBackgroundColor(Color.GRAY);
            answer=2;
        }
    }
    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 여기
            case R.id.ToLv11:
                // 여기
                Intent intent = new Intent(this, Prob11Activity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("Answers",Answers);
                startActivity(intent);
                finish();
                overridePendingTransition(R.anim.horizon_enterleft, R.anim.horizon_exitleft);
                break;
            // 여기
            case R.id.Lv10_O:
                answer = 1;
                Answers.remove(1);
                Answers.add(1,answer);
                btnO.setBackgroundColor(Color.GRAY);
                btnX.setBackgroundColor(Color.WHITE);
                break;
            // 여기
            case R.id.Lv10_X:
                answer = 2;
                Answers.remove(1);
                Answers.add(1,answer);
                btnO.setBackgroundColor(Color.WHITE);
                btnX.setBackgroundColor(Color.GRAY);
                break;
            // 여기
            case R.id.LV10_back:
                // 여기
                Intent intent2 = new Intent(this, Prob9Activity.class);
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
        }
    }
}