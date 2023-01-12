package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Login_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tvRegister;
    EditText editTextEmail, editTextPassword;
    Button btnLogin;
    int roleID=0;
    Spinner loginSpiner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);

        tvRegister=findViewById(R.id.signupTxt);
        editTextEmail=findViewById(R.id.loginEmail);
        editTextPassword=findViewById(R.id.loginPassword);
        btnLogin=findViewById(R.id.loginBtn);


        loginSpiner=findViewById(R.id.loginSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.number, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginSpiner.setAdapter(adapter);
        loginSpiner.setOnItemSelectedListener(this);

        btnLogin.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {
                if(roleID>0)
                {
                    if(roleID==1){

                        Intent intent=new Intent(getApplicationContext(),Home_page.class);
                        startActivity(intent);

                    }
                    else{
                        Intent intent=new Intent(getApplicationContext(),Employer_Home_page.class);
                        startActivity(intent);

                        Toast.makeText(getApplicationContext(),"Employer section is not ready to use now",Toast.LENGTH_SHORT).show();
                    }
                }
                else{

                    Toast.makeText(getApplicationContext(),"Please select your role",Toast.LENGTH_SHORT).show();
                    loginSpiner.setFocusable(true);


                }

            }
        });



    }

    public void register(View v)
    {
        Intent intent=new Intent(getApplicationContext(),registration_page.class);
        startActivity(intent);
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

        Toast.makeText(getApplicationContext(),Integer.toString(i),Toast.LENGTH_SHORT).show();
        roleID=i;

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }
}