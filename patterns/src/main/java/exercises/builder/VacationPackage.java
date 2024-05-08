package exercises.builder;

import java.time.LocalDate;
import java.util.List;

public class VacationPackage {
    private final String hotel;
    private final String departureCity;
    private final String destinationCity;
    private final LocalDate departureDate;
    private final LocalDate returnDate;
    private final List<String> tours;
    private final String carRental;
    private final List<String> meals;

    public VacationPackage(String hotel, String departureCity, String destinationCity,
                           LocalDate departureDate, LocalDate returnDate, List<String> tours,
                           String carRental, List<String> meals) {
        this.hotel = hotel;
        this.departureCity = departureCity;
        this.destinationCity = destinationCity;
        this.departureDate = departureDate;
        this.returnDate = returnDate;
        this.tours = tours;
        this.carRental = carRental;
        this.meals = meals;
    }

}