package exercises.observer;

class ForecastDisplay implements WeatherObserver {
    @Override
    public void update(double temp, double humidity, double pressure) {
        System.out.println("Forecast: More of the same");
    }
}
