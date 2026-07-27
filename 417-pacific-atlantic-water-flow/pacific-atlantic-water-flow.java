class Solution {

    int[][] dir = {{1,0},{-1,0},{0,1},{0,-1}};

    public List<List<Integer>> pacificAtlantic(int[][] heights) {

        int m = heights.length;
        int n = heights[0].length;

        boolean[][] pacific = new boolean[m][n];
        boolean[][] atlantic = new boolean[m][n];

        for(int j = 0; j < n; j++)
            dfs(0, j, pacific, heights);

        for(int i = 0; i < m; i++)
            dfs(i, 0, pacific, heights);

        for(int j = 0; j < n; j++)
            dfs(m - 1, j, atlantic, heights);

        for(int i = 0; i < m; i++)
            dfs(i, n - 1, atlantic, heights);

        List<List<Integer>> ans = new ArrayList<>();

        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(pacific[i][j] && atlantic[i][j]) {
                    ans.add(Arrays.asList(i, j));
                }
            }
        }

        return ans;
    }

    private void dfs(int r, int c, boolean[][] vis, int[][] heights) {

        if(vis[r][c]) return;

        vis[r][c] = true;

        int m = heights.length;
        int n = heights[0].length;

        for(int[] d : dir) {

            int nr = r + d[0];
            int nc = c + d[1];

            if(nr < 0 || nc < 0 || nr >= m || nc >= n)
                continue;

            if(vis[nr][nc])
                continue;

            if(heights[nr][nc] >= heights[r][c]) {
                dfs(nr, nc, vis, heights);
            }
        }
    }
}