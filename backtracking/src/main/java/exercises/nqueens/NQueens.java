package exercises.nqueens;
import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public static void main(String[] args) {
        List<Queen> solution = solve(new ArrayList<>());
        System.out.println(solution);
    }

    private static boolean freeRow(List<Queen> positions,
                                   int column) {
        for (int row = 0; row < 8; row++) {
            var newQ = new Queen(row, column);
            if (positions.stream().noneMatch(newQ::attacks)) {
                return true;
            }
        }
        return false;
    }

    record Queen(int row, int col) {
        public boolean attacks(Queen other) {
            return row == other.row() ||
                    col == other.col() ||
                    Math.abs(col - other.col()) ==
                            Math.abs(row - other.row());
        }
    }

    private static List<Queen> solve(
            List<Queen> positions) {
        if (positions.size() == 8) return positions;
        if (!freeRow(positions, nextCol(positions))) return null;

        var col = nextCol(positions);
        for (int row = 0; row < 8; row++) {
            var newQ = new Queen(row, col);
            if (positions.stream().noneMatch(newQ::attacks)) {
                positions.add(newQ);
                var solution = solve(positions);
                if (solution != null) return solution;
                positions.removeLast();
            }
        }
        return null;
    }



    private static int nextCol(List<Queen> positions) {
        return positions.size();
    }
}
