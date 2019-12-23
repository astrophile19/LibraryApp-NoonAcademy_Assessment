package com.example.library;
/**
 *Created by nischal on 12/23/2019.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class history_for extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history_for);

        Button studentHistory = (Button) findViewById(R.id.historyForStudent);
        studentHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intentToStudentHistory = new Intent(history_for.this,student_history.class);
                startActivity(intentToStudentHistory);
            }
        });


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
                startActivity(new Intent(history_for.this, student_search.class));
                Toast.makeText(history_for.this,"Search Student By StudentId",Toast.LENGTH_SHORT).show();
                return true;
            case  R.id.book:
                startActivity(new Intent(history_for.this, book_search.class));
                Toast.makeText(history_for.this,"Search Book By BookId",Toast.LENGTH_SHORT).show();
                this.finish();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }




}
