package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.widget.TextView;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Application_detail extends AppCompatActivity {

    Button editButton;

    LinearLayout linearLayout;


    ExtendedFloatingActionButton btnFloating;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_detail);




        btnFloating=findViewById(R.id.addJob);
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),Apply_contact.class);
                startActivity(intent);




            }
        });



        TableLayout tbl_exp= findViewById(R.id.tabl_exp);


        for(int i=0;i<9;i++){




            TableRow tblrw=new TableRow(this);

            TextView tv_company=new TextView(this);
            tv_company.setWidth(100);
            tv_company.setTextColor(Color.parseColor("#FF000000"));
            tv_company.setPadding(5,0,5,0);
            TextView tv_responsiblity=new TextView(this);
            tv_responsiblity.setTextColor(Color.parseColor("#FF000000"));
            tv_responsiblity.setWidth(100);
            tv_responsiblity.setPadding(5,0,5,0);
            TextView tv_duration=new TextView(this);
            tv_duration.setTextColor(Color.parseColor("#FF000000"));;
            tv_duration.setWidth(100);
            tv_duration.setPadding(5,0,5,0);

            tv_company.setText("A Group");
            tv_responsiblity.setText("development uihdih eiwkhd jkwhkwh ekehejkh uihdih eiwkhd jkwhkwh ekehejkh");
            tv_duration.setText("1/02/04\nto\n05/02/10");
            tblrw.addView(tv_company);
            tblrw.addView(tv_responsiblity);
            tblrw.addView(tv_duration);
            tbl_exp.addView(tblrw);

        }

        TableLayout tbl_academic= findViewById(R.id.tabl_academic);

        for(int j=0;j<9;j++){




            TableRow tblrw_ac=new TableRow(this);

            TextView tv_exam=new TextView(this);
            tv_exam.setWidth(100);
            tv_exam.setTextColor(Color.parseColor("#FF000000"));
            tv_exam.setPadding(5,0,5,0);
            TextView tv_major=new TextView(this);
            tv_major.setTextColor(Color.parseColor("#FF000000"));
            tv_major.setWidth(100);
            tv_major.setPadding(5,0,5,0);
            TextView tv_result=new TextView(this);
            tv_result.setTextColor(Color.parseColor("#FF000000"));;
            tv_result.setWidth(100);
            tv_result.setPadding(5,0,5,0);

            TextView tv_institution=new TextView(this);
            tv_institution.setTextColor(Color.parseColor("#FF000000"));;
            tv_institution.setWidth(100);
            tv_institution.setPadding(5,0,5,0);

            tv_exam.setText("A Group");
            tv_major.setText("Science");
            tv_result.setText("1/02/04\nto\n05/02/10");
            tv_institution.setText("Milestone Collage");
            tblrw_ac.addView(tv_exam);
            tblrw_ac.addView(tv_major);
            tblrw_ac.addView(tv_result);
            tblrw_ac.addView(tv_institution);
            tbl_academic.addView(tblrw_ac);

        }





    }
}