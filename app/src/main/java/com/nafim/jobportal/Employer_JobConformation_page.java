package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Employer_JobConformation_page extends AppCompatActivity {

    TextView jobTitleDetail,locationDetail,employerDetail,vacancyDetail,SalaryDetail,deadlineDetail,educationalQualificationDetail;

    Button btnPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_job_conformation_page);



        vacancyDetail=findViewById(R.id.vacancyDetail);
        jobTitleDetail=findViewById(R.id.jobTitleDetail);
        employerDetail=findViewById(R.id.employerDetail);
        locationDetail=findViewById(R.id.locationDetail);
        //vacancyDetail=findViewById(R.id.vacancyDetail);
        SalaryDetail=findViewById(R.id.SalaryDetail);
        deadlineDetail=findViewById(R.id.deadlineDetail);
        educationalQualificationDetail=findViewById(R.id.educationalQualificationDetail);

        btnPost=findViewById(R.id.btnpost);

        btnPost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Done_page.class);
                startActivity(intent);
            }
        });







        Bundle extras = getIntent().getExtras();

        String jobTitle,jobType,empjobvacancy,jobLocation,employer,deadLine,eduQualification,employerName,empJobResponsiblity,Salary,deadline;
        jobTitle= extras.getString("jobTitle");
        jobType=extras.getString("jobType");
        employer=extras.getString("employerName");

        eduQualification=extras.getString("emp_educationalQualification");
        empJobResponsiblity= extras.getString("empJobResponsiblity");
        empjobvacancy=extras.getString("empjobvacancy");
        jobLocation=extras.getString("empjobLocation");
        Salary=extras.getString("Salary");
        deadline= extras.getString("deadline");
        employerName=extras.getString("employerName");


        jobTitleDetail.setText(jobTitle);
        employerDetail.setText(employer);
        deadlineDetail.setText(deadline);
        locationDetail.setText(jobLocation);
        SalaryDetail.setText(Salary);
        vacancyDetail.setText(empjobvacancy);
        deadlineDetail.setText(deadline);
        educationalQualificationDetail.setText(eduQualification);

    }

}