package com.example.library;

/**
 *Created by nischal on 12/23/2019.
 */

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Build;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collections;

public class show_book extends AppCompatActivity {

    DatabaseHelperClass mydb;
    ArrayList<Book> books = new ArrayList<>();
    String bclass,bksavail,tbksavail;
    TextView bookavailable,totalbooks;
    private String Issued;

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_show_book);

        totalbooks =findViewById(R.id.total_books);
        bookavailable = findViewById(R.id.books_available);
        mydb = new DatabaseHelperClass(show_book.this);
        Cursor dbh = mydb.getAvailableBooksCount(bksavail);
        bookavailable.setText(Integer.toString(dbh.getCount()));
        Cursor dbhh = mydb.getTotalBooksCount();
        totalbooks.setText(Integer.toString(dbhh.getCount()));




        final Cursor tempDB = mydb.getFromBooks();

        while (tempDB.moveToNext())
        {
            books.add(new Book(tempDB.getString(1),tempDB.getString(0),tempDB.getString(2),tempDB.getString(6),tempDB.getString(9)));
        }
        Collections.reverse(books);

        ListView bookview = (ListView) findViewById(R.id.showBookListView);
        BookAdapter madapter = new BookAdapter(show_book.this,0,books);
        bookview.setAdapter(madapter);

       /* bookview.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {


                Book book = books.get(position);
                String bookid = book.getMbookId();
                Cursor tempdb = mydb.getAboutABook(bookid);

                if (!tempdb.moveToFirst())

                    if( tempdb != null && tempdb.moveToFirst()){

                Intent intentToshowbookinfo = new Intent(show_book.this, book_single_info.class);
                intentToshowbookinfo.putExtra("BookId", tempdb.getString(2));
                intentToshowbookinfo.putExtra("Title", tempdb.getString(1));
                intentToshowbookinfo.putExtra("Edition", tempdb.getString(3));
                intentToshowbookinfo.putExtra("Author", tempdb.getString(6));
                intentToshowbookinfo.putExtra("Genre", tempdb.getString(4));
                intentToshowbookinfo.putExtra("Publisher", tempdb.getString(8));
                intentToshowbookinfo.putExtra("Year of Publication", tempdb.getString(7));
                intentToshowbookinfo.putExtra("Price", tempdb.getString(0));
                intentToshowbookinfo.putExtra("Issued", tempdb.getString(9));
                intentToshowbookinfo.putExtra("Class", tempdb.getString(6));


                startActivity(intentToshowbookinfo);

                tempdb.close();
            }
            }
        });*/

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        books.clear();
    }


    @Override
    public  boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu_searchbook_classwise, menu);
        return true;

    }

    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle item selection
        switch (item.getItemId()) {
            case R.id.search_class_wise:
                startActivity(new Intent(show_book.this, Book_classwise.class));
                Toast.makeText(show_book.this,"Search Books By Class/Grade",Toast.LENGTH_SHORT).show();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }






}
