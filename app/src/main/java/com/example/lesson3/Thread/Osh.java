package com.example.lesson3.Thread;

import android.util.Log;

import org.jsoup.Jsoup;
import org.jsoup.select.Elements;

import java.io.IOException;

public class Osh extends  Region {


    @Override
    public void run() {
        try {
            doc = Jsoup.connect("http://bpetroleum.kg/rus/retail/").get();


            Elements bishkek = doc.getElementsByTag("tbody");
//            Log.e("TAG", "getData: " + bishkek.get(3).child(1).text());
//            setTemperature(bishkek.get(3).child(1).text());
            Log.e("TAG", "onItemSelectedBIshkek : " + bishkek.text() );

        } catch (IOException e) {
            e.printStackTrace();
        }
//            MainActivity.weather.setText(getTemperature());
    }
}
