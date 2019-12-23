package com.example.library;

/**
 *Created by nischal on 12/23/2019.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class issue_to_both extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_issue_to_both);

        Button studentIssueBtn = (Button) findViewById(R.id.studentissuebtn);


        studentIssueBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToStudentIssue = new Intent(issue_to_both.this,issuetostudent.class);
                startActivity(intentToStudentIssue);
            }
        });


    }
}
