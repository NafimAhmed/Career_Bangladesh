package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    ImageView image;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = findViewById(R.id.startingImage);
        
        image.setImageResource(R.drawable.logo);



        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {



                Intent intent=new Intent(getApplicationContext(), Login_page.class);
                startActivity(intent);
                finish();




            }
        },2000);


//        Intent intent= new Intent(getApplicationContext(),Login_page.class);
//        startActivity(intent);
    }
}