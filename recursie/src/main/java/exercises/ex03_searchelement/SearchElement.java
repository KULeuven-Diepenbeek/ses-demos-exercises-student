package exercises.ex03_searchelement;

import java.util.List;

public class SearchElement {

    public static <T> int search(
            List<? extends T> elements,
            T elementToFind) {
        if (elements.isEmpty()) return -1;

        if (elements.getLast().equals(elementToFind)) {
            return elements.size() - 1;
        }
        return search(
                elements.subList(0,
                        elements.size() - 1),
        elementToFind);
    }

    public static <T extends Comparable<T>> int search2(List<? extends T> elements,
                                                        T elementToFind) {
        return search2(elements, elementToFind, 0, elements.size());
    }

    public static <T extends Comparable<T>> int search2(
            List<? extends T> elements,
            T elementToFind,
            int from, int to) {
        if (from >= to) return -1;

        var mid = from + (to-from)/2;
        if (elements.get(mid).equals(elementToFind)) {
            return mid;
        } else if (elements.get(mid).compareTo(elementToFind) < 0) {
            return search2(elements, elementToFind, mid+1, to);
        } else {
            return search2(elements, elementToFind, 0, mid);
        }
    }

}
