package exercises.ex22_reduce;

import java.util.List;
import java.util.function.BiFunction;

public class Reduce {

    public static <T, R> R reduce(List<T> lst, R initial, BiFunction<? super R, ? super T, ? extends R> reducer) {
        if (lst.isEmpty()) return initial;

        var first = lst.getFirst();
        return reduce(lst.subList(1, lst.size()), reducer.apply(initial, first), reducer);
    }
}
