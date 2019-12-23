package com.example.library;

/**
 *Created by nischal on 12/23/2019.
 */

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class student_history extends AppCompatActivity {

    DatabaseHelperClass mydb;
    ArrayList<History> students = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_student_history);


        mydb = new DatabaseHelperClass(student_history.this);
         Cursor tempDB = mydb.getAllFromStudentHistory();

        while (tempDB.moveToNext())
        {
            students.add(new History(tempDB.getString(1),tempDB.getString(0),tempDB.getString(2),
                    tempDB.getString(3), tempDB.getString(4),tempDB.getString(5)));
        }

        Collections.reverse(students);

        ListView studenthistory = (ListView) findViewById(R.id.studentHistoryListView);
        StudentAdapter adapt = new StudentAdapter(student_history.this,0,students);
        studenthistory.setAdapter(adapt);
    }


    @Override
    protected void onDestroy() {
        super.onDestroy();
        students.clear();
    }

    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_search, menu);
        MenuInflater inflater1 =getMenuInflater();
        inflater1.inflate(R.menu.menu_sebook,menu);

        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.student:
                startActivity(new Intent(student_history.this, student_search.class));
                Toast.makeText(student_history.this,"Search Student By StudentId",Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.book:
                startActivity(new Intent(student_history.this, book_search.class));
                Toast.makeText(student_history.this,"Search Book By BookId",Toast.LENGTH_SHORT).show();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
