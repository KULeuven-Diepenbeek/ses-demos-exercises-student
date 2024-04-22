package exercises.ex04_remove_duplicates;

import org.junit.jupiter.api.Test;

import static exercises.ex04_remove_duplicates.RemoveDuplicateChars.removeDuplicateCharacters;
import static org.assertj.core.api.Assertions.assertThat;

public class RemoveDuplicatesTest {

    @Test
    public void remove_duplicates_empty() {
        assertThat(removeDuplicateCharacters("")).isEqualTo("");
    }

    @Test
    public void remove_duplicates_single() {
        assertThat(removeDuplicateCharacters("x")).isEqualTo("x");
    }

    @Test
    public void remove_duplicates_two_different() {
        assertThat(removeDuplicateCharacters("xy")).isEqualTo("xy");
    }

    @Test
    public void remove_duplicates_two_same() {
        assertThat(removeDuplicateCharacters("xx")).isEqualTo("x");
    }

    @Test
    public void remove_duplicates_many_no_repeated() {
        assertThat(removeDuplicateCharacters("xyx")).isEqualTo("xyx");
    }

    @Test
    public void remove_duplicates_many_repeated() {
        assertThat(removeDuplicateCharacters("aaaaa")).isEqualTo("a");
    }

    @Test
    public void remove_duplicates_alternating() {
        assertThat(removeDuplicateCharacters("AAAbbCdddEE")).isEqualTo("AbCdE");
    }

    @Test
    public void remove_duplicates_examples() {
        assertThat(removeDuplicateCharacters("aaaaa")).isEqualTo("a");
        assertThat(removeDuplicateCharacters("koortsmeetsysteemstrook")).isEqualTo("kortsmetsystemstrok");
        assertThat(removeDuplicateCharacters("AAAbbCddd")).isEqualTo("AbCd");
    }
}
