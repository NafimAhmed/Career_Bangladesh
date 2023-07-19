package com.careers.app;



import androidx.annotation.NonNull;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;

import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;

import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;


import com.google.android.material.navigation.NavigationView;
import com.google.firebase.auth.FirebaseAuth;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Home_page extends AppCompatActivity implements Adapter.OnNoteListener, JobType_Adapter.JobType_OnNoteListener{

    RecyclerView recyclerView,recyclerView_Jobtype;
    Adapter adapter;
    JobType_Adapter jobType_adapter;
    EditText jobSearch;
    private static final String CHANNEL_ID="My Channel";

    LinearLayout searchLayout;

    ArrayList<Item> arrayList;
    ArrayList<JobType_Item> JobType_arrayList;



    RecyclerView.LayoutManager layoutManager,jobType_layoutManager;

    //////////////////////////

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView imageMenu,srch;



    //////////////////////////




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        getSupportActionBar().setTitle("Job List");

        Adapter.OnNoteListener onNoteListener=this;



        //////////////////////////////////////////////////////










        /////////////////////////////////////////

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        jobSearch=findViewById(R.id.jobSearch);

        srch=findViewById(R.id.srch);

        jobSearch.setWidth(width-250);



        /////Data retrive///////////////////////////


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderAPI jsonPlaceHolderAPI=retrofit.create(JsonPlaceHolderAPI.class);

        Call<List<Post>> call= jsonPlaceHolderAPI.getPost();

        call.enqueue(new Callback<List<Post>>() {
            @Override
            public void onResponse(Call<List<Post>> call, Response<List<Post>> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    List<Post> posts=response.body();
                    String ttl = null;

                    for (Post post:posts)
                    {
                        //ttl+=post.getJobTitle().toString()+"\n";

                        arrayList.add(new Item(
                                post.getId(),
                                        post.getPostersEmail(),
                                        post.getCategory(),
                                        post.getJobTitle(),
                                        post.getOrganization(),
                                        post.getBusinessDescription()+"\n"+post.getJobContext(),
                                post.getDeadLine(),
                                post.getLocation(),
                                post.getVacancies(),
                                post.getSalaryFrom()+" to "+post.getSalaryTo(),
                                post.getEducation()+"\n\nRequired Experience : "+post.getExperience(),
                                        post.getJobResponst(),
                                post.getCompanyLogo()
                        )
                        );

                        adapter=new Adapter(arrayList,onNoteListener,Home_page.this);
                        layoutManager=new LinearLayoutManager(getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(layoutManager);




                    }


                }
            }

            @Override
            public void onFailure(Call<List<Post>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });






        ////Data retrive//////////////////////////////////////////


        srch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                showAlertDialogButtonClicked();
            }
        });




        ////////////////////////////////

        drawerLayout = findViewById(R.id.drawer_layout);
        navigationView = findViewById(R.id.nav_View);
        imageMenu = findViewById(R.id.imageMenu);
        searchLayout=findViewById(R.id.search_Layout);


        ////////////////////////////////

        View headerView= navigationView.getHeaderView(0);
        ImageView imageView=headerView.findViewById(R.id.profileImg);
        imageView.setImageResource(R.drawable.logo);

        TextView tv=headerView.findViewById(R.id.profileName);
        TextView tv2=headerView.findViewById(R.id.emlid);




       // String nm=FirebaseAuth.getInstance().getCurrentUser().getDisplayName();
       String em=FirebaseAuth.getInstance().getCurrentUser().getEmail();
        tv.setText(em);
        tv2.setText(em);


        ////////////////////////////////////




        toggle = new ActionBarDrawerToggle(Home_page.this, drawerLayout,R.string.app_name,R.string.app_name);
        drawerLayout.addDrawerListener(toggle);
        toggle.syncState();
        //getSupportActionBar().setDisplayHomeAsUpEnabled(true);

        // Drawar click event
        // Drawer item Click event ------

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                switch (item.getItemId()) {
                    case R.id.profile:
                        Toast.makeText(Home_page.this, "Clicked", Toast.LENGTH_SHORT).show();
                        Intent i=new Intent(getApplicationContext(),Resume_Detail.class);
                        i.putExtra("button_visible",false);
                        startActivity(i);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.faq_page:
                        Toast.makeText(Home_page.this, "faq_page", Toast.LENGTH_SHORT).show();
                        Intent faq_page=new Intent(getApplicationContext(),FAQs_paage.class);
                        startActivity(faq_page);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.savedjob:
                        Toast.makeText(Home_page.this, "faq_page", Toast.LENGTH_SHORT).show();
                        Intent savedJobpage=new Intent(getApplicationContext(),Saved_Job_list.class);
                        savedJobpage.putExtra("email",em);
                        startActivity(savedJobpage);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.edit_profile:
                        Toast.makeText(Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        Intent in=new Intent(getApplicationContext(),Profile_page2.class);
                        in.putExtra("Email",em);
                        startActivity(in);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.settings:
                        Toast.makeText(Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        Intent setting=new Intent(getApplicationContext(),Settings.class);
                        startActivity(setting);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.shareapp:
                        Toast.makeText(Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        share(Home_page.this);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.contact:
                        Toast.makeText(Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        Intent contact=new Intent(getApplicationContext(),Contact_page.class);
                        startActivity(contact);
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.download_resume:
                        Toast.makeText(Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        Intent cvDownload=new Intent(getApplicationContext(),Download_Resume.class);
                        startActivity(cvDownload);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.logout:
                        FirebaseAuth.getInstance().signOut();
                        finish();
                        break;

                }

                return false;
            }
        });
        //------------------------------

        // ------------------------
        // App Bar Click Event
        imageMenu = findViewById(R.id.imageMenu);

        imageMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // Code Here
                drawerLayout.openDrawer(GravityCompat.START);
            }
        });


        // ------------------------


        /////////////////////////////////////////////////////////////





        ////////job type//////////////////////////////


        recyclerView_Jobtype=findViewById(R.id.rcvw_job_type);

        recyclerView_Jobtype.setClickable(true);

        JobType_arrayList=new ArrayList<>();

        JobType_Adapter.JobType_OnNoteListener jobType_onNoteListener=this;





        //JobType_arrayList.add(new JobType_Item("Agro (Plant/Animal/Fisheries)"));






        Retrofit retrofitJobType=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderJobcatagory jsonPlaceHolderJobcatagory=retrofit.create(JsonPlaceHolderJobcatagory.class);

        Call<List<PostCatagory>> callJobType= jsonPlaceHolderJobcatagory.getPostCatagory();

        callJobType.enqueue(new Callback<List<PostCatagory>>() {
            @Override
            public void onResponse(Call<List<PostCatagory>> call, Response<List<PostCatagory>> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    List<PostCatagory> posts=response.body();

                    for (PostCatagory postJC:posts)
                    {
                        //ttl+=post.getJobTitle().toString()+"\n";

                        JobType_arrayList.add(new JobType_Item(postJC.getName()));



                        jobType_adapter= new JobType_Adapter(JobType_arrayList,jobType_onNoteListener);
                        jobType_layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
                        recyclerView_Jobtype.setAdapter(jobType_adapter);
                        recyclerView_Jobtype.setLayoutManager(jobType_layoutManager);



                    }


                }
            }

            @Override
            public void onFailure(Call<List<PostCatagory>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });










//        jobType_adapter= new JobType_Adapter(JobType_arrayList,jobType_onNoteListener);
//        jobType_layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
//        recyclerView_Jobtype.setAdapter(jobType_adapter);
//        recyclerView_Jobtype.setLayoutManager(jobType_layoutManager);








        /////Job Type///////////////////////////







        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayList=new ArrayList<>();




//        arrayList.add(new Item(".Net Developer","Febco.inc","this is a development related job","1/5/23","Dhanmondi, Dhaka","2","12000","MSc. In Computer Science",
//                "Mobile app development","https://i.ibb.co/GR3GzKw/logo-08.png"));





//                adapter=new Adapter(arrayList,onNoteListener,Home_page.this);
//        layoutManager=new LinearLayoutManager(getApplicationContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(layoutManager);





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
        String PosterEmail=item.Poster_Email;
        String JobCatagory=item.Job_Catagory;


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
        intent.putExtra("id",item.id);
        intent.putExtra("PosterEmail",PosterEmail);
        intent.putExtra("JobCatagory",JobCatagory);
        startActivity(intent);





        return null;
    }


    public void share(Context context){
        Intent shr=new Intent();
        shr.setAction(Intent.ACTION_SEND);
        shr.putExtra(Intent.EXTRA_TEXT,"Download Now : https://play.google.com/store/apps/details?id="+context.getPackageName());
        shr.setType("text/plain");
        context.startActivity(shr);
        //getApplicationContext().startActivity(shr);
    }


    @Override
    public Void onNoteclick(int position) {


        return null;
    }






//    public void openDialog() {
//        ExampleDialog exampleDialog = new ExampleDialog();
//        exampleDialog.show(getSupportFragmentManager(), "example dialog");
//    }

    public void showAlertDialogButtonClicked() {
        // Create an alert builder
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Search a job");

        // set the custom layout
        final View customLayout = getLayoutInflater().inflate(R.layout.search_alert_dialog, null);
        builder.setView(customLayout);

        // add a button
        builder.setPositiveButton("Search", (dialog, which) -> {
            // send data from the AlertDialog to the Activity
            EditText editText = customLayout.findViewById(R.id.edit_search);
            sendDialogDataToActivity(editText.getText().toString());
            filter(editText.getText().toString());
        }).setNegativeButton("Cancel", (dialog, which) -> {
            // send data from the AlertDialog to the Activity
//            EditText editText = customLayout.findViewById(R.id.edit_search);
//            sendDialogDataToActivity(editText.getText().toString());
        });
        // create and show the alert dialog
        AlertDialog dialog = builder.create();
        dialog.show();
    }

    // Do something with the data coming from the AlertDialog
    private void sendDialogDataToActivity(String data) {
        Toast.makeText(this, data, Toast.LENGTH_SHORT).show();
    }





    private void filter(String text) {
        // creating a new array list to filter our data.
        ArrayList<Item> filteredlist = new ArrayList<Item>();


        Adapter.OnNoteListener onListener=this;

        // running a for loop to compare elements.
        for (Item itm : arrayList) {
            // checking if the entered string matched with any item of our recycler view.
            if (itm.jobTitle.toLowerCase().contains(text.toLowerCase())||itm.employerName.toLowerCase().contains(text.toLowerCase())) {
                // if the item is matched we are
                // adding it to our filtered list.

                filteredlist.add(new Item(itm.id, itm.Poster_Email,itm.Job_Catagory,itm.jobTitle,itm.employerName,itm.jobDescription,itm.deadLine,itm.joblocation,itm.vacancy,itm.salary,itm.educationalQualification,
                        itm.jobResponsiblity,itm.logoURL));


            }
        }
        if (filteredlist.isEmpty()) {


            // if no item is added in filtered list we are
            // displaying a toast message as no data found.
            Toast.makeText(this, "No Data Found..", Toast.LENGTH_SHORT).show();
        } else {
            arrayList=filteredlist;
            adapter=new Adapter(arrayList,onListener,Home_page.this);
            layoutManager=new LinearLayoutManager(getApplicationContext());
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);

        }
    }



    public void note(){

        Toast.makeText(getApplicationContext(),"clicked",Toast.LENGTH_SHORT).show();

        NotificationCompat.Builder builder = new NotificationCompat.Builder(this, CHANNEL_ID)
                .setSmallIcon(R.drawable.logo)
                .setContentTitle("Message")
                .setContentText("this is a sample message")
                .setPriority(NotificationCompat.PRIORITY_DEFAULT);

        NotificationManagerCompat notificationManager = NotificationManagerCompat.from(this);

// notificationId is a unique int for each notification that you must define
        notificationManager.notify(100, builder.build());

    }















}