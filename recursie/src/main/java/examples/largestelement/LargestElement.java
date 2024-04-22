package examples.largestelement;

import java.util.List;
import java.util.NoSuchElementException;

public class LargestElement {
    public static int largestElement(List<Integer> list) {
        if (list.isEmpty()) throw new NoSuchElementException();
        if (list.size() == 1) return list.getFirst();

        var firstElement = list.getFirst();
        var largestRest = largestElement(list.subList(1, list.size()));
        return Math.max(firstElement, largestRest);
    }

    public static int largestElement_alt(List<Integer> list) {
        if (list.isEmpty()) throw new NoSuchElementException();
        if (list.size() == 1) return list.getFirst();

        int n = list.size();
        var largestFirstHalf = largestElement(list.subList(0, n/2));
        var largestSecondHalf = largestElement(list.subList(n/2, n));
        return Math.max(largestFirstHalf, largestSecondHalf);
    }
}
