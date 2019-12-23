package com.example.library;
/**
 *Created by nischal on 12/23/2019.
 */
import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.Collections;

public class Book_classwise extends AppCompatActivity {

    DatabaseHelperClass mydb;
    ArrayList<Book> booksc = new ArrayList<>();
    Button search;
    EditText book;
    String bookclass;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_book_classwise);

        search = findViewById(R.id.buttonsearch);
        book = findViewById(R.id.book_classwise);


        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                bookclass= book.getText().toString();

                mydb = new DatabaseHelperClass(Book_classwise.this);

                 final Cursor tempDB = mydb.getAllAboutBook(bookclass);


                while (tempDB.moveToNext())
                {
                    booksc.add(new Book(tempDB.getString(1),tempDB.getString(0),tempDB.getString(2),tempDB.getString(6),tempDB.getString(9)));
                }

                Collections.reverse(booksc);

                ListView bookview = (ListView) findViewById(R.id.showBookClassListView);
                BookAdapter madapter = new BookAdapter(Book_classwise.this,0,booksc);
                bookview.setAdapter(madapter);




            }
        });






    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        booksc.clear();
    }
}
