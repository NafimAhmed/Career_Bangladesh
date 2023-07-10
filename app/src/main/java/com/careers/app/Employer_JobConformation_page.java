package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.google.firebase.auth.FirebaseAuth;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Employer_JobConformation_page extends AppCompatActivity {

    TextView jobTitleDetail,jbdesc,JobResponsiblity,jobType,locationDetail,employerDetail,vacancyDetail,SalaryDetail,deadlineDetail,educationalQualificationDetail;

    String em= FirebaseAuth.getInstance().getCurrentUser().getEmail();
    Button btnPost;
    String jobTitle,CompanyLogao,empjobLevel,BusinesDesciption,JobContext,workPlace,SalaryReview,Others,Salaryto,yearlyBonus,CompanySize,PostDate,Experience,OrganizationName,organizationType,jobtype,empJobdescription,empjobvacancy,jobLocation,employer,eduQualification,empJobResponsiblity,Salary,deadline;
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
                PostAJob();
                Intent intent=new Intent(getApplicationContext(),Done_page.class);
                startActivity(intent);
            }
        });







        Bundle extras = getIntent().getExtras();


        jobTitle= extras.getString("jobTitle");
        jobtype=extras.getString("jobType");
        employer=extras.getString("employerName");
        empJobdescription=extras.getString("empJobdescription");
        eduQualification=extras.getString("emp_educationalQualification");
        empJobResponsiblity= extras.getString("empJobResponsiblity");
        empjobvacancy=extras.getString("empjobvacancy");
        jobLocation=extras.getString("empjobLocation");
        Salary=extras.getString("Salary");
        CompanyLogao=extras.getString("CompanyLogao");
        deadline= extras.getString("deadline");
        OrganizationName=extras.getString("OrganizationName");
        organizationType=extras.getString("organizationType");
        PostDate=extras.getString("PostDate");
        Experience=extras.getString("Experience");
        CompanySize=extras.getString("CompanySize");
        Salaryto=extras.getString("Salaryto");
        yearlyBonus=extras.getString("yearlyBonus");
        Others=extras.getString("Others");
        workPlace=extras.getString("workPlace");
        SalaryReview=extras.getString("SalaryReview");
        JobContext=extras.getString("JobContext");
        BusinesDesciption=extras.getString("BusinesDesciption");
        empjobLevel=extras.getString("empjobLevel");


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

    public void PostAJob(){


        Post_job post_job=new Post_job(
                em,
                employer,
                jobtype,
                jobTitle,
                CompanyLogao,//"https://i.ibb.co/qBS164d/gbl-logo.png",//"https://i.ibb.co/7zt3BBv/talktalkbdltd.png",
                OrganizationName,
                organizationType,
                jobLocation,
                empjobvacancy,
                eduQualification,
                Experience,
                CompanySize,
                PostDate,
                deadline,
                "ApplyOnline",
                "0",
                BusinesDesciption,
                empjobLevel,
                workPlace,
                JobContext,
                empJobResponsiblity,
                Salary,
                Salaryto,
                yearlyBonus,
                SalaryReview,
                "Active",
                Others


        );
//        Apply_Job apply_job=new Apply_Job(
//                jobId,
//                ApplicantEmail,
//                "fim",
//                "jahid@gmail.com",
//                "100000",
//                JobTitle,
//                organization,
//                "HR/Org. Development",
//                "2023-03-13"
//        );

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI=retrofit.create(JsonPlaceHolderAPI.class);


        Call<Post_job> call= jsonPlaceHolderAPI.PostAJob(post_job);

        call.enqueue(new Callback<Post_job>() {
            @Override
            public void onResponse(Call<Post_job> call, Response<Post_job> response) {
                Toast.makeText(getApplicationContext(), "Resp code : "+response.code()+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Post_job> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "error"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });








    }



}