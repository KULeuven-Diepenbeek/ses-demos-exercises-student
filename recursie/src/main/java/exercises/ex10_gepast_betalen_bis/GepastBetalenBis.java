package exercises.ex10_gepast_betalen_bis;

import java.util.List;

public class GepastBetalenBis {

    public static int countChange(int amount, List<Integer> coinValues) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (coinValues.isEmpty()) return 0;

        var first = coinValues.getFirst();
        return countChange(amount, coinValues.subList(1, coinValues.size()))
                + countChange(amount - first, coinValues);
    }
}
