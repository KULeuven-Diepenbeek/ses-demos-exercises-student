package org.example;

import java.util.Collections;
import java.util.function.Function;
import java.util.stream.IntStream;
import java.util.stream.StreamSupport;

public class MapMultiDemo {

    public static void main(String[] args) {
        IntStream.range(1, 4) // => 1 2 3
                .flatMap((value) -> IntStream.generate(() -> value).limit(value))
                .forEach(System.out::println);

        IntStream.range(1, 4) // => 1 2 3
                .mapMulti((value, output) -> {
                    for (int i = 0; i < value; i++) {
                        output.accept(value);
                    }
                }).forEach(System.out::println); // => 1 2 2 3 3 3
    }
}
