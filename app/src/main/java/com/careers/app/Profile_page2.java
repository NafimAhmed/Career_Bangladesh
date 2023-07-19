package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
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

public class Profile_page2 extends AppCompatActivity {



    EditText NID_NO,PassportNo,email,name,phone_number,permanentAddress,presentAddress,Skills, fatherName,CareerObj, mothersName,Religion,gender,MaritalStatus,Nationality;
    Button basic_info_Save;
    String emailjobSeeker;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page2);



        Bundle extras = getIntent().getExtras();
        emailjobSeeker= extras.getString("Email");







       // getData();

        NID_NO=findViewById(R.id.Nid_number);
        name=findViewById(R.id.Name);
        fatherName=findViewById(R.id.fathername);
        mothersName=findViewById(R.id.mothername);
        gender=findViewById(R.id.gender);
        Nationality=findViewById(R.id.Nationality);
        MaritalStatus=findViewById(R.id.MaritalStatus);
        Religion=findViewById(R.id.Religion);
        phone_number=findViewById(R.id.phone_number);
        CareerObj=findViewById(R.id.CareerObj);
        presentAddress=findViewById(R.id.presentAddress);
        Skills=findViewById(R.id.Skills);
        permanentAddress=findViewById(R.id.permanentAddress);
        basic_info_Save=findViewById(R.id.basic_info_Save);
        email=findViewById(R.id.email);
        PassportNo=findViewById(R.id.PassportNo);




        ////////////////////////////////////////////


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobSeekersPersonal/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderSavedJob jsonPlaceHolderprofile=retrofit.create(JsonPlaceHolderSavedJob.class);

        Call<UsersPersonal> call= jsonPlaceHolderprofile.getUserDetail(emailjobSeeker/*"shamim@gmail.com"*/);

        call.enqueue(new Callback<UsersPersonal>() {
            @Override
            public void onResponse(Call<UsersPersonal> call, Response<UsersPersonal> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    UsersPersonal usersPersonal=response.body();

                    //String name1=usersPersonal.getName();

                    name.setText(usersPersonal.getName());
                    NID_NO.setText(usersPersonal.nationalID);
                    fatherName.setText(usersPersonal.getFathersName());
                    mothersName.setText(usersPersonal.getMothersName());
                    Nationality.setText(usersPersonal.getNationality());
                    MaritalStatus.setText(usersPersonal.getMaritalStatus());
                    gender.setText(usersPersonal.getGender());
                    Religion.setText(usersPersonal.getReligion());
                    phone_number.setText(usersPersonal.getPhone());
                    email.setText(usersPersonal.getEmail());
                    //PassportNo.setText(usersPersonal.nationalID);
                    CareerObj.setText(usersPersonal.getCareerObjective());
                    permanentAddress.setText(usersPersonal.getPermanentAddress());
                    presentAddress.setText(usersPersonal.getPresentAddress());




                    // Log.e("TAG",posts.get(position).jobID);


                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<UsersPersonal> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();

                Log.e("TAG",t.getMessage());

            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();










        ////////////////////////////////////////////










        basic_info_Save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(getApplicationContext(), Education_Profile.class);
                        intent.putExtra("Email",emailjobSeeker);
                        startActivity(intent);

                    }
                }
        );






    }



    public void getData(){

        //String jobID="640ed1085e671c6b71a39738";




    }





}