package com.careers.app;

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
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

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
    TextView addjobtext;

    String em=FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
    AdapterEmployer.OnNoteListener onNoteListener=this;






    ////////////////////////////



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_home_page);

       // getSupportActionBar().setTitle("Previous job post");

        Intent i=getIntent();




        addjobtext=findViewById(R.id.addjobtext);
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




        // String nm=FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
        //String em=FirebaseAuth.getInstance().getCurrentUser().getEmail().toString();
        tv.setText(em);
        tv2.setText(em);



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



        /////Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHoldeEmpty jsonPlaceHolderemp=retrofit.create(JsonPlaceHoldeEmpty.class);

        Call<List<PostEmployer>> call= jsonPlaceHolderemp.getPost("/postedjob?email="+em);

        call.enqueue(new Callback<List<PostEmployer>>() {
            @Override
            public void onResponse(Call<List<PostEmployer>> call, Response<List<PostEmployer>> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    List<PostEmployer> posts=response.body();
                    String ttl = null;


                    for (PostEmployer post:posts)
                    {

                        arrayList.add(new ItemEmployer(
                                "63f305bd5c3c0e24b96e1b50",
                                post.getJobTitle(),
                                post.getEmail(),
                                post.getPostDate(),
                                post.getLocation(),
                                post.getVacancies(),
                                post.getSalaryFrom() + " to " + post.getSalaryTo(),
                                post.getOrganization(), post.getDeadLine(),
                                post.getEducation() + "\n\nRequired Experience : " + post.getExperience()
                                , post.getJobResponst(), "0", post.getJobContext()));

                        adapter=new AdapterEmployer(arrayList,onNoteListener);
                        layoutManager=new LinearLayoutManager(getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(layoutManager);







                    }


                }
            }

            @Override
            public void onFailure(Call<List<PostEmployer>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });






        ////Data retrive//////////////////////////////////////////









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
                    addjobtext.setVisibility(View.GONE);

                }
                else{
                    btnFloating.show();
                    addjobtext.setVisibility(View.VISIBLE);
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
        String jbid=item.jobId;
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
        intent.putExtra("jobId",jbid);
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