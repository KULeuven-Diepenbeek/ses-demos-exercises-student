package exercises.observer;

public class Main {
    public static void main(String[] args) {
        CurrentConditionsDisplay currentDisplay = new CurrentConditionsDisplay();
        ForecastDisplay forecastDisplay = new ForecastDisplay();
        StatisticsDisplay statisticsDisplay = new StatisticsDisplay();
        WeatherData data = new WeatherData(
                currentDisplay,
                statisticsDisplay,
                forecastDisplay
        );

        data.setMeasurements(21, 45, 103);
    }
}
