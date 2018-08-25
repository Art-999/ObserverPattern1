package com.company;

import com.company.interfaces.Observer;
import com.company.interfaces.Subject;

import java.util.ArrayList;

public class WeatherData implements Subject {
    private ArrayList observersList;
    private float temp;
    private float humidity;
    private float pressure;

    public WeatherData() {
        observersList = new ArrayList();
    }

    @Override
    public void registerObserver(Observer observer) {
        observersList.add(observer);
    }

    @Override
    public void removeObserver(Observer observer) {
        int index = observersList.indexOf(observer);
        if (index >= 0) {
            observersList.remove(observer);
        }

    }

    @Override
    public void notifyObservers() {
        for (int i = 0; i < observersList.size(); i++) {
            Observer observer = (Observer) observersList.get(i);
            observer.update(temp, humidity, pressure);
        }
    }

    public void measurmentsChanged() {
        notifyObservers();
    }

    public void setMeasurments(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        measurmentsChanged();
    }
}
