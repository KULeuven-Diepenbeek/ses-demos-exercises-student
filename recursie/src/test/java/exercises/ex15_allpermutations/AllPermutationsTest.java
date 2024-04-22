package exercises.ex15_allpermutations;

import org.junit.jupiter.api.Test;

import java.util.List;

import static exercises.ex15_allpermutations.AllPermutations.allPermutations;
import static org.assertj.core.api.Assertions.assertThat;

public class AllPermutationsTest {
    @Test
    public void empty() {
        assertThat(allPermutations(List.of())).hasSize(1).containsExactly(List.of());
    }

    @Test
    public void single_element() {
        assertThat(allPermutations(List.of("A")))
                .hasSize(1)
                .containsExactlyInAnyOrder(List.of("A"));
    }

    @Test
    public void two_elements() {
        assertThat(allPermutations(List.of("A", "B")))
                .hasSize(2)
                .containsExactlyInAnyOrder(List.of("A", "B"), List.of("B", "A"));
    }

    @Test
    public void three_elements() {
        assertThat(allPermutations(List.of("A", "B", "C")))
                .hasSize(6)
                .containsExactlyInAnyOrder(List.of("A", "B", "C"), List.of("A", "C", "B"),
                        List.of("B", "A", "C"), List.of("B", "C", "A"),
                        List.of("C", "A", "B"), List.of("C", "B", "A"));
    }
}
