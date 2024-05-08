package exercises.observer;

// Display elements
class CurrentConditionsDisplay {
    public void update(double temp, double humidity, double pressure) {
        System.out.println("Current conditions: " + temp + "°C and " + humidity + "% humidity");
    }
}
