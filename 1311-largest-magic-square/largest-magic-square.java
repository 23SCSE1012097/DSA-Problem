class Solution {
    public int largestMagicSquare(int[][] grid) {
        int m = grid.length, n = grid[0].length;

        // Prefix sums
        int[][] row = new int[m][n + 1];
        int[][] col = new int[m + 1][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                row[i][j + 1] = row[i][j] + grid[i][j];
                col[i + 1][j] = col[i][j] + grid[i][j];
            }
        }

        int maxSize = Math.min(m, n);

        // Try largest size first
        for (int k = maxSize; k >= 2; k--) {
            for (int i = 0; i + k <= m; i++) {
                for (int j = 0; j + k <= n; j++) {

                    int target = row[i][j + k] - row[i][j];

                    boolean magic = true;

                    // Check rows
                    for (int r = i; r < i + k; r++) {
                        if (row[r][j + k] - row[r][j] != target) {
                            magic = false;
                            break;
                        }
                    }

                    // Check columns
                    for (int c = j; c < j + k && magic; c++) {
                        if (col[i + k][c] - col[i][c] != target) {
                            magic = false;
                            break;
                        }
                    }

                    // Check diagonals
                    if (magic) {
                        int d1 = 0, d2 = 0;
                        for (int d = 0; d < k; d++) {
                            d1 += grid[i + d][j + d];
                            d2 += grid[i + d][j + k - d - 1];
                        }
                        if (d1 != target || d2 != target) magic = false;
                    }

                    if (magic) return k;
                }
            }
        }

        return 1; // At least 1x1 is always magic
    }
}
