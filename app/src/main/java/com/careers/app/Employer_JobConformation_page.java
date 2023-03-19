package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Employer_JobConformation_page extends AppCompatActivity {

    TextView jobTitleDetail,jbdesc,JobResponsiblity,jobType,locationDetail,employerDetail,vacancyDetail,SalaryDetail,deadlineDetail,educationalQualificationDetail;

    Button btnPost;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_job_conformation_page);



        vacancyDetail=findViewById(R.id.vacancyDetail);
        jobTitleDetail=findViewById(R.id.jobTitleDetail);
        employerDetail=findViewById(R.id.employerDetail);
        locationDetail=findViewById(R.id.locationDetail);
        jobType=findViewById(R.id.jobType);
        jbdesc=findViewById(R.id.jbdesc);
        JobResponsiblity=findViewById(R.id.JobResponsiblity);
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

        String jobTitle,jobtype,empJobdescription,empjobvacancy,jobLocation,employer,deadLine,eduQualification,employerName,empJobResponsiblity,Salary,deadline;
        jobTitle= extras.getString("jobTitle");
        jobtype=extras.getString("jobType");
        employer=extras.getString("employerName");
        empJobdescription=extras.getString("empJobdescription");

        eduQualification=extras.getString("emp_educationalQualification");
        empJobResponsiblity= extras.getString("empJobResponsiblity");
        empjobvacancy=extras.getString("empjobvacancy");
        jobLocation=extras.getString("empjobLocation");
        Salary=extras.getString("Salary");
        deadline= extras.getString("deadline");


        jbdesc.setText(empJobdescription);
        jobTitleDetail.setText(jobTitle);
        employerDetail.setText(employer);
        deadlineDetail.setText(deadline);
        locationDetail.setText(jobLocation);
        SalaryDetail.setText(Salary);
        JobResponsiblity.setText(empJobResponsiblity);
        jobType.setText(jobtype);
        vacancyDetail.setText(empjobvacancy);
        deadlineDetail.setText(deadline);
        educationalQualificationDetail.setText(eduQualification);

    }

}