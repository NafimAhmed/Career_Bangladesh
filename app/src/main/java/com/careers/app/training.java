package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.EditText;

public class training extends AppCompatActivity {

    EditText TraningTitleOne,link2,portfolio,link1,Github,TraningyearThree,TraningDurationThree,TraningLocationThree,TraningTopicThree,TraningTitleThree,TraningyearTwo,TraningDurationTwo,TraningLocationTwo,TraningTopicTwo,TraningTitleTwo,TraningyearOne,TraningDurationOne,TraningLocationOne,TraningTopicOne;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_training);




        TraningTitleOne=findViewById(R.id.TraningTitleOne);
        TraningTopicOne=findViewById(R.id.TraningTopicOne);
        TraningLocationOne=findViewById(R.id.TraningLocationOne);
        TraningDurationOne=findViewById(R.id.TraningDurationOne);
        TraningyearOne=findViewById(R.id.TraningyearOne);
        TraningTitleTwo=findViewById(R.id.TraningTitleTwo);
        TraningTopicTwo=findViewById(R.id.TraningTopicTwo);
        TraningLocationTwo=findViewById(R.id.TraningLocationTwo);
        TraningDurationTwo=findViewById(R.id.TraningDurationTwo);
        TraningyearTwo=findViewById(R.id.TraningyearTwo);
        TraningTitleThree=findViewById(R.id.TraningTitleThree);
        TraningTopicThree=findViewById(R.id.TraningTopicThree);
        TraningLocationThree=findViewById(R.id.TraningLocationThree);
        TraningDurationThree=findViewById(R.id.TraningDurationThree);
        TraningyearThree=findViewById(R.id.TraningyearThree);
        Github=findViewById(R.id.Github);
        link1=findViewById(R.id.link1);
        link2=findViewById(R.id.link2);
        portfolio=findViewById(R.id.portfolio);


    }
}