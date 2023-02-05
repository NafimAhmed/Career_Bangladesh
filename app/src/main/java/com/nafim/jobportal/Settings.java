package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Settings extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    Spinner loginSpiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_settings);



        loginSpiner=findViewById(R.id.loginSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.language,
                //android.R.layout.simple_spinner_item,
                R.layout.spinner_text
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginSpiner.setAdapter(adapter);

        loginSpiner.setOnItemSelectedListener(this);




    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}