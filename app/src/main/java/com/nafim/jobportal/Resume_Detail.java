package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Resume_Detail extends AppCompatActivity {

    Button editButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_detail);

        getSupportActionBar().setTitle("Resume Detail");

        editButton = findViewById(R.id.edit_resume);



        editButton.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Profile_Page.class);
                startActivity(intent);

            }
        });






    }
}