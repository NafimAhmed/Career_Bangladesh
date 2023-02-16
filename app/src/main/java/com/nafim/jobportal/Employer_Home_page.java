package com.nafim.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.service.controls.actions.FloatAction;
import android.view.MenuItem;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;

public class Employer_Home_page extends AppCompatActivity implements AdapterEmployer.OnNoteListener  {

    RecyclerView recyclerView;
    AdapterEmployer adapter;
    FloatingActionButton btnFloating;
    //RecyclerView.LayoutManager layoutManager;
    ArrayList<ItemEmployer> arrayList;

    //Adapter.OnNoteListener onNoteListener=this;

    RecyclerView.LayoutManager layoutManager;

    //////////////////////////////

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView imageMenu;



    ////////////////////////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_home_page);

       // getSupportActionBar().setTitle("Previous job post");




        btnFloating=findViewById(R.id.addJob);
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent=new Intent(getApplicationContext(),Emplyer_job_Add_Page.class);
                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Floating is clicked",Toast.LENGTH_SHORT).show();


            }
        });


        ////////////////////////////////////////////


        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Here
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });

        ////////////////////////////////

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);


        ////////////////////////////////

        View headerView= navigationView.getHeaderView(0);
        ImageView imageView=headerView.findViewById(R.id.profileImg);
        imageView.setImageResource(R.drawable.logo);

        TextView tv=headerView.findViewById(R.id.profileName);
        TextView tv2=headerView.findViewById(R.id.emlid);
        tv.setText("Re Ahmed");
        tv2.setText("re@gmail.com");


        ////////////////////////////////////

        toggle = new ActionBarDrawerToggle(Employer_Home_page.this, drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();



        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.profile:
                        Toast.makeText(Employer_Home_page.this, "Clicked", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),Employer_profile.class);
                        startActivity(i);
                        drawerLayout.closeDrawers();
                        break;

//                    case R.id.edit_profile:
//                        Toast.makeText(Employer_Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
////                        Intent in=new Intent(getApplicationContext(),Profile_Page.class);
////                        startActivity(in);
//                        drawerLayout.closeDrawers();
//                        break;
                    case R.id.settings:
                        Toast.makeText(Employer_Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        Intent setting=new Intent(getApplicationContext(),Settings.class);
                        startActivity(setting);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.shareapp:
                        Toast.makeText(Employer_Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        share(Employer_Home_page.this);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.contact:
                        Toast.makeText(Employer_Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        Intent contact=new Intent(getApplicationContext(),Contact_page.class);
                        startActivity(contact);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        break;
//                    case R.id.download_resume:
//                        Toast.makeText(Employer_Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
////                        Intent cvDownload=new Intent(getApplicationContext(),Download_Resume.class);
////                        startActivity(cvDownload);
//                        drawerLayout.closeDrawers();
//                        break;

                }

                return false;
            }
        });






        //////////////////////////////////////////









        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayList=new ArrayList<>();

        AdapterEmployer.OnNoteListener onNoteListener=this;


        arrayList.add(new ItemEmployer("Android Developer","1/2/23","Uttara,dhaka","2","12000","A Group","02/02/23","MSc. In Computer Science","devlopment","5","this is job description"));
        arrayList.add(new ItemEmployer("Android Developer","1/2/23","Uttara,dhaka","2","12000","B Group","02/02/23","MSc. In Computer Science","devlopment","5","this is job description"));
        arrayList.add(new ItemEmployer("Android Developer","1/2/23","Uttara,dhaka","2","12000","C Group","02/02/23","MSc. In Computer Science","devlopment","5","this is job description"));
        arrayList.add(new ItemEmployer("Android Developer","1/2/23","Uttara,dhaka","2","12000","D Group","02/02/23","MSc. In Computer Science","devlopment","5","this is job description"));
        arrayList.add(new ItemEmployer("Android Developer","1/2/23","Uttara,dhaka","2","12000","D Group","02/02/23","MSc. In Computer Science","devlopment","5","this is job description"));
        arrayList.add(new ItemEmployer("Android Developer","1/2/23","Uttara,dhaka","2","12000","E Group","02/02/23","MSc. In Computer Science","devlopment","5","this is job description"));
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
        String postingDate=item.jobPostingDate;
        String vacan=item.vacancy;
        String salar=item.salary;
        String jbdesc=item.jobDescription;
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
        intent.putExtra("postingDate",postingDate);
        intent.putExtra("vacancy",vacan);
        intent.putExtra("numb_cv",cvNumb);
        intent.putExtra("salary",salar);
        intent.putExtra("jbdesc",jbdesc);
        intent.putExtra("jobResponsiblity",jbResp);
        startActivity(intent);


        return null;
    }


    //------------------------------



    public void share(Context context){
        Intent shr=new Intent();
        shr.setAction(Intent.ACTION_SEND);
        shr.putExtra(Intent.EXTRA_TEXT,"Download Now : https://play.google.com/store/apps/details?id="+context.getPackageName());
        shr.setType("text/plain");
        context.startActivity(shr);
        //getApplicationContext().startActivity(shr);
    }




}