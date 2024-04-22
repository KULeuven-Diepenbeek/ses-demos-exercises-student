package exercises.ex10_gepast_betalen_bis;

import java.util.List;

public class GepastBetalenBis {
    public static void main(String[] args) {
        var coins = List.of(5, 10, 20, 50, 100, 200);
        var target = 260;
        System.out.println(countChange(target, coins));
    }

    public static int countChange(int amount, List<Integer> coinValues) {
        if (amount < 0) return 0;
        if (amount == 0) return 1;
        if (coinValues.isEmpty()) return 0;
        return countChange(amount - coinValues.getFirst(), coinValues) + countChange(amount, coinValues.subList(1, coinValues.size()));
    }
}
