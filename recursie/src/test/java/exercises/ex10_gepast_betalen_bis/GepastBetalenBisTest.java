package exercises.ex10_gepast_betalen_bis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class GepastBetalenBisTest {

    @Test
    public void noCoins() {
        assertThat(GepastBetalenBis.countChange(10, List.of())).isEqualTo(0);
    }

    @Test
    public void only1Way() {
        assertThat(GepastBetalenBis.countChange(10, List.of(5, 20))).isEqualTo(1);
    }

    @Test
    public void example1() {
        assertThat(GepastBetalenBis.countChange(35, List.of(5, 10, 20, 50, 100, 200))).isEqualTo(6);
    }

    @Test
    public void example2() {
        assertThat(GepastBetalenBis.countChange(260, List.of(5, 10, 20, 50, 100, 200))).isEqualTo(646);
    }

    @Test
    public void example3() {
        assertThat(GepastBetalenBis.countChange(1000, List.of(5, 10, 20, 50, 100, 200))).isEqualTo(98411);
    }
}

