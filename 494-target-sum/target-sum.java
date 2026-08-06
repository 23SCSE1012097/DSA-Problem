class Solution {

    int sum;

    public int ways(int i, int[] arr, int res, int target, int[][] dp) {

        if (i == arr.length) {
            return (res == target) ? 1 : 0;
        }

        if (dp[i][res + sum] != -1) {
            return dp[i][res + sum];
        }

        int add = ways(i + 1, arr, res + arr[i], target, dp);
        int sub = ways(i + 1, arr, res - arr[i], target, dp);

        return dp[i][res + sum] = add + sub;
    }

    public int findTargetSumWays(int[] nums, int target) {

        sum = 0;

        for (int x : nums) {
            sum += x;
        }

        if (Math.abs(target) > sum)
            return 0;

        int[][] dp = new int[nums.length][2 * sum + 1];

        for (int i = 0; i < nums.length; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return ways(0, nums, 0, target, dp);
    }
}
        
