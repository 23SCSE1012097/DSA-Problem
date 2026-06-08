class Solution {
    public int deleteGreatestValue(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        for (int[] row : grid) {
            Arrays.sort(row);
        }

        int ans = 0;

        for (int col = 0; col < n; col++) {
            int max = 0;

            for (int row = 0; row < m; row++) {
                max = Math.max(max, grid[row][col]);
            }

            ans += max;
        }

        return ans;
    }
}