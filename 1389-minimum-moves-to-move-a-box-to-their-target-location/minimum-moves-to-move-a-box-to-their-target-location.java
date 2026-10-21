import java.util.*;

class Solution {
    public int minPushBox(char[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        int sx = 0, sy = 0, bx = 0, by = 0;
        int tx = 0, ty = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (grid[i][j] == 'S') {
                    sx = i;
                    sy = j;
                } else if (grid[i][j] == 'B') {
                    bx = i;
                    by = j;
                } else if (grid[i][j] == 'T') {
                    tx = i;
                    ty = j;
                }
            }
        }

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};
        boolean[][][] visited = new boolean[m][n][m * n];
        Queue<int[]> q = new LinkedList<>();
        q.offer(new int[]{bx, by, sx * n + sy, 0});

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            int x = cur[0], y = cur[1], player = cur[2], pushes = cur[3];

            if (x == tx && y == ty) {
                return pushes;
            }

            int px = player / n;
            int py = player % n;

            for (int[] d : dirs) {
                int nx = x + d[0];
                int ny = y + d[1];
                int rx = x - d[0];
                int ry = y - d[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n ||
                    grid[nx][ny] == '#' ||
                    rx < 0 || rx >= m || ry < 0 || ry >= n ||
                    grid[rx][ry] == '#') {
                    continue;
                }

                if (!canReach(grid, px, py, rx, ry, x, y)) {
                    continue;
                }

                int nextPlayer = x * n + y;

                if (visited[nx][ny][nextPlayer]) {
                    continue;
                }

                visited[nx][ny][nextPlayer] = true;
                q.offer(new int[]{nx, ny, nextPlayer, pushes + 1});
            }
        }

        return -1;
    }

    private boolean canReach(char[][] grid, int sx, int sy,
                             int tx, int ty, int bx, int by) {
        int m = grid.length, n = grid[0].length;
        boolean[][] vis = new boolean[m][n];
        Queue<int[]> q = new LinkedList<>();

        q.offer(new int[]{sx, sy});
        vis[sx][sy] = true;

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        while (!q.isEmpty()) {
            int[] cur = q.poll();

            if (cur[0] == tx && cur[1] == ty) {
                return true;
            }

            for (int[] d : dirs) {
                int nx = cur[0] + d[0];
                int ny = cur[1] + d[1];

                if (nx < 0 || nx >= m || ny < 0 || ny >= n ||
                    grid[nx][ny] == '#' || vis[nx][ny] ||
                    (nx == bx && ny == by)) {
                    continue;
                }

                vis[nx][ny] = true;
                q.offer(new int[]{nx, ny});
            }
        }

        return false;
    }
}