package com.sparrow.kidsapp.Activity;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.WindowManager;

import com.airbnb.lottie.LottieAnimationView;
import com.sparrow.kidsapp.R;

public class SplashActivity extends AppCompatActivity {

    LottieAnimationView animationView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getWindow().setFlags(
                WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_splash);


// Declaring the animation view
         animationView
                = findViewById(R.id.lottieView);

        // Custom animation speed or duration.
        ValueAnimator animator
                = ValueAnimator.ofFloat(0f, 1f);
        animator
                .addUpdateListener(animation -> {
                    animationView
                            .setProgress((Float) animation.getAnimatedValue());
                });
        animator.start();

        new Handler().postDelayed(new Runnable() {
            public void run() {

            startActivity(new Intent(SplashActivity.this,
                    MainActivity.class));
            finish();

            }
        }, /*secondsDelayed **/ 2000);
    }
}