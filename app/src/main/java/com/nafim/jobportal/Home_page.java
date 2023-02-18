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

public class Home_page extends AppCompatActivity implements Adapter.OnNoteListener, JobType_Adapter.JobType_OnNoteListener,ExampleDialog.ExampleDialogListener{

    RecyclerView recyclerView,recyclerView_Jobtype;
    Adapter adapter;
    JobType_Adapter jobType_adapter;
    EditText jobSearch;

    LinearLayout searchLayout;

    ArrayList<Item> arrayList;
    ArrayList<JobType_Item> JobType_arrayList;



    RecyclerView.LayoutManager layoutManager,jobType_layoutManager;

    //////////////////////////

    DrawerLayout drawerLayout;
    NavigationView navigationView;
    ActionBarDrawerToggle toggle;

    ImageView imageMenu;

    //////////////////////////




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);
//        getSupportActionBar().setTitle("Job List");

        /////////////////////////////////////////

        DisplayMetrics displayMetrics = new DisplayMetrics();
        getWindowManager().getDefaultDisplay().getMetrics(displayMetrics);
        int height = displayMetrics.heightPixels;
        int width = displayMetrics.widthPixels;

        jobSearch=findViewById(R.id.jobSearch);

        jobSearch.setWidth(width-250);



        ////////////////////////////////





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
                        startActivity(savedJobpage);
                        drawerLayout.closeDrawers();
                        break;

                    case R.id.edit_profile:
                        Toast.makeText(Home_page.this, "Facebook", Toast.LENGTH_SHORT).show();
                        Intent in=new Intent(getApplicationContext(),Profile_Page.class);
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





        //////////////////////////////////////


        recyclerView_Jobtype=findViewById(R.id.rcvw_job_type);

        recyclerView_Jobtype.setClickable(true);

        JobType_arrayList=new ArrayList<>();

        JobType_Adapter.JobType_OnNoteListener jobType_onNoteListener=this;

        JobType_arrayList.add(new JobType_Item("Bank/Non-Bank Fin. Institution"));
        JobType_arrayList.add(new JobType_Item("Accounting/Finance"));
        JobType_arrayList.add(new JobType_Item("Education/Training"));
        JobType_arrayList.add(new JobType_Item("Garments/Textile"));
        JobType_arrayList.add(new JobType_Item("HR/Org. Development"));

        JobType_arrayList.add(new JobType_Item("Design/Creative"));
        JobType_arrayList.add(new JobType_Item("IT & Telecommunication"));
        JobType_arrayList.add(new JobType_Item("Marketing/Sales"));
        JobType_arrayList.add(new JobType_Item("Media/Ad./Event Mgt."));
        JobType_arrayList.add(new JobType_Item("Law/Legal"));

        JobType_arrayList.add(new JobType_Item("Electrician/Construction/Repair"));
        JobType_arrayList.add(new JobType_Item("Research/Consultancy"));
        JobType_arrayList.add(new JobType_Item("Production/Operation"));
        JobType_arrayList.add(new JobType_Item("Beauty Care/ Health & Fitness"));
        JobType_arrayList.add(new JobType_Item("Hospitality/ Travel/ Tourism"));

        JobType_arrayList.add(new JobType_Item("Data Entry/Operator/BPO"));
        JobType_arrayList.add(new JobType_Item("FHR/Org. Development"));
        JobType_arrayList.add(new JobType_Item("Customer Service/Call Centre"));
        JobType_arrayList.add(new JobType_Item("Gen Mgt/Admin"));
        JobType_arrayList.add(new JobType_Item(" Secretary/Receptionist"));

        JobType_arrayList.add(new JobType_Item("Driving/Motor Technician"));
        JobType_arrayList.add(new JobType_Item("Commercial"));
        JobType_arrayList.add(new JobType_Item("Agro (Plant/Animal/Fisheries)"));






        jobType_adapter= new JobType_Adapter(JobType_arrayList,jobType_onNoteListener);
        jobType_layoutManager=new LinearLayoutManager(getApplicationContext(),LinearLayoutManager.HORIZONTAL,false);
        recyclerView_Jobtype.setAdapter(jobType_adapter);
        recyclerView_Jobtype.setLayoutManager(jobType_layoutManager);






        ////////////////////////////////







        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayList=new ArrayList<>();

        Adapter.OnNoteListener onNoteListener=this;


        arrayList.add(new Item("Flutter Developer","Neat.inc","this is a development related job","1/5/23","Uttara, Dhaka","2","12000","MSc. In Computer Science",
                "Software development","https://i.ibb.co/MpKCcWf/logo-01.png"));
        arrayList.add(new Item("Android Developer","Gorgious Bangladesh Limited.","this is a development related job","1/5/23","Banani, Dhaka","2","12000","MSc. In Computer Science","Node JS development"
                ,"https://i.ibb.co/djkwb8Y/gbl-logo.png"));
        arrayList.add(new Item(".Net Developer","Cocacola.inc","this is a development related job","1/5/23","Dhanmondi, Dhaka","2","12000","MSc. In Computer Science",
                "Mobile app development","https://i.ibb.co/4j1RBt3/logo-02.png"));
        arrayList.add(new Item("Anguler Developer","Google.inc","this is a development related job","1/5/23","Motijheel, Dhaka","2","12000","MSc. In Computer Science",
                ".NET development","https://i.ibb.co/xCQnZzX/logo-04.png"));
        arrayList.add(new Item("Python Developer","BSA.inc","this is a development related job","1/5/23","Bongshal, Dhaka","2","12000","MSc. In Computer Science","PHP development"
                ,"https://i.ibb.co/4PNrtb0/logo-05.png"));
        arrayList.add(new Item("HR","TravelGenies.inc","this is a development related job","1/5/23","Mirpur 12, Dhaka","2","12000","MSc. In Computer Science",
                "Software development","https://i.ibb.co/k1SF5JP/logo-06.png"));

        arrayList.add(new Item("Flutter Developer","Twitter.inc","this is a development related job","1/5/23","Uttara, Dhaka","2","12000","MSc. In Computer Science",
                "Software development","https://i.ibb.co/xDL6W5q/logo-07.png"));
        arrayList.add(new Item("Android Developer","Facebook.Inc","this is a development related job","1/5/23","Banani, Dhaka","2","12000","MSc. In Computer Science","Node JS development"
                ,"https://i.ibb.co/GR3GzKw/logo-08.png"));
        arrayList.add(new Item(".Net Developer","Febco.inc","this is a development related job","1/5/23","Dhanmondi, Dhaka","2","12000","MSc. In Computer Science",
                "Mobile app development","https://i.ibb.co/WNhwDdN/logo-09.png"));
        //arrayList.add(new Item("Anguler Developer","Google.inc","this is a development related job","1/5/23","Motijheel, Dhaka","2","12000","MSc. In Computer Science",

        arrayList.add(new Item("Flutter Developer","Twitter.inc","this is a development related job","1/5/23","Uttara, Dhaka","2","12000","MSc. In Computer Science",
                "Software development","https://i.ibb.co/HDt1LPP/logo-10.png"));
        arrayList.add(new Item("Android Developer","Facebook.Inc","this is a development related job","1/5/23","Banani, Dhaka","2","12000","MSc. In Computer Science","Node JS development"
                ,"https://i.ibb.co/WNhwDdN/logo-09.png"));
        arrayList.add(new Item(".Net Developer","Febco.inc","this is a development related job","1/5/23","Dhanmondi, Dhaka","2","12000","MSc. In Computer Science",
                "Mobile app development","https://i.ibb.co/GR3GzKw/logo-08.png"));





                adapter=new Adapter(arrayList,onNoteListener,Home_page.this);
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




    public void search_Visible(View view){

        openDialog();



//        if (searchLayout.getVisibility()== View.VISIBLE) {
//
//
//
//            searchLayout.setVisibility(View.GONE);
//        } else {
//
//            searchLayout.setVisibility(View.VISIBLE);
//        }



    }

    public void openDialog() {
        ExampleDialog exampleDialog = new ExampleDialog();
        exampleDialog.show(getSupportFragmentManager(), "example dialog");
    }


    @Override
    public void applyTexts(String username) {

    }
}