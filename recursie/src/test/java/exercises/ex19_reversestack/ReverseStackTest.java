package exercises.ex19_reversestack;

import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class ReverseStackTest {

    @Test
    public void empty_stack() {
        var stack = new LinkedList<>();
        ReverseStack.reverse(stack);
        assertThat(stack).isEmpty();
    }

    @Test
    public void single_element() {
        var stack = new LinkedList<>(List.of("A"));
        ReverseStack.reverse(stack);
        assertThat(stack).isEqualTo(List.of("A"));
    }

    @Test
    public void two_elements() {
        var stack = new LinkedList<>(List.of("A", "B"));
        ReverseStack.reverse(stack);
        assertThat(stack).isEqualTo(List.of("B", "A"));
    }

    @Test
    public void five_elements() {
        var stack = new LinkedList<>(List.of("A", "B", "C", "D", "E"));
        ReverseStack.reverse(stack);
        assertThat(stack).isEqualTo(List.of("E", "D", "C", "B", "A"));
    }
}
