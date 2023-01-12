package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Job_Detail extends AppCompatActivity {

    TextView jbttl,emp,ddln,edqual;
    Button aplyNow;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);
        

        getSupportActionBar().setTitle("Job Detail");
        
        jbttl=findViewById(R.id.jobTitleDetail);
        emp=findViewById(R.id.employerDetail);
        ddln=findViewById(R.id.deadlineDetail);
        edqual=findViewById(R.id.educationalQualificationDetail);
        aplyNow=findViewById(R.id.applyNow);


        Bundle extras = getIntent().getExtras();

        String jobTitle,employer,deadLine,eduQualification;
        jobTitle= extras.getString("jobTitle");
        employer=extras.getString("employer");
        deadLine=extras.getString("deadLine");
        eduQualification=extras.getString("educationalQualification");

        jbttl.setText(jobTitle);
        emp.setText(employer);
        ddln.setText(deadLine);
        edqual.setText(eduQualification);

        aplyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Resume_Detail.class);
                startActivity(intent);
            }
        });


        
        






    }
}