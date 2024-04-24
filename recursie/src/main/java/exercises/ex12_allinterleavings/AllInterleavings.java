package exercises.ex12_allinterleavings;

import java.util.HashSet;
import java.util.Set;

public class AllInterleavings {

    public static Set<String> allInterleavings(String s1, String s2) {
        if (s1.isEmpty()) return new HashSet<>(Set.of(s2));
        if (s2.isEmpty()) return new HashSet<>(Set.of(s1));

        var first1 = s1.charAt(0);
        var first2 = s2.charAt(0);
        var result = new HashSet<String>();
        for (var i : allInterleavings(s1.substring(1), s2)) {
            result.add(first1 + i);
        }
        for (var i : allInterleavings(s1, s2.substring(1))) {
            result.add(first2 + i);
        }
        return result;
    }

}
