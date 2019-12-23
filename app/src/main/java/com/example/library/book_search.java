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

public class book_search extends AppCompatActivity {

    DatabaseHelperClass mydb;
    ArrayList<History> books = new ArrayList<>();
    Button search;
    EditText book;
    String bookid;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_search);

        search = findViewById(R.id.btnsearch);
        book = findViewById(R.id.bookid);

        search.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
            @Override
            public void onClick(View v) {

                bookid= book.getText().toString();

                mydb = new DatabaseHelperClass(book_search.this);
                Cursor tempDB = mydb.getAllFromStudentHistoryBook(bookid);


                while (tempDB.moveToNext())
                {
                    books.add(new History(tempDB.getString(1),tempDB.getString(0),tempDB.getString(2),
                            tempDB.getString(3) ,tempDB.getString(4),tempDB.getString(5)));
                }

                Collections.reverse(books);

                ListView studenthistory = (ListView) findViewById(R.id.studentHistoryListView);
                StudentAdapter adapt = new StudentAdapter(book_search.this,0,books);
                studenthistory.setAdapter(adapt);


            }
        });

    }



    }

