class Solution {
    public int minZeroArray(int[] nums, int[][] queries) {
        int left = 0;
        int right = queries.length;

        if (!canMakeZero(nums, queries, right)) {
            return -1;
        }

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canMakeZero(nums, queries, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canMakeZero(int[] nums, int[][] queries, int k) {
        for (int i = 0; i < nums.length; i++) {
            boolean[] dp = new boolean[nums[i] + 1];
            dp[0] = true;

            for (int j = 0; j < k; j++) {
                int l = queries[j][0];
                int r = queries[j][1];
                int val = queries[j][2];

                if (i < l || i > r) {
                    continue;
                }

                for (int sum = nums[i]; sum >= val; sum--) {
                    if (dp[sum - val]) {
                        dp[sum] = true;
                    }
                }
            }

            if (!dp[nums[i]]) {
                return false;
            }
        }

        return true;
    }
}