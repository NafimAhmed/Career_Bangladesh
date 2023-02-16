package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.ScrollView;
import android.widget.Toast;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

import org.jetbrains.annotations.Nullable;

public class Employer_profile extends AppCompatActivity {



    ImageView roundedImageView;
    FloatingActionButton btnFloating;
    ScrollView scrlvw;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_employer_profile);

        roundedImageView=findViewById(R.id.roundedImageView);
        scrlvw=findViewById(R.id.scrlvw);
        getSupportActionBar().setTitle("Profile");


        btnFloating=findViewById(R.id.addJob);
        btnFloating.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


//                Intent intent=new Intent(getApplicationContext(),Emplyer_job_Add_Page.class);
//                startActivity(intent);

                Toast.makeText(getApplicationContext(),"Floating is clicked",Toast.LENGTH_SHORT).show();


            }
        });

        scrlvw.setOnScrollChangeListener(new View.OnScrollChangeListener() {
            @Override
            public void onScrollChange(View view, int i, int i1, int i2, int i3) {

                if(i3<i1){

                    btnFloating.hide();

                }
                else if (i3>i1){
                    btnFloating.show();
                }

            }
        });




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