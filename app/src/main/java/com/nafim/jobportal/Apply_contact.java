package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;

public class Apply_contact extends AppCompatActivity {

    String phone="+8801797609439";
    String mail="recentnafimahmed@gmail.com";
    String Address="MAG House, House#20,\nShah Mokhdum Avenue, Sector#11\n, Uttara, Dhaka-1230, Bangladesh";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_contact);
    }

    public void mailTo(View view){
        Intent emailIntent = new Intent(Intent.ACTION_SENDTO);
        emailIntent.setData(Uri.parse("mailto:"+mail));
        //emailIntent.putExtra(Intent.EXTRA_SUBJECT,"Career support");
        startActivity(Intent.createChooser(emailIntent, "Send feedback"));
    }


    public void callTo(View view){
        //String phone = "+34666777888";
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.fromParts("tel", phone, null));
        startActivity(intent);
    }


}