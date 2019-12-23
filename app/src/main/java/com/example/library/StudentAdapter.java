package com.example.library;


/**
 *Created by nischal on 12/23/2019.
 */


import android.app.Activity;
import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.List;

public class StudentAdapter extends ArrayAdapter<History> {
    private Context mcontext;
    private List<History> mhistory;

    public StudentAdapter(@NonNull Context context, int resource, @NonNull List<History> objects) {
        super(context, resource, objects);
        mcontext = context;
        mhistory=objects;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {

        if(convertView == null)
            convertView = ((Activity) getContext()).getLayoutInflater().inflate(R.layout.show_history_view, parent, false);

        TextView studentId = convertView.findViewById(R.id.showHistoryStudentId);
        TextView bookId = convertView.findViewById(R.id.showHistoryBookId);
        TextView returndate = convertView.findViewById(R.id.showHistoryStudentReturnDate);
        TextView issueddate = convertView.findViewById(R.id.showHistoryStudentIssueDate);
        TextView todate = convertView.findViewById(R.id.showHistoryStudentToDate);
        TextView fineamount = convertView.findViewById(R.id.showHistoryFineAmt);

        studentId.setText(mhistory.get(position).getmIssuerId());
        returndate.setText(mhistory.get(position).getMreturnDate());
        bookId.setText(mhistory.get(position).getmBookId());
        issueddate.setText(mhistory.get(position).getmIssueDate());
        fineamount.setText(mhistory.get(position).getmFineAmount());
        todate.setText(mhistory.get(position).getmToDate());



        return convertView;
    }
}
