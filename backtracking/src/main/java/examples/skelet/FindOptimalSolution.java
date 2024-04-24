package examples.skelet;

public abstract class FindOptimalSolution {

    public Solution solve() {
        PartialSolution initial = createInitialSolution();
        return findOptimalSolution(initial, null);
    }

    private Solution findOptimalSolution(PartialSolution current, Solution bestSoFar) {
        if (current.isComplete()) {
            var solution = current.toSolution();
            if (bestSoFar == null || solution.isBetterThan(bestSoFar)) {
                return solution;
            } else {
                return bestSoFar;
            }
        }
        if (current.shouldAbort() ||
                (bestSoFar != null && !current.canImproveUpon(bestSoFar))) {
            return bestSoFar;
        }
        for (var extension : current.extend()) {
            bestSoFar = findOptimalSolution(extension, bestSoFar);
        }
        return bestSoFar;
    }

    protected abstract PartialSolution createInitialSolution();
}
