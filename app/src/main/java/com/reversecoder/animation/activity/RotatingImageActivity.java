package com.reversecoder.animation.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.Animation.AnimationListener;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.reversecoder.animation.R;

/*
* @author Md. Rashadul Alam
* */
public class RotatingImageActivity extends AppCompatActivity {

    ImageView middleCircle, roundBall;
    Button btnStart, btnStop;
    Animation rotateAnimation, slideDownAnimation, slideUpAnimation;
    boolean isAnimating = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rotating_image);

        initUI();

        initAction();

    }

    private void initUI() {
        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
        middleCircle = (ImageView) findViewById(R.id.middle_circle);
        roundBall = (ImageView) findViewById(R.id.round_ball);
    }

    private void initAction() {
        //set animation
        rotateAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.rotate_animation_infinite_clock_wise);
        slideUpAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_slide_up);
        slideDownAnimation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.translate_slide_down);

        //define animation listener
        AnimationListener rotateAnimationListener = new AnimationListener() {

            @Override
            public void onAnimationEnd(Animation animation) {
            }

            @Override
            public void onAnimationRepeat(Animation animation) {

            }

            @Override
            public void onAnimationStart(Animation animation) {

            }
        };

        AnimationListener slideUpAnimationListener = new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
                roundBall.setVisibility(View.GONE);
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                slideUpAnimation.cancel();
                middleCircle.clearAnimation();
                middleCircle.setVisibility(View.VISIBLE);
                isAnimating = false;
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };

        AnimationListener slideDownAnimationListener = new AnimationListener() {

            @Override
            public void onAnimationStart(Animation animation) {
            }

            @Override
            public void onAnimationEnd(Animation animation) {
                middleCircle.setVisibility(View.GONE);
                roundBall.setVisibility(View.VISIBLE);
                roundBall.startAnimation(rotateAnimation);
                slideDownAnimation.cancel();
                middleCircle.clearAnimation();
            }

            @Override
            public void onAnimationRepeat(Animation animation) {
            }
        };

        //set animation listener
        rotateAnimation.setAnimationListener(rotateAnimationListener);
        slideUpAnimation.setAnimationListener(slideUpAnimationListener);
        slideDownAnimation.setAnimationListener(slideDownAnimationListener);

        //button action
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isAnimating) {
                    middleCircle.startAnimation(slideDownAnimation);
                    isAnimating = true;
                } else {
                    Toast.makeText(RotatingImageActivity.this, "Please stop animation for restart", Toast.LENGTH_LONG).show();
                }
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isAnimating) {
                    middleCircle.setVisibility(View.GONE);
                    roundBall.setVisibility(View.VISIBLE);
                    rotateAnimation.cancel();
                    roundBall.clearAnimation();

                    middleCircle.startAnimation(slideUpAnimation);
                } else {
                    Toast.makeText(RotatingImageActivity.this, "Please start animation first", Toast.LENGTH_LONG).show();

                }
            }
        });
    }
}
