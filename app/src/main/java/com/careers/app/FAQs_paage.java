package com.careers.app;

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


        faq_arrayList.add(new FAQ_Items(" Question : how to apply for a Job ????","Answer : see the tutorial"));
        faq_arrayList.add(new FAQ_Items(" Question : how to Post a job ????","Answer : see the tutorial"));
        faq_arrayList.add(new FAQ_Items(" Question : how to Make resume ????","Answer : see the tutorial"));
        faq_arrayList.add(new FAQ_Items(" Question : how to Update resume ????","Answer : see the tutorial"));
        faq_arrayList.add(new FAQ_Items(" Question : how to Download resume ????","Answer : see the tutorial"));



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