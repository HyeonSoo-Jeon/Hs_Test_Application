package com.hscode.hstest;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.widget.TextView;

public class NamePopupActivity extends AppCompatActivity implements View.OnClickListener {

    String userName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //타이틀바 없애기
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_namepopup);

        Intent prev_intent = getIntent();
        userName = prev_intent.getExtras().getString("userName");

        TextView textView = findViewById(R.id.askName);
        textView.setText(userName+"님 맞으신가요?");

        findViewById(R.id.closeConfirmName).setOnClickListener(this);
        findViewById(R.id.confirmName).setOnClickListener(this);
        findViewById(R.id.cancelName).setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.closeConfirmName:
            case R.id.cancelName:
                finish();
                break;
            case R.id.confirmName:
                Intent intent = new Intent(this, StartActivity.class);
                intent.putExtra("userName",userName);
                startActivity(intent);
                finish();
                break;
        }

    }
}