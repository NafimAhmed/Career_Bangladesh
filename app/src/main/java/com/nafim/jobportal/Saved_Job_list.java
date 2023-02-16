package com.nafim.jobportal;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Saved_Job_list extends AppCompatActivity implements Adapter.OnNoteListener {





    RecyclerView recyclerView;
    Adapter adapter;




    ArrayList<Item> arrayList;




    RecyclerView.LayoutManager layoutManager;

    //////////////////////////



    //////////////////////////







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_job_list);
        getSupportActionBar().setTitle("Saved job list");






        /////////////////////////////////////////////////



        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayList=new ArrayList<>();

        Adapter.OnNoteListener onNoteListener=this;


        arrayList.add(new Item("Android Developer","A Group","this is a development related job","1/5/23","Uttara, Dhaka","2","12000","MSc. In Computer Science",
                "Software development","https://www.freepnglogos.com/uploads/youtube-logo-hd-8.png"));
        arrayList.add(new Item("Android Developer","B Group","this is a development related job","1/5/23","Banani, Dhaka","2","12000","MSc. In Computer Science","Node JS development"
                ,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2048px-Google_%22G%22_Logo.svg.png"));
        arrayList.add(new Item("Android Developer","C Group","this is a development related job","1/5/23","Dhanmondi, Dhaka","2","12000","MSc. In Computer Science",
                "Mobile app development","https://www.freepnglogos.com/uploads/youtube-logo-hd-8.png"));
        arrayList.add(new Item("Android Developer","D Group","this is a development related job","1/5/23","Motijheel, Dhaka","2","12000","MSc. In Computer Science",
                ".NET development","https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2048px-Google_%22G%22_Logo.svg.png"));
        arrayList.add(new Item("Android Developer","E Group","this is a development related job","1/5/23","Bongshal, Dhaka","2","12000","MSc. In Computer Science","PHP development"
                ,"https://www.freepnglogos.com/uploads/youtube-logo-hd-8.png"));
        arrayList.add(new Item("Android Developer","AF Group","this is a development related job","1/5/23","Mirpur 12, Dhaka","2","12000","MSc. In Computer Science",
                "Software development","https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2048px-Google_%22G%22_Logo.svg.png"));
        adapter=new Adapter(arrayList,onNoteListener,Saved_Job_list.this);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);









        //////////////////////////////////////////////////







    }

    @Override
    public Void onNoteclicl(int position) {





        Item item=arrayList.get(position);
        String jobTitle=item.getJobTitle();
        String employer=item.getEmployerName();
        String location=item.joblocation;
        String vacancy= item.vacancy;
        String salary= item.salary;
        String jbResponsiblity=item.jobResponsiblity;
        String jbdescription=item.jobDescription;
        String deadLine=item.getDeadLine();
        String educationalQualification=item.getEducationalQualification();


        Toast.makeText(getApplicationContext(),jobTitle+employer+deadLine+educationalQualification,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),Job_Detail.class);
        intent.putExtra("jobTitle",jobTitle);
        intent.putExtra("employer",employer);
        intent.putExtra("deadLine",deadLine);
        intent.putExtra("jobDescription",jbdescription);
        intent.putExtra("educationalQualification",educationalQualification);
        intent.putExtra("jbResponsiblity",jbResponsiblity);
        intent.putExtra("location",location);
        intent.putExtra("vacancy",vacancy);
        intent.putExtra("salary",salary);
        intent.putExtra("img",item.logoURL);
        startActivity(intent);











        return null;
    }
}