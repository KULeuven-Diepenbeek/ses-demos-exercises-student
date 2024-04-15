package multithreading.exercises.ex01_ticketsales;

import java.util.*;

public class BookingSystem {

    private final String[] seats = {"A", "B", "C", "D", "E", "F"};
    private int availableTickets = seats.length;
    private final Map<String, String> seatAssignments = new HashMap<>();

    public boolean isAssigned(String seat) {
        return seatAssignments.containsKey(seat);
    }

    private void assignSeat(String seat, String customer) {
        // simulate that creating a ticket takes some time
        try {
            Thread.sleep(100);
        } catch (InterruptedException ignored) {
        }
        seatAssignments.put(seat, customer);
    }

    public List<String> bookSeats(String customer, int requestedSeats) {
        if (requestedSeats > availableTickets) throw new IllegalStateException("Not enough seats available");

        // simulate that preprocessing takes a lot of time
        try {
            Thread.sleep(2000);
        } catch (InterruptedException ignored) {
        }
        List<String> seatsForCustomer = new ArrayList<>();
        int seatIndex = 0;
        while (seatsForCustomer.size() < requestedSeats) {
            String seat = seats[seatIndex];
            if (!isAssigned(seat)) {
                assignSeat(seat, customer);
                seatsForCustomer.add(seat);
            }
            seatIndex++;
        }
        availableTickets -= requestedSeats;
        return seatsForCustomer;
    }
}
