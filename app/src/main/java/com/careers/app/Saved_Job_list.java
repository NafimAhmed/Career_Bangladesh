package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Tag;

public class Saved_Job_list extends AppCompatActivity implements Adapter.OnNoteListener {





    List<PostSavedJob> posts;
    RecyclerView recyclerView;
    Adapter adapter;




    ArrayList<Item> arrayListSaved;




    RecyclerView.LayoutManager layoutManager;

    //////////////////////////



    //////////////////////////







    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saved_job_list);
        getSupportActionBar().setTitle("Saved job list");



        //////////////////////////////////////////////////




        Intent intent=getIntent();
        String eml=intent.getStringExtra("email");

        /////////////////////////////////////////////////



        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayListSaved =new ArrayList<>();

        Adapter.OnNoteListener onNoteListener=this;


//        arrayList.add(new Item("Android Developer","A Group","this is a development related job","1/5/23","Uttara, Dhaka","2","12000","MSc. In Computer Science",
//                "Software development","https://www.freepnglogos.com/uploads/youtube-logo-hd-8.png"));
//        arrayList.add(new Item("Android Developer","B Group","this is a development related job","1/5/23","Banani, Dhaka","2","12000","MSc. In Computer Science","Node JS development"
//                ,"https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2048px-Google_%22G%22_Logo.svg.png"));
//        arrayList.add(new Item("Android Developer","C Group","this is a development related job","1/5/23","Dhanmondi, Dhaka","2","12000","MSc. In Computer Science",
//                "Mobile app development","https://www.freepnglogos.com/uploads/youtube-logo-hd-8.png"));
//        arrayList.add(new Item("Android Developer","D Group","this is a development related job","1/5/23","Motijheel, Dhaka","2","12000","MSc. In Computer Science",
//                ".NET development","https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2048px-Google_%22G%22_Logo.svg.png"));
//        arrayList.add(new Item("Android Developer","E Group","this is a development related job","1/5/23","Bongshal, Dhaka","2","12000","MSc. In Computer Science","PHP development"
//                ,"https://www.freepnglogos.com/uploads/youtube-logo-hd-8.png"));
//        arrayList.add(new Item("Android Developer","AF Group","this is a development related job","1/5/23","Mirpur 12, Dhaka","2","12000","MSc. In Computer Science",
//                "Software development","https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2048px-Google_%22G%22_Logo.svg.png"));
//        adapter=new Adapter(arrayList,onNoteListener,Saved_Job_list.this);
//        layoutManager=new LinearLayoutManager(getApplicationContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(layoutManager);
//


        /// data retrive //////////////////////////////////////////////////



        /////Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderSavedJob jsonPlaceHolderemp=retrofit.create(JsonPlaceHolderSavedJob.class);

        Call<List<PostSavedJob>> call= jsonPlaceHolderemp.getPost("/jobseekersavedjobs?email="+eml);

        call.enqueue(new Callback<List<PostSavedJob>>() {
            @Override
            public void onResponse(Call<List<PostSavedJob>> call, Response<List<PostSavedJob>> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                     posts=response.body();

                    for (PostSavedJob post:posts)
                    {

                        arrayListSaved.add(new Item(post.getJobID(),post.getPostersEmail(),post.getCategory(),post.getJobTitle(),post.getOrganization(),post.getJobID(),"1/5/23","Mirpur 12, Dhaka","2","12000","MSc. In Computer Science",
                                "Software development","https://upload.wikimedia.org/wikipedia/commons/thumb/5/53/Google_%22G%22_Logo.svg/2048px-Google_%22G%22_Logo.svg.png"));


                        adapter=new Adapter(arrayListSaved,onNoteListener,Saved_Job_list.this);
                        layoutManager=new LinearLayoutManager(getApplicationContext());
                        recyclerView.setAdapter(adapter);
                        recyclerView.setLayoutManager(layoutManager);
                    }






                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<List<PostSavedJob>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();







        ////Data retrive//////////////////////////////////////////






        /// Data retrive ///////////////////////////////////////////////







    }

    @Override
    public Void onNoteclicl(int position) {


        /////Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com


        String jobID="640ed1085e671c6b71a39738";
        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app/jobs/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderSavedJob jsonPlaceHolderemp=retrofit.create(JsonPlaceHolderSavedJob.class);

        Call<PostJobDetail> call= jsonPlaceHolderemp.getPostjobDetail(jobID);

        call.enqueue(new Callback<PostJobDetail>() {
            @Override
            public void onResponse(Call<PostJobDetail> call, Response<PostJobDetail> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    PostJobDetail postJobDetail=response.body();


                    Item item= arrayListSaved.get(position);
                    String jobTitle=postJobDetail.getJobTitle();
                    String employer=postJobDetail.getOrganization();
                    String location=postJobDetail.getLocation();
                    String vacancy= postJobDetail.getVacancies();
                    String salary= postJobDetail.getSalaryFrom()+ "to" +postJobDetail.getSalaryTo();
                    String jbResponsiblity=postJobDetail.getJobResponst();
                    String jbdescription=postJobDetail.getJobContext()+postJobDetail.getBusinessDescription();
                    String deadLine=postJobDetail.getDeadLine();
                    String educationalQualification=postJobDetail.getEducation()+ "\n Experience Required : "+postJobDetail.getExperience();


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
                    intent.putExtra("img",postJobDetail.getCompanyLogo());
                    intent.putExtra("jobid",jobID);
                    startActivity(intent);

                    // Log.e("TAG",posts.get(position).jobID);






                }


//                Toast.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<PostJobDetail> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });

        //.makeText(getApplicationContext(),posts.get(1).getJobID(),Toast.LENGTH_SHORT).show();







        ////Data retrive//////////////////////////////////////////




















        return null;
    }
}