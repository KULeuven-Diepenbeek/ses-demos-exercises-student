package exercises.builder;

import java.time.LocalDate;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        // huidige manier
        VacationPackage vacation = new VacationPackage(
                "SeaView Resort", "Cancun", "New York",
                LocalDate.of(2024, 7, 10), LocalDate.of(2024, 7, 20),
                List.of("Chichen Itza Tour", "Snorkeling at Cozumel"),
                "Full-size Car", List.of("Breakfast Buffet", "Dinner Course"));

        // gewenste manier
        /*
        VacationPackage vacation = new VacationPackage.Builder()
                .hotel("SeaView Resort")
                .destinationCity("Cancun")
                .departureCity("New York")
                .departureDate(LocalDate.of(2024, 7, 10))
                .returnDate(LocalDate.of(2024, 7, 20))
                .addTour("Chichen Itza Tour")
                .addTour("Snorkeling at Cozumel")
                .carRental("Full-size Car")
                .addMeal("Breakfast Buffet")
                .addMeal("Dinner Course")
                .build();
         */
    }
}
