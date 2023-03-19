package com.careers.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

import org.jetbrains.annotations.Nullable;

public class registration_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener{

    Spinner loginSpiner;
    ImageView roundedImageView;
    EditText email,password,name,phoneNumber,confirmPassword;
    Button register;
    int role=0;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);


        //getSupportActionBar().setTitle("Registration");
        roundedImageView=findViewById(R.id.imz);
        register=findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);
        name=findViewById(R.id.name);
        phoneNumber=findViewById(R.id.phoneNumber);
        confirmPassword=findViewById(R.id.confirmPassword);

        roundedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagechooser();
            }
        });




        loginSpiner=findViewById(R.id.loginSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.number,
                //android.R.layout.simple_spinner_item,
                R.layout.spinner_text
        );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginSpiner.setAdapter(adapter);

        loginSpiner.setOnItemSelectedListener(this);




        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String mail=email.getText().toString();
                String pass=password.getText().toString();

                if(mail.isEmpty())
                {
                    email.setError("Enter email address");
                    email.setFocusable(true);
                    return;
                }
                else if(pass.isEmpty())
                {
                    password.setError("Enter password");
                    password.setFocusable(true);
                    return;

                }
                else if(name.getText().toString().isEmpty())
                {
                    name.setError("Enter name");
                    name.setFocusable(true);
                    return;

                }
                else if(phoneNumber.getText().toString().isEmpty())
                {
                    phoneNumber.setError("Enter phone number");
                    phoneNumber.setFocusable(true);
                    return;

                }
                else if(confirmPassword.getText().toString().isEmpty())
                {
                    confirmPassword.setError("Enter password");
                    confirmPassword.setFocusable(true);
                    return;

                }
                else if(!confirmPassword.getText().toString().matches(pass))
                {
                    confirmPassword.setError("password didn't match password");
                    confirmPassword.setFocusable(true);
                    return;

                }
                else if(role==0){
                    Toast.makeText(getApplicationContext(), "Select role", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    Register(mail,pass);
                }














            }
        });








    }


    ///////////////////////////////////

//    @Override
//    public void onRequestPermissionsResult(int requestCode, String[] permissions, int[] grantResults) {
//        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
//
//        // Forward results to EasyPermissions
//        EasyPermissions.onRequestPermissionsResult(requestCode, permissions, grantResults, this);
//    }
//
//    @Override
//    public void onPermissionsGranted(int requestCode, List<String> list) {
//        // Some permissions have been granted
//        // ...
//    }
//
//    @Override
//    public void onPermissionsDenied(int requestCode, List<String> list) {
//        // Some permissions have been denied
//        // ...
//    }
//


    /////////////////////////////////

    public void Register(String email,String password){

        mAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {
                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "createUserWithEmail:success");
                            Toast.makeText(registration_page.this, "Registration successful", Toast.LENGTH_SHORT).show();
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent=new Intent(getApplicationContext(),Home_page.class);
                            startActivity(intent);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Registra failed.",
                                    Toast.LENGTH_SHORT).show();
                            //updateUI(null);
                        }
                    }


//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                    }
                });

    }



    //////////////////////////////////////





    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {


        role=position;

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void imagechooser(){

        Intent intent=new Intent();
        intent.setType("image/*");
        intent.setAction(Intent.ACTION_GET_CONTENT);
        startActivityForResult(intent,1001);

    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == 1001 && resultCode==RESULT_OK)
        {
            roundedImageView.setImageURI(data.getData());

        }
    }
}