package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.content.ContextCompat;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

public class Job_Detail extends AppCompatActivity {

    TextView jbttl,emp,jobDescriptionDetail,ddln,edqual,locationdt,vacancydt,salarydt,jbResponsiblitydt,saveimg;
    Button aplyNow;
    ImageView companyLogo;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        companyLogo=findViewById(R.id.companyLogo);

        //saveimg=findViewById(R.id.saveimg);

//////////////////////////////////////////////////////////////////////




        //////////////////////////////////////////////////


        


        
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

        jobDescriptionDetail=findViewById(R.id.jobDescriptionDetail);




        Bundle extras = getIntent().getExtras();

        String jobTitle,employer,jbDesription,location,vacancy,salary,jbResponsiblity,deadLine,eduQualification;
        jobTitle= extras.getString("jobTitle");
        employer=extras.getString("employer");
        location=extras.getString("location");
        vacancy=extras.getString("vacancy");
        salary=extras.getString("salary");
        jbDesription=extras.getString("jobDescription");
        jbResponsiblity=extras.getString("jbResponsiblity");
        deadLine=extras.getString("deadLine");
        String img=extras.getString("img");

        eduQualification=extras.getString("educationalQualification");

        jbttl.setText(jobTitle);
        emp.setText(employer);
        salarydt.setText(salary);
        ddln.setText(deadLine);
        edqual.setText(eduQualification);
        locationdt.setText(location);
        vacancydt.setText(vacancy);
        jbResponsiblitydt.setText(jbResponsiblity);
        jobDescriptionDetail.setText(jbDesription);


        Glide.with(this).load(img).into(companyLogo);




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