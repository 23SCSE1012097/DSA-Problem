class Solution {

    int rows, cols;
    int totalPaths = 0;

    public int uniquePathsIII(int[][] grid) {
        rows = grid.length;
        cols = grid[0].length;

        int emptyCells = 0;
        int startX = 0, startY = 0;

        // Find start position and count empty cells
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == 0) {
                    emptyCells++;
                } else if (grid[i][j] == 1) {
                    startX = i;
                    startY = j;
                }
            }
        }

        // +1 to include the start cell
        dfs(grid, startX, startY, emptyCells + 1);
        return totalPaths;
    }

    private void dfs(int[][] grid, int x, int y, int remain) {

        // Boundary or obstacle check
        if (x < 0 || y < 0 || x >= rows || y >= cols || grid[x][y] == -1) {
            return;
        }

        // Reached ending cell
        if (grid[x][y] == 2) {
            if (remain == 0) {
                totalPaths++;
            }
            return;
        }

        // Mark current cell as visited
        int temp = grid[x][y];
        grid[x][y] = -1;

        // Explore all 4 directions
        dfs(grid, x + 1, y, remain - 1);
        dfs(grid, x - 1, y, remain - 1);
        dfs(grid, x, y + 1, remain - 1);
        dfs(grid, x, y - 1, remain - 1);

        // Backtrack
        grid[x][y] = temp;
    }
}
