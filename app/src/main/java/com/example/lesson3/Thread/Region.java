package com.example.lesson3.Thread;

import android.view.View;

import org.jsoup.nodes.Document;

public abstract class Region extends Thread {

    private String weatherЫtatus
    ;

    private String temperature;

    protected Document doc;


    public String getWeatherЫtatus() {
        return weatherЫtatus;
    }

    public void setWeatherЫtatus(String weatherЫtatus) {
        this.weatherЫtatus = weatherЫtatus;
    }

    public String getTemperature() {
        return temperature;
    }

    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }

    @Override
    public void run() {

    }

}
