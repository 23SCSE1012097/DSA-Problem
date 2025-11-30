class Solution {
    public int minSpaceWastedKResizing(int[] nums, int k) {
        int n = nums.length;

      
        int[] pre = new int[n + 1];
        for (int i = 0; i < n; i++) pre[i + 1] = pre[i] + nums[i];

        int[][] dp = new int[n + 1][k + 1];
        for (int i = 0; i <= n; i++)
            for (int j = 0; j <= k; j++)
                dp[i][j] = Integer.MAX_VALUE / 2;

       
        for (int j = 0; j <= k; j++) dp[n][j] = 0;

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j <= k; j++) {
                int maxVal = 0;

                if (j == 0) {
                    for (int p = i; p < n; p++) maxVal = Math.max(maxVal, nums[p]);
                    dp[i][0] = maxVal * (n - i) - (pre[n] - pre[i]);
                } else {
                   
                    maxVal = 0;
                    for (int p = i; p < n; p++) {
                        maxVal = Math.max(maxVal, nums[p]);
                        int length = p - i + 1;
                        int sum = pre[p + 1] - pre[i];
                        int waste = maxVal * length - sum;

                        if (p + 1 <= n)
                            dp[i][j] = Math.min(dp[i][j], waste + dp[p + 1][j - 1]);
                    }
                }
            }
        }

        return dp[0][k];
    }
}
