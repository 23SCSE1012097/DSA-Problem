
import java.util.*;

class Solution {
    public List<List<Integer>> shiftGrid(int[][] grid, int k) {
        int m = grid.length;
        int n = grid[0].length;
        List<List<Integer>> result = new ArrayList<>();

        k = k % (m * n);

        for (int i = 0; i < m; i++) {
            List<Integer> row = new ArrayList<>();

            for (int j = 0; j < n; j++) {
                int index = (i * n + j - k + m * n) % (m * n);
                row.add(grid[index / n][index % n]);
            }

            result.add(row);
        }

        return result;
    }
}
