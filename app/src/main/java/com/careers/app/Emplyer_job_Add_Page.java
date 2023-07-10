package com.careers.app;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;


import android.app.DatePickerDialog;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.drawable.BitmapDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.util.Base64;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;
import com.google.firebase.storage.UploadTask;
import com.google.firebase.storage.internal.StorageReferenceUri;

import org.jetbrains.annotations.Nullable;

import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Locale;

public class Emplyer_job_Add_Page extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


    DatePickerDialog picker;
    String base64;

    StorageReference storageReference;

    ImageView roundedImageView;
    Spinner jobTypeSpiner;
    TextView deadline;
    Uri uri;
    String CompanyLogao;

    EditText empjobTitle,empjobLevel,BusinesDesciption,JobContext,workPlace,SalaryReview,Others,yearlyBonus,Salaryto,CompanySize,Experience,PostDate,organizationType,OrganizationName,employerName,empJobdescription,empjobLocation,empjobvacancy,emp_educationalQualification,empJobResponsiblity,Salary;
    Button confirmBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_emplyer_job_add_page);

        getSupportActionBar().setTitle("Post a new job");

        ////////////////////////////



        ////////////////////////


        jobTypeSpiner=findViewById(R.id.jobTypeSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.Job_type, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        jobTypeSpiner.setAdapter(adapter);
        jobTypeSpiner.setOnItemSelectedListener(this);
        employerName=findViewById(R.id.employerName);
        empjobTitle=findViewById(R.id.empjobTitle);
        empJobdescription=findViewById(R.id.empJobdescription);
        empjobvacancy=findViewById(R.id.empjobvacancy);
        empjobLocation=findViewById(R.id.empjobLocation);
        empjobLocation.setVerticalScrollBarEnabled(true);
        emp_educationalQualification=findViewById(R.id.emp_educationalQualification);
        empJobResponsiblity=findViewById(R.id.empJobResponsiblity);
        Salary=findViewById(R.id.Salary);
        roundedImageView=findViewById(R.id.imz);
        deadline=findViewById(R.id.deadline);
        OrganizationName=findViewById(R.id.OrganizationName);
        organizationType=findViewById(R.id.organizationType);
        PostDate=findViewById(R.id.PostDate);
        Experience=findViewById(R.id.Experience);
        Salaryto=findViewById(R.id.Salaryto);
        yearlyBonus=findViewById(R.id.yearlyBonus);
        CompanySize=findViewById(R.id.CompanySize);
        Others=findViewById(R.id.Others);
        SalaryReview=findViewById(R.id.SalaryReview);
        workPlace=findViewById(R.id.workPlace);
        JobContext=findViewById(R.id.JobContext);
        BusinesDesciption=findViewById(R.id.BusinesDesciption);
        empjobLevel=findViewById(R.id.empjobLevel);




        roundedImageView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imagechooser();
            }
        });


        /////////////////////////////

        deadline.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final Calendar cldr = Calendar.getInstance();
                int day = cldr.get(Calendar.DAY_OF_MONTH);
                int month = cldr.get(Calendar.MONTH);
                int year = cldr.get(Calendar.YEAR);
                // date picker dialog
                picker = new DatePickerDialog(Emplyer_job_Add_Page.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                                deadline.setText(dayOfMonth + "/" + (monthOfYear + 1) + "/" + year);
                            }
                        }, year, month, day);
                picker.show();
            }
        });




        //////////////////////////////




        /////////////////////////////////



        confirmBtn=findViewById(R.id.confirmPost);
        confirmBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {




                Intent intent = new Intent(getApplicationContext(),Employer_JobConformation_page.class);
                intent.putExtra("jobType",jobTypeSpiner.getSelectedItem().toString());
                intent.putExtra("jobTitle",empjobTitle.getText().toString());
                intent.putExtra("OrganizationName",OrganizationName.getText().toString());
                intent.putExtra("employerName",employerName.getText().toString());
                intent.putExtra("empjobvacancy",empjobvacancy.getText().toString());
                intent.putExtra("empjobLocation",empjobLocation.getText().toString());
                intent.putExtra("empJobdescription",empJobdescription.getText().toString());
                intent.putExtra("emp_educationalQualification",emp_educationalQualification.getText().toString());
                intent.putExtra("empJobResponsiblity",empJobResponsiblity.getText().toString());
                intent.putExtra("Salary",Salary.getText().toString());
                intent.putExtra("deadline",deadline.getText().toString());
                intent.putExtra("CompanyLogao",base64);
                intent.putExtra("PostDate",PostDate.getText().toString());
                intent.putExtra("Experience",Experience.getText().toString());
                intent.putExtra("organizationType",organizationType.getText().toString());
                intent.putExtra("CompanySize",CompanySize.getText().toString());
                intent.putExtra("Salaryto",Salaryto.getText().toString());
                intent.putExtra("yearlyBonus",yearlyBonus.getText().toString());
                intent.putExtra("Others",Others.getText().toString());
                intent.putExtra("SalaryReview",SalaryReview.getText().toString());
                intent.putExtra("workPlace",workPlace.getText().toString());
                intent.putExtra("JobContext",JobContext.getText().toString());
                intent.putExtra("BusinesDesciption",BusinesDesciption.getText().toString());
                intent.putExtra("empjobLevel",empjobLevel.getText().toString());

                startActivity(intent);





            }
        });

    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {



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
            uri=data.getData();

            imageUpload();




            /////////////////////////////////////////////////////////

//            //create a file to write bitmap data
//            File f = new File(String.valueOf(data.getData()), "Logo.png");
//            try {
//                f.createNewFile();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//
////Convert bitmap to byte array
//            Bitmap bitmap = roundedImageView.getDrawingCache();
//            ByteArrayOutputStream bos = new ByteArrayOutputStream();
//            bitmap.compress(Bitmap.CompressFormat.PNG, 100, bos);
//            byte[] bitmapdata = bos.toByteArray();
//
////write the bytes in file
//            FileOutputStream fos = null;
//            try {
//                fos = new FileOutputStream(f);
//            } catch (FileNotFoundException e) {
//                e.printStackTrace();
//            }
//            try {
//                fos.write(bitmapdata);
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                fos.flush();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            try {
//                fos.close();
//            } catch (IOException e) {
//                e.printStackTrace();
//            }

            ///////////////////////////////////////////////////
            //Toast.makeText(this, " "+data.getData().toString(), Toast.LENGTH_SHORT).show();


        }
    }


    public void imageUpload()
    {

        roundedImageView.setDrawingCacheEnabled(true);
        roundedImageView.buildDrawingCache();
        Bitmap bitmap = ((BitmapDrawable) roundedImageView.getDrawable()).getBitmap();
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
        byte[] data = baos.toByteArray();

        base64= Base64.encodeToString(data, Base64.DEFAULT);

    }

//
//    public void imageUpload()
//    {
//
//        StorageReference storageRef = FirebaseStorage.getInstance().getReference();
//
//// Create a reference to "mountains.jpg"
//        StorageReference mountainsRef = storageRef.child(OrganizationName.getText().toString()+".jpg");
//
//// Create a reference to 'images/mountains.jpg'
//        StorageReference mountainImagesRef = storageRef.child("images/"+OrganizationName.getText().toString()+".jpg");
//
//// While the file names are the same, the references point to different files
//        mountainsRef.getName().equals(mountainImagesRef.getName());    // true
//        mountainsRef.getPath().equals(mountainImagesRef.getPath());    // false
//
//
//
//        roundedImageView.setDrawingCacheEnabled(true);
//        roundedImageView.buildDrawingCache();
//        Bitmap bitmap = ((BitmapDrawable) roundedImageView.getDrawable()).getBitmap();
//        ByteArrayOutputStream baos = new ByteArrayOutputStream();
//        bitmap.compress(Bitmap.CompressFormat.JPEG, 100, baos);
//        byte[] data = baos.toByteArray();
//
//        UploadTask uploadTask = mountainsRef.putBytes(data);
//
//
//        Task<Uri> urlTask = uploadTask.continueWithTask(new Continuation<UploadTask.TaskSnapshot, Task<Uri>>() {
//            @Override
//            public Task<Uri> then(@NonNull Task<UploadTask.TaskSnapshot> task) throws Exception {
//                if (!task.isSuccessful()) {
//                    throw task.getException();
//                }
//
//                // Continue with the task to get the download URL
//                return mountainsRef.getDownloadUrl();
//            }
//        }).addOnCompleteListener(new OnCompleteListener<Uri>() {
//            @Override
//            public void onComplete(@NonNull Task<Uri> task) {
//                if (task.isSuccessful()) {
//                     Uri downloadUri = task.getResult();
//                     Toast.makeText(getApplicationContext(),downloadUri.toString(),Toast.LENGTH_SHORT).show();
//                     CompanyLogao=downloadUri.toString();
//
//                } else {
//                    // Handle failures
//                    // ...
//                }
//            }
//        });
//
//
////        uploadTask.addOnFailureListener(new OnFailureListener() {
////            @Override
////            public void onFailure(@NonNull Exception exception) {
////                // Handle unsuccessful uploads
////
////
////
////                Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_SHORT).show();
////
////            }
////        }).addOnSuccessListener(new OnSuccessListener<UploadTask.TaskSnapshot>() {
////            @Override
////            public void onSuccess(UploadTask.TaskSnapshot taskSnapshot) {
////
////                String downloadUrl = mountainsRef.getDownloadUrl().toString();
////
////                Toast.makeText(getApplicationContext(),downloadUrl,Toast.LENGTH_SHORT).show();
////                // taskSnapshot.getMetadata() contains file metadata such as size, content-type, etc.
////                // ...
////            }
////        });
////
//
//
////        mountainsRef.getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
////            @Override
////            public void onSuccess(Uri uri) {
////                // Got the download URL for 'users/me/profile.png'
////                Toast.makeText(getApplicationContext(),uri.toString(),Toast.LENGTH_SHORT).show();
////            }
////        }).addOnFailureListener(new OnFailureListener() {
////            @Override
////            public void onFailure(@NonNull Exception exception) {
////                // Handle any errors
////                Toast.makeText(getApplicationContext(),"Empty",Toast.LENGTH_SHORT).show();
////            }
////        });
//
//
//    }



}