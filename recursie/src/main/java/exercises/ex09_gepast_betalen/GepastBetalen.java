package exercises.ex09_gepast_betalen;

import java.util.List;

public class GepastBetalen {

    public static boolean kanGepastBetalen(int bedrag, List<Integer> munten) {
        if (bedrag < 0) return false;
        if (bedrag == 0) return true;
        if (munten.isEmpty()) return false;

        var first = munten.getFirst();

        return kanGepastBetalen(bedrag - first, munten.subList(1, munten.size())) ||
                kanGepastBetalen(bedrag, munten.subList(1, munten.size()));
    }
}
