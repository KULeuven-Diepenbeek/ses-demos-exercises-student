package exercises.ex14_powerset;

import java.util.Set;

public class Powerset {

    public static <T> Set<Set<T>> powerset(Set<T> s) {
        var someEl = s.iterator().next();
        s.remove(someEl);

        return null;
    }

}
