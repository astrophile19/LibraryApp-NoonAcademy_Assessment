package com.example.library;
/**
 *Created by nischal on 12/23/2019.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class editinfo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editinfo);

        Button editstudent = (Button) findViewById(R.id.editstudentInfobtn);
        editstudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(editinfo.this,editstudentinfo.class);
                startActivity(in1);
            }
        });

        Button deletestudent = (Button) findViewById(R.id.deletestudentbtn);
        deletestudent.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent in1 = new Intent(editinfo.this,delete_student.class);
                startActivity(in1);
            }
        });




  }




}
