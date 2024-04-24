package examples.tokensegmentation;

import examples.skelet.FindAllSolutions;
import examples.skelet.PartialSolution;
import examples.skelet.Solution;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class TokenSegmentation {
    public static void main(String[] args) {
        var tokens = List.of("s", "an", "ca", "cat", "dog", "and", "sand", "dogs");
        var string = "catsanddogs";
        var allSolutions = new FindAllSolutions() {

            @Override
            protected PartialSolution createInitialSolution() {
                return new Segmentation(string, List.of(), tokens);
            }
        };
        System.out.println(allSolutions.solve().toString());

    }

    static class Segmentation implements PartialSolution, Solution {

        private final String restOfString;
        private final List<String> usedTokens;
        private final List<String> allTokens;

        public Segmentation(String restOfString, List<String> tokens, List<String> allTokens) {
            this.restOfString = restOfString;
            this.usedTokens = tokens;
            this.allTokens = allTokens;
        }

        @Override
        public boolean isComplete() {
            return restOfString.isEmpty();
        }

        @Override
        public boolean shouldAbort() {
            return allTokens.stream().noneMatch(restOfString::startsWith);
        }

        @Override
        public Collection<Segmentation> extend() {
            List<Segmentation> result = new ArrayList<>();
            for (var token : allTokens) {
                if (restOfString.startsWith(token)) {
                    var newTokens = new ArrayList<>(this.usedTokens);
                    newTokens.add(token);
                    result.add(new Segmentation(restOfString.substring(token.length()), newTokens, allTokens));
                }
            }
            return result;
        }

        @Override
        public Solution toSolution() {
            return this;
        }

        @Override
        public boolean canImproveUpon(Solution solution) {
            return false;
        }

        @Override
        public boolean isBetterThan(Solution other) {
            return false;
        }

        @Override
        public String toString() {
            return usedTokens.toString();
        }
    }
}
