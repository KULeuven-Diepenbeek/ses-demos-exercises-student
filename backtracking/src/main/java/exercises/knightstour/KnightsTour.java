package exercises.knightstour;
import java.util.ArrayList;
import java.util.List;


public class KnightsTour {
    private static int N = 8;

    private static List<Position> findTour(
            List<Position> tourSoFar
    ) {
        if (tourSoFar.size() == N*N)
            return List.copyOf(tourSoFar);
        var last = tourSoFar.getLast();
        var steps = new int[][] {
                {-2, 1}, {-1, 2}, {1, 2}, {2, 1},
                {2, -1}, {1, -2}, {-1, -2}, {-2, -1}
        };
        for (var step : steps) {
            var newPosition = last.move(step[0], step[1]);
            if (!newPosition.isValid()) continue;
            if (tourSoFar.contains(newPosition)) continue;
            tourSoFar.add(newPosition);
            var solution = findTour(tourSoFar);
            if (solution != null) return solution;
            else tourSoFar.removeLast();
        }
        return null;
    }

    public static void main(String[] args) {
        var start = new ArrayList<>(List.of(new Position(0,0)));
        var solution = findTour(start);
        System.out.println(solution);
    }

    record Position(int row, int col) {
        public Position move(int rows, int cols) {
            return new Position(this.row + rows,
                    this.col + cols);
        }

        public boolean isValid() {
            return 0 <= row && row < N &&
                    0 <= col && col < N;
        }
    }

}
