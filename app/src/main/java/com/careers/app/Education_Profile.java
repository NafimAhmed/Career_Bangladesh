package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class Education_Profile extends AppCompatActivity {


    Button addedu;

    EditText edulevelOne,eduResultFour,eduResultTypeSpinnerFour,eduInstituteFour,PassingyearFour,eduMajorTwoSpinnerFour,edulevelTFour,eduResultThree,eduResultTypeSpinnerThree
            ,PassingYearThree,eduInstituteThree,eduMajorSpinnerThree,edulevelThree,eduResultTwo,
            eduResultTypeSpinnerTwo,PassingYearTwo,eduInstituteTwo,edulevelTwo,eduResultOne,eduPassingYearOne,
            eduInstituteOne,eduMajorSpinnerOne;

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




        addedu=findViewById(R.id.addedu);

        addedu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),Exp_profile.class);
                startActivity(intent);
            }
        });
    }
}