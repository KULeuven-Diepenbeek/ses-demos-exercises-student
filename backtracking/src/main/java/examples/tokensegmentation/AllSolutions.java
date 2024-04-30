package examples.tokensegmentation;

import java.util.ArrayList;
import java.util.List;

public class AllSolutions {
    public static void main(String[] args) {
        var tokens = List.of("s", "an", "ca", "cat", "dog", "and", "sand", "dogs");
        var str = "catsanddogs";
        System.out.println(segment(str, tokens));
    }

    public static List<List<String>> segment(String str, List<String> availableTokens) {
        var solutions = new ArrayList<List<String>>();
        segment(str, availableTokens, new ArrayList<>(), solutions);
        return solutions;
    }

    private static void segment(String strToTokenize,
                                List<String> availableTokens,
                                List<String> usedTokens,
                                List<List<String>> solutionsSoFar) {
        if (strToTokenize.isEmpty()) {
            solutionsSoFar.add(new ArrayList<>(usedTokens));
            return;
        }
        if (availableTokens.stream().noneMatch(t -> strToTokenize.startsWith(t)))
            return;

        for (var token : availableTokens) {
            if (strToTokenize.startsWith(token)) {
                usedTokens.add(token);
                var newString = strToTokenize.substring(token.length());
                segment(newString, availableTokens,
                        usedTokens, solutionsSoFar);
                usedTokens.removeLast();
            }
        }
    }
}
