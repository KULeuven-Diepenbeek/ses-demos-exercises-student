package org.example;

import java.util.List;

public class Lazyness {
    public static void main(String[] args) {
        var list = List.of(1, 2, 3, 4, 5, 6, 7, 8, 9, 10);

        var incrementAll = list.stream().map(n -> {
            System.out.println("Processing " + n);
            return n + 1;
        });

        // hier wordt niets geprint

        incrementAll.limit(1).forEach(n -> {
            System.out.println("Got " + n);
        });

        // print "Processing 1" en "Got 2"
    }
}
