class Solution {
    public int[] pathsWithMaxScore(List<String> board) {
        int n = board.size();
        int mod = 1000000007;
        int[][] dp = new int[n][n];
        int[][] ways = new int[n][n];

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], -1);
        }

        dp[n - 1][n - 1] = 0;
        ways[n - 1][n - 1] = 1;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                if (board.get(i).charAt(j) == 'X' || (i == n - 1 && j == n - 1)) {
                    continue;
                }

                int max = -1;
                int count = 0;

                int[][] dir = {{1, 0}, {0, 1}, {1, 1}};

                for (int[] d : dir) {
                    int x = i + d[0];
                    int y = j + d[1];

                    if (x < n && y < n && dp[x][y] != -1) {
                        if (dp[x][y] > max) {
                            max = dp[x][y];
                            count = ways[x][y];
                        } else if (dp[x][y] == max) {
                            count = (count + ways[x][y]) % mod;
                        }
                    }
                }

                if (max == -1) {
                    continue;
                }

                char c = board.get(i).charAt(j);
                int val = (c >= '1' && c <= '9') ? c - '0' : 0;

                dp[i][j] = max + val;
                ways[i][j] = count;
            }
        }

        if (ways[0][0] == 0) {
            return new int[]{0, 0};
        }

        return new int[]{dp[0][0], ways[0][0]};
    }
}