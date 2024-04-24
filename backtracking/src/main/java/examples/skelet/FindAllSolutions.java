package examples.skelet;

import java.util.ArrayList;
import java.util.Collection;

public abstract class FindAllSolutions {

    public Collection<Solution> solve() {
        PartialSolution initial = createInitialSolution();
        return findAllSolutions(initial, new ArrayList<>());
    }

    private Collection<Solution> findAllSolutions(PartialSolution current, Collection<Solution> solutionsSoFar) {
        if (current.isComplete()) {
            solutionsSoFar.add(current.toSolution());
            return solutionsSoFar;
        }
        if (current.shouldAbort()) return solutionsSoFar;
        for (var extension : current.extend()) {
            findAllSolutions(extension, solutionsSoFar);
        }
        return solutionsSoFar;
    }

    protected abstract PartialSolution createInitialSolution();
}
