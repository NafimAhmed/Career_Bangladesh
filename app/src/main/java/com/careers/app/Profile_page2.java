package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Profile_page2 extends AppCompatActivity {



    EditText NID_NO, name,phone_number,permanentAddress,presentAddress,Skills, fatherName,CareerObj, mothersName,Religion,gender,MaritalStatus,Nationality;
    Button basic_info_Save;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page2);

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


        basic_info_Save.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                        Intent intent=new Intent(getApplicationContext(), Education_Profile.class);
                        startActivity(intent);

                    }
                }
        );






    }
}