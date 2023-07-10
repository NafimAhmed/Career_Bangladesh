package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Apply_contact extends AppCompatActivity {

    TextView callTo,mailTo,nam,adrss;

    String phone="";
    String mail="";
    String Add="";
    String naam="";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_contact);

        Bundle extras = getIntent().getExtras();
        phone=extras.getString("Phone");
        mail=extras.getString("Email");
        Add=extras.getString("Address");
        naam=extras.getString("Name");


        callTo=findViewById(R.id.callTo);
        mailTo=findViewById(R.id.mailTo);
        adrss=findViewById(R.id.adrss);
        nam=findViewById(R.id.naam);

        nam.setText(naam);
        adrss.setText(Add);
        callTo.setText(phone);
        mailTo.setText(mail);




        mailTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailTo();
            }
        });



        callTo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTo();
            }
        });



    }

    public void mailTo(){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"+mail));
        //emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Career support");
        startActivity(Intent.createChooser(emailIntent, "Send feedback"));
    }


    public void callTo(){
        //String phone = "+34666777888";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }


}