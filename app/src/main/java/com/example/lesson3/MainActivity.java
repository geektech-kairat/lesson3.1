package com.example.lesson3;

import android.annotation.SuppressLint;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lesson3.Thread.Bishkek;
import com.example.lesson3.Thread.Osh;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {


   public static TextView weather;
   public static TextView weatherDown;


    private String[] regions = {"Бишкек", "Ош", "Ысык-кол", "Баткен", "Чуй", "Талас", "Джала-Абад"};

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

//        setMyThread();
        weather = findViewById(R.id.weather);
        weatherDown = findViewById(R.id.weatherDown);
        region();
    }

    public void region() {


        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, R.layout.item, regions);

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
            Bishkek bishkek = new Bishkek();
            bishkek.start();

            Log.e("TAG", "onItemSelected: " + bishkek.getTemperature());
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

//    public void setMyThread(){
//        runnable = this::getData;
//        myThread = new Thread(runnable);
//        myThread.start();
//    }


}