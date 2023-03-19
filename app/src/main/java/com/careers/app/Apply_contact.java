package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Apply_contact extends AppCompatActivity {

    TextView callTo,mailTo;

    String phone="+8801797609439";
    String mail="recentnafimahmed@gmail.com";
    String Address="MAG House, House#20,\nShah Mokhdum Avenue, Sector#11\n, Uttara, Dhaka-1230, Bangladesh";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_apply_contact);


        callTo=findViewById(R.id.callTo);
        mailTo=findViewById(R.id.mailTo);
        mailTo=findViewById(R.id.mailTo);

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