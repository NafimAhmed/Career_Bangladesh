package com.nafim.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class Home_page extends AppCompatActivity implements Adapter.OnNoteListener, NavigationView.OnNavigationItemSelectedListener {

    RecyclerView recyclerView;
    Adapter adapter;
    //RecyclerView.LayoutManager layoutManager;
    ArrayList<Item> arrayList;

    //Adapter.OnNoteListener onNoteListener=this;

    RecyclerView.LayoutManager layoutManager;

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    Toolbar toolbar;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        getSupportActionBar().setTitle("Job List");


        Toolbar toolbar=findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        drawerLayout=findViewById(R.id.drewerlayout);
        navigationView=findViewById(R.id.nev_drawer);
        ActionBarDrawerToggle toggle=new ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        //drawerLayout.setDrawerListener(toggle);
        toggle.syncState();

        navigationView.setNavigationItemSelectedListener(this);


        ////////////////////////////////

        ////////////////////////////////







        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayList=new ArrayList<>();

        Adapter.OnNoteListener onNoteListener=this;


        arrayList.add(new Item("Android Developer","A Group","1/5/23","Uttara, Dhaka","2","12000","MSc. In Computer Science","Software development"));
        arrayList.add(new Item("Android Developer","B Group","1/5/23","Banani, Dhaka","2","12000","MSc. In Computer Science","Node JS development"));
        arrayList.add(new Item("Android Developer","C Group","1/5/23","Dhanmondi, Dhaka","2","12000","MSc. In Computer Science","Mobile app development"));
        arrayList.add(new Item("Android Developer","D Group","1/5/23","Motijheel, Dhaka","2","12000","MSc. In Computer Science",".NET development"));
        arrayList.add(new Item("Android Developer","E Group","1/5/23","Bongshal, Dhaka","2","12000","MSc. In Computer Science","PHP development"));
        arrayList.add(new Item("Android Developer","AF Group","1/5/23","Mirpur 12, Dhaka","2","12000","MSc. In Computer Science","Software development"));
        adapter=new Adapter(arrayList,onNoteListener);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setAdapter(adapter);
        recyclerView.setLayoutManager(layoutManager);





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
        String deadLine=item.getDeadLine();
        String educationalQualification=item.getEducationalQualification();


        Toast.makeText(getApplicationContext(),jobTitle+employer+deadLine+educationalQualification,Toast.LENGTH_LONG).show();

        Intent intent = new Intent(getApplicationContext(),Job_Detail.class);
        intent.putExtra("jobTitle",jobTitle);
        intent.putExtra("employer",employer);
        intent.putExtra("deadLine",deadLine);
        intent.putExtra("educationalQualification",educationalQualification);
        intent.putExtra("jbResponsiblity",jbResponsiblity);
        intent.putExtra("location",location);
        intent.putExtra("vacancy",vacancy);
        intent.putExtra("salary",salary);
        startActivity(intent);



        /*Intent intent = new Intent(getApplicationContext(),Read.class);
        //intent.setDataAndType(uri,"application/*");
        intent.putExtra("txt",read(Uri.parse("content://com.android.exteralstorage.documents/document/9C33-6BBD%3Atxttospeeck%2FArabic2.txt")) );
        startActivity(intent);*/


        // return null;


        return null;
    }

    @Override
    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
        int id= item.getItemId();
        Toast.makeText(getApplicationContext(),item.getTitle(),Toast.LENGTH_SHORT).show();
       /* if(id==R.id.home_menue)
        {
            Toast.makeText(getApplicationContext(),"home_menue",Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.resume_menue)
        {
            Toast.makeText(getApplicationContext(),"resume_menue",Toast.LENGTH_SHORT).show();
        }
        else if (id==R.id.settings_menue)
        {
            Toast.makeText(getApplicationContext(),"settings_menue",Toast.LENGTH_SHORT).show();
        }*/


        return false;
    }

    /*@Override
    public void onPointerCaptureChanged(boolean hasCapture) {
        super.onPointerCaptureChanged(hasCapture);

    }*/




}