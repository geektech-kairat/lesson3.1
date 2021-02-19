package com.example.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView weather;
    TextView weatherDown;

    ImageButton camera;
    ImageButton call;
    ImageButton chrome;


    private String[] regions = {"Бишкек", "Ош", "Ысык-кол", "Баткен", "Чуй", "Талас", "Джала-Абад"};

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        weather = findViewById(R.id.weather);
        weatherDown = findViewById(R.id.weatherDown);

        camera = findViewById(R.id.camera);
        chrome = findViewById(R.id.chrome);
        call = findViewById(R.id.call);

        intent();

        region();


    }

    public void region() {


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_spinner_item, regions);

        Spinner spinner = findViewById(R.id.spinner_city);
        spinner.getBackground().setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);


    }

    @SuppressLint("SetTextI18n")
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        if (position == 0) {
            weather.setText("25 °6 ");
            weatherDown.setText("Солнечно ");
        } else if (position == 1) {
            weather.setText("25 °4 ");
            weatherDown.setText(" Птицы весело поют  \n на ветках деревьев. ");
        } else if (position == 2) {
            weather.setText("15 °5 ");
            weatherDown.setText(" Небольшой ветер");
        } else if (position == 3) {
            weather.setText("12 °3 ");
            weatherDown.setText("Туманно");
        } else if (position == 4) {
            weather.setText("15 °1 ");
            weatherDown.setText("Облачно");
        } else if (position == 5) {
            weather.setText("16 °8 ");
            weatherDown.setText("Туманно");
        }


    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

    public void intent() {
        call.setOnClickListener(v -> {
            Intent intent = new Intent(MainActivity.this, Call.class);
            startActivity(intent);

        });
        camera.setOnClickListener(v -> {
            Intent intent2 = new Intent(MainActivity.this, Camera.class);
            startActivity(intent2);
        });
        chrome.setOnClickListener(v -> {
            Intent intent3 = new Intent(MainActivity.this, Chrome.class);
            startActivity(intent3);

        });
    }
}