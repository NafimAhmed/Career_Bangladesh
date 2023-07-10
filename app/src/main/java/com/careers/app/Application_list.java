package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Application_list extends AppCompatActivity implements Adapter_Applicant.OnNoteListener{

    RecyclerView recyclerView_faq;
    Adapter_Applicant adapterFAQs;
    ArrayList<Applicant_Item> faq_arrayList;
    RecyclerView.LayoutManager layoutManager,jobType_layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_list);

        Intent i=getIntent();
        String id=i.getStringExtra("id");


        recyclerView_faq=findViewById(R.id.faqrcvw);

        recyclerView_faq.setClickable(true);

        faq_arrayList=new ArrayList<>();

        Adapter_Applicant.OnNoteListener faq_onNoteListener=  this;





        /////Data retrive///////////////////////////https://careers-bangladesh-server.vercel.app/postedjob?email=jahid@gmail.com


        Retrofit retrofit=new Retrofit.Builder()
                .baseUrl("https://careers-bangladesh-server.vercel.app")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        JsonPlaceHolderApplicant jsonPlaceHolderapp=retrofit.create(JsonPlaceHolderApplicant.class);

        Call<List<PostApplicat>> call= jsonPlaceHolderapp.getPostApplicant("/jobapplicant?jobId="+id);

        call.enqueue(new Callback<List<PostApplicat>>() {
            @Override
            public void onResponse(Call<List<PostApplicat>> call, Response<List<PostApplicat>> response) {

                Toast.makeText(getApplicationContext(),"resp code :"+response.code(),Toast.LENGTH_SHORT).show();
                if(response.isSuccessful())
                {
                    List<PostApplicat> posts=response.body();



                    for (PostApplicat post:posts)
                    {

                        faq_arrayList.add(new Applicant_Item(post.getID(),post.getName(),post.getEmail()));


                        adapterFAQs =new Adapter_Applicant(faq_arrayList,faq_onNoteListener);
                        layoutManager=new LinearLayoutManager(getApplicationContext());
                        recyclerView_faq.setAdapter(adapterFAQs);
                        recyclerView_faq.setLayoutManager(layoutManager);

                    }


                }
            }

            @Override
            public void onFailure(Call<List<PostApplicat>> call, Throwable t) {

                Toast.makeText(getApplicationContext(),"resp code :"+t.getMessage(),Toast.LENGTH_SHORT).show();


            }
        });






        ////Data retrive//////////////////////////////////////////









//        faq_arrayList.add(new FAQ_Items("Name : Nafim Ahmed","CV ID : 123456789"));
//        faq_arrayList.add(new FAQ_Items("Name : Asad Hossain","CV ID : 123456789"));
//        faq_arrayList.add(new FAQ_Items("Name : Amina Aziz","CV ID : 123456789"));
//        faq_arrayList.add(new FAQ_Items("Name : Nafisa Afnan","CV ID : 123456789"));
//        faq_arrayList.add(new FAQ_Items("Name : Amir Ahmed","CV ID : 123456789"));
//
//
//        adapterFAQs =new Adapter_FAQs(faq_arrayList,faq_onNoteListener);
//        layoutManager=new LinearLayoutManager(getApplicationContext());
//        recyclerView_faq.setAdapter(adapterFAQs);
//        recyclerView_faq.setLayoutManager(layoutManager);






    }

    @Override
    public Void onNoteclick(int position) {

        Intent i=new Intent(getApplicationContext(),Application_detail.class);
       // i.putExtra("button_visible",false);

        Applicant_Item applicant_item=faq_arrayList.get(position);

        String eml=applicant_item.getEmail();
        i.putExtra("Email",eml);

        startActivity(i);

        return null;


    }
}