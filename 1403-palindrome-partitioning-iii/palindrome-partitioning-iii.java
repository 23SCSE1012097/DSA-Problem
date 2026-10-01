class Solution {
    public int palindromePartition(String s, int k) {
        int n = s.length();

        int[][] cost = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                cost[i][j] = cost[i + 1][j - 1];

                if (s.charAt(i) != s.charAt(j)) {
                    cost[i][j]++;
                }
            }
        }

        int[][] dp = new int[k + 1][n + 1];

        for (int i = 0; i <= k; i++) {
            for (int j = 0; j <= n; j++) {
                dp[i][j] = 1000000;
            }
        }

        dp[0][0] = 0;

        for (int parts = 1; parts <= k; parts++) {
            for (int i = parts; i <= n; i++) {
                for (int j = parts - 1; j < i; j++) {
                    dp[parts][i] = Math.min(
                        dp[parts][i],
                        dp[parts - 1][j] + cost[j][i - 1]
                    );
                }
            }
        }

        return dp[k][n];
    }
}