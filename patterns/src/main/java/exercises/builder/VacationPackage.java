package exercises.builder;

import java.time.LocalDate;
import java.util.ArrayList;
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

    private VacationPackage(String hotel, String departureCity, String destinationCity,
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

    public static class Builder {
        private String hotel;
        private String destinationCity;
        private String departureCity;
        private LocalDate departureDate;
        private LocalDate returnDate;
        private List<String> tours = new ArrayList<>();
        private String carRental;
        private List<String> meals = new ArrayList<>();

        public Builder hotel(String hotel) {
            this.hotel = hotel;
            return this;
        }

        public Builder destinationCity(String dest) {
            this.destinationCity = dest;
            return this;
        }

        public Builder departureCity(String depart) {
            this.departureCity = depart;
            return this;
        }

        public Builder departureDate(LocalDate depDate) {
            this.departureDate = depDate;
            return this;
        }

        public Builder returnDate(LocalDate returnDate) {
            this.returnDate = returnDate;
            return this;
        }

        public Builder addTour(String tour) {
            tours.add(tour);
            return this;
        }

        public Builder carRental(String car) {
            this.carRental = car;
            return this;
        }

        public Builder addMeal(String meal) {
            this.meals.add(meal);
            return this;
        }

        public VacationPackage build() {
            return new VacationPackage(hotel, departureCity, destinationCity,
                    departureDate, returnDate, tours,
                    carRental, meals);
        }
    }
}