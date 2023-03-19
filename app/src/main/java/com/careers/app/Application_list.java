package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;

import java.util.ArrayList;

public class Application_list extends AppCompatActivity implements Adapter_FAQs.OnNoteListener{

    RecyclerView recyclerView_faq;
    Adapter_FAQs adapterFAQs;
    ArrayList<FAQ_Items> faq_arrayList;
    RecyclerView.LayoutManager layoutManager,jobType_layoutManager;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_application_list);





        recyclerView_faq=findViewById(R.id.faqrcvw);

        recyclerView_faq.setClickable(true);

        faq_arrayList=new ArrayList<>();

        Adapter_FAQs.OnNoteListener faq_onNoteListener=  this;


        faq_arrayList.add(new FAQ_Items("Name : Nafim Ahmed","CV ID : 123456789"));
        faq_arrayList.add(new FAQ_Items("Name : Asad Hossain","CV ID : 123456789"));
        faq_arrayList.add(new FAQ_Items("Name : Amina Aziz","CV ID : 123456789"));
        faq_arrayList.add(new FAQ_Items("Name : Nafisa Afnan","CV ID : 123456789"));
        faq_arrayList.add(new FAQ_Items("Name : Amir Ahmed","CV ID : 123456789"));


        adapterFAQs =new Adapter_FAQs(faq_arrayList,faq_onNoteListener);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView_faq.setAdapter(adapterFAQs);
        recyclerView_faq.setLayoutManager(layoutManager);






    }

    @Override
    public Void onNoteclick(int position) {

        Intent i=new Intent(getApplicationContext(),Application_detail.class);
        //i.putExtra("button_visible",false);
        startActivity(i);

        return null;


    }
}