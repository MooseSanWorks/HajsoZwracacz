package com.example.hajsozwracacz;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;


public class DataRecordAdapter extends ArrayAdapter<DataRecord> {

    private  static final String TAG = "DataRecordAdapter";
    private Context mContext;
    int mResource;

    public DataRecordAdapter(@NonNull Context context, int resource, @NonNull ArrayList<DataRecord> objects) {
        super(context, resource, objects);
        mContext = context;
        mResource = resource;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        //Get the data information
        String cash = getItem(position).getCash();
        String person = getItem(position).getPersons();
        String sum = getItem(position).getCashBack();

        //Create the data object with the information
        DataRecord dataRecord = new DataRecord(cash, person, sum);

        LayoutInflater inflater = LayoutInflater.from(mContext);
        convertView = inflater.inflate(mResource, parent, false);

        TextView tvCash = (TextView) convertView.findViewById(R.id.textView1);
        TextView tvPerson = (TextView) convertView.findViewById(R.id.textView2);
        TextView tvCashBack = (TextView) convertView.findViewById(R.id.textView3);

        tvCash.setText(cash);
        tvPerson.setText(person);
        tvCashBack.setText(sum);

        return convertView;
    }
}
