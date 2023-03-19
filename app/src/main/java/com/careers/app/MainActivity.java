package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView tv_apply,tv_done;

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.startingImage);
        
        image.setImageResource(R.drawable.logo);



        tv_apply=findViewById(R.id.tv_apply);
        tv_done=findViewById(R.id.tv_done);


        Animation textanim_apply= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.textanim_left);
        Animation textanim_done= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.textanim_right);
        Animation zoom= AnimationUtils.loadAnimation(getApplicationContext(),R.anim.zoom);


        tv_apply.setAnimation(textanim_apply);
        tv_done.setAnimation(textanim_done);
        image.setAnimation(zoom);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {









                Intent intent=new Intent(getApplicationContext(), com.careers.app.Slider_page.class);
                startActivity(intent);
                finish();




            }
        },2000);


//        Intent intent= new Intent(getApplicationContext(),Login_page.class);
//        startActivity(intent);
    }
}