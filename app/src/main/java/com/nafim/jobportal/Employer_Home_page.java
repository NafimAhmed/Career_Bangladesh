package com.nafim.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Employer_Home_page extends AppCompatActivity implements AdapterEmployer.OnNoteListener  {

    RecyclerView recyclerView;
    AdapterEmployer adapter;
    FloatingActionButton btnFloating;
    //RecyclerView.LayoutManager layoutManager;
    ArrayList<ItemEmployer> arrayList;

    //Adapter.OnNoteListener onNoteListener=this;

    RecyclerView.LayoutManager layoutManager;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_home_page);

        getSupportActionBar().setTitle("Previous job post");


        btnFloating=findViewById(R.id.addJob);
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),Emplyer_job_Add_Page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Floating is clicked",Toast.LENGTH_SHORT).show();


            }
        });


        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayList=new ArrayList<>();

        AdapterEmployer.OnNoteListener onNoteListener=this;


        arrayList.add(new ItemEmployer("Android Developer","Uttara,dhaka","2","12000","A Group","02/02/23","MSc. In Computer Science","devlopment","4"));
        arrayList.add(new ItemEmployer("Android Developer","Uttara,dhaka","2","12000","B Group","02/02/23","MSc. In Computer Science","devlopment","5"));
        arrayList.add(new ItemEmployer("Android Developer","Uttara,dhaka","2","12000","C Group","02/02/23","MSc. In Computer Science","devlopment","6"));
        arrayList.add(new ItemEmployer("Android Developer","Uttara,dhaka","2","12000","D Group","02/02/23","MSc. In Computer Science","devlopment","7"));
        arrayList.add(new ItemEmployer("Android Developer","Uttara,dhaka","2","12000","D Group","02/02/23","MSc. In Computer Science","devlopment","8"));
        arrayList.add(new ItemEmployer("Android Developer","Uttara,dhaka","2","12000","E Group","02/02/23","MSc. In Computer Science","devlopment","9"));
        adapter=new AdapterEmployer(arrayList,onNoteListener);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);


        recyclerView.addOnScrollListener(new RecyclerView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
                super.onScrollStateChanged(recyclerView, newState);
            }

            @Override
            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
                super.onScrolled(recyclerView, dx, dy);
                if(dy>0){

                    btnFloating.hide();

                }
                else{
                    btnFloating.show();
                }
            }
        });


    }






    @Override
    public Void onNoteclicl(int position) {


        ItemEmployer item=arrayList.get(position);
        String jobTitle=item.getJobTitle();
        String employer=item.getEmployerName();
        String deadLine=item.getDeadLine();
        String loc=item.location;
        String vacan=item.vacancy;
        String salar=item.salary;
        String cvNumb=item.numb_CV;
        String jbResp=item.jobResponsiblity;
        String educationalQualification=item.getEducationalQualification();


        Toast.makeText(getApplicationContext(),jobTitle+employer+deadLine+educationalQualification,Toast.LENGTH_LONG).show();

        //Intent intent = new Intent(getApplicationContext(),Job_Detail.class);


        Intent intent=new Intent(getApplicationContext(),Employer_ViewJobDetail_page.class);
        intent.putExtra("jobTitle",jobTitle);
        intent.putExtra("employer",employer);
        intent.putExtra("deadLine",deadLine);
        intent.putExtra("educationalQualification",educationalQualification);
        intent.putExtra("location",loc);
        intent.putExtra("vacancy",vacan);
        intent.putExtra("numb_cv",cvNumb);
        intent.putExtra("salary",salar);
        intent.putExtra("jobResponsiblity",jbResp);
        startActivity(intent);


        return null;
    }
}