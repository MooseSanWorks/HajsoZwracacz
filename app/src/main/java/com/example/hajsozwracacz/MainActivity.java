package com.example.hajsozwracacz;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.res.Resources;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Locale;

public class MainActivity extends AppCompatActivity {


    public String data;
    private TextView mtvLogo;
    private EditText metCash;
    private EditText metPersons;
    private TextView mtvZiomek;
    private TextView mtvCashBack;
    private Button mbtCheck;
    private Button mbtHistory;

    private String cash;
    private String persons;
    private double sum;
    private String sumStr;

    public String getData() {
        return data;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mtvLogo = findViewById(R.id.tvLogo);
        metCash = findViewById(R.id.etCash);
        metPersons = findViewById(R.id.etPersons);
        mtvZiomek = findViewById(R.id.tvZiomek);
        mtvCashBack = findViewById(R.id.tvCashBack);
        mbtCheck = findViewById(R.id.btCheck);
        mbtHistory = findViewById(R.id.btHistory);

        mbtCheck.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View v) {

                cash = metCash.getText().toString().trim();
                persons = metPersons.getText().toString().trim();

                if (cash.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Podaj ile kasy wydałeś", Toast.LENGTH_LONG).show();
                } else if (persons.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Podaj ile osób się składa", Toast.LENGTH_LONG).show();
                } else {

                    try {

                        mtvZiomek.setText("Każdy ziomek musi Ci oddać po: ");

                        sum = Double.parseDouble(cash) / Double.parseDouble(persons);
                        sumStr = String.format(Locale.ENGLISH, "%,.2f", sum);

                        mtvCashBack.setText(sumStr + " PLN");

                       data = (cash + " PLN / " + persons + " os. = " + sumStr + "PLN");

                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error coś poszło nie tak", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });

        mbtHistory.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(getBaseContext(), ListActivity.class);
                intent.putExtra("cash", cash);
                intent.putExtra("persons", persons);
                intent.putExtra("sum", sumStr);
                startActivityForResult(intent, 1);
            }
        });


    }


}