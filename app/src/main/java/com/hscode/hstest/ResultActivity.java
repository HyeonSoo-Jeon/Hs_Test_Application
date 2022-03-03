package com.hscode.hstest;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    public static Activity resultActivity;

    ArrayList<Integer> Answers, Corrects;
    String userName;
    int AnswerCnt=0;
    private long backKeyPressedTime=0;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
//        overridePendingTransition(R.anim.horizon_enterleft, R.anim.horizon_exitleft);
        resultActivity = ResultActivity.this;

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        Answers = prev_intent.getExtras().getIntegerArrayList("Answers");
        Corrects = new ArrayList<Integer>(Arrays.asList(1,2,4,2,3,3,1,2,1,4,4,1,3,2,2,1,4,3,3,1));

        for(int i=0;i<20;i++){
            if(Answers.get(i)==Corrects.get(i)){
                AnswerCnt+=1;
            }
        }

        findViewById(R.id.retry).setOnClickListener(this);
        findViewById(R.id.share).setOnClickListener(this);

        TextView pointView = findViewById(R.id.point);
        TextView commentView = findViewById(R.id.comment);

        int score = AnswerCnt*5;
        pointView.setText(Integer.toString(score)+"점");
        String comment;
        if(score<=20){
            comment="실망이 조금 크네요...";
        }
        else if(score<=50){
            comment="아직 우린 덜 친한가봐요..";
        }
        else if(score<=80){
            comment="이 정도면 그럭저럭 잘 지내고 있죠?";
        }
        else if(score<100){
            comment="나를 너무 많이 알아요!";
        }
        else{
            comment="이제 우리 그만 멀어질 때가 됐네요.";
        }
        commentView.setText(comment);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.retry:
                Intent intent = new Intent(this, RetryPopupActivity.class);
                startActivity(intent);
                break;
            case R.id.share:
                String message = userName+"님은 \'전현수 모의고사\'에서 "+Integer.toString(AnswerCnt*5)+"점을 맞았습니다!\n당신은 몇 점일까요?";
                message += "\n\nPlay Store에서 모의고사 어플을 받아보세요!!\n\nhttps://play.google.com/store/apps/details?id=com.hscode.hstest";
                Intent sendIntent = new Intent();
                sendIntent.setAction(Intent.ACTION_SEND);
                sendIntent.putExtra(Intent.EXTRA_TEXT, message);
                sendIntent.setType("text/plain");

                Intent shareIntent = Intent.createChooser(sendIntent, null);
                startActivity(shareIntent);
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