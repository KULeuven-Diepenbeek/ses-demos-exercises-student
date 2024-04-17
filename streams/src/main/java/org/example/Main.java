package org.example;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import static org.example.Data.DATASET;

public class Main {
    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
        exercise04();
        exercise04b();
        exercise05();
        exercise06();
        exercise07();
        exercise08();
        exercise09();
        exercise10();
    }

    private static Stream<Person> personAndAllHeirs(Person p) {
        Stream<Person> self = Stream.of(p);
        Stream<Person> heirs = Stream.empty();
        if (p instanceof Adult par) {
            heirs = par.children().stream().flatMap(Main::personAndAllHeirs);
        }
        return Stream.concat(self, heirs);
    }

    private static Stream<Adult> allParents() {
        return DATASET.stream();
    }

    private static Stream<Person> allPeople() {
        return DATASET.stream().flatMap(Main::personAndAllHeirs);
    }

    private static void exercise10() {
        var result = allParents()
                .filter(p -> p.children().stream().anyMatch(c -> p.age() == 6 * c.age()))
                .toList();
        print(result);
    }

    private static void exercise09() {
        var result = allPeople()
                .mapToInt(p -> p.lastName().length())
                .summaryStatistics();
        print(result);
    }

    private static void exercise08() {
        var result = allPeople()
                .max(Comparator.comparing(p -> p.lastName().length()));
        print(result);
    }

    private static void exercise07() {
        var result = allParents()
                .filter(p -> p.age() >= 35)
                .flatMap(p -> p.children().stream())
                .mapToInt(Person::age)
                .average();
        print(result);
    }

    private static void exercise04b() {
        print(allParents().filter(p -> !p.children().isEmpty()).count());
    }

    private static void exercise04() {
        print(allParents().flatMap(p -> p.children().stream()).count());
    }

    private static void exercise06() {
        var result = allPeople()
                .sorted(Comparator.comparing(Person::age).reversed())
                .limit(5)
                .sorted(Comparator.comparing(Person::firstName))
                .map(p -> String.format("%s %s %d", p.firstName(), p.lastName(), p.age()))
                .collect(Collectors.joining("\n"));
        print(result);
    }

    private static void exercise05() {
        var result = allParents()
                .flatMap(p -> p.children().stream())
                .map(Person::firstName)
                .sorted()
                .distinct()
                .toList();
        print(result);
    }

    private static void exercise03() {
        var result = allPeople()
                .collect(Collectors.groupingBy(Person::zipCode));
        print(result);
    }

    private static void exercise02() {
        var result = allPeople()
                .filter(p -> p.firstName().equals("Joseph"))
                .findAny();
        print(result);
    }

    private static void exercise01() {
        var result = allPeople()
                .mapToInt(Person::age)
                .filter(age -> age >= 30)
                .summaryStatistics();
        print(result);
    }


    private static void print(Object value) {
        var s = Arrays.stream(Thread.currentThread().getStackTrace()).dropWhile(m -> !m.getMethodName().startsWith("ex")).findFirst().get();
        if (value instanceof Optional<?> o) {
            if (o.isPresent())
                value = o.get();
            else
                value = "Nothing found.";
        } else if (value instanceof OptionalDouble o) {
            if (o.isPresent()) {
                value = o.getAsDouble();
            } else {
                value = "Nothing found.";
            }
        }
        System.out.println("\n- " + s.getMethodName() + ":\n" + value.toString().lines().map(l -> "  " + l).collect(Collectors.joining("\n")));
    }
}