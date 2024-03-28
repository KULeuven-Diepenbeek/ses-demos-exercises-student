package sescourse.collections;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class MyFIFOTest {
    @Test
    public void my_fifo_test() {
        MyFIFO<String> fifo = new MyFIFO<>(5);
        assertThat(fifo.size()).isEqualTo(0);

        fifo.add("first");
        assertThat(fifo.size()).isEqualTo(1);

        assertThat(fifo.poll()).isEqualTo("first");

        for (var e : List.of("first", "second", "third", "fourth", "fifth")) {
            assertThat(fifo.add(e)).isTrue();
        }
        assertThat(fifo.size()).isEqualTo(5);

        assertThat(fifo.add("sixth")).isFalse();
        assertThat(fifo.size()).isEqualTo(5);

        assertThat(fifo.poll()).isEqualTo("first");
        assertThat(fifo.poll()).isEqualTo("second");
        assertThat(fifo.size()).isEqualTo(3);
    }
}
