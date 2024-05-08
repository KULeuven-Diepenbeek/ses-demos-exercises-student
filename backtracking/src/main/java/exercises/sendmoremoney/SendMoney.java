package exercises.sendmoremoney;

import java.util.HashMap;
import java.util.Map;

public class SendMoney {
    public static void main(String[] args) {
        var solution = solve("ONE", "TWO", "SIX");
        System.out.println(solution);
    }

    private static Map<Character, Integer> solve(
            String term1,
            String term2,
            String result) {
        return solve(term1, term2, result, new HashMap<>());
    }

    private static Map<Character, Integer> solve(
            String term1,
            String term2,
            String result,
            Map<Character, Integer> mapSoFar
    ) {
        if (sumCorrect(term1, term2, result, mapSoFar))
            return Map.copyOf(mapSoFar);
        var firstLetter = findFirstUnknown(
                term1 + term2 + result, mapSoFar);
        if (firstLetter == null)
            return null;
        for (int digit = 0; digit < 10; digit++) {
            if (mapSoFar.containsValue(digit)) continue;
            mapSoFar.put(firstLetter, digit);
            var solution = solve(term1, term2, result, mapSoFar);
            if (solution != null)
                return solution;
            else
                mapSoFar.remove(firstLetter);
        }
        return null;
    }

    private static boolean sumCorrect(
            String term1,
            String term2,
            String result,
            Map<Character, Integer> mapSoFar) {
        for (char c : mapSoFar.keySet()) {
            term1 = replaceCharWithNumber(term1,
                    c, mapSoFar.get(c));
            term2 = replaceCharWithNumber(term2,
                    c, mapSoFar.get(c));
            result = replaceCharWithNumber(result,
                    c, mapSoFar.get(c));
        }
        if (term1.startsWith("0") ||
            term2.startsWith("0") ||
                result.startsWith("0")) return false;

        try {
            return Integer.parseInt(term1) +
                    Integer.parseInt(term2) == Integer.parseInt(result);
        } catch (NumberFormatException e) {
            return false;
        }
    }

    private static String replaceCharWithNumber(String str, char charToReplace, int digit) {
        return str.replace(charToReplace, (char) ('0' + digit));
    }

    private static boolean containsLetter(String str) {
        return str.chars().anyMatch(Character::isLetter);
    }

    private static Character findFirstUnknown(
            String str,
            Map<Character, Integer> mapSoFar) {
        for (char c : str.toCharArray()) {
            if (!mapSoFar.containsKey(c))
                return c;
        }
        return null;
    }
}
