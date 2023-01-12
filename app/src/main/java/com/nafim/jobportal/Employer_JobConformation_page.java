package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

public class Employer_JobConformation_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_job_conformation_page);

        Bundle extras = getIntent().getExtras();

        String jobTitle,employer,deadLine,eduQualification,employerName,empJobResponsiblity,Salary,deadline;
        jobTitle= extras.getString("jobType");
        employer=extras.getString("jobTitle");
        deadLine=extras.getString("empjobLocation");
        eduQualification=extras.getString("emp_educationalQualification");
        empJobResponsiblity= extras.getString("empJobResponsiblity");
        Salary=extras.getString("Salary");
        deadline= extras.getString("deadline");
        employerName=extras.getString("employerName");

    }
}