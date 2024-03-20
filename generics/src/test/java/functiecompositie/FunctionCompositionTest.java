package functiecompositie;

import org.junit.jupiter.api.Test;

import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;

public class FunctionCompositionTest {
    @Test
    public void testCompose() {
        Function<Fruit, PeeledFruit> peelFruit = (var fruit) -> new PeeledFruit(fruit);
        Function<Ingredient, Chopped> chopIngredient = (var food) -> new Chopped(food);

        var makeFruitSalad = Composer.compose(peelFruit, chopIngredient);

        assertThat(makeFruitSalad.apply(new Fruit())).isEqualTo(new Chopped(new PeeledFruit(new Fruit())));
    }
}
