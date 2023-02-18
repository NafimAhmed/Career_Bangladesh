package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Locale;

public class Profile_Page extends AppCompatActivity implements Adapter3.OnNoteListener, Adapter2.OnNoteListener, AdapterView.OnItemSelectedListener{

    RecyclerView recyclerView,recyclerViewSkill;
    Adapter2 adapter;
    Adapter3 adapter_skill;
    TextView DOB,JoiningDate_Text,resigningDate_Text,certificate_valid_to,certificate_valid_from;
    final Calendar myCalendar= Calendar.getInstance();

    EditText eduResultType,eduResult;
    //Button eduSave;

    //RecyclerView.LayoutManager layoutManager;
    ArrayList<Item2> arrayList;
    ArrayList<Item3> arrayList_skill;
    ArrayList<String>arrayList_edulevel;

    //Adapter.OnNoteListener onNoteListener=this;

    RecyclerView.LayoutManager layoutManager,layoutManager_skill;
    Adapter2.OnNoteListener onNoteListener=this;
    Adapter3.OnNoteListener onNoteListenerSkill=this;
    Spinner eduMajorSpin,eduResultTypeSpinner, eduLevelSpinner;


    LinearLayout basic,edu,skill,exp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile_page);

        getSupportActionBar().setTitle("Profile Detail");

        basic=findViewById(R.id.basic_info);
        edu=findViewById(R.id.Edu_info);
        skill=findViewById(R.id.skill_info);
        exp=findViewById(R.id.Experience_info);
        DOB=findViewById(R.id.DOB);
        JoiningDate_Text=findViewById(R.id.JoiningDate_Text);
        certificate_valid_to=findViewById(R.id.certificate_valid_to);
        certificate_valid_from=findViewById(R.id.certificate_valid_from);

        //eduLevel=findViewById(R.id.edulevel);
        //eduMajor=findViewById(R.id.eduMajor);
        eduResultType=findViewById(R.id.eduResult);
        eduResult=findViewById(R.id.eduResult);
        resigningDate_Text=findViewById(R.id.resigningDate_Text);



        ////////////////Date picker Dialogue///////////////////////

//        DatePickerDialog.OnDateSetListener date =new DatePickerDialog.OnDateSetListener() {
//            @Override
//            public void onDateSet(DatePicker datePicker, int year, int month, int day) {
//
//                myCalendar.set(Calendar.YEAR, year);
//                myCalendar.set(Calendar.MONTH,month);
//                myCalendar.set(Calendar.DAY_OF_MONTH,day);
//                updateLabel();
//
//            }
//
//
//        };

        certificate_valid_from.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Profile_Page.this);
                builder.setTitle("Select Date");

                // set the custom layout
                final View customLayout = getLayoutInflater().inflate(R.layout.date_picker_dialogue, null);
                builder.setView(customLayout);

                // add a button
                builder.setPositiveButton("Select", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
                    DatePicker date = customLayout.findViewById(R.id.datePicker);
                    certificate_valid_from.setText(date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear());
                    //filter(editText.getText().toString());
                }).setNegativeButton("Cancel", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
//            EditText editText = customLayout.findViewById(R.id.edit_search);
//            sendDialogDataToActivity(editText.getText().toString());
                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();





            }
        });



        certificate_valid_to.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Profile_Page.this);
                builder.setTitle("Select Date");

                // set the custom layout
                final View customLayout = getLayoutInflater().inflate(R.layout.date_picker_dialogue, null);
                builder.setView(customLayout);

                // add a button
                builder.setPositiveButton("Select", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
                    DatePicker date = customLayout.findViewById(R.id.datePicker);
                    certificate_valid_to.setText(date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear());
                    //filter(editText.getText().toString());
                }).setNegativeButton("Cancel", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
//            EditText editText = customLayout.findViewById(R.id.edit_search);
//            sendDialogDataToActivity(editText.getText().toString());
                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();




            }
        });



        resigningDate_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Profile_Page.this);
                builder.setTitle("Select Date");

                // set the custom layout
                final View customLayout = getLayoutInflater().inflate(R.layout.date_picker_dialogue, null);
                builder.setView(customLayout);

                // add a button
                builder.setPositiveButton("Select", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
                    DatePicker date = customLayout.findViewById(R.id.datePicker);
                    resigningDate_Text.setText(date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear());
                    //filter(editText.getText().toString());
                }).setNegativeButton("Cancel", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
//            EditText editText = customLayout.findViewById(R.id.edit_search);
//            sendDialogDataToActivity(editText.getText().toString());
                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();





            }
        });








        JoiningDate_Text.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {



                AlertDialog.Builder builder = new AlertDialog.Builder(Profile_Page.this);
                builder.setTitle("Select Date");

                // set the custom layout
                final View customLayout = getLayoutInflater().inflate(R.layout.date_picker_dialogue, null);
                builder.setView(customLayout);

                // add a button
                builder.setPositiveButton("Select", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
                    DatePicker date = customLayout.findViewById(R.id.datePicker);
                    JoiningDate_Text.setText(date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear());
                    //filter(editText.getText().toString());
                }).setNegativeButton("Cancel", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
//            EditText editText = customLayout.findViewById(R.id.edit_search);
//            sendDialogDataToActivity(editText.getText().toString());
                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();




            }
        });








        DOB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                AlertDialog.Builder builder = new AlertDialog.Builder(Profile_Page.this);
                builder.setTitle("Select Date");

                // set the custom layout
                final View customLayout = getLayoutInflater().inflate(R.layout.date_picker_dialogue, null);
                builder.setView(customLayout);

                // add a button
                builder.setPositiveButton("Select", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
                    DatePicker date = customLayout.findViewById(R.id.datePicker);
                    DOB.setText(date.getDayOfMonth()+"/"+(date.getMonth()+1)+"/"+date.getYear());
                    //filter(editText.getText().toString());
                }).setNegativeButton("Cancel", (dialog, which) -> {
                    // send data from the AlertDialog to the Activity
//            EditText editText = customLayout.findViewById(R.id.edit_search);
//            sendDialogDataToActivity(editText.getText().toString());
                });
                // create and show the alert dialog
                AlertDialog dialog = builder.create();
                dialog.show();



                //new DatePickerDialog(Profile_Page.this,date,myCalendar.get(Calendar.YEAR),myCalendar.get(Calendar.MONTH),myCalendar.get(Calendar.DAY_OF_MONTH)).show();
            }
        });





        //////////////////////Date picker Dialogue/////////////////////








        ///////////////////////////////////////////

        eduMajorSpin=findViewById(R.id.eduMajorSpinner);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.major, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eduMajorSpin.setAdapter(adapter);
        eduMajorSpin.setOnItemSelectedListener(this);
        eduMajorSpin.getSelectedItem();

        ///////////////////////////////////////////////

        eduResultTypeSpinner=findViewById(R.id.eduResultTypeSpinner);
        ArrayAdapter<CharSequence> eduResultTypeAdapter=ArrayAdapter.createFromResource(this,R.array.result_type, android.R.layout.simple_spinner_item);
        eduResultTypeAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eduResultTypeSpinner.setAdapter(eduResultTypeAdapter);
        eduResultTypeSpinner.setOnItemSelectedListener(this);
        eduResultTypeSpinner.getSelectedItem();


        ////////////////////////////////////////
        arrayList_edulevel=new ArrayList<>();

        eduLevelSpinner=findViewById(R.id.edulevel);
        ArrayAdapter<CharSequence> adapterEduLevel=ArrayAdapter.createFromResource(this,R.array.edu_level, android.R.layout.simple_spinner_item);
        adapterEduLevel.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        eduLevelSpinner.setAdapter(adapterEduLevel);
        eduLevelSpinner.setOnItemSelectedListener(this);
        eduLevelSpinner.getSelectedItem();





        ////////////////////////////////

        recyclerView=findViewById(R.id.rcvw);

        recyclerView.setClickable(true);

        arrayList=new ArrayList<>();

        /////////////////////////////////////////

        recyclerViewSkill=findViewById(R.id.rcvw_Skill);

        recyclerViewSkill.setClickable(true);

        arrayList_skill=new ArrayList<>();

        ////////////////////////////////////

        //Adapter2.OnNoteListener onNoteListener=this;


//        arrayList.add(new Item2("Android Developer","A Group","1/5/23","content://com.android.exteralstorage.documents/document/9C336BBD%3Atxttospeeck%2FArabic.txt"));
//        arrayList.add(new Item2("Android Developer","B Group","1/5/23","content://com.android.exteralstorage.documents/document/9C336BBD%3Atxttospeeck%2FArabic2.txt"));
//        arrayList.add(new Item2("Android Developer","C Group","1/5/23","content://com.android.exteralstorage.documents/document/9C336BBD%3Atxttospeeck%2Fsample.txt"));
//        arrayList.add(new Item2("Android Developer","D Group","1/5/23","content://com.android.exteralstorage.documents/document/9C336BBD%3Atxttospeeck%2Fsample3.txt"));
//       arrayList.add(new Item2("Android Developer","E Group","1/5/23","uihfdsj"));
//        arrayList.add(new Item2("Android Developer","AF Group","1/5/23","jifer"));
//        adapter=new Adapter2(arrayList,onNoteListener);
//        layoutManager=new LinearLayoutManager(getApplicationContext());
//        recyclerView.setAdapter(adapter);
//        recyclerView.setLayoutManager(layoutManager);










        ///////////////////////////////////


    }

    public void BasicInfo(View view){

        basic.setVisibility(View.VISIBLE);
        edu.setVisibility(View.GONE);
        skill.setVisibility(View.GONE);
        exp.setVisibility(View.GONE);





    }

    public void EduInfo(View view){


        basic.setVisibility(View.GONE);
        edu.setVisibility(View.VISIBLE);
        skill.setVisibility(View.GONE);
        exp.setVisibility(View.GONE);




    }

    public void SkillInfo(View view){

        basic.setVisibility(View.GONE);
        edu.setVisibility(View.GONE);
        skill.setVisibility(View.VISIBLE);
        exp.setVisibility(View.GONE);


    }

    public void ExpInfo(View view){

        basic.setVisibility(View.GONE);
        edu.setVisibility(View.GONE);
        skill.setVisibility(View.GONE);
        exp.setVisibility(View.VISIBLE);


    }

    public void addEdu(View v)
    {


                arrayList.add(new Item2(eduLevelSpinner.getSelectedItem().toString(),eduMajorSpin.getSelectedItem().toString(),eduResultTypeSpinner.getSelectedItem().toString(),eduResult.getText().toString()));
                adapter=new Adapter2(arrayList,onNoteListener);
                layoutManager=new LinearLayoutManager(getApplicationContext());
                recyclerView.setAdapter(adapter);
                recyclerView.setLayoutManager(layoutManager);


    }


    public void addSkill(View v)
    {


        arrayList_skill.add(new Item3("yudsgasg","sdhweidhqwih","12/05/23","uihdwhehhed"));
        adapter_skill=new Adapter3(arrayList_skill,onNoteListenerSkill);
        layoutManager_skill=new LinearLayoutManager(getApplicationContext());
        recyclerViewSkill.setAdapter(adapter_skill);
        recyclerViewSkill.setLayoutManager(layoutManager_skill);


    }


    @Override
    public Void onNoteclicl(int position) {
        return null;
    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        Toast.makeText(getApplicationContext(),eduMajorSpin.getSelectedItem().toString(),Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    private void updateLabel(){
        String myFormat="MM/dd/yy";
        SimpleDateFormat dateFormat=new SimpleDateFormat(myFormat, Locale.US);
        DOB.setText(dateFormat.format(myCalendar.getTime()));
    }
}