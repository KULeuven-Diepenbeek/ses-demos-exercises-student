package exercises.observer;

import java.util.ArrayList;
import java.util.List;

public class WeatherData {
    private double temperature;
    private double humidity;
    private double pressure;

    private List<WeatherObserver> observers = new ArrayList<>();

    public WeatherData() {
    }

    public void addObserver(WeatherObserver observer) {
        observers.add(observer);
    }

    public void removeObserver(WeatherObserver observer) {
        observers.remove(observer);
    }

    public void measurementsChanged() {
        for (var observer : observers) {
            observer.update(temperature, humidity, pressure);
        }
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // Getters and Setters for temperature, humidity, pressure
}

