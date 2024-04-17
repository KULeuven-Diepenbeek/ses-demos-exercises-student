package streams.exercises.exercise1;

import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        exercise01();
    }

    private static void exercise01() {
        var result = "TODO";
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