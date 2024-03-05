package com.sparrow.kidsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.HorizontalScrollView;
import android.widget.LinearLayout;

import com.sparrow.kidsapp.R;

public class MainActivity extends AppCompatActivity {

    HorizontalScrollView hlvCustomList;
    LinearLayout container;
    LinearLayout ll_abc,ll_onetwo,ll_quiz,ll_match;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_main);

        hlvCustomList=findViewById(R.id.hlvCustomList);
        container=findViewById(R.id.container);
        ll_abc=findViewById(R.id.ll_abc);
        ll_onetwo=findViewById(R.id.ll_onetwo);
        ll_quiz=findViewById(R.id.ll_quiz);
        ll_match=findViewById(R.id.ll_match);



        ll_abc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,AbcBoardView.class);
                startActivity(intent);
            }
        });

        ll_onetwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,LettersBoradView.class);
                startActivity(intent);
            }
        });


        ll_quiz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,QuizActivity.class);
                startActivity(intent);
            }
        });
        ll_match.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(MainActivity.this,MatchQuizActivity.class);
                startActivity(intent);
            }
        });


    }
}