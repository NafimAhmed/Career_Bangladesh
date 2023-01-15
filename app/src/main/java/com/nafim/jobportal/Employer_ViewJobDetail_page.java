package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Employer_ViewJobDetail_page extends AppCompatActivity {

    TextView jbttl,emp,ddln,edqual;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_view_job_detail_page);


        getSupportActionBar().setTitle("Pervious Job Detail");

        jbttl=findViewById(R.id.jobTitleDetail);
        emp=findViewById(R.id.employerDetail);
        ddln=findViewById(R.id.deadlineDetail);
        edqual=findViewById(R.id.educationalQualificationDetail);




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

    }
}