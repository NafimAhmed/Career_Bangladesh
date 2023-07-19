package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Education_Profile extends AppCompatActivity {


    Button addedu;

    EditText edulevelOne,eduMajorTwoSpinner,eduResultFour,eduResultTypeSpinnerFour,eduInstituteFour,PassingyearFour,eduMajorTwoSpinnerFour,edulevelTFour,eduResultThree,eduResultTypeSpinnerThree
            ,PassingYearThree,eduInstituteThree,eduMajorSpinnerThree,edulevelThree,eduResultTwo,
            eduResultTypeSpinnerTwo,PassingYearTwo,eduInstituteTwo,edulevelTwo,eduResultOne,eduPassingYearOne,
            eduInstituteOne,eduMajorSpinnerOne;
    String emailjobSeeker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_education_profile);




        edulevelOne=findViewById(R.id.edulevelOne);
        eduMajorSpinnerOne=findViewById(R.id.eduMajorSpinnerOne);
        eduInstituteOne=findViewById(R.id.eduInstituteOne);
        eduPassingYearOne=findViewById(R.id.eduPassingYearOne);
        eduResultOne=findViewById(R.id.eduResultOne);
        edulevelTwo=findViewById(R.id.edulevelTwo);
        eduInstituteTwo=findViewById(R.id.eduInstituteTwo);
        PassingYearTwo=findViewById(R.id.PassingYearTwo);
        eduResultTypeSpinnerTwo=findViewById(R.id.eduResultTypeSpinnerTwo);
        eduResultTwo=findViewById(R.id.eduResultTwo);
        edulevelThree=findViewById(R.id.edulevelThree);
        eduMajorSpinnerThree=findViewById(R.id.eduMajorSpinnerThree);
        eduInstituteThree=findViewById(R.id.eduInstituteThree);
        PassingYearThree=findViewById(R.id.PassingYearThree);
        eduResultTypeSpinnerThree=findViewById(R.id.eduResultTypeSpinnerThree);
        eduResultThree=findViewById(R.id.eduResultThree);
        edulevelTFour=findViewById(R.id.edulevelTFour);
        eduMajorTwoSpinnerFour=findViewById(R.id.eduMajorTwoSpinnerFour);
        eduInstituteFour=findViewById(R.id.eduInstituteFour);
        PassingyearFour=findViewById(R.id.PassingyearFour);
        eduResultTypeSpinnerFour=findViewById(R.id.eduResultTypeSpinnerFour);
        eduResultFour=findViewById(R.id.eduResultFour);
        eduMajorTwoSpinner=findViewById(R.id.eduMajorTwoSpinner);



        Bundle extras = getIntent().getExtras();
        emailjobSeeker= extras.getString("Email");












        ////////////////////////////////////////////


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobseekersAcademics/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderSavedJob jsonPlaceHolderprofile=retrofit.create(JsonPlaceHolderSavedJob.class);

        Call<Jobseeker_Edu_Detail> call= jsonPlaceHolderprofile.getJobseekerEduDetail(emailjobSeeker);

        call.enqueue(new Callback<Jobseeker_Edu_Detail>() {
            @Override
            public void onResponse(Call<Jobseeker_Edu_Detail> call, Response<Jobseeker_Edu_Detail> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    Jobseeker_Edu_Detail jobseeker_edu_detail=response.body();

                    //String name1=usersPersonal.getName();
                    edulevelOne.setText(jobseeker_edu_detail.getExamTitleOne());
                    eduMajorSpinnerOne.setText(jobseeker_edu_detail.getMajorOne());
                    eduInstituteOne.setText(jobseeker_edu_detail.getInstituteOne());
                    eduPassingYearOne.setText(jobseeker_edu_detail.getPassYearOne());
                    eduResultOne.setText(jobseeker_edu_detail.getResultOne());
                    edulevelTwo.setText(jobseeker_edu_detail.getExamTitleTwo());
                    eduMajorTwoSpinner.setText(jobseeker_edu_detail.getMajorTwo());
                    eduInstituteTwo.setText(jobseeker_edu_detail.getInstituteTwo());
                    PassingYearTwo.setText(jobseeker_edu_detail.getPassYearTwo());
                    eduResultTwo.setText(jobseeker_edu_detail.getResultTwo());
                    edulevelThree.setText(jobseeker_edu_detail.getExamTitleThree());
                    eduMajorSpinnerThree.setText(jobseeker_edu_detail.getMajorThree());
                    eduInstituteThree.setText(jobseeker_edu_detail.getInstituteThree());
                    PassingYearThree.setText(jobseeker_edu_detail.getPassYearThree());
                    eduResultThree.setText(jobseeker_edu_detail.getResultThree());
                    edulevelTFour.setText(jobseeker_edu_detail.getExamTitleFour());
                    eduMajorTwoSpinnerFour.setText(jobseeker_edu_detail.getMajorFour());
                    eduInstituteFour.setText(jobseeker_edu_detail.getInstituteFour());
                    PassingyearFour.setText(jobseeker_edu_detail.getPassYearFour());
                    eduResultFour.setText(jobseeker_edu_detail.getResultFour());


//                    name.setText(.getName());
//                    NID_NO.setText(usersPersonal.nationalID);
//                    fatherName.setText(usersPersonal.getFathersName());
//                    mothersName.setText(usersPersonal.getMothersName());
//                    Nationality.setText(usersPersonal.getNationality());
//                    MaritalStatus.setText(usersPersonal.getMaritalStatus());
//                    gender.setText(usersPersonal.getGender());
//                    Religion.setText(usersPersonal.getReligion());
//                    phone_number.setText(usersPersonal.getPhone());
//                    email.setText(usersPersonal.getEmail());
//                    //PassportNo.setText(usersPersonal.nationalID);
//                    CareerObj.setText(usersPersonal.getCareerObjective());
//                    permanentAddress.setText(usersPersonal.getPermanentAddress());
//                    presentAddress.setText(usersPersonal.getPresentAddress());




                    // Log.e("TAG",posts.get(position).jobID);


                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Jobseeker_Edu_Detail> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();

                Log.e("TAG",t.getMessage());

            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();




        ////////////////////////////////////////////
















        addedu=findViewById(R.id.addedu);

        addedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Exp_profile.class);
                intent.putExtra("Email",emailjobSeeker);
                startActivity(intent);
            }
        });
    }
}