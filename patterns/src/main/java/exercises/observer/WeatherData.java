package exercises.observer;

public class WeatherData {
    private double temperature;
    private double humidity;
    private double pressure;

    private CurrentConditionsDisplay currentDisplay;
    private StatisticsDisplay statisticsDisplay;
    private ForecastDisplay forecastDisplay;

    public WeatherData(CurrentConditionsDisplay currentDisplay, StatisticsDisplay statisticsDisplay, ForecastDisplay forecastDisplay) {
        this.currentDisplay = currentDisplay;
        this.statisticsDisplay = statisticsDisplay;
        this.forecastDisplay = forecastDisplay;
    }

    public void measurementsChanged() {
        currentDisplay.update(temperature, humidity, pressure);
        statisticsDisplay.update(temperature, humidity, pressure);
        forecastDisplay.update(temperature, humidity, pressure);
    }

    public void setMeasurements(double temperature, double humidity, double pressure) {
        this.temperature = temperature;
        this.humidity = humidity;
        this.pressure = pressure;
        measurementsChanged();
    }

    // Getters and Setters for temperature, humidity, pressure
}

