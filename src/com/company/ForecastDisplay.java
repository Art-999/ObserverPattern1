package com.company;

import com.company.interfaces.DisplayElement;
import com.company.interfaces.Observer;
import com.company.interfaces.Subject;

public class ForecastDisplay implements Observer, DisplayElement {
    private float temp;
    private float humidity;
    private float pressure;
    private Subject weatherDate;

    public ForecastDisplay(Subject weatherDate) {
        this.weatherDate = weatherDate;
        weatherDate.registerObserver(this);
    }

    @Override
    public void update(float temp, float humidity, float pressure) {
        this.temp = temp;
        this.humidity = humidity;
        this.pressure = pressure;
        display();
    }

    @Override
    public void display() {
        System.out.println("temp: " + temp + " ,humidity: " + humidity + " ,pressure: " + pressure);
    }
}
