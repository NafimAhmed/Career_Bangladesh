package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Emplyer_job_Add_Page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    DatePickerDialog picker;


    Spinner jobTypeSpiner;
    TextView deadline;

    EditText empjobTitle,employerName,empJobdescription,empjobLocation,empjobvacancy,emp_educationalQualification,empJobResponsiblity,Salary;
    Button confirmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplyer_job_add_page);

        getSupportActionBar().setTitle("Post a new job");

        ////////////////////////////



        ////////////////////////


        jobTypeSpiner=findViewById(R.id.jobTypeSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Job_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobTypeSpiner.setAdapter(adapter);
        jobTypeSpiner.setOnItemSelectedListener(this);
        employerName=findViewById(R.id.employerName);
        empjobTitle=findViewById(R.id.empjobTitle);
        empJobdescription=findViewById(R.id.empJobdescription);
        empjobvacancy=findViewById(R.id.empjobvacancy);
        empjobLocation=findViewById(R.id.empjobLocation);
        empjobLocation.setVerticalScrollBarEnabled(true);
        emp_educationalQualification=findViewById(R.id.emp_educationalQualification);
        empJobResponsiblity=findViewById(R.id.empJobResponsiblity);
        Salary=findViewById(R.id.Salary);
        deadline=findViewById(R.id.deadline);


        /////////////////////////////

        deadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Emplyer_job_Add_Page.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                deadline.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });




        //////////////////////////////




        /////////////////////////////////



        confirmBtn=findViewById(R.id.confirmPost);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplicationContext(),Employer_JobConformation_page.class);
                intent.putExtra("jobType",jobTypeSpiner.getSelectedItem().toString());
                intent.putExtra("jobTitle",empjobTitle.getText().toString());
                intent.putExtra("employerName",employerName.getText().toString());
                intent.putExtra("empjobvacancy",empjobvacancy.getText().toString());
                intent.putExtra("empjobLocation",empjobLocation.getText().toString());
                intent.putExtra("empJobdescription",empJobdescription.getText().toString());
                intent.putExtra("emp_educationalQualification",emp_educationalQualification.getText().toString());
                intent.putExtra("empJobResponsiblity",empJobResponsiblity.getText().toString());
                intent.putExtra("Salary",Salary.getText().toString());
                intent.putExtra("deadline",deadline.getText().toString());
                startActivity(intent);



            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }


}