class Solution {
    public int stoneGameVII(int[] stones) {
        int n = stones.length;

        int[] prefix = new int[n + 1];

        for (int i = 0; i < n; i++) {
            prefix[i + 1] = prefix[i] + stones[i];
        }

        int[][] dp = new int[n][n];

        for (int len = 2; len <= n; len++) {
            for (int i = 0; i + len - 1 < n; i++) {
                int j = i + len - 1;

                int total = prefix[j + 1] - prefix[i];

                int removeLeft = total - stones[i] - dp[i + 1][j];
                int removeRight = total - stones[j] - dp[i][j - 1];

                dp[i][j] = Math.max(removeLeft, removeRight);
            }
        }

        return dp[0][n - 1];
    }
}