package com.example.library;
/**
 *Created by nischal on 12/23/2019.
 */
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.os.Build;

import androidx.annotation.Nullable;
import androidx.annotation.RequiresApi;

public class DatabaseHelperClass extends SQLiteOpenHelper {

    private static String databaseName = "library.db";

    private String studentTable = "studentTable";
    private String bookTable = "bookTable";

    private String studentHistoryTable = "studentHistoryTable";

    private String loginTable = "loginTable";
    private String adminTable = "adminTable";

    private String studentTableSID = "sID";
    private String studentTableNAME = "name";
    private String studentTablePHONE = "phone";
    private String studentTableEMAILID = "email_id";
    private String studentTableClass = "sclass";


    private String bookTableID = "bID";
    private String bookTableTITLE = "title";
    private String bookTableAUTHOR = "author";
    private String bookTableEDITION = "edition";
    private String bookTablePUBLICATION = "publication";
    private String bookTableGENRE = "genre";
    private String bookTableYEAR = "year";
    private String bookTablePRICE = "price";
    private String bookTableISSUED = "issued";
    private String bookTableClass = "bclass";

    private String studentHistoryTableISSUERID = "issuer_id";
    private String studentHistoryTableBID = "bid";
    private String studentHistoryTableISSUEDATE = "issue_date";
    private String studentHistoryTableTODATE ="to_date";
    private String studentHistoryTableRETURNDATE = "return_date";
    private String studentHistoryTableFINEAMT = "fine_amt";



    private String adminTableID = "aID";
    private String adminTableNAME = "name";
    private String adminTableNUMBER= "phone" ;

    private String loginTableUID = "uID";
    private String loginTablePASSWORD = "password";
    private String loginTableSECQTN = "security_qtn";
    private String loginTableSECANS = "security_ans";


    private Context mcontext;


    public DatabaseHelperClass(@Nullable Context context) {
        super(context, databaseName, null, 1);
        mcontext = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL("create table if not exists "+studentTable+"("+studentTableSID+" varchar(10) primary key, "+studentTableNAME +" varchar(30), "
                + studentTableEMAILID+" varchar(20), "+ studentTablePHONE+" char(10), "+studentTableClass+"  varchar(15))");


        db.execSQL("create table if not exists "+bookTable+"("+bookTableID+" char(4) primary key, "+ bookTableTITLE +" varchar(30), "
                + bookTableAUTHOR+" varchar(20), "+ bookTableEDITION+ " varchar(2)," + bookTableGENRE+" varchar(10),"+ bookTablePRICE+" varchar(5),"
                + bookTableISSUED+"  varchar(3)," + bookTablePUBLICATION+"  varchar(20),"  + bookTableYEAR+"  char(4), "+bookTableClass+" varchar(10))");

        db.execSQL("create table if not exists " + studentHistoryTable+"("+studentHistoryTableBID+" char(4) ,"+ studentHistoryTableISSUERID +" varchar(10), "
                + studentHistoryTableISSUEDATE+" date, "+ studentHistoryTableTODATE+" date, "+ studentHistoryTableRETURNDATE+" date, "+ studentHistoryTableFINEAMT+" varchar(5))");


        db.execSQL("create table if not exists "+adminTable+"("+adminTableID+" varchar(20) primary key, "+adminTableNAME +" varchar(15), "
                +adminTableNUMBER+" char(10))");

        db.execSQL("create table if not exists "+loginTable+"("+loginTableUID+" varchar(20) primary key, "+ loginTablePASSWORD +" varchar(15),"+ loginTableSECQTN +
                " varchar(50)," + loginTableSECANS + " varchar(50))");

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

        db.execSQL("drop table if exists "+ studentTable);
        db.execSQL("drop table if exists "+ bookTable);
        db.execSQL("drop table if exists "+ adminTable);
        db.execSQL("drop table if exists "+ loginTable);
        onCreate(db);
    }

    public boolean insertIntoSignUp(String name,String emailid,String number,String password,String securityqtn,String securityans)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues valuesIntoAdminTable = new ContentValues();
        valuesIntoAdminTable.put(adminTableID,emailid);
        valuesIntoAdminTable.put(adminTableNAME,name);
        valuesIntoAdminTable.put(adminTableNUMBER,number);

        ContentValues valuesIntoLoginTable = new ContentValues();
        valuesIntoLoginTable.put(loginTableUID,emailid);
        valuesIntoLoginTable.put(loginTablePASSWORD,password);
        valuesIntoLoginTable.put(loginTableSECQTN,securityqtn);
        valuesIntoLoginTable.put(loginTableSECANS,securityans);

        long result = db.insert(adminTable,null,valuesIntoAdminTable);
        long result1 = db.insert(loginTable,null,valuesIntoLoginTable);

        if(result==-1 || result1 == -1) {

            //Toast.makeText(mcontext, "Insertion Failed", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            //Toast.makeText(mcontext, "Insertion Successful", Toast.LENGTH_SHORT).show();
            return true;

        }
    }

    public boolean insertIntoStudent(String sname,String emailid,String phone,String SClass,String ID)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues valuesintostudentTable = new ContentValues();
        valuesintostudentTable.put(studentTableSID,ID);
        valuesintostudentTable.put(studentTableNAME,sname);
        valuesintostudentTable.put(studentTablePHONE,phone);
        valuesintostudentTable.put(studentTableClass,SClass);
        valuesintostudentTable.put(studentTableEMAILID,emailid);

        long result = db.insert(studentTable,null,valuesintostudentTable);

        if(result==-1 ) {

            //Toast.makeText(mcontext, "Student exists", Toast.LENGTH_SHORT).show();
            return false;
        }
        else
        {
            //Toast.makeText(mcontext, "Student added", Toast.LENGTH_SHORT).show();
            return true;

        }
    }



    public boolean insertIntoBook(String title,String bclass,String author,String ID,String price,String edition,String genre,String publisher,String year){
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues valuesintobookTable = new ContentValues();
        valuesintobookTable.put(bookTableID,ID);
        valuesintobookTable.put(bookTableClass,bclass);
        valuesintobookTable.put(bookTableTITLE,title);
        valuesintobookTable.put(bookTableAUTHOR,author);
        valuesintobookTable.put(bookTableEDITION,edition);
        valuesintobookTable.put(bookTableGENRE,genre);
        valuesintobookTable.put(bookTablePRICE,price);
        valuesintobookTable.put(bookTableISSUED,"NO");
        valuesintobookTable.put(bookTablePUBLICATION,publisher);
        valuesintobookTable.put(bookTableYEAR,year);

        long result = db.insert(bookTable,null,valuesintobookTable);


        if(result==-1 ) {

            //Toast.makeText(mcontext, "Faculty exists", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            //Toast.makeText(mcontext, "Faculty added", Toast.LENGTH_SHORT).show();
            return true;

        }
    }

    public boolean insertIntoStudentHistory(String bookid,String studentid,String issuedate,String todate,String returndate,String fine){
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues valuesIntoStudentHistory = new ContentValues();
        valuesIntoStudentHistory.put(studentHistoryTableBID,bookid);
        valuesIntoStudentHistory.put(studentHistoryTableISSUERID,studentid);
        valuesIntoStudentHistory.put(studentHistoryTableISSUEDATE,issuedate);
        valuesIntoStudentHistory.put(studentHistoryTableTODATE,todate);
        valuesIntoStudentHistory.put(studentHistoryTableRETURNDATE,returndate);
        valuesIntoStudentHistory.put(studentHistoryTableFINEAMT,fine);

        long result = db.insert(studentHistoryTable,null,valuesIntoStudentHistory);


        if(result==-1 ) {

            //Toast.makeText(mcontext, "Faculty exists", Toast.LENGTH_SHORT).show();
            return false;
        }
        else {
            //Toast.makeText(mcontext, "Faculty added", Toast.LENGTH_SHORT).show();
            return true;

        }
    }




    public Cursor getFromLogin(String userID)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+loginTable +" where "+loginTableUID +" = "+ " '"+userID+"'",null);
        return res;
    }

    public Cursor getFromBooks()
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+bookTable,null);
        return res;
    }

    public Cursor getAboutABook(String bookID)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+bookTable +" where "+bookTableID +" = "+ " '"+bookID+"'",null);
        return res;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Cursor getAllAboutBook(String bookTableClass1)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+bookTable+" where "+bookTableClass +" = "+ " '"+bookTableClass1+"'",null);
        return res;
    }

    public Cursor getAboutAStudent(String studentID)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+studentTable +" where "+studentTableSID +" = "+ " '"+studentID+"'",null);
        return res;
    }



    public Cursor getFromStudents()
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+studentTable,null);
        return res;
    }

    public Cursor getAllFromStudentHistory()
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+studentHistoryTable,null);
        return res;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Cursor getAllFromStudentHistoryStudent(String studentid)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+studentHistoryTable+ " where "+ studentHistoryTableISSUERID +" = "+ " '"+studentid+"'",null );
        return res;
    }
    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Cursor getAllFromStudentHistoryBook(String bookid)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+studentHistoryTable+ " where "+ studentHistoryTableBID +" = "+ " '"+bookid +"'",null );
        return res;
    }

    @RequiresApi(api = Build.VERSION_CODES.JELLY_BEAN)
    public Cursor getAvailableBooksCount(String Issued)
    {
        //String countQuery = "SELECT  * FROM " + bookTable + " where " + bookTableISSUED + " = "+" '"+Issued+"'";
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        //Cursor res = db.rawQuery("select * from "+bookTable+" where bookTableISSUED= YES ",null);
        Cursor res = db.rawQuery ( "SELECT  * FROM " + bookTable + " where " + bookTableISSUED + " = "+" '"+"NO"+"'",null);
       return res;
    }
    public Cursor getTotalBooksCount()
    {
        //String countQuery = "SELECT  * FROM " + bookTable + " where " + bookTableISSUED + " = "+" '"+Issued+"'";
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        //Cursor res = db.rawQuery("select * from "+bookTable+" where bookTableISSUED= YES ",null);
        Cursor res = db.rawQuery ( "SELECT  * FROM " + bookTable, null);
        return res;
    }



    public Cursor getFromAdmin(String userId)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+adminTable+" where "+adminTableID +"= "+" '"+userId+"'",null);
        return res;
    }





    public Cursor getFromStudentHistory(String studentID, String bookID)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor res = db.rawQuery("select * from "+studentHistoryTable + " where "+studentHistoryTableBID +"= ? and " +
                        studentHistoryTableISSUERID + "= ? and " + studentHistoryTableRETURNDATE +" is null"
                ,new String[]{bookID,studentID});
        return res;
    }

    public boolean updatePassword(String userID, String newpassword)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues loginTableUpdate = new ContentValues();
        loginTableUpdate.put(loginTableUID,userID);
        loginTableUpdate.put(loginTablePASSWORD,newpassword);

        int res = db.update(loginTable,loginTableUpdate,loginTableUID+" = ?", new String[] { userID });

        if(res==0)
            return false;
        else
            return true;
    }



    public boolean updateStudentHistoryTable(String bookid, String studentid,String IssueDate,String todate, String ReturnDate,String Fineamt)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues studentHistoryTableUpdate = new ContentValues();
        studentHistoryTableUpdate.put(studentHistoryTableBID,bookid);
        studentHistoryTableUpdate.put(studentHistoryTableISSUERID,studentid);
        studentHistoryTableUpdate.put(studentHistoryTableISSUEDATE,IssueDate);
        studentHistoryTableUpdate.put(studentHistoryTableTODATE,todate);
        studentHistoryTableUpdate.put(studentHistoryTableRETURNDATE,ReturnDate);
        studentHistoryTableUpdate.put(studentHistoryTableFINEAMT,Fineamt);

        int res = db.update(studentHistoryTable,studentHistoryTableUpdate,studentHistoryTableBID+" = ? and "+
                studentHistoryTableISSUERID+ " = ? and "+studentHistoryTableRETURNDATE+ " is null", new String[] { bookid,studentid });

        if(res==0)
            return false;
        else
            return true;
    }

    public boolean updateIssuedOfBook(String title,String bclass,String author,String ID,String price,String edition,String genre,String publisher,String year,String issued)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues bookTableUpdate = new ContentValues();
        bookTableUpdate.put(bookTableID,ID);
        bookTableUpdate.put(bookTableClass,bclass);
        bookTableUpdate.put(bookTableTITLE,title);
        bookTableUpdate.put(bookTableAUTHOR,author);
        bookTableUpdate.put(bookTableEDITION,edition);
        bookTableUpdate.put(bookTableGENRE,genre);
        bookTableUpdate.put(bookTablePRICE,price);
        bookTableUpdate.put(bookTableISSUED,issued);
        bookTableUpdate.put(bookTablePUBLICATION,publisher);
        bookTableUpdate.put(bookTableYEAR,year);

        int res = db.update(bookTable,bookTableUpdate,bookTableID+" = ?", new String[] { ID });

        if(res==0)
            return false;
        else
            return true;
    }

    public boolean updateStudent(String ID,String name,String email,String phone,String sclass)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues studentTableUpdate = new ContentValues();
        studentTableUpdate.put(studentTableSID,ID);
        studentTableUpdate.put(studentTableNAME,name);
        studentTableUpdate.put(studentTableEMAILID,email);
        studentTableUpdate.put(studentTablePHONE,phone);
        studentTableUpdate.put(studentTableClass,sclass);

        int res = db.update(studentTable,studentTableUpdate,studentTableSID+" = ?", new String[] { ID });

        if(res==0)
            return false;
        else
            return true;
    }



    public boolean updateAdminTable(String newname , String id , String newphone)
    {
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        ContentValues adminTableUpdate = new ContentValues();
        adminTableUpdate.put(adminTableNAME,newname);
        adminTableUpdate.put(adminTableNUMBER,newphone);
        adminTableUpdate.put(adminTableID,id);


        int res = db.update(adminTable,adminTableUpdate,adminTableID+" = ?", new String[] { id });

        if(res==0)
            return false;
        else
            return true;
    }

    public boolean deletefromAdmin(String email){
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();

        int res1 = db.delete(adminTable,adminTableID+" = ?",new String[] {email});
        int res2 = db.delete(loginTable,loginTableUID+" = ?",new String[] {email});

        if(res1==0 || res2==0)
            return false;
        else
            return true;

    }

    public boolean deletefromStudent(String sid){
        SQLiteDatabase db = DatabaseHelperClass.this.getWritableDatabase();
        Cursor student = db.rawQuery("select * from "+ studentHistoryTable+ " where "+studentHistoryTableISSUERID +" = ? and "
                        +studentHistoryTableRETURNDATE+ " is null"
                , new String[]{sid});
        if(student.getCount() == 0)
        {
            int res1 = db.delete(studentTable, studentTableSID + " = ?", new String[]{sid});

            if (res1 == 0)
                return false;
            else
                return true;
        }
        else {
            return false;
        }
    }


}
