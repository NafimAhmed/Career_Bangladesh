package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.TextView;

public class Done_page extends AppCompatActivity {

    TextView tv_apply,tv_done;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_done_page);


        tv_apply=findViewById(R.id.tv_apply);
        tv_done=findViewById(R.id.tv_done);


        Animation textanim_apply= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.textanim_left);
        Animation textanim_done= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.textanim_right);


        tv_apply.setAnimation(textanim_apply);
        tv_done.setAnimation(textanim_done);


    }
}