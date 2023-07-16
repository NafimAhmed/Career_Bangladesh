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

public class Exp_profile extends AppCompatActivity {

    EditText CompanyOneName,jbLocationTwo,jbExpertiesTwo,jbResponsiblityTwo,resigningDateTwo,JoiningDateTwo,CompanyTwoDepartment,CompanyTwoDesignetion,copanyTwoBusiness,CompanyTwoName,jbLocationOne,jbExpertiesOne,copanyOneBusiness,CompanyOneDesignetion,jbResponsiblityOne,resigningDateOne,CompanyOneDepartment,JoiningDateOne;

    Button addexp;//


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exp_profile);



        CompanyOneName=findViewById(R.id.CompanyOneName);
        copanyOneBusiness=findViewById(R.id.copanyOneBusiness);
        CompanyOneDesignetion=findViewById(R.id.CompanyOneDesignetion);
        CompanyOneDepartment=findViewById(R.id.CompanyOneDepartment);
        JoiningDateOne=findViewById(R.id.JoiningDateOne);
        resigningDateOne=findViewById(R.id.resigningDateOne);
        jbResponsiblityOne=findViewById(R.id.jbResponsiblityOne);
        jbExpertiesOne=findViewById(R.id.jbExpertiesOne);
        jbLocationOne=findViewById(R.id.jbLocationOne);
        CompanyTwoName=findViewById(R.id.CompanyTwoName);
        copanyTwoBusiness=findViewById(R.id.copanyTwoBusiness);
        CompanyTwoDesignetion=findViewById(R.id.CompanyTwoDesignetion);
        CompanyTwoDepartment=findViewById(R.id.CompanyTwoDepartment);
        JoiningDateTwo=findViewById(R.id.JoiningDateTwo);
        resigningDateTwo=findViewById(R.id.resigningDateTwo);
        jbResponsiblityTwo=findViewById(R.id.jbResponsiblityTwo);
        jbExpertiesTwo=findViewById(R.id.jbExpertiesTwo);
        jbLocationTwo=findViewById(R.id.jbLocationTwo);

        addexp=findViewById(R.id.addexp);




        ////////////////////////////////////////////


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersExpriences/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderSavedJob jsonPlaceHolderprofile=retrofit.create(JsonPlaceHolderSavedJob.class);

        Call<Job_Seeker_Exp_Detail> call= jsonPlaceHolderprofile.getJobseekerExpDetail("shamim@gmail.com");

        call.enqueue(new Callback<Job_Seeker_Exp_Detail>() {
            @Override
            public void onResponse(Call<Job_Seeker_Exp_Detail> call, Response<Job_Seeker_Exp_Detail> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    Job_Seeker_Exp_Detail job_seeker_exp_detail=response.body();




                    CompanyOneName.setText(job_seeker_exp_detail.getExpOneCompanayName());
                    copanyOneBusiness.setText(job_seeker_exp_detail.getExpOneCompanayBusiness());
                    CompanyOneDesignetion.setText(job_seeker_exp_detail.getExpOneDesignation());
                    CompanyOneDepartment.setText(job_seeker_exp_detail.getExpOneDepartment());
                    JoiningDateOne.setText(job_seeker_exp_detail.getExpOneFrom());
                    resigningDateOne.setText(job_seeker_exp_detail.getExpOneTo());
                    jbResponsiblityOne.setText(job_seeker_exp_detail.getExprOneResp());
                    jbExpertiesOne.setText(job_seeker_exp_detail.getExprOneExpertise());
                    jbLocationOne.setText(job_seeker_exp_detail.getExprCompOneAddress());
                    CompanyTwoName.setText(job_seeker_exp_detail.getExpTwoCompanayName());
                    copanyTwoBusiness.setText(job_seeker_exp_detail.getExpTwoCompanayBusiness());
                    CompanyOneDesignetion.setText(job_seeker_exp_detail.getExpTwoDesignation());
                    CompanyOneDepartment.setText(job_seeker_exp_detail.getExpOneDepartment());
                    JoiningDateOne.setText(job_seeker_exp_detail.getExpTwoFrom());
                    resigningDateTwo.setText(job_seeker_exp_detail.getExpTwoTo());
                    jbResponsiblityTwo.setText(job_seeker_exp_detail.getExprTwoResp());
                    jbExpertiesTwo.setText(job_seeker_exp_detail.getExprTwoExpertise());
                    jbLocationTwo.setText(job_seeker_exp_detail.getExprCompTwoAddress());



                    //String name1=usersPersonal.getName();
//                    edulevelOne.setText(jobseeker_edu_detail.getExamTitleOne());
//                    eduMajorSpinnerOne.setText(jobseeker_edu_detail.getMajorOne());
//                    eduInstituteOne.setText(jobseeker_edu_detail.getInstituteOne());
//                    eduPassingYearOne.setText(jobseeker_edu_detail.getPassYearOne());
//                    eduResultOne.setText(jobseeker_edu_detail.getResultOne());
//                    edulevelTwo.setText(jobseeker_edu_detail.getExamTitleTwo());
//                    eduMajorTwoSpinner.setText(jobseeker_edu_detail.getMajorTwo());
//                    eduInstituteTwo.setText(jobseeker_edu_detail.getInstituteTwo());
//                    PassingYearTwo.setText(jobseeker_edu_detail.getPassYearTwo());
//                    eduResultTwo.setText(jobseeker_edu_detail.getResultTwo());
//                    edulevelThree.setText(jobseeker_edu_detail.getExamTitleThree());
//                    eduMajorSpinnerThree.setText(jobseeker_edu_detail.getMajorThree());
//                    eduInstituteThree.setText(jobseeker_edu_detail.getInstituteThree());
//                    PassingYearThree.setText(jobseeker_edu_detail.getPassYearThree());
//                    eduResultThree.setText(jobseeker_edu_detail.getResultThree());
//                    edulevelTFour.setText(jobseeker_edu_detail.getExamTitleFour());
//                    eduMajorTwoSpinnerFour.setText(jobseeker_edu_detail.getMajorFour());
//                    eduInstituteFour.setText(jobseeker_edu_detail.getInstituteFour());
//                    PassingyearFour.setText(jobseeker_edu_detail.getPassYearFour());
//                    eduResultFour.setText(jobseeker_edu_detail.getResultFour());
//

//



                    // Log.e("TAG",posts.get(position).jobID);


                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Job_Seeker_Exp_Detail> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();

                Log.e("TAG",t.getMessage());

            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();




        ////////////////////////////////////////////





        addexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),training.class);
                startActivity(intent);
            }
        });


    }
}