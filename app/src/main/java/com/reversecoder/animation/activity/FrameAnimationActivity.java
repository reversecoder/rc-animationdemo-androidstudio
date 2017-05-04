package com.reversecoder.animation.activity;

import android.graphics.drawable.AnimationDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.reversecoder.animation.R;

/*
* @author Md. Rashadul Alam
* */
public class FrameAnimationActivity extends AppCompatActivity {

    ImageView frameAnimationImageView;
    AnimationDrawable frameAnimation;
    Button btnStart, btnStop;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_frame_animation);

        initUI();

        initAction();

    }

    private void initUI() {
        frameAnimationImageView = (ImageView) findViewById(R.id.frame_image);
//        frameAnimationImageView.setBackgroundResource(R.drawable.frame_animation);
        frameAnimation = (AnimationDrawable) frameAnimationImageView.getBackground();

        btnStart = (Button) findViewById(R.id.btn_start);
        btnStop = (Button) findViewById(R.id.btn_stop);
    }

    private void initAction() {
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameAnimation.start();
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                frameAnimation.stop();
//                frameAnimation.selectDrawable(0);
            }
        });
    }
}
