package exercises.ex12_allinterleavings;

import org.junit.jupiter.api.Test;

import static exercises.ex12_allinterleavings.AllInterleavings.allInterleavings;
import static org.assertj.core.api.Assertions.assertThat;

public class AllInterleavingsTest {
    @Test
    public void both_one_character() {
        assertThat(allInterleavings("A", "B")).containsExactlyInAnyOrder("AB", "BA");
    }

    @Test
    public void first_empty() {
        assertThat(allInterleavings("", "BCD")).containsExactlyInAnyOrder("BCD");
    }

    @Test
    public void second_empty() {
        assertThat(allInterleavings("ABC", "")).containsExactlyInAnyOrder("ABC");
    }

    @Test
    public void both_empty() {
        assertThat(allInterleavings("", "")).containsExactlyInAnyOrder("");
    }

    @Test
    public void second_only_one_character() {
        assertThat(allInterleavings("ABC", "x")).containsExactlyInAnyOrder("ABCx", "ABxC", "AxBC", "xABC");
    }

    @Test
    public void example1() {
        assertThat(allInterleavings("AB", "xy")).containsExactlyInAnyOrder("ABxy", "AxBy", "AxyB", "xABy", "xAyB", "xyAB");
    }

    @Test
    public void example2() {
        assertThat(allInterleavings("ABC", "xy")).containsExactlyInAnyOrder("ABCxy", "ABxCy", "ABxyC", "AxBCy", "AxByC", "AxyBC", "xABCy", "xAByC", "xAyBC", "xyABC");
    }
}
