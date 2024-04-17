package streams.exercises.exercise2;

import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class MapTransform {

    private static <K, V, V2> Map<K, V2> mapAllValues(Map<? extends K, V> oldMap, Function<? super V, ? extends V2> function) {
        return oldMap.entrySet().stream().collect(Collectors.toMap(Map.Entry::getKey, e -> function.apply(e.getValue())));
    }
    public static void main(String[] args) {
        Map<String, String> myMap = Map.of("first", "333", "second", "55555");
        Function<Object, Integer> fn = (x) -> x.toString().length();
        Map<Object, Object> result = mapAllValues(myMap, fn);
        System.out.println(result);
    }
}
