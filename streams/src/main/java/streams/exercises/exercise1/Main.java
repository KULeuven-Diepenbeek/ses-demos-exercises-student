package streams.exercises.exercise1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        exercise01();
        exercise02();
        exercise03();
        exercise04();
        exercise05();
        exercise06();
        exercise07();
        exercise08();
        exercise09();
        exercise10();
    }

    private static void exercise01() {
        var result = Data.DATASET.stream()
                .map(a -> a.firstName() + " " + a.lastName())
                .toList();
        print(result);
    }

    private static void exercise02() {
        var result = Data.DATASET.stream()
                .mapToInt(Adult::age)
                .allMatch(a -> a >= 18);
        print(result);
    }

    private static void exercise03() {
        var result = Data.DATASET.stream()
                .map(a -> a.firstName())
                .anyMatch(n -> "Joseph".equals(n));
        result = Data.DATASET.stream()
                .filter(a -> "Joseph"
                        .equals(a.firstName()))
                .count() > 0;
        result = Data.DATASET.stream()
                .anyMatch(a -> "Joseph"
                        .equals(a.firstName()));
        print(result);
    }

    private static void exercise04() {
        var result = Data.DATASET.stream()
                .filter(a -> a.age() >= 30)
                .mapToInt(Adult::age)
                .summaryStatistics();
        print(result);
    }

    private static void exercise05() {
        var result = Data.DATASET.stream()
                .max(Comparator.comparing(a ->
                        a.lastName().length()));
        print(result);
    }

    private static void exercise06() {
        Map<String, List<Adult>> result = Data.DATASET.stream()
                .collect(Collectors.groupingBy(
                        a -> a.zipCode()));
        print(result);
    }

    private static void exercise07() {
        var result = Data.DATASET.stream()
                .sorted(Comparator.comparing(
                        (Adult a) -> a.age()).reversed())
                .limit(5)
                .sorted(Comparator.comparing(Adult::firstName))
                .map(a -> a.firstName() + " " + a.lastName() +
                        " " + a.age())
                .collect(Collectors.joining("\n"));

        print(result);
    }

    private static void exercise08() {
        var result = Data.DATASET.stream()
                        .mapToInt(a -> a.children().size())
                        .sum();
        print(result);
    }

    private static void exercise09() {
        var result = Data.DATASET.stream()
                .filter(a -> !a.children().isEmpty())
                .count();
        print(result);
    }

    private static void exercise10() {
        var result = Data.DATASET.stream()
                .mapToInt(a -> a.children().size())
                .summaryStatistics();
        print(result.getMax() + " " + result.getMin());
    }

    private static void exercise11() {
        var result = Data.DATASET.stream()
                .filter(a -> a.children()
                        .stream().anyMatch(c -> 6 * c.age() == a.age()))
                .toList();

        print(result);
    }

    private static void exercise12() {

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