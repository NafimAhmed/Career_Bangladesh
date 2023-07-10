package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;

import android.util.DisplayMetrics;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Resume_Detail extends AppCompatActivity {




    Button editButton;

    ImageView jobSeekerImage;

    TextView address,permanentAddress,academicHistory,EmploymentHistory,maritalstat,careerObjective,DOB,phone_number,gender,Email,relagion,fathername,motherame,NID_number,name;

    LinearLayout linearLayout;
    boolean button=true;

    FloatingActionButton btnFloating;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resume_detail);

        getSupportActionBar().setTitle("Resume Detail");

        Bundle extras = getIntent().getExtras();
        button=extras.getBoolean("button_visible");

        editButton = findViewById(R.id.apply);

        if (button){

            editButton.setVisibility(View.VISIBLE);

        }else{
            editButton.setVisibility(View.GONE);
        }


        address=findViewById(R.id.address);
        phone_number=findViewById(R.id.phone_number);
        fathername=findViewById(R.id.fathername);
        Email=findViewById(R.id.email);
        motherame=findViewById(R.id.motherame);
        NID_number=findViewById(R.id.NID_number);
        name=findViewById(R.id.name);
        relagion=findViewById(R.id.relagion);
        jobSeekerImage=findViewById(R.id.jobSeekerImage);
        gender=findViewById(R.id.gender);
        maritalstat=findViewById(R.id.maritalstat);
        DOB=findViewById(R.id.DOB);
        careerObjective=findViewById(R.id.careerObjective);
        permanentAddress=findViewById(R.id.permanentAddress);
        EmploymentHistory=findViewById(R.id.EmploymentHistory);
        academicHistory=findViewById(R.id.academicHistory);





        ///////////////////////////////////


        btnFloating=findViewById(R.id.addJob);
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),Profile_page2.class);
                startActivity(intent);




            }
        });


        //////////////////////////////////

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

                    name.setText(jovSeekerDetail.getName());
                    address.setText(jovSeekerDetail.getPresentAddress()+", "+jovSeekerDetail.getPresentAddressLine2());
                    phone_number.setText(jovSeekerDetail.getPhone());
                    Email.setText(jovSeekerDetail.getEmail());
                    fathername.setText(jovSeekerDetail.getFathersName());
                    motherame.setText(jovSeekerDetail.getMothersName());
                    NID_number.setText(jovSeekerDetail.getNationalID());
                    relagion.setText(jovSeekerDetail.getReligion());
                    Picasso.get().load(jovSeekerDetail.getImage()).into(jobSeekerImage);
                    maritalstat.setText(jovSeekerDetail.getMaritalStatus());
                    gender.setText(jovSeekerDetail.getGender());
                    DOB.setText(jovSeekerDetail.getBirthDate());
                    careerObjective.setText(jovSeekerDetail.getCareerObjective());
                    permanentAddress.setText(jovSeekerDetail.getPermanentAddress()+", "+jovSeekerDetail.getPermanentAddressLine2());



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



        /////Exp Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com

        //String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();

        //String email="salam@gmail.com";
        Retrofit retrofitexp=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersExpriences/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderexp=retrofitexp.create(JsonPlaceHolderAPI.class);

        Call<jovSeekerExpDetail> callexp= jsonPlaceHolderexp.getjobSeekerExpDetail(email);

        callexp.enqueue(new Callback<jovSeekerExpDetail>() {
            @Override
            public void onResponse(Call<jovSeekerExpDetail> call, Response<jovSeekerExpDetail> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    jovSeekerExpDetail jovSeekerExpDetail=response.body();

                    EmploymentHistory.setText(jovSeekerExpDetail.getExpOneCompanayName()+"\n Address : "+
                                    jovSeekerExpDetail.getExprCompOneAddress()+"\n Department : "+
                            jovSeekerExpDetail.getExpOneDepartment()+"\n position : "+
                            jovSeekerExpDetail.getExpOneDesignation()+
                            "\n From :"+
                            jovSeekerExpDetail.getExpOneFrom()+"\n To : "+
                            jovSeekerExpDetail.getExpOneTo()
                            );





                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<jovSeekerExpDetail> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();







        ////Data retrive//////////////////////////////////////////



        //String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();

        //String email="salam@gmail.com";
        Retrofit retrofitedu=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersAcademics/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderEdu=retrofitedu.create(JsonPlaceHolderAPI.class);

        Call<JovSeekerEdu> calledu= jsonPlaceHolderEdu.getjobSeekerEduDetail(email);

        calledu.enqueue(new Callback<JovSeekerEdu>() {
            @Override
            public void onResponse(Call<JovSeekerEdu> call, Response<JovSeekerEdu> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    JovSeekerEdu jovSeekerEdu=response.body();

                    academicHistory.setText(jovSeekerEdu.getExamTitleFour()+" "+jovSeekerEdu.getMajorFour()+" "+jovSeekerEdu.getInstituteFour()+"\n"+
                            jovSeekerEdu.getExamTitleThree()+" "+jovSeekerEdu.getMajorThree()+" "+jovSeekerEdu.getInstituteThree()+"\n"+
                            jovSeekerEdu.getExamTitleTwo()+" "+jovSeekerEdu.getMajorTwo()+" "+jovSeekerEdu.getInstituteTwo()+"\n"+
                            jovSeekerEdu.getExamTitleOne()+" "+jovSeekerEdu.getMajorOne()+" "+jovSeekerEdu.getInstituteOne()
                    );

//                    EmploymentHistory.setText(jovSeekerExpDetail.getExpOneCompanayName()+"\n Address : "+
//                            jovSeekerExpDetail.getExprCompOneAddress()+"\n Department : "+
//                            jovSeekerExpDetail.getExpOneDepartment()+"\n position : "+
//                            jovSeekerExpDetail.getExpOneDesignation()+
//                            "\n From :"+
//                            jovSeekerExpDetail.getExpOneFrom()+"\n To : "+
//                            jovSeekerExpDetail.getExpOneTo()
//                    );







                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<JovSeekerEdu> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();







        ////Data retrive//////////////////////////////////////////






        ///////////////////////////////








        editButton.setOnClickListener(new View.OnClickListener(

        ) {
            @Override
            public void onClick(View v) {

                Intent intent=new Intent(getApplicationContext(),Confirm_Apply_page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"unavailable",Toast.LENGTH_SHORT).show();
                finish();

            }
        });






    }
}