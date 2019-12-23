package com.example.library;

/**
 *Created by nischal on 12/23/2019.
 */

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import java.util.ArrayList;

public class show_history extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_history);

        ArrayList<Book> books = new ArrayList<>();
        books.add(new Book("Book1","B100","Author1","No","1st"));
        books.add(new Book("Book2","B101","Author2","No","2nd"));
        books.add(new Book("Book3","B102","Author3","Yes","3rd"));
        books.add(new Book("Book4","B103","Author4","Yes","4th"));
        books.add(new Book("Book5","B104","Author5","Yes","5th"));
        books.add(new Book("Book6","B105","Author6","No","6th"));
        books.add(new Book("Book7","B106","Author7","Yes","7th"));
        books.add(new Book("Book8","B107","Author8","No","8th"));
        books.add(new Book("Book9","B108","Author9","No","9th"));
        books.add(new Book("Book10","B108","Author10","Yes","10th"));
        ListView bookview = (ListView) findViewById(R.id.showHistoryListView);
        BookAdapter madapter = new BookAdapter(show_history.this,0,books);
        bookview.setAdapter(madapter);
    }
}
