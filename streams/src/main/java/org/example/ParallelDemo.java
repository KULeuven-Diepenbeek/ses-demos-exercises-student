package org.example;

import java.util.stream.IntStream;
import java.util.stream.LongStream;

public class ParallelDemo {
    public static void main(String[] args) {
        var start = System.nanoTime();
        var result = LongStream.range(0, 300_000_000L).filter(i -> i % 7 == 0).boxed().toList();
        var end = System.nanoTime();
        System.out.println(result.size());
        System.out.println((end - start)/1e9);

        start = System.nanoTime();
        result = LongStream.range(0, 300_000_000L).parallel().filter(i -> i % 7 == 0).boxed().toList();
        end = System.nanoTime();
        System.out.println(result.size());
        System.out.println((end - start)/1e9);
    }
}
