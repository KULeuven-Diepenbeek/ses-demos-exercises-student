package exercises.ex03_searchelement;

import org.junit.jupiter.api.Test;

import java.util.List;

import static exercises.ex03_searchelement.SearchElement.search;
import static org.assertj.core.api.Assertions.assertThat;

public class SearchElementTest {
    @Test
    void cannot_find_element_in_empty_list() {
        assertThat(search(List.of(), "x")).isEqualTo(-1);
    }

    @Test
    void can_find_only_element() {
        assertThat(search(List.of("x"), "x")).isEqualTo(0);
    }

    @Test
    void can_find_last_element() {
        assertThat(search(List.of("x", "y", "z"), "z")).isEqualTo(2);
    }

    @Test
    void cannot_find_nonexistent_element() {
        assertThat(search(List.of("x", "y", "z"), "a")).isEqualTo(-1);
    }
}
