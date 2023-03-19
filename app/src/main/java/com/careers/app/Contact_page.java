package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Contact_page extends AppCompatActivity {

    TextView tv,phn,email;
    String phone="+8801832059211";
    String mail="parvez.devsgig@gmail.com";
    String Address="MAG House, House#20,\nShah Mokhdum Avenue, Sector#11\n, Uttara, Dhaka-1230, Bangladesh";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_page);

        tv=findViewById(R.id.address);
        phn=findViewById(R.id.phone_numb);
        email=findViewById(R.id.email_address);

        phn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                callTo();
            }
        });
        email.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mailTo();
            }
        });


        tv.setText("Address : "+Address);
        phn.setText("Phone : "+phone);
        email.setText("Email : "+mail);

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