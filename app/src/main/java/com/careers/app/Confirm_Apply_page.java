package com.careers.app;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class Confirm_Apply_page extends AppCompatActivity {

    Button btn_apply_ok;
    TextView condition;
    CheckBox checkbox_condition;

    String cond="Terms and Condition : Careers Bangladesh শুধুমাত্রই নিয়োগকর্তা এবং চাকরিপ্রার্থীদের মাঝে যোগাযোগ মাধ্যম হিসেবে কাজ করে। Careers Bangladesh ওয়েবসাইটের মাধ্যমে চাকরিতে আবেদন করার পর কোম্পানি যদি আপনার সাথে কোনো আর্থিক লেনদেন অথবা অনিয়ম/প্রতারণা করে তার জন্য Careers Bangladesh লিমিটেড দায়ী থাকবে না।";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_confirm_apply_page);

        checkbox_condition=findViewById(R.id.checkbox_condition);
        btn_apply_ok=findViewById(R.id.btn_apply_ok);

        checkbox_condition.setTextSize(17);
        condition=findViewById(R.id.condition);
        condition.setText(cond);


        checkbox_condition.isChecked();

        btn_apply_ok.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (checkbox_condition.isChecked()){
                    checkbox_condition.setTextColor(Color.parseColor("#FF000000"));
                    Intent intent=new Intent(getApplicationContext(),Apply_done_page.class);
                    startActivity(intent);
                    finish();

                }else{

                    checkbox_condition.requestFocus();
                   // checkbox_condition.setBackgroundColor(Color.parseColor("#ff0006"));
                    //checkbox_condition.setTextScaleX(1);
                    checkbox_condition.setTextColor(Color.parseColor("#ff0006"));

                    Toast.makeText(Confirm_Apply_page.this, "Please check out the term and condition", Toast.LENGTH_SHORT).show();

                }



            }
        });



    }
}