package org.example;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collector;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class FunctionalinterfaceDemo {
    record Person(String name, int age) {}

    @FunctionalInterface
    interface PersonPredicate {
        public boolean test(Person person);
    }

    public static List<Person> selectPeople(List<Person> people, PersonPredicate predicate) {
        List<Person> result = new ArrayList<>();
        for (Person p : people) {
            if (predicate.test(p)) {
                result.add(p);
            }
        }
        return result;
    }

    static class IsAdult implements PersonPredicate {
        @Override
        public boolean test(Person person) {
            return person.age() >= 18;
        }
    }

    public static void main(String[] args) {
        List<Person> people = List.of(new Person("Vandeneynde", 16), new Person("Vervoort", 23));
        System.out.println(selectPeople(people, new IsAdult()));

        System.out.println(selectPeople(people, new PersonPredicate() {
            @Override
            public boolean test(Person person) {
                return person.name().startsWith("Van");
            }
        }));

        System.out.println(selectPeople(people, p -> p.age() >= 18));
        System.out.println(selectPeople(people, p -> p.name().startsWith("Van")));

    }

}
