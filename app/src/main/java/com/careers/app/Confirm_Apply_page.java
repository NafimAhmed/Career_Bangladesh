package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Confirm_Apply_page extends AppCompatActivity {

    Button btn_apply_ok;
    EditText ExpectedSalary;
    TextView condition;
    CheckBox checkbox_condition;
    String jobId,JobseekerName,PosterEmail,JobCatagory,ApplicantEmail,JobTitle, organization;

    String cond="Terms and Condition : Careers Bangladesh শুধুমাত্রই নিয়োগকর্তা এবং চাকরিপ্রার্থীদের মাঝে যোগাযোগ মাধ্যম হিসেবে কাজ করে। Careers Bangladesh ওয়েবসাইটের মাধ্যমে চাকরিতে আবেদন করার পর কোম্পানি যদি আপনার সাথে কোনো আর্থিক লেনদেন অথবা অনিয়ম/প্রতারণা করে তার জন্য Careers Bangladesh লিমিটেড দায়ী থাকবে না।";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_apply_page);

        checkbox_condition=findViewById(R.id.checkbox_condition);
        btn_apply_ok=findViewById(R.id.btn_apply_ok);

        checkbox_condition.setTextSize(17);
        condition=findViewById(R.id.condition);

        ExpectedSalary=findViewById(R.id.ExpectedSalary);


        condition.setText(cond);

        Bundle extras = getIntent().getExtras();

         jobId=extras.getString("jobid");
         ApplicantEmail=extras.getString("ApplicantEmail");
         JobTitle=extras.getString("JobTitle");
         organization =extras.getString("organization");
        JobCatagory=extras.getString("JobCatagory");
        PosterEmail=extras.getString("PosterEmail");
        JobseekerName=extras.getString("JobseekerName");



        Toast.makeText(getApplicationContext(),"Job ID : "+jobId,Toast.LENGTH_SHORT).show();


        checkbox_condition.isChecked();

        btn_apply_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkbox_condition.isChecked()){







                    JobApply();

                    checkbox_condition.setTextColor(Color.parseColor("#FF000000"));
                    Intent intent=new Intent(getApplicationContext(),Apply_done_page.class);
                    startActivity(intent);
                    finish();

                }else{

                    checkbox_condition.requestFocus();
                   // checkbox_condition.setBackgroundColor(Color.parseColor("#ff0006"));
                    //checkbox_condition.setTextScaleX(1);
                    checkbox_condition.setTextColor(Color.parseColor("#ff0006"));

                    Toast.makeText(Confirm_Apply_page.this, "Please check out the term and condition", Toast.LENGTH_SHORT).show();

                }



            }
        });



    }


    public void JobApply(){


        Apply_Job apply_job=new Apply_Job(
                jobId,
                ApplicantEmail,
                JobseekerName,
                PosterEmail,
                ExpectedSalary.getText().toString(),
                JobTitle,
                organization,
                JobCatagory,
                getDateTime()
        );

        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI=retrofit.create(JsonPlaceHolderAPI.class);


        Call<Apply_Job> call= jsonPlaceHolderAPI.ApplyAJob(apply_job);

        call.enqueue(new Callback<Apply_Job>() {
            @Override
            public void onResponse(Call<Apply_Job> call, Response<Apply_Job> response) {
                Toast.makeText(getApplicationContext(), "Resp code : "+response.code()+response.body(), Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Apply_Job> call, Throwable t) {

                Toast.makeText(getApplicationContext(), "error"+t.getMessage(), Toast.LENGTH_SHORT).show();

            }
        });






    }


    public String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        Date date = new Date();
        return dateFormat.format(date);
    }



}