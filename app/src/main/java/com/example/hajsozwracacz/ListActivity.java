package com.example.hajsozwracacz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;

public class ListActivity extends AppCompatActivity {

    private static final String TAG = "ListActivity";

    private Button mbtback;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        String cash = getIntent().getStringExtra("cash");
        String persons = getIntent().getStringExtra("persons");
        String sum = getIntent().getStringExtra("sum");

        mbtback = findViewById(R.id.btBack);

        Log.d(TAG, "onCreate: Started.");
        ListView mListView = (ListView) findViewById(R.id.lv);

        //Create the DataRecord object
        DataRecord dataRecord = new DataRecord(cash, persons, sum);
        DataRecord dataRecord2 = new DataRecord("505", "20", "45");

        //Add data objects to an ArrayList
        ArrayList<DataRecord> dataRecordList = new ArrayList<>();
        dataRecordList.add(dataRecord);
        dataRecordList.add(dataRecord2);

       DataRecordAdapter adapter = new DataRecordAdapter(this, R.layout.adapter_view_layout, dataRecordList);
       mListView.setAdapter(adapter);

        mbtback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                finishActivity(1);
                finish();
            }
        });

    }
}