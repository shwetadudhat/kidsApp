package com.sparrow.kidsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.os.Bundle;
import android.view.WindowManager;
import android.widget.ImageView;
import android.widget.LinearLayout;

import com.sparrow.kidsapp.Adapter.CustomPagerAdapter;
import com.sparrow.kidsapp.Adapter.CustomQuizPagerAdapter;
import com.sparrow.kidsapp.Model.Quiz;
import com.sparrow.kidsapp.Model.QuizData;
import com.sparrow.kidsapp.R;
import com.sparrow.kidsapp.WebService;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class QuizActivity extends AppCompatActivity {

    ViewPager pager;
    ImageView btnLeft,btnRight,btnHome;
    CustomQuizPagerAdapter customPagerAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_quiz);

        pager=findViewById(R.id.pager);
        btnLeft=findViewById(R.id.btnLeft);
        btnRight=findViewById(R.id.btnRight);
        btnHome=findViewById(R.id.btnHome);


        getQuizdata();
    }

    private void getQuizdata() {
        WebService.getClient().getQuizData().enqueue(new Callback<QuizData>() {
            @Override
            public void onResponse(Call<QuizData> call, Response<QuizData> response) {

                if (response.isSuccessful()){
                    if (response.body().getQuiz().size()>0){

                        customPagerAdapter = new CustomQuizPagerAdapter(QuizActivity.this,response.body().getQuiz());
                        pager.setAdapter(customPagerAdapter);

                        customPagerAdapter.setViewItemInterface(new CustomQuizPagerAdapter.RecyclerViewItemInterface() {
                            @Override
                            public void onItemClick(int position, List<Quiz> mcatlist) {
//                                pager.setCurrentItem(getItem(+1), true);
                                pager.setCurrentItem(pager.getCurrentItem() + 1, true);
                            }
                        });

                    }
                }

            }

            @Override
            public void onFailure(Call<QuizData> call, Throwable t) {

            }
        });
    }
}