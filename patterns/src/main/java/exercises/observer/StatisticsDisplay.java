package exercises.observer;

class StatisticsDisplay implements WeatherObserver {
    @Override
    public void update(double temp, double humidity, double pressure) {
        System.out.println("Statistics: " + temp + "°C");
    }
}
