package exercises.ex22_reduce;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;

import static exercises.ex22_reduce.Reduce.reduce;
import static org.assertj.core.api.Assertions.assertThat;

public class ReduceTest {

    private static final BiFunction<Integer, Integer, Integer> SUM = (a, b) -> a + b;

    @Test
    public void reduce_empty() {
        assertThat(reduce(Collections.emptyList(), 0, SUM)).isEqualTo(0);
    }

    @Test
    public void reduce_single() {
        assertThat(reduce(List.of(5), 0, SUM)).isEqualTo(5);
    }

    @Test
    public void reduce_two() {
        assertThat(reduce(List.of(5, 3), 0, SUM)).isEqualTo(8);
    }

    @Test
    public void reduce_many() {
        assertThat(reduce(List.of(5, 3, 1, 4, 9), 0, SUM)).isEqualTo(22);
    }



}
