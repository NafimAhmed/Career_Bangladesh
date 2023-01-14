package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Employer_JobConformation_page extends AppCompatActivity {

    TextView jobTitleDetail,locationDetail,employerDetail,vacancyDetail,SalaryDetail,deadlineDetail,educationalQualificationDetail;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_job_conformation_page);



        vacancyDetail=findViewById(R.id.vacancyDetail);
        jobTitleDetail=findViewById(R.id.jobTitleDetail);
        employerDetail=findViewById(R.id.employerDetail);
        locationDetail=findViewById(R.id.locationDetail);
        vacancyDetail=findViewById(R.id.vacancyDetail);
        SalaryDetail=findViewById(R.id.SalaryDetail);
        deadlineDetail=findViewById(R.id.deadlineDetail);
        educationalQualificationDetail=findViewById(R.id.educationalQualificationDetail);







        Bundle extras = getIntent().getExtras();

        String jobTitle,empjobvacancy,employer,deadLine,eduQualification,employerName,empJobResponsiblity,Salary,deadline;
        jobTitle= extras.getString("jobType");
        employer=extras.getString("jobTitle");
        deadLine=extras.getString("empjobLocation");
        eduQualification=extras.getString("emp_educationalQualification");
        empJobResponsiblity= extras.getString("empJobResponsiblity");
        empjobvacancy=extras.getString("empjobvacancy");
        Salary=extras.getString("Salary");
        deadline= extras.getString("deadline");
        employerName=extras.getString("employerName");

    }
}