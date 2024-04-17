package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FirstExample {
    record Person(int age) {}

    public static void main(String[] args) {
        Random rnd = new Random(123);
        List<Person> people = new ArrayList<>();
        for (int i = 0; i < 100; i++) {
            people.add(new Person(rnd.nextInt(100)));
        }

        double average = 0;
        int count = 0;
        int index = 0;
        while (index < people.size() && count < 20) {
            var person = people.get(index);
            index++;
            if (person.age() >= 18) {
                average += person.age();
                count++;
            }
        }
        average /= count;
        System.out.println(average);

        var averageStream = people.stream()
                .mapToInt(Person::age)
                .filter(a -> a >= 18)
                .limit(20)
                .average();
        System.out.println(averageStream.getAsDouble());

        Stream.of("Alpha", "Bravo", "Charlie", "Delta").takeWhile(s -> s.charAt(0) < 'C').forEach(System.out::println);
    }
}
