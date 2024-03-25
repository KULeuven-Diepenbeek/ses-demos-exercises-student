package sescourse.collections;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.AssertionsForClassTypes.assertThatThrownBy;

public class MyArrayListTest {
    @Test
    public void test_my_arraylist() {
        MyArrayList<String> lst = new MyArrayList<>();
        // initial capacity and size
        assertThat(lst.capacity()).isEqualTo(4);
        assertThat(lst.size()).isEqualTo(0);

        // adding elements
        for (int i = 0; i < 4; i++) {
            lst.add("item" + i);
        }
        assertThat(lst.size()).isEqualTo(4);
        assertThat(lst.capacity()).isEqualTo(4);
        assertThat(lst.last()).isEqualTo("item3");

        // adding more elements
        for (int i = 4; i < 10; i++) {
            lst.add("item" + i);
        }
        assertThat(lst.size()).isEqualTo(10);
        assertThat(lst.capacity()).isEqualTo(16);
        assertThat(lst.last()).isEqualTo("item9");

        // remove an element
        lst.remove(3);
        assertThat(lst.size()).isEqualTo(9);
        assertThat(lst.capacity()).isEqualTo(16);
        assertThat(lst.get(3)).isEqualTo("item4");
        assertThatThrownBy(() -> lst.get(10)).isInstanceOf(IndexOutOfBoundsException.class);
    }
}
