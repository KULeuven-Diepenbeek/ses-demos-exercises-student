package exercises.ex11_allprefixes;

import org.junit.jupiter.api.Test;

import static exercises.ex11_allprefixes.AllPrefixes.allPrefixes;
import static org.assertj.core.api.Assertions.assertThat;

public class AllPrefixesTest {
    @Test
    public void example_hello() {
        assertThat(allPrefixes("Hello")).containsExactlyInAnyOrder("", "H", "He", "Hel", "Hell", "Hello");
    }

    @Test
    public void example_cat() {
        assertThat(allPrefixes("cat")).containsExactlyInAnyOrder("", "c", "ca", "cat");
    }

    @Test
    public void example_empty() {
        assertThat(allPrefixes("")).containsExactlyInAnyOrder("");
    }
}
