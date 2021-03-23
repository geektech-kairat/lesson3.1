package com.example.lesson3.Thread;

import android.util.Log;
import android.view.View;
import android.widget.TextView;


import com.example.lesson3.MainActivity;


import org.jsoup.Jsoup;

import org.jsoup.select.Elements;

public class Bishkek extends  Region {





    @Override
    public void run() {
        try {
            doc = Jsoup.connect("https://world-weather.ru/pogoda/kyrgyzstan/").get();
            Elements temp = doc.getElementsByClass("city-block");
            Elements stat = doc.getElementsByClass("tooltip wi-24 d300 reg-list");
            setTemperature(temp.get(3).child(1).text());
            Log.e("TAG", "onItemSelectedBIshkek : " + getTemperature() );
            MainActivity.weather.setText(getTemperature());



            MainActivity.weatherDown.setText(stat.attr("title"));
            Log.e("TAG", "getData: " + getWeatherЫtatus());
        } catch (Exception e) {
            Log.e("ololo", "getData: ", e);
        }
    }

}
