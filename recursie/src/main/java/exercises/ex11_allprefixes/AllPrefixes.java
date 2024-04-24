package exercises.ex11_allprefixes;

import java.util.HashSet;
import java.util.Set;

public class AllPrefixes {

    public static Set<String> allPrefixes(String str) {
        if (str.isEmpty()) {
            var result = new HashSet<String>();
            result.add("");
            return result;
        }

        var result = allPrefixes(str.substring(0, str.length() - 1));
        result.add(str);
        return result;
    }

    public static Set<String> allPrefixes2(String str) {
        return allPrefixes2(str, new HashSet<>());
    }

    public static Set<String> allPrefixes2(String str, Set<String> prefixesSoFar) {
        if (str.isEmpty()) {
            prefixesSoFar.add(str);
            return prefixesSoFar;
        }

        prefixesSoFar.add(str);
        allPrefixes2(str.substring(0, str.length() - 1), prefixesSoFar);
        return prefixesSoFar;
    }
}
