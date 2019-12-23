package com.example.library;
/**
 *Created by nischal on 12/23/2019.
 */
public class History {

    private String mIssuerId;
    private String mBookId;
    private String mToDate;
    private String mreturnDate;
    private String mIssueDate;
    private String mFineAmount;

    public History(String IssuerId, String BookId,String IssueDate,String ToDate ,String ReturnDate, String FineAmount)
    {
        mBookId=BookId;
        mFineAmount = FineAmount;
        mreturnDate = ReturnDate;
        mIssueDate = IssueDate;
        mToDate = ToDate;
        mIssuerId = IssuerId;
    }

    public String getmIssuerId() {
        return mIssuerId;
    }

    public String getmBookId() {
        return mBookId;
    }

    public String getMreturnDate() {
        if (mreturnDate == null || mreturnDate.length() == 0)
            return "-------";
        else
            return mreturnDate;
    }

    public String getmIssueDate() {
        return mIssueDate;
    }

    public String getmToDate() {
        return mToDate;
    }

    public String getmFineAmount() {
        return mFineAmount;
    }
}
