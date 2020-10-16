package com.example.hajsozwracacz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.graphics.Color;
import android.os.Bundle;
import android.text.Spannable;
import android.text.SpannableString;
import android.text.style.ForegroundColorSpan;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView mtvLogo;
    private EditText metCash;
    private EditText metPersons;
    private TextView mtvZiomek;
    private TextView mtvCashBack;
    private Button mbtCheck;

    private String cas;
    private String per;
    private double sum;

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

        mbtCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                cas = metCash.getText().toString().trim();
                per = metPersons.getText().toString().trim();

                if (cas.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Podaj ile kasy wydałeś", Toast.LENGTH_LONG).show();
                } else if (per.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Podaj ile osób się składa", Toast.LENGTH_LONG).show();
                } else {

                    try {

                        mtvZiomek.setText("Każdy ziomek musi Ci oddać po: ");

                        sum = Integer.parseInt(cas) / Integer.parseInt(per);
                        String sumStr = String.valueOf(sum);

                        mtvCashBack.setText(sumStr + " PLN");


                    } catch (Resources.NotFoundException e) {
                        e.printStackTrace();
                        Toast.makeText(MainActivity.this, "Error coś się zjebało", Toast.LENGTH_LONG).show();
                    }
                }
            }
        });
    }
}