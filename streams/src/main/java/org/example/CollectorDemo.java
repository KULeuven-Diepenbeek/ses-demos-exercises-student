package org.example;

import java.util.LinkedList;
import java.util.Set;
import java.util.StringJoiner;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class CollectorDemo {
    static class StringJoiningCollector implements Collector<String, StringJoiner, String> {

        @Override
        public Supplier<StringJoiner> supplier() {
            return () -> new StringJoiner(", ", "", "");
        }

        @Override
        public BiConsumer<StringJoiner, String> accumulator() {
            return StringJoiner::add;
        }

        @Override
        public BinaryOperator<StringJoiner> combiner() {
            return StringJoiner::merge;
        }

        @Override
        public Function<StringJoiner, String> finisher() {
            return StringJoiner::toString;
        }

        @Override
        public Set<Characteristics> characteristics() {
            return Set.of();
        }
    }
    public static void main(String[] args) {
        System.out.println(Stream.of("Alpha", "Bravo", "Charlie", "Delta").collect(new StringJoiningCollector()));
    }
}
