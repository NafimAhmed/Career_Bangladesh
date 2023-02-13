package com.nafim.jobportal;

import static android.Manifest.permission.READ_EXTERNAL_STORAGE;
import static android.Manifest.permission.WRITE_EXTERNAL_STORAGE;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import android.graphics.pdf.PdfDocument;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;

public class Download_Resume extends AppCompatActivity {

    Button generatePDFbtn;

    // declaring width and height
    // for our PDF file.
    int pageHeight = 1120;
    int pagewidth = 792;

    // creating a bitmap variable
    // for storing our images
    Bitmap bmp, scaledbmp;

    // constant code for runtime permissions
    private static final int PERMISSION_REQUEST_CODE = 200;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_download_resume);




        generatePDFbtn = findViewById(R.id.idBtnGeneratePDF);
        bmp = BitmapFactory.decodeResource(getResources(), R.drawable.logo);
        scaledbmp = Bitmap.createScaledBitmap(bmp, 140, 140, false);

        // below code is used for
        // checking our permissions.
        if (checkPermission()) {
            Toast.makeText(this, "Permission Granted", Toast.LENGTH_SHORT).show();
        } else {
            requestPermission();
        }

        generatePDFbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // calling method to
                Toast.makeText(getApplicationContext(),"Clicked generate",Toast.LENGTH_SHORT).show();
                generatePDF();
            }
        });

    }



    private boolean checkPermission() {
        // checking of permissions.
        int permission1 = ContextCompat.checkSelfPermission(getApplicationContext(), WRITE_EXTERNAL_STORAGE);
        int permission2 = ContextCompat.checkSelfPermission(getApplicationContext(), READ_EXTERNAL_STORAGE);
        return permission1 == PackageManager.PERMISSION_GRANTED && permission2 == PackageManager.PERMISSION_GRANTED;
    }


    private void requestPermission() {
        // requesting permissions if not provided.
        ActivityCompat.requestPermissions(this, new String[]{WRITE_EXTERNAL_STORAGE, READ_EXTERNAL_STORAGE}, PERMISSION_REQUEST_CODE);
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);



        if (requestCode == PERMISSION_REQUEST_CODE) {
            if (grantResults.length > 0) {

                // after requesting permissions we are showing
                // users a toast message of permission granted.
                boolean writeStorage = grantResults[0] == PackageManager.PERMISSION_GRANTED;
                boolean readStorage = grantResults[1] == PackageManager.PERMISSION_GRANTED;

                if (writeStorage && readStorage) {
                    Toast.makeText(this, "Permission Granted..", Toast.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "Permission Denied.", Toast.LENGTH_SHORT).show();
                    finish();
                }
            }
        }
    }





    ////////////////////////////////////////////


    private void generatePDF() {
        // creating an object variable
        // for our PDF document.
        PdfDocument pdfDocument = new PdfDocument();

        firstpage(pdfDocument);
        secondtpage(pdfDocument);

        // two variables for paint "paint" is used
        // for drawing shapes and we will use "title"
        // for adding text in our PDF file.

        // below line is used to set the name of
        // our PDF file and its path.
        File file = new File(Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS).getAbsolutePath(), "career_bangladesh_Resume.pdf");

        try {
            // after creating a file name we will
            // write our PDF file to that location.
            pdfDocument.writeTo(new FileOutputStream(file));

            // below line is to print toast message
            // on completion of PDF generation.
            Toast.makeText(Download_Resume.this, "PDF file generated successfully.", Toast.LENGTH_SHORT).show();
        } catch (IOException e) {
            // below line is used
            // to handle error
            e.printStackTrace();
        }
        // after storing our pdf to that
        // location we are closing our PDF file.
        pdfDocument.close();
    }





    public void firstpage(PdfDocument pdfDocument){


        Paint paint = new Paint();
        Paint title = new Paint();
        Paint title1 = new Paint();
        Paint title2 = new Paint();
        Paint table=new Paint();


        // we are adding page info to our PDF file
        // in which we will be passing our pageWidth,
        // pageHeight and number of pages and after that
        // we are calling it to create our PDF.
        PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();

        // below line is used for setting
        // start page for our PDF file.
        PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);

        // creating a variable for canvas
        // from our page of PDF.
        Canvas canvas = myPage.getCanvas();

        // below line is used to draw our image on our PDF file.
        // the first parameter of our drawbitmap method is
        // our bitmap
        // second parameter is position from left
        // third parameter is position from top and last
        // one is our variable for paint.
        canvas.drawBitmap(scaledbmp, 56, 40, paint);

        // below line is used for adding typeface for
        // our text which we will be adding in our PDF file.
        title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        title1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        title2.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));


        // below line is used for setting text size
        // which we will be displaying in our PDF file.
        title.setTextSize(25);
        title2.setTextSize(20);
        title1.setTextSize(15);


        // below line is sued for setting color
        // of our text inside our PDF file.
        title.setColor(ContextCompat.getColor(this, R.color.purple_200));

        // below line is used to draw text in our PDF file.
        // the first parameter is our text, second parameter
        // is position from start, third parameter is position from top
        // and then we are passing our variable of paint which is title.


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        canvas.drawText("Nafim Ahmed", 209, 80, title);
        canvas.drawText("Address : Faidabad, Dakshin khan,", 209, 100, title1);
        canvas.drawText("Email : re@gmail.com\n", 209, 115, title1);
        canvas.drawText("Phone : +8801797609439", 209, 130, title1);


        Toast.makeText(getApplicationContext(),canvas.getHeight()+"",Toast.LENGTH_SHORT).show();


        canvas.drawText("Personal info : \n", 100, 200, title);
        canvas.drawText("Mother's name : MRS. Shahnaz Begum", 100, 215, title1);
        canvas.drawText("Father's : MD. Saiful Islam", 100, 230, title1);
        canvas.drawText("Relagion : Islam", 100, 245, title1);
        canvas.drawText("NID/Passport Number : 4654797911", 100, 260, title1);

        canvas.drawText("Date of birth : 02/04/1999", 100, 275, title1);
        canvas.drawText("Gender : Male", 100, 290, title1);
        canvas.drawText("Marital Status : Single", 100, 305, title1);
        canvas.drawText("Blood Group : B+", 100, 320, title1);
        canvas.drawText("Nationality : Bangladeshi", 100, 335, title1);
        canvas.drawText("Parmanent address : Faidabad, Dakshin khan, Dhaka.", 100, 350, title1);


        canvas.drawText("Academic info : \n", 100, 380, title);

        /////////////////////////////////////////////////////////////

        canvas.drawText("SSC : \n", 100, 400, title2);
        canvas.drawText("Major : Science\n", 100, 415, title1);
        canvas.drawText("Result : 5.00 out of 5.00\n", 100, 430, title1);
        canvas.drawText("Institute : Milestone Collage", 100, 445, title1);

        ///////////////////////////////////////


        canvas.drawText("HSC : \n", 100, 475, title2);
        canvas.drawText("Major : Science\n", 100, 490, title1);
        canvas.drawText("Result : 5.00 out of 5.00\n", 100, 505, title1);
        canvas.drawText("Institute : Milestone Collage", 100, 520, title1);

        ////////////////////////////////////



        canvas.drawText("BSc : \n", 100, 550, title2);
        canvas.drawText("Major : Computer science and Engineering\n", 100, 570, title1);
        canvas.drawText("Result : 3.91 out of 4.00\n", 100, 585, title1);
        canvas.drawText("Institute : Daffodil International University", 100, 600, title1);



        ////////////////////////////////////


        canvas.drawText("Employment history : \n", 100, 630, title);


        /////////////////////////

        canvas.drawText("A Group : \n", 100, 660, title2);
        canvas.drawText("Job Responsiblity : Computer science and Engineering\n", 100, 675, title1);
        canvas.drawText("Duration : From 14/08/2022 to 08/01/2023\n", 100, 690, title1);



        ////////////////////////

        Toast.makeText(getApplicationContext(),canvas.getHeight()+"",Toast.LENGTH_SHORT).show();

        canvas.drawText("Specialization : \n", 100, 720, title);

        canvas.drawLine(100,750,canvas.getWidth()-150,750,table);
        canvas.drawText("Field of Specialization", 150, 770, title1);
        canvas.drawText("Description", 400, 770, title1);
        canvas.drawLine(100,800,canvas.getWidth()-150,800,table);



        canvas.drawLine(100,750,100,1000,table);
        canvas.drawLine(350,750,350,1000,table);
        canvas.drawLine(canvas.getWidth()-150,750,canvas.getWidth()-150,1000,table);



        canvas.drawLine(100,1000,canvas.getWidth()-150,1000,table);



        ////////////////////////////////////////
        //////////////////////////2nd page///////////////////////////////


//        Paint paint2 = new Paint();
//        Paint title = new Paint();
//        Paint table2=new Paint();

        // we are adding page info to our PDF file
        // in which we will be passing our pageWidth,
        // pageHeight and number of pages and after that
        // we are calling it to create our PDF.



        // canvas2.drawText("Language : \n", 100, 200, title);



















        ///////////////////////////////////////////////////////////////////////////////////









        // similarly we are creating another text and in this
        // we are aligning this text to center of our PDF file.
        title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        title.setColor(ContextCompat.getColor(this, R.color.purple_200));
        title.setTextSize(15);

        // below line is used for setting
        // our text to center of PDF.
        title.setTextAlign(Paint.Align.CENTER);
        //canvas.drawText("This is sample document which we have created.", 396, 560, title);

        // after adding all attributes to our
        // PDF file we will be finishing our page.
        pdfDocument.finishPage(myPage);

    }





    //////////////////////////////////////





    public void secondtpage(PdfDocument pdfDocument){


        Paint paint = new Paint();
        Paint title = new Paint();
        Paint title1 = new Paint();
        Paint title2 = new Paint();
        Paint table=new Paint();


        // we are adding page info to our PDF file
        // in which we will be passing our pageWidth,
        // pageHeight and number of pages and after that
        // we are calling it to create our PDF.
        PdfDocument.PageInfo mypageInfo = new PdfDocument.PageInfo.Builder(pagewidth, pageHeight, 1).create();

        // below line is used for setting
        // start page for our PDF file.
        PdfDocument.Page myPage = pdfDocument.startPage(mypageInfo);

        // creating a variable for canvas
        // from our page of PDF.
        Canvas canvas = myPage.getCanvas();

        // below line is used to draw our image on our PDF file.
        // the first parameter of our drawbitmap method is
        // our bitmap
        // second parameter is position from left
        // third parameter is position from top and last
        // one is our variable for paint.
        //canvas.drawBitmap(scaledbmp, 56, 40, paint);

        // below line is used for adding typeface for
        // our text which we will be adding in our PDF file.
        title.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));
        title1.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.NORMAL));
        title2.setTypeface(Typeface.create(Typeface.DEFAULT, Typeface.BOLD));


        // below line is used for setting text size
        // which we will be displaying in our PDF file.
        title.setTextSize(25);
        title2.setTextSize(20);
        title1.setTextSize(15);


        // below line is sued for setting color
        // of our text inside our PDF file.
        title.setColor(ContextCompat.getColor(this, R.color.purple_200));

        // below line is used to draw text in our PDF file.
        // the first parameter is our text, second parameter
        // is position from start, third parameter is position from top
        // and then we are passing our variable of paint which is title.


        ///////////////////////////////////////////////////////////////////////////////////////////////////////////////////////


        canvas.drawText("Language preficiency : \n", 100, 70, title);
        canvas.drawText("Bangla :", 100, 100, title2);
        canvas.drawText(" Speaking: Execelent, Reading : Excellent, Writing : Exellent, ", 100, 120, title1);
        canvas.drawText("English : ", 100, 140, title2);
        canvas.drawText(" Speaking: Execelent, Reading : Excellent, Writing : Exellent, ", 100, 160, title1);



        ////////////////////////////////////////////////////////////////


        canvas.drawText("Extracurricular activities : \n", 100, 190, title);

        canvas.drawText(" Coding, Singing, Dancing ", 100, 220, title1);


        Toast.makeText(getApplicationContext(),canvas.getHeight()+"",Toast.LENGTH_SHORT).show();

        ////////////////////////////////////////////////////////

        canvas.drawText("Reference : \n", 100, 250, title);
        canvas.drawText(" Reference1 : ", 100, 280, title2);
        canvas.drawText(" Name : MD. Saiful Islam", 100, 300, title1);
        canvas.drawText(" Organization : Bangladesh Bank", 100, 315, title1);
        canvas.drawText(" Designetion : Join Director", 100, 330, title1);
        canvas.drawText(" Address : Uttara, Dhaka.", 100, 345, title1);
        canvas.drawText(" Phone Number : 01726222954", 100, 360, title1);
        canvas.drawText(" Email : re@gmail.com", 100, 375, title1);
        canvas.drawText(" Relation : Father", 100, 390, title1);





        //////////////////////////////////////////////////

        canvas.drawText("Reference 2 : \n", 100, 420, title2);

        canvas.drawText(" Name : MD. Saiful Islam", 100, 450, title1);
        canvas.drawText(" Organization : Bangladesh Bank", 100, 465, title1);
        canvas.drawText(" Designetion : Join Director", 100, 480, title1);
        canvas.drawText(" Address : Uttara, Dhaka.", 100, 495, title1);
        canvas.drawText(" Phone Number : 01726222954", 100, 510, title1);
        canvas.drawText(" Email : re@gmail.com", 100, 525, title1);
        canvas.drawText(" Relation : Father", 100, 540, title1);

























        ///////////////////////////////////////////////////////////////////////////////////









        // similarly we are creating another text and in this
        // we are aligning this text to center of our PDF file.
        title.setTypeface(Typeface.defaultFromStyle(Typeface.NORMAL));
        title.setColor(ContextCompat.getColor(this, R.color.purple_200));
        title.setTextSize(15);

        // below line is used for setting
        // our text to center of PDF.
        title.setTextAlign(Paint.Align.CENTER);
        //canvas.drawText("This is sample document which we have created.", 396, 560, title);

        // after adding all attributes to our
        // PDF file we will be finishing our page.
        pdfDocument.finishPage(myPage);

    }









}