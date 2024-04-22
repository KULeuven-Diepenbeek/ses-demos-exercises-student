package exercises.ex13_vliegtuigreis;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

public class VliegtuigreisTest {

    private static final Vliegtuigreis.Item ITEM_50 = new Vliegtuigreis.Item("A", 50);
    private static final Vliegtuigreis.Item ITEM_20 = new Vliegtuigreis.Item("B", 20);
    private static final Vliegtuigreis.Item ITEM_10 = new Vliegtuigreis.Item("C", 10);
    private static final Vliegtuigreis.Item ITEM_5 = new Vliegtuigreis.Item("D", 5);

    @Test
    public void no_items() {
        assertThat(Vliegtuigreis.pack(List.of(), 100)).isEmpty();
    }

    @Test
    public void single_item_fits() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50), 100)).containsExactlyInAnyOrder(ITEM_50);
    }

    @Test
    public void single_item_fits_exactly() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50), 50)).containsExactlyInAnyOrder(ITEM_50);
    }

    @Test
    public void single_item_does_not_fit() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50), 10)).isEmpty();
    }

    @Test
    public void multiple_items_fit() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50, ITEM_20), 100)).containsExactlyInAnyOrder(ITEM_50, ITEM_20);
    }

    @Test
    public void multiple_items_fit_exactly() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50, ITEM_20, ITEM_10), 80)).containsExactlyInAnyOrder(ITEM_50, ITEM_20, ITEM_10);
    }

    @Test
    public void multiple_items_none_fits() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50, ITEM_20, ITEM_10), 5)).isEmpty();
    }

    @Test
    public void multiple_items_not_all_fit() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50, ITEM_20, ITEM_10, ITEM_5), 40))
                .hasSize(3)
                .doesNotContain(ITEM_50);
    }

    @Test
    public void multiple_items_not_all_fit2() {
        assertThat(Vliegtuigreis.pack(List.of(ITEM_50, ITEM_20, ITEM_10, ITEM_5), 20))
                .hasSize(2)
                .doesNotContain(ITEM_50, ITEM_20);
    }
}
