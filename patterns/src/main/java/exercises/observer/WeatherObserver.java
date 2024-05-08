package exercises.observer;

public interface WeatherObserver {
    void update(double temperature, double humidity, double pressure);
}
