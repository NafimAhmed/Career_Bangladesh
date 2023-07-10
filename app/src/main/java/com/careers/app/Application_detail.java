package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.auth.FirebaseAuth;
import com.squareup.picasso.Picasso;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Application_detail extends AppCompatActivity {

    Button editButton;

    ImageView jobSeekerImage;
    String nam,phn,adrs,em;

    LinearLayout linearLayout;
    TextView Email,academicHistory,EmploymentHistory,DOB,permanentAddress,careerObjective,name,address,gender,relagion,NID_number,motherame,fathername,maritalstat,phone_number;


    ExtendedFloatingActionButton btnFloating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_detail);



        Bundle extras = getIntent().getExtras();
        String emil=extras.getString("Email");
        name=findViewById(R.id.name);
        address=findViewById(R.id.address);
        phone_number=findViewById(R.id.phone_number);
        fathername=findViewById(R.id.fathername);
        motherame=findViewById(R.id.motherame);
        NID_number=findViewById(R.id.NID_number);
        relagion=findViewById(R.id.relagion);
        jobSeekerImage=findViewById(R.id.jobSeekerImage);
        maritalstat=findViewById(R.id.maritalstat);
        gender=findViewById(R.id.gender);
        DOB=findViewById(R.id.DOB);
        careerObjective=findViewById(R.id.careerObjective);
        permanentAddress=findViewById(R.id.permanentAddress);
        academicHistory=findViewById(R.id.academicHistory);
        EmploymentHistory=findViewById(R.id.EmploymentHistory);

        Email=findViewById(R.id.email);
        //Email.setText(emil);


        ///applicant data/////////////////////////////////////////////////////////////////////



        /////Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com

        //String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();

        //String email="salam@gmail.com";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersPersonal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderemp=retrofit.create(JsonPlaceHolderAPI.class);

        Call<jovSeekerDetail> call= jsonPlaceHolderemp.getjobSeekerDetail(emil);

        call.enqueue(new Callback<jovSeekerDetail>() {
            @Override
            public void onResponse(Call<jovSeekerDetail> call, Response<jovSeekerDetail> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    jovSeekerDetail jovSeekerDetail=response.body();

                    nam=jovSeekerDetail.getName();
                    adrs=jovSeekerDetail.getPresentAddress()+", "+jovSeekerDetail.getPresentAddressLine2();
                    phn=jovSeekerDetail.getPhone();
                    em=jovSeekerDetail.getEmail();

                    name.setText(nam);
                    address.setText(jovSeekerDetail.getPresentAddress()+", "+jovSeekerDetail.getPresentAddressLine2());
                    phone_number.setText(phn);
                    Email.setText(em);
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




        ///applicant data/////////////////////////////////////////////////////////////////////




        btnFloating=findViewById(R.id.addJob);
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),Apply_contact.class);


                intent.putExtra("Name",nam);
                intent.putExtra("Address",adrs);
                intent.putExtra("Phone",phn);
                intent.putExtra("Email",em);


                startActivity(intent);




            }
        });




        ///////////////////////////////////////////////////////////////////////

        ////Data retrive//////////////////////////////////////////



        /////Exp Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com

        //String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();

        //String email="salam@gmail.com";
        Retrofit retrofitexp=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersExpriences/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderexp=retrofitexp.create(JsonPlaceHolderAPI.class);

        Call<jovSeekerExpDetail> callexp= jsonPlaceHolderexp.getjobSeekerExpDetail(emil);

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



        ////Data retrive//////////////////////////////////////////



        //String email= FirebaseAuth.getInstance().getCurrentUser().getEmail();

        //String email="salam@gmail.com";
        Retrofit retrofitedu=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersAcademics/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderEdu=retrofitedu.create(JsonPlaceHolderAPI.class);

        Call<JovSeekerEdu> calledu= jsonPlaceHolderEdu.getjobSeekerEduDetail(emil);

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

















        ////////////////////////////////////////////////////////////








       // TableLayout tbl_exp= findViewById(R.id.tabl_exp);


//        for(int i=0;i<9;i++){
//
//
//
//
//            TableRow tblrw=new TableRow(this);
//
//            TextView tv_company=new TextView(this);
//            tv_company.setWidth(100);
//            tv_company.setTextColor(Color.parseColor("#FF000000"));
//            tv_company.setPadding(5,0,5,0);
//            TextView tv_responsiblity=new TextView(this);
//            tv_responsiblity.setTextColor(Color.parseColor("#FF000000"));
//            tv_responsiblity.setWidth(100);
//            tv_responsiblity.setPadding(5,0,5,0);
//            TextView tv_duration=new TextView(this);
//            tv_duration.setTextColor(Color.parseColor("#FF000000"));;
//            tv_duration.setWidth(100);
//            tv_duration.setPadding(5,0,5,0);
//
//            tv_company.setText("A Group");
//            tv_responsiblity.setText("development uihdih eiwkhd jkwhkwh ekehejkh uihdih eiwkhd jkwhkwh ekehejkh");
//            tv_duration.setText("1/02/04\nto\n05/02/10");
//            tblrw.addView(tv_company);
//            tblrw.addView(tv_responsiblity);
//            tblrw.addView(tv_duration);
//            tbl_exp.addView(tblrw);
//
//        }
//
//        TableLayout tbl_academic= findViewById(R.id.tabl_academic);
//
//        for(int j=0;j<9;j++){
//
//
//
//
//            TableRow tblrw_ac=new TableRow(this);
//
//            TextView tv_exam=new TextView(this);
//            tv_exam.setWidth(100);
//            tv_exam.setTextColor(Color.parseColor("#FF000000"));
//            tv_exam.setPadding(5,0,5,0);
//            TextView tv_major=new TextView(this);
//            tv_major.setTextColor(Color.parseColor("#FF000000"));
//            tv_major.setWidth(100);
//            tv_major.setPadding(5,0,5,0);
//            TextView tv_result=new TextView(this);
//            tv_result.setTextColor(Color.parseColor("#FF000000"));;
//            tv_result.setWidth(100);
//            tv_result.setPadding(5,0,5,0);
//
//            TextView tv_institution=new TextView(this);
//            tv_institution.setTextColor(Color.parseColor("#FF000000"));;
//            tv_institution.setWidth(100);
//            tv_institution.setPadding(5,0,5,0);
//
//            tv_exam.setText("A Group");
//            tv_major.setText("Science");
//            tv_result.setText("1/02/04\nto\n05/02/10");
//            tv_institution.setText("Milestone Collage");
//            tblrw_ac.addView(tv_exam);
//            tblrw_ac.addView(tv_major);
//            tblrw_ac.addView(tv_result);
//            tblrw_ac.addView(tv_institution);
//            tbl_academic.addView(tblrw_ac);
//
//        }





    }
}