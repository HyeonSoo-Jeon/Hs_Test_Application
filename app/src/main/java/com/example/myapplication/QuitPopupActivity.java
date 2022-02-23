package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;

public class QuitPopupActivity extends AppCompatActivity implements View.OnClickListener {

    Prob1Activity PA = (Prob1Activity) Prob1Activity.probActivity;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_quitpopup);

        findViewById(R.id.closeQuit).setOnClickListener(this);
        findViewById(R.id.confirmQuit).setOnClickListener(this);
        findViewById(R.id.cancelQuit).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.closeQuit:
            case R.id.cancelQuit:
                finish();
                break;
            case R.id.confirmQuit:
                PA.finish();
                finish();
//                ActivityCompat.finishAffinity(this);
                System.exit(0);
                break;
        }
    }
}