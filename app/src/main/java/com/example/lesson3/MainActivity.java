package com.example.lesson3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.PorterDuff;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.TextView;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;


public class MainActivity extends AppCompatActivity implements AdapterView.OnItemSelectedListener {

    TextView weather;
    TextView weatherDown;
    Document doc;

    Thread myThread;
    Runnable runnable;


    public void getData() {
        try {
            doc = Jsoup.connect("https://world-weather.ru/pogoda/kyrgyzstan/bishkek/").get();
            Elements elements = doc.getElementsByClass("weather-now-number");
            Log.e("ololo", "getData: ");
            Element element = elements.get(0);
        } catch (Exception e) {
            Log.e("ololo", "getData: ", e);
        }
    }

    private String[] regions = {"Бишкек", "Ош", "Ысык-кол", "Баткен", "Чуй", "Талас", "Джала-Абад"};

    @SuppressLint("SimpleDateFormat")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setMyThread();
        weather = findViewById(R.id.weather);
        weatherDown = findViewById(R.id.weatherDown);

        region();
    }

    public void region() {


        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, R.layout.item, regions);

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

    public void setMyThread(){
        runnable = this::getData;
        myThread = new Thread(runnable);
        myThread.start();
    }


}