package com.careers.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

import java.util.regex.Pattern;

public class forgot_password extends AppCompatActivity {

    EditText edtx;
    Button mail;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtx=findViewById(R.id.edtx);
        mail=findViewById(R.id.mail);
        mail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edtx.getText().toString().isEmpty())
                {
                    Toast.makeText(getApplicationContext(),"Please Enter a email address",Toast.LENGTH_SHORT).show();
                    return;

                }
                else if(!Patterns.EMAIL_ADDRESS.matcher(edtx.getText().toString()).matches()){
                    Toast.makeText(forgot_password.this, "Please enter a valied email address", Toast.LENGTH_SHORT).show();
                    return;
                }
                else{
                    sendMail();
                }


            }
        });
    }

    public void sendMail(){

        String email=edtx.getText().toString().trim();



        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {



                AlertDialog.Builder builder = new AlertDialog.Builder(forgot_password.this);

                // Set the message show for the Alert time
                builder.setMessage(" A Password resetting link has been sent to your mail. Please checkout the mail to change or reset password");

                // Set Alert Title
                builder.setTitle("Alert !");

                // Set Cancelable false for when the user clicks on the outside the Dialog Box then it will remain show
                builder.setCancelable(false);

                // Set the positive button with yes name Lambda OnClickListener method is use of DialogInterface interface.
                builder.setPositiveButton("Ok", (DialogInterface.OnClickListener) (dialog, which) -> {
                    // When the user click yes button then app will close
                    finish();
                });

                // Set the Negative button with No name Lambda OnClickListener method is use of DialogInterface interface.


                // Create the Alert dialog
                AlertDialog alertDialog = builder.create();
                // Show the Alert Dialog box
                alertDialog.show();



            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                Toast.makeText(getApplicationContext(), "Something wrong. Please try again", Toast.LENGTH_SHORT).show();
                return;

            }
        });






    }


}