package multithreading.exercises.ex01_ticketsales;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.Executors;

public class Customers {
    public static void main(String[] args) {
        var nbCustomers = 20;
        var bookingSystem = new BookingSystem();
        var assignedSeats = Collections.synchronizedList(new ArrayList<String>());
        try (var executor = Executors.newFixedThreadPool(nbCustomers)) {
            // wait until all customers are ready: simulates opening ticket sales
            var ticketSalesOpening = new CyclicBarrier(nbCustomers);
            for (int i = 0; i < nbCustomers; i++) {
                final var customer = "Customer %02d".formatted(i);
                executor.execute(() -> {
                    try {
                        ticketSalesOpening.await();
                        var seats = bookingSystem.bookSeats(customer, 1);
                        System.out.println(customer + ": " + seats);
                        assignedSeats.addAll(seats);
                    } catch (IllegalStateException e) {
                        // no tickets left for customer
                    } catch (BrokenBarrierException | InterruptedException e) {
                        e.printStackTrace();
                    }
                });
            }
        }
        var uniqueSeats = new HashSet<>(assignedSeats);
        System.out.println((assignedSeats.size() - uniqueSeats.size()) + " overbookings.");
    }
}
