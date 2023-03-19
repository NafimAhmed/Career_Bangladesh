package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Employer_ViewJobDetail_page extends AppCompatActivity {

    RadioGroup radioGroup;
    ArrayList<String> buttonNames;
    Button allApp;
    TextView numb_CV,jbdsc,jbttl,emp,ddln,edqual,jopPostingDate,locationDetail,vacancyDetail,SalaryDetail,jbResponsiblity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_view_job_detail_page);

        ////////////////////////////////////////

       // radioActiveGroup =findViewById(R.id.radio_active_group);

        radioGroup = findViewById(R.id.radioGroup);
        allApp=findViewById(R.id.allApp);

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




        allApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i=new Intent(getApplicationContext(),Application_list.class);

                startActivity(i);
            }
        });






        ////////////////////////////////


        getSupportActionBar().setTitle("Pervious Job Detail");


        jbttl=findViewById(R.id.jobTitleDetail);
        emp=findViewById(R.id.employerDetail);
        ddln=findViewById(R.id.deadlineDetail);
        jbdsc=findViewById(R.id.jbdsc);

        edqual=findViewById(R.id.educationalQualificationDetail);
        locationDetail=findViewById(R.id.locationDetail);
        vacancyDetail=findViewById(R.id.vacancyDetail);
        SalaryDetail=findViewById(R.id.SalaryDetail);
        jbResponsiblity=findViewById(R.id.jbResponsiblity);
        jopPostingDate=findViewById(R.id.jopPostingDate);
        numb_CV=findViewById(R.id.numb_CV);




        Bundle extras = getIntent().getExtras();

        String jobTitle,employer,postingDate,jbdisc,deadLine,eduQualification,vacancy,location,salary,jobResp,cvnmb;
        jobTitle= extras.getString("jobTitle");
        employer=extras.getString("employer");
        deadLine=extras.getString("deadLine");
        vacancy= extras.getString("vacancy");
        jbdisc=extras.getString("jbdesc");
        location=extras.getString("location");
        cvnmb=extras.getString("numb_cv");
        postingDate=extras.getString("postingDate");


        salary=extras.getString("salary");
        jobResp=extras.getString("jobResponsiblity");
        eduQualification=extras.getString("educationalQualification");
        jbttl.setText(jobTitle);
        jopPostingDate.setText(postingDate);
        emp.setText(employer);
        ddln.setText(deadLine);
        edqual.setText(eduQualification);
        locationDetail.setText(location);
        vacancyDetail.setText(vacancy);
        SalaryDetail.setText(salary);
        numb_CV.setText(cvnmb);

        jbResponsiblity.setText(jobResp);
        jbdsc.setText(jbdisc);






    }
}