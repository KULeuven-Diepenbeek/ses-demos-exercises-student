package examples.tokensegmentation;

import java.util.ArrayList;
import java.util.List;

public class BestSolution {
    public static void main(String[] args) {
        var tokens = List.of("s", "an", "ca", "cat", "dog", "and", "sand", "dogs");
        var str = "catsanddogs";
        System.out.println(segment(str, tokens));
    }

    public static List<String> segment(String str, List<String> availableTokens) {
        return segment(str, availableTokens, new ArrayList<>(), null);
    }

    private static List<String> segment(String strToTokenize,
                                        List<String> availableTokens,
                                        List<String> usedTokens,
                                        List<String> bestSoFar) {
        if (strToTokenize.isEmpty()) {
            if (bestSoFar == null || usedTokens.size() < bestSoFar.size()) {
                return new ArrayList<>(usedTokens);
            } else {
                return bestSoFar;
            }
        }
        if (availableTokens.stream().noneMatch(t -> strToTokenize.startsWith(t))) return null;
        for (var token : availableTokens) {
            if (strToTokenize.startsWith(token)) {
                usedTokens.add(token);
                var newString = strToTokenize.substring(token.length());
                bestSoFar = segment(newString, availableTokens, usedTokens, bestSoFar);
                usedTokens.removeLast();
            }
        }
        return bestSoFar;
    }
}
