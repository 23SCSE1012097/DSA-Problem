class Solution {
    class DSU {
        int[] parent;
        int[] size;

        DSU(int n) {
            parent = new int[n];
            size = new int[n];

            for (int i = 0; i < n; i++) {
                parent[i] = i;
                size[i] = 1;
            }
        }

        int find(int x) {
            if (parent[x] != x) {
                parent[x] = find(parent[x]);
            }
            return parent[x];
        }

        void union(int x, int y) {
            int px = find(x);
            int py = find(y);

            if (px == py) return;

            if (size[px] < size[py]) {
                int temp = px;
                px = py;
                py = temp;
            }

            parent[py] = px;
            size[px] += size[py];
        }

        int getSize(int x) {
            return size[find(x)];
        }
    }

    public int[] hitBricks(int[][] grid, int[][] hits) {
        int m = grid.length;
        int n = grid[0].length;

        int[][] copy = new int[m][n];

        for (int i = 0; i < m; i++) {
            copy[i] = grid[i].clone();
        }

        for (int[] hit : hits) {
            copy[hit[0]][hit[1]]--;
        }

        int top = m * n;
        DSU dsu = new DSU(m * n + 1);

        int[][] dirs = {{1, 0}, {-1, 0}, {0, 1}, {0, -1}};

        for (int r = 0; r < m; r++) {
            for (int c = 0; c < n; c++) {
                if (copy[r][c] != 1) continue;

                int idx = r * n + c;

                if (r == 0) {
                    dsu.union(idx, top);
                }

                if (r > 0 && copy[r - 1][c] == 1) {
                    dsu.union(idx, (r - 1) * n + c);
                }

                if (c > 0 && copy[r][c - 1] == 1) {
                    dsu.union(idx, r * n + c - 1);
                }
            }
        }

        int[] res = new int[hits.length];

        for (int i = hits.length - 1; i >= 0; i--) {
            int r = hits[i][0];
            int c = hits[i][1];

            if (grid[r][c] == 0) {
                res[i] = 0;
                continue;
            }

            int before = dsu.getSize(top);

            copy[r][c] = 1;

            int idx = r * n + c;

            if (r == 0) {
                dsu.union(idx, top);
            }

            for (int[] d : dirs) {
                int nr = r + d[0];
                int nc = c + d[1];

                if (nr < 0 || nr >= m || nc < 0 || nc >= n) {
                    continue;
                }

                if (copy[nr][nc] == 1) {
                    dsu.union(idx, nr * n + nc);
                }
            }

            int after = dsu.getSize(top);

            res[i] = Math.max(0, after - before - 1);
        }

        return res;
    }
}
