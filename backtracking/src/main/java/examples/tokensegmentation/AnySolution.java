package examples.tokensegmentation;

import java.util.ArrayList;
import java.util.List;

public class AnySolution {
    public static void main(String[] args) {
        var tokens = List.of("s", "an", "ca", "cat", "dog", "and", "sand", "dogs");
        var str = "catsanddogs";
        System.out.println(segment(str, tokens));
    }

    public static List<String> segment(String str, List<String> availableTokens) {
        return segment(str, availableTokens, new ArrayList<>());
    }

    private static List<String> segment(String strToTokenize, List<String> availableTokens,
                                        List<String> usedTokens) {
        if (strToTokenize.isEmpty()) return new ArrayList<>(usedTokens);
        if (availableTokens.stream().noneMatch(t -> strToTokenize.startsWith(t))) return null;
        for (var token : availableTokens) {
            if (strToTokenize.startsWith(token)) {
                usedTokens.add(token);
                var newString = strToTokenize.substring(token.length());
                var sol = segment(newString, availableTokens, usedTokens);
                if (sol != null) return sol;
                usedTokens.removeLast();
            }
        }
        return null;
    }
}
