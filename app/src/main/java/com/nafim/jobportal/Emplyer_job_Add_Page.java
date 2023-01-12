package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class Emplyer_job_Add_Page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner jobTypeSpiner;
    EditText empjobTitle,empjobLocation,emp_educationalQualification,empJobResponsiblity,Salary,deadline;
    Button confirmBtn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplyer_job_add_page);

        jobTypeSpiner=findViewById(R.id.jobTypeSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Job_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobTypeSpiner.setAdapter(adapter);
        jobTypeSpiner.setOnItemSelectedListener(this);
        empjobTitle=findViewById(R.id.empjobTitle);
        empjobLocation=findViewById(R.id.empjobLocation);
        emp_educationalQualification=findViewById(R.id.emp_educationalQualification);
        empJobResponsiblity=findViewById(R.id.empJobResponsiblity);
        Salary=findViewById(R.id.Salary);
        deadline=findViewById(R.id.deadline);

        confirmBtn=findViewById(R.id.confirmPost);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                Intent intent = new Intent(getApplicationContext(),Employer_JobConformation_page.class);
                intent.putExtra("jobType",jobTypeSpiner.getSelectedItem().toString());
                intent.putExtra("jobTitle",empjobTitle.getText().toString());
                intent.putExtra("empjobLocation",empjobLocation.getText().toString());
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