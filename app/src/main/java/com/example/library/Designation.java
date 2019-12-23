package com.example.library;
/**
 *Created by nischal on 12/23/2019.
 */
public class Designation {

    private String mName;
    private String mEmail;
    private String mphoneNumber;
    private String mClass;
    private String mId;

    public Designation(String mName, String mEmail, String mphoneNumber, String mClass, String mId) {
        this.mName = mName;
        this.mEmail = mEmail;
        this.mphoneNumber = mphoneNumber;
        this.mClass = mClass;
        this.mId = mId;
    }

    public String getmName() {
        return mName;
    }

    public String getmEmail() {
        return mEmail;
    }

    public String getMphoneNumber() {
        return mphoneNumber;
    }

    public String getmClass() {
        return mClass;
    }

    public String getmId() {
        return mId;
    }
}
