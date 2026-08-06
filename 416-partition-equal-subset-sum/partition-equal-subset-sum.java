class Solution {

    public boolean subset(int i, int[] arr, int target, int[][] dp) {

        if (target == 0)
            return true;

        if (i == arr.length)
            return false;

        if (dp[i][target] != -1)
            return dp[i][target] == 1;

        boolean skip = subset(i + 1, arr, target, dp);

        boolean pick = false;
        if (arr[i] <= target) {
            pick = subset(i + 1, arr, target - arr[i], dp);
        }

        boolean ans = pick || skip;

        dp[i][target] = ans ? 1 : 0;

        return ans;
    }

    public boolean canPartition(int[] nums) {

        int sum = 0;

        for (int x : nums)
            sum += x;

        if (sum % 2 != 0)
            return false;

        int target = sum / 2;
        int n = nums.length;

        int[][] dp = new int[n][target + 1];

        for (int i = 0; i < n; i++) {
            java.util.Arrays.fill(dp[i], -1);
        }

        return subset(0, nums, target, dp);
    }
}