package com.sparrow.kidsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

import com.sparrow.kidsapp.Adapter.CustomQuizPagerAdapter;
import com.sparrow.kidsapp.Adapter.MatchListAdapter;
import com.sparrow.kidsapp.Model.MatchQuiz;
import com.sparrow.kidsapp.Model.Quiz;
import com.sparrow.kidsapp.Model.QuizData;
import com.sparrow.kidsapp.R;
import com.sparrow.kidsapp.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MatchQuizActivity extends AppCompatActivity {

    RecyclerView hlvCustomList;
    MatchListAdapter matchListAdapter;
    ImageView back;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_match_quiz);

        hlvCustomList=findViewById(R.id.hlvCustomList);
        back=findViewById(R.id.back);

        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onBackPressed();
            }
        });

        getQuizdata();
    }

    private void getQuizdata() {
        WebService.getClient().getMatchQuizData().enqueue(new Callback<MatchQuiz>() {
            @Override
            public void onResponse(Call<MatchQuiz> call, Response<MatchQuiz> response) {

                if (response.isSuccessful()){
                    if (response.body().getQuiz().size()>0){

                        matchListAdapter = new MatchListAdapter(response.body().getQuiz(),MatchQuizActivity.this);
                        hlvCustomList.setLayoutManager(new GridLayoutManager(MatchQuizActivity.this,5));
                        hlvCustomList.setAdapter(matchListAdapter);

                    }
                }

            }

            @Override
            public void onFailure(Call<MatchQuiz> call, Throwable t) {

            }
        });
    }
}