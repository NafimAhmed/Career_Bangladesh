package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.ArrayList;

public class FAQs_paage extends AppCompatActivity implements Adapter_FAQs.OnNoteListener {

    RecyclerView recyclerView_faq;
    Adapter_FAQs adapterFAQs;
    ArrayList<FAQ_Items> faq_arrayList;
    RecyclerView.LayoutManager layoutManager,jobType_layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_faqs_paage);

        recyclerView_faq=findViewById(R.id.faqrcvw);

        recyclerView_faq.setClickable(true);

        faq_arrayList=new ArrayList<>();

        Adapter_FAQs.OnNoteListener faq_onNoteListener=  this;


        faq_arrayList.add(new FAQ_Items(" how to apply for a Job ????","see the tutorial"));
        faq_arrayList.add(new FAQ_Items("how to Post a job ????","see the tutorial"));
        faq_arrayList.add(new FAQ_Items("how to Make resume ????","see the tutorial"));
        faq_arrayList.add(new FAQ_Items("how to Update resume ????","see the tutorial"));
        faq_arrayList.add(new FAQ_Items("how to Download resume ????","see the tutorial"));



        adapterFAQs =new Adapter_FAQs(faq_arrayList,faq_onNoteListener);
        layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView_faq.setAdapter(adapterFAQs);
        recyclerView_faq.setLayoutManager(layoutManager);






    }


    @Override
    public Void onNoteclick(int position) {
        return null;
    }
}