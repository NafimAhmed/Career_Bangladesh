package com.nafim.jobportal;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.HideReturnsTransformationMethod;
import android.text.method.PasswordTransformationMethod;
import android.util.Patterns;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class Login_page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView tvRegister;
    EditText editTextEmail, editTextPassword;
    Button btnLogin;
    LinearLayout google_signin;
    int roleID=0;
    Spinner loginSpiner;
    private FirebaseAuth mAuth;

    GoogleSignInOptions gso;
    GoogleSignInClient gsc;

    CheckBox checkbox_showPass;






// ...
// Initialize Firebase Auth



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_page);


        ////////////////////////Google sign in//////////////////////

        google_signin=findViewById(R.id.google_signin);

        gso=new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestEmail()
                .build();
        gsc=GoogleSignIn.getClient(Login_page.this, gso);


        google_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                SignIn();
            }
        });












        ///////////Google Sign in/////////////////////////////////












        tvRegister=findViewById(R.id.signupTxt);
        editTextEmail=findViewById(R.id.loginEmail);
        editTextPassword=findViewById(R.id.loginPassword);
        btnLogin=findViewById(R.id.loginBtn);
        checkbox_showPass=findViewById(R.id.checkbox_showPass);

        ////////////////////////check box//////////////////////////


        checkbox_showPass.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

                if(b){
                    editTextPassword.setTransformationMethod(HideReturnsTransformationMethod.getInstance());
                }
                else{
                    editTextPassword.setTransformationMethod(PasswordTransformationMethod.getInstance());

                }

            }
        });


        ////////////////////////check box///////////////////////////

        loginSpiner=findViewById(R.id.loginSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,
                R.array.number,
                //android.R.layout.simple_spinner_item,
                R.layout.spinner_text
                );
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        loginSpiner.setAdapter(adapter);

        loginSpiner.setOnItemSelectedListener(this);

        btnLogin.setOnClickListener(new View.OnClickListener(
        ) {
            @Override
            public void onClick(View v) {


                if(editTextEmail.getText().toString().isEmpty()){

                    editTextEmail.setError("Enter email address");
                    editTextEmail.setFocusable(true);
                    return;

                }
                else if(editTextPassword.getText().toString().isEmpty()){

                    editTextPassword.setError("Enter password");
                    editTextPassword.setFocusable(true);

                    return;

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(editTextEmail.getText().toString()).matches()){

                    editTextEmail.setError("Enter Correct email address");
                    editTextEmail.setFocusable(true);
                    return;

                }

                else{

                    if(roleID>0)
                    {
                        if(roleID==1){

                            //Intent intent=new Intent(getApplicationContext(),Home_page.class);
                            // startActivity(intent);
                            login(editTextEmail.getText().toString(),editTextPassword.getText().toString(),1);

                        }
                        else{
//                        Intent intent=new Intent(getApplicationContext(),Employer_Home_page.class);
//                        startActivity(intent);

                            login(editTextEmail.getText().toString(),editTextPassword.getText().toString(),2);

                            Toast.makeText(getApplicationContext(),"Employer section is not ready to use now",Toast.LENGTH_SHORT).show();
                        }
                    }
                    else{

                        Toast.makeText(getApplicationContext(),"Please select your role",Toast.LENGTH_SHORT).show();
                        loginSpiner.setFocusable(true);


                    }

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

    public void forgotPass(View view){
        Toast.makeText(getApplicationContext(),"This function is not available yet",Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(getApplicationContext(),forgot_password.class);
        startActivity(intent);
    }


    public void login(String email, String password, int i)
    {
        mAuth = FirebaseAuth.getInstance();

        mAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
                    @Override
                    public void onComplete(@NonNull Task<AuthResult> task) {

                        if (task.isSuccessful()) {
                            // Sign in success, update UI with the signed-in user's information
                            //Log.d(TAG, "signInWithEmail:success");
                            FirebaseUser user = mAuth.getCurrentUser();



                            if(i==1){
                                Intent intent=new Intent(getApplicationContext(),Home_page.class);
                                //Intent intent=new Intent(getApplicationContext(),New_Home.class);
                                startActivity(intent);
                            }
                            else if (i==2){
                                Intent intent=new Intent(getApplicationContext(),Employer_Home_page.class);
                                startActivity(intent);
                            }



                           // updateUI(user);
                        } else {
                            // If sign in fails, display a message to the user.
                            //Log.w(TAG, "signInWithEmail:failure", task.getException());
                            Toast.makeText(getApplicationContext(), "Authentication failed.",
                                    Toast.LENGTH_SHORT).show();
                           // updateUI(null);
                        }

                    }


//                    @Override
//                    public void onComplete(@NonNull Task<AuthResult> task) {
//
//                    }


                });






    }







    public void SignIn(){

        Intent signInIntent=gsc.getSignInIntent();
        startActivityForResult(signInIntent,1000);

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        if(requestCode==1000){


            Task<GoogleSignInAccount> task= GoogleSignIn.getSignedInAccountFromIntent(data);
            Intent intent=new Intent(getApplicationContext(),Home_page.class);
                startActivity(intent);

//            try {
//                task.getResult(ApiException.class);
//                Intent intent=new Intent(getApplicationContext(),Home_page.class);
//                startActivity(intent);
//            } catch (ApiException e) {
//                Toast.makeText(getApplicationContext(),"Some thing is wrong",Toast.LENGTH_SHORT).show();
//                e.printStackTrace();
//            }
        }

    }
}