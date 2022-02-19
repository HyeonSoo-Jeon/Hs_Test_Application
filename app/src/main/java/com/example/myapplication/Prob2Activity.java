package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Prob2Activity extends AppCompatActivity implements View.OnClickListener {

    String userName;
    int AnswerCnt;
    private long backKeyPressedTime=0;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // layout 변경하기
        setContentView(R.layout.activity_prob2);
        overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_exit);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        AnswerCnt = prev_intent.getExtras().getInt("AnswerCnt");

        // 다음 레벨 버튼 바꾸기
        findViewById(R.id.ToLv3).setOnClickListener(this);



    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            // 다음 레벨 버튼 바꾸기
            case R.id.ToLv3:
                // 다음 액티비티 바꾸기
                Intent intent = new Intent(this, ResultActivity.class);
                intent.putExtra("userName",userName);
                intent.putExtra("AnswerCnt",AnswerCnt);
                startActivity(intent);
                finish();
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