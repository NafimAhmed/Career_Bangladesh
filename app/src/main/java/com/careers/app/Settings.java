package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner languageSpiner;
    TextView changepass;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        languageSpiner =findViewById(R.id.loginSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.language,
                //android.R.layout.simple_spinner_item,
                R.layout.spinner_text
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        languageSpiner.setAdapter(adapter);

        languageSpiner.setOnItemSelectedListener(this);

        changepass=findViewById(R.id.changepass);

        changepass.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                changePass();
            }
        });




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public void changePass(){
        Intent intent=new Intent(getApplicationContext(),forgot_password.class);
        startActivity(intent);
    }
}