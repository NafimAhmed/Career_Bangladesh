package com.careers.app;

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
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Job_Detail extends AppCompatActivity {

    TextView jbttl,emp,jobDescriptionDetail,ddln,edqual,locationdt,vacancydt,salarydt,jbResponsiblitydt,saveimg;
    Button aplyNow;
    ImageView companyLogo;
    String jobTitle,JobseekerName,employer,jbDesription,location,vacancy,salary,jbResponsiblity,deadLine,eduQualification;

    int i=0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_job_detail);

        companyLogo=findViewById(R.id.companyLogo);

        //saveimg=findViewById(R.id.saveimg);

//////////////////////////////////////////////////////////////////////

        /////Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com

        String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();

        //String email="salam@gmail.com";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersPersonal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderemp=retrofit.create(JsonPlaceHolderAPI.class);

        Call<jovSeekerDetail> call= jsonPlaceHolderemp.getjobSeekerDetail(email);

        call.enqueue(new Callback<jovSeekerDetail>() {
            @Override
            public void onResponse(Call<jovSeekerDetail> call, Response<jovSeekerDetail> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    jovSeekerDetail jovSeekerDetail=response.body();

                    JobseekerName=jovSeekerDetail.getName();

//                    name.setText(jovSeekerDetail.getName());
//                    address.setText(jovSeekerDetail.getPresentAddress()+", "+jovSeekerDetail.getPresentAddressLine2());
//                    phone_number.setText(jovSeekerDetail.getPhone());
//                    Email.setText(jovSeekerDetail.getEmail());
//                    fathername.setText(jovSeekerDetail.getFathersName());
//                    motherame.setText(jovSeekerDetail.getMothersName());
//                    NID_number.setText(jovSeekerDetail.getNationalID());
//                    relagion.setText(jovSeekerDetail.getReligion());
//                    Picasso.get().load(jovSeekerDetail.getImage()).into(jobSeekerImage);
//                    maritalstat.setText(jovSeekerDetail.getMaritalStatus());
//                    gender.setText(jovSeekerDetail.getGender());
//                    DOB.setText(jovSeekerDetail.getBirthDate());
//                    careerObjective.setText(jovSeekerDetail.getCareerObjective());
//                    permanentAddress.setText(jovSeekerDetail.getPermanentAddress()+", "+jovSeekerDetail.getPermanentAddressLine2());



                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<jovSeekerDetail> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();







        ////Data retrive//////////////////////////////////////////





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


        saveimg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                save();
            }
        });




        Bundle extras = getIntent().getExtras();


        jobTitle= extras.getString("jobTitle");
        employer=extras.getString("employer");
        location=extras.getString("location");
        vacancy=extras.getString("vacancy");
        salary=extras.getString("salary");
        jbDesription=extras.getString("jobDescription");
        jbResponsiblity=extras.getString("jbResponsiblity");
        deadLine=extras.getString("deadLine");
        String img=extras.getString("img");
        String jobId=extras.getString("id");
        String JobCatagory=extras.getString("JobCatagory");
        String PosterEmail=extras.getString("PosterEmail");

        Toast.makeText(getApplicationContext(),"Job ID : "+jobId,Toast.LENGTH_SHORT).show();

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


        String em= FirebaseAuth.getInstance().getCurrentUser().getEmail();


        aplyNow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Intent intent = new Intent(getApplicationContext(),Resume_Detail.class);
//                intent.putExtra("button_visible",true);
                Intent intent=new Intent(getApplicationContext(),Confirm_Apply_page.class);
                intent.putExtra("jobid",jobId);
                intent.putExtra("ApplicantEmail",em);
                intent.putExtra("JobTitle",jobTitle);
                intent.putExtra("organization",employer);
                intent.putExtra("PosterEmail",PosterEmail);
                intent.putExtra("JobCatagory",JobCatagory);
                intent.putExtra("JobseekerName",JobseekerName);
                startActivity(intent);
            }
        });


        
        






    }


    public void save(){

        if(i==0)
        {
            i=1;
            for (Drawable drawable : saveimg.getCompoundDrawables()) {
                if (drawable != null) {
                    drawable.setColorFilter(new PorterDuffColorFilter(ContextCompat.getColor(saveimg.getContext(), R.color.gold), PorterDuff.Mode.SRC_IN));
                }
            }


            SaveAJob();



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



    public void SaveAJob()
    {

        Saved_Job_post saved_job_post=new Saved_Job_post("6419654c0dd5022450231606",
                "salam@gmail.com",
                "Jahid hasan",
                "63e9c2b49ff0b29304ec7c32",
                "IT Manager",
                "https://i.ibb.co/7zt3BBv/talktalkbdltd.png",
                "Government",
                "Whole Bangladesh",
                "Whole Bangladesh",
                "100",
                "MSC  in CSE",
                "2 years",
                "2023-03-21",
                "2023-04-30",
                "Apply Online",
                "Full Time",
                "Arise awaken and stop not till the goal reached. Arise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reached",
                "Mid",
                "Hybrid",
                "Arise awaken and stop not till the goal reached. Arise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reached",
                "Arise awaken and stop not till the goal reached. Arise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reached",
                "60000",
                "80000",
                "3",
                "1",
                "Arise awaken and stop not till the goal reached. Arise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reachedArise awaken and stop not till the goal reached",
                null,
                "Active"
                );

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderSavedJob jsonPlaceHolderSavedJob=retrofit.create(JsonPlaceHolderSavedJob.class);


        Call<Saved_Job_post> call= jsonPlaceHolderSavedJob.savedJob(saved_job_post);

        call.enqueue(new Callback<Saved_Job_post>() {
            @Override
            public void onResponse(Call<Saved_Job_post> call, Response<Saved_Job_post> response) {
                Toast.makeText(getApplicationContext(), "Resp code : "+response.code()+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Saved_Job_post> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "error"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });

    }








}