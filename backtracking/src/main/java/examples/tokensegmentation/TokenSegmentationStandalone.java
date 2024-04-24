package examples.tokensegmentation;

import java.sql.Array;
import java.util.ArrayList;
import java.util.List;

public class TokenSegmentationStandalone {

    public static void main(String[] args) {
        var string = "catsanddogs";
        var tokens = List.of("s", "an", "ca", "cat", "dog", "and", "sand", "dogs");
        System.out.println("FIND ANY");

        System.out.println(findAny(string, tokens));
        System.out.println("\nFIND ALL");
        System.out.println(findAll(string, tokens));

        System.out.println("\nFIND BEST");
        System.out.println(findOptimal(string, tokens));
    }

    public static List<String> findAny(String string, List<String> tokens) {
        return findAny(string, tokens, new ArrayList<>());
    }

    private static List<String> findAny(String remainingString, List<String> allTokens, List<String> usedTokens) {
        var prev = String.join("_", usedTokens);
        if (prev.isEmpty()) prev = "start";
        System.out.println(prev + "[\"[" + String.join(", ", usedTokens) + "], " + remainingString + "\"]");
        if (remainingString.isEmpty()) {
            System.out.println("class " + prev + " success");
            return usedTokens;
        };
        if (allTokens.stream().noneMatch(remainingString::startsWith)) {
            System.out.println("class " + prev + " fail");
            return null;
        }
        for (String tok : allTokens) {
            if (remainingString.startsWith(tok)) {
                usedTokens.add(tok);
                var thisNode = String.join("_", usedTokens);
                System.out.println(prev + " -->|" + tok + "| " + thisNode);
                var solution = findAny(remainingString.substring(tok.length()), allTokens, usedTokens);
                if (solution != null) {
                    return solution;
                } else {
                    usedTokens.removeLast();
                }
            }
        }
        return null;
    }

    public static List<List<String>> findAll(String string, List<String> tokens) {
        return findAll(string, tokens, new ArrayList<>(), new ArrayList<>());
    }

    private static List<List<String>> findAll(String remainingString, List<String> allTokens, List<String> usedTokens, List<List<String>> foundSoFar) {
        var prev = String.join("_", usedTokens);
        if (prev.isEmpty()) prev = "start";
        System.out.println(prev + "[\"[" + String.join(", ", usedTokens) + "], " + remainingString + "\"]");
        if (remainingString.isEmpty()) {
            System.out.println("class " + prev + " success");
            foundSoFar.add(List.copyOf(usedTokens));
            return foundSoFar;
        };
        if (allTokens.stream().noneMatch(remainingString::startsWith)) {
            System.out.println("class " + prev + " fail");
            return foundSoFar;
        }
        for (String tok : allTokens) {
            if (remainingString.startsWith(tok)) {
                usedTokens.add(tok);
                var thisNode = String.join("_", usedTokens);
                System.out.println(prev + " -->|" + tok + "| " + thisNode);
                findAll(remainingString.substring(tok.length()), allTokens, usedTokens, foundSoFar);
                usedTokens.removeLast();
            }
        }
        return foundSoFar;
    }

    public static List<String> findOptimal(String string, List<String> tokens) {
        return findOptimal(string, tokens, new ArrayList<>(), null);
    }

    private static List<String> findOptimal(String remainingString, List<String> allTokens, List<String> usedTokens, List<String> bestSoFar) {
        var prev = nodeName(usedTokens);
        System.out.println(node(usedTokens, remainingString));
        if (remainingString.isEmpty()) {
            var solution = List.copyOf(usedTokens);
            if (bestSoFar == null || solution.size() < bestSoFar.size()) {
                System.out.println("class " + prev + " bestsofar");
                return solution;
            } else {
                return bestSoFar;
            }
        };
        if (allTokens.stream().noneMatch(remainingString::startsWith) || (bestSoFar != null && bestSoFar.size() <= usedTokens.size())) {
            System.out.println("class " + prev + " fail");
            return bestSoFar;
        }
        for (String tok : allTokens) {
            if (remainingString.startsWith(tok)) {
                usedTokens.add(tok);
                var thisNode = nodeName(usedTokens);
                System.out.println(prev + " -->|" + tok + "| " + thisNode);
                bestSoFar = findOptimal(remainingString.substring(tok.length()), allTokens, usedTokens, bestSoFar);
                usedTokens.removeLast();
            }
        }
        return bestSoFar;
    }


    private static String nodeName(List<String> tokens) {
        if (tokens.isEmpty()) return "start";
        return String.join("_", tokens);
    }

    private static String node(List<String> tokens, String remaining) {
        return nodeName(tokens) + "[\"[" + String.join(", ", tokens) + "], " + remaining + "\"]";
    }

}
