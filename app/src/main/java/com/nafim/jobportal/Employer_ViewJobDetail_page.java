package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.Gravity;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Employer_ViewJobDetail_page extends AppCompatActivity {

    RadioGroup radioGroup;
    ArrayList<String> buttonNames;
    TextView jbttl,emp,ddln,edqual,locationDetail,vacancyDetail,SalaryDetail,jbResponsiblity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_view_job_detail_page);

        ////////////////////////////////////////

       // radioActiveGroup =findViewById(R.id.radio_active_group);

        radioGroup = findViewById(R.id.radioGroup);

        radioGroup.check(R.id.javaRB);


        // on below line we are adding check change listener for our radio group.
        radioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {

                // on below line we are getting radio button from our group.
                RadioButton radioButton = findViewById(checkedId);

                // on below line we are displaying a toast message.
                Toast.makeText(Employer_ViewJobDetail_page.this, "Selected Radio Button is : " + radioButton.getText(), Toast.LENGTH_SHORT).show();
            }
        });






        ////////////////////////////////


        getSupportActionBar().setTitle("Pervious Job Detail");

        jbttl=findViewById(R.id.jobTitleDetail);
        emp=findViewById(R.id.employerDetail);
        ddln=findViewById(R.id.deadlineDetail);
        edqual=findViewById(R.id.educationalQualificationDetail);
        locationDetail=findViewById(R.id.locationDetail);
        vacancyDetail=findViewById(R.id.vacancyDetail);
        SalaryDetail=findViewById(R.id.SalaryDetail);
        jbResponsiblity=findViewById(R.id.jbResponsiblity);




        Bundle extras = getIntent().getExtras();

        String jobTitle,employer,deadLine,eduQualification,vacancy,location,salary,jobResp;
        jobTitle= extras.getString("jobTitle");
        employer=extras.getString("employer");
        deadLine=extras.getString("deadLine");
        vacancy= extras.getString("vacancy");
        location=extras.getString("location");
        salary=extras.getString("salary");
        jobResp=extras.getString("jobResponsiblity");
        eduQualification=extras.getString("educationalQualification");
        jbttl.setText(jobTitle);
        emp.setText(employer);
        ddln.setText(deadLine);
        edqual.setText(eduQualification);
        locationDetail.setText(location);
        vacancyDetail.setText(vacancy);
        SalaryDetail.setText(salary);
        jbResponsiblity.setText(jobResp);




    }
}