package com.example.library;
/**
 *Created by nischal on 12/23/2019.
 */
public class Book {

    private  String mbookTitle;
    private  String mbookId;
    private  String mbookAuthor;
    private  String missued;
    private String mbclass;

    public  String getMbookTitle() {
        return mbookTitle;
    }



    public  String getMbookId() {
        return mbookId;
    }

    public  String getMbookAuthor() {
        return mbookAuthor;
    }

    public  String getMissued() {
        return missued;
    }

    public String getMbclass(){return mbclass;}


    public Book(String booktitle, String bookId, String bookAuthor, String issued,String bookclass)
    {
        mbookTitle = booktitle;
        mbookId = bookId;
        mbookAuthor = bookAuthor;
        missued = issued;
        mbclass =bookclass;
    }

}
