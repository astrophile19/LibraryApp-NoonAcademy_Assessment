package com.example.library;


/**
 *Created by nischal on 12/23/2019.
 */


import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class student_search extends AppCompatActivity {

    DatabaseHelperClass mydb;
    ArrayList<History> student = new ArrayList<>();
    Button search1;
    EditText stud;
    String students;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_search);

        search1 = findViewById(R.id.btnsearch1);
        stud = findViewById(R.id.studentid);

          search1.setOnClickListener(new View.OnClickListener() {
              @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
              @Override
              public void onClick(View v) {

               students= stud.getText().toString();

                  mydb = new DatabaseHelperClass(student_search.this);
                  Cursor tempDB = mydb.getAllFromStudentHistoryStudent(students);


                  while (tempDB.moveToNext())
                  {
                      student.add(new History(tempDB.getString(1),tempDB.getString(0),tempDB.getString(2),
                              tempDB.getString(3),tempDB.getString(4),tempDB.getString(5)));
                  }

                  Collections.reverse(student);

                  ListView studenthistory = (ListView) findViewById(R.id.studentHistorystudentid);
                  StudentAdapter adapt = new StudentAdapter(student_search.this,0,student);
                  studenthistory.setAdapter(adapt);


              }
          });

    }
}
