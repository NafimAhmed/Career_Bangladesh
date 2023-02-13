package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class Job_Detail extends AppCompatActivity {

    TextView jbttl,emp,ddln,edqual,locationdt,vacancydt,salarydt,jbResponsiblitydt,saveimg;
    Button aplyNow;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        //saveimg=findViewById(R.id.saveimg);


        

        //getSupportActionBar().setTitle("Job Detail");
        
        jbttl=findViewById(R.id.jobTitleDetail);
        locationdt=findViewById(R.id.locationDetail);
        vacancydt=findViewById(R.id.vacancyDetail);
        salarydt=findViewById(R.id.SalaryDetail);
        emp=findViewById(R.id.employerDetail);
        ddln=findViewById(R.id.deadlineDetail);
        jbResponsiblitydt=findViewById(R.id.jbResponsiblityDetail);
        edqual=findViewById(R.id.educationalQualificationDetail);
        aplyNow=findViewById(R.id.applyNow);
        saveimg=findViewById(R.id.saveimg);


        Bundle extras = getIntent().getExtras();

        String jobTitle,employer,location,vacancy,salary,jbResponsiblity,deadLine,eduQualification;
        jobTitle= extras.getString("jobTitle");
        employer=extras.getString("employer");
        location=extras.getString("location");
        vacancy=extras.getString("vacancy");
        salary=extras.getString("salary");
        jbResponsiblity=extras.getString("jbResponsiblity");
        deadLine=extras.getString("deadLine");

        eduQualification=extras.getString("educationalQualification");

        jbttl.setText(jobTitle);
        emp.setText(employer);
        salarydt.setText(salary);
        ddln.setText(deadLine);
        edqual.setText(eduQualification);
        locationdt.setText(location);
        vacancydt.setText(vacancy);
        jbResponsiblitydt.setText(jbResponsiblity);



        aplyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(),Resume_Detail.class);
                intent.putExtra("button_visible",true);
                startActivity(intent);
            }
        });


        
        






    }


    public void save(View view){

        if(i==0)
        {
            i=1;
            for (Drawable drawable : saveimg.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(saveimg.getContext(), R.color.gold), PorterDuff.Mode.SRC_IN));
                }
            }

        }
        else{
            i=0;
            for (Drawable drawable : saveimg.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(saveimg.getContext(), R.color.grey), PorterDuff.Mode.SRC_IN));
                }
            }

        }



    }
}