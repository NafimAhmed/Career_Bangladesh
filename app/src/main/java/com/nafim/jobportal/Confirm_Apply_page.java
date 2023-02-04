package com.nafim.jobportal;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class Confirm_Apply_page extends AppCompatActivity {

    Button btn_apply_ok;
    CheckBox checkbox_condition;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_apply_page);

        checkbox_condition=findViewById(R.id.checkbox_condition);
        btn_apply_ok=findViewById(R.id.btn_apply_ok);

        checkbox_condition.setTextSize(17);


        checkbox_condition.isChecked();

        btn_apply_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkbox_condition.isChecked()){
                    checkbox_condition.setTextColor(Color.parseColor("#FF000000"));
                    Intent intent=new Intent(getApplicationContext(),Apply_done_page.class);
                    startActivity(intent);

                }else{

                    checkbox_condition.requestFocus();
                   // checkbox_condition.setBackgroundColor(Color.parseColor("#ff0006"));
                    //checkbox_condition.setTextScaleX(1);
                    checkbox_condition.setTextColor(Color.parseColor("#ff0006"));

                }

                finish();

            }
        });



    }
}