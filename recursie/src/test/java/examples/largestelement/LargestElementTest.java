package examples.largestelement;

import org.junit.jupiter.api.Test;

import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

import static examples.largestelement.LargestElement.largestElement;
import static examples.largestelement.LargestElement.largestElement_alt;
import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;


public class LargestElementTest {

    @Test
    public void largest_element_of_empty_throws() {
        assertThrows(NoSuchElementException.class, () -> largestElement(Collections.emptyList()));
    }

    @Test
    public void largest_element_when_one_element() {
        assertThat(largestElement(List.of(4))).isEqualTo(4);
    }

    @Test
    public void largest_element_test() {
        assertThat(largestElement(List.of(4, 1, 5, 8, 10, 9))).isEqualTo(10);
    }

    @Test
    public void largest_element_alt_of_empty_throws() {
        assertThrows(NoSuchElementException.class, () -> largestElement_alt(Collections.emptyList()));
    }

    @Test
    public void largest_element_alt_when_one_element() {
        assertThat(largestElement_alt(List.of(4))).isEqualTo(4);
    }

    @Test
    public void largest_element_alt_test() {
        assertThat(largestElement_alt(List.of(4, 1, 5, 8, 10, 9))).isEqualTo(10);
    }

}
