package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

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


        addexp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(getApplicationContext(),training.class);
                startActivity(intent);
            }
        });


    }
}