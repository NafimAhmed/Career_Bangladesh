package com.nafim.jobportal;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.FirebaseAuth;

public class forgot_password extends AppCompatActivity {

    EditText edtx;
    FirebaseAuth m;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forgot_password);

        edtx=findViewById(R.id.edtx);
    }

    public void sendMail(View view){

        String email=edtx.getText().toString().trim();



        FirebaseAuth.getInstance().sendPasswordResetEmail(email).addOnSuccessListener(new OnSuccessListener<Void>() {
            @Override
            public void onSuccess(Void unused) {

            }
        }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

            }
        });





        //String email = "user@example.com";
//        try {
//            String link = FirebaseAuth.getInstance().generatePasswordResetLink(
//                    email, actionCodeSettings);
//            // Construct email verification template, embed the link and send
//            // using custom SMTP server.
//            sendCustomEmail(email, displayName, link);
//        } catch (FirebaseAuthException e) {
//            System.out.println("Error generating email link: " + e.getMessage());
//        }
//                m.sendPasswordResetEmail(email).addOnCompleteListener(new OnCompleteListener<Void>() {
//
//            @Override
//            public void onComplete(@NonNull Task<Void> task) {
//               // loadingBar.dismiss();
//                if(task.isSuccessful())
//                {
//                    // if isSuccessful then done message will be shown
//                    // and you can change the password
//                    Toast.makeText(forgot_password.this,"Done sent",Toast.LENGTH_LONG).show();
//                }
//                else {
//                    Toast.makeText(forgot_password.this,"Error Occurred",Toast.LENGTH_LONG).show();
//                }
//            }
//        }).addOnFailureListener(new OnFailureListener() {
//            @Override
//            public void onFailure(@NonNull Exception e) {
//                //loadingBar.dismiss();
//                Toast.makeText(forgot_password.this,"Error Failed",Toast.LENGTH_LONG).show();
//            }
//        });
    }


}