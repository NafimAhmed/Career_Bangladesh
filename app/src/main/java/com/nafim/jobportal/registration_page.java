package com.nafim.jobportal;

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
    EditText email,password;
    Button register;
    FirebaseAuth mAuth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registration_page);


        getSupportActionBar().setTitle("Registration");
        roundedImageView=findViewById(R.id.imz);
        register=findViewById(R.id.register);

        mAuth = FirebaseAuth.getInstance();
        email=findViewById(R.id.email);
        password=findViewById(R.id.password);




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

                Register(mail,pass);





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
                            FirebaseUser user = mAuth.getCurrentUser();
                            Intent intent=new Intent(getApplicationContext(),Home_page.class);
                            startActivity(intent);
                            //updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "createUserWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
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

    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void imagechooser(View view){

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