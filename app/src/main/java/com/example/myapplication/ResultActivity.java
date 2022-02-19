package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class ResultActivity extends AppCompatActivity implements View.OnClickListener {

    String userName;
    int AnswerCnt;
    private long backKeyPressedTime=0;
    private Toast toast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        overridePendingTransition(R.anim.horizon_enter, R.anim.horizon_exit);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");
        AnswerCnt = prev_intent.getExtras().getInt("AnswerCnt");

        findViewById(R.id.retry).setOnClickListener(this);
        findViewById(R.id.share).setOnClickListener(this);


    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.retry:
                Intent intent = new Intent(this, NameActivity.class);
                startActivity(intent);
                finish();
                break;
            case R.id.share:
                String message = userName+"님은 \'전현수 모의고사\'에서 "+Integer.toString(AnswerCnt)+"점을 맞았습니다!\n당신은 몇 점일까요?";
                message += "\n\n현수에게 카톡해서 어플을 받아보세요!!";
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
        if (System.currentTimeMillis() > backKeyPressedTime + 1000) {
            backKeyPressedTime = System.currentTimeMillis();
            toast = Toast.makeText(this, "\'뒤로\' 버튼을 한번 더 누르시면 종료됩니다.", Toast.LENGTH_SHORT);
            toast.show();
            return;
        }
        if (System.currentTimeMillis() <= backKeyPressedTime + 1000) {
            finish();
            toast.cancel();
        }
    }
}