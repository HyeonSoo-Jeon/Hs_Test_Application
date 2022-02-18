package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mAnswer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        overridePendingTransition(R.anim.fadein, R.anim.fadeout);


        mAnswer = (EditText) findViewById(R.id.input);
        Button mButton = (Button) findViewById(R.id.answer);

        findViewById(R.id.answer).setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.answer:
                String answer = "hi";
                String userInput = mAnswer.getText().toString();
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