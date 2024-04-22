package exercises.ex14_powerset;

import org.junit.jupiter.api.Test;

import java.util.Set;

import static exercises.ex14_powerset.Powerset.powerset;
import static org.assertj.core.api.Assertions.assertThat;

public class PowersetTest {
    @Test
    public void powerset_empty() {
        assertThat(powerset(Set.of()))
                .hasSize(1)
                .containsExactlyInAnyOrder(Set.of());
    }

    @Test
    public void powerset_singleton() {
        assertThat(powerset(Set.of("A")))
                .hasSize(2)
                .containsExactlyInAnyOrder(Set.of(), Set.of("A"));
    }

    @Test
    public void powerset_two_elements() {
        assertThat(powerset(Set.of("A", "B")))
                .hasSize(4)
                .containsExactlyInAnyOrder(Set.of(), Set.of("A"), Set.of("B"), Set.of("A", "B"));
    }

    @Test
    public void powerset_three_elements() {
        assertThat(powerset(Set.of("A", "B", "C")))
                .hasSize(8)
                .containsExactlyInAnyOrder(Set.of(), Set.of("A"), Set.of("B"), Set.of("C"), Set.of("A", "B"), Set.of("A", "C"), Set.of("B", "C"), Set.of("A", "B", "C"));
    }
}
