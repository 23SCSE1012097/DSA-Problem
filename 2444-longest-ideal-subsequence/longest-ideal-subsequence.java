class Solution {
    public int longestIdealString(String s, int k) {
        int[] dp = new int[26];
        int ans = 0;

        for (char ch : s.toCharArray()) {
            int curr = ch - 'a';

            int best = 0;

            int left = Math.max(0, curr - k);
            int right = Math.min(25, curr + k);

            for (int i = left; i <= right; i++) {
                best = Math.max(best, dp[i]);
            }

            dp[curr] = Math.max(dp[curr], best + 1);
            ans = Math.max(ans, dp[curr]);
        }

        return ans;
    }
}