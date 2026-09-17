import java.util.*;

class Solution {
    public int countPartitions(int[] nums, int k) {
        int n = nums.length;
        long MOD = 1000000007L;

        long[] dp = new long[n + 1];
        long[] prefix = new long[n + 1];

        dp[0] = 1;
        prefix[0] = 1;

        Deque<Integer> maxDeque = new ArrayDeque<>();
        Deque<Integer> minDeque = new ArrayDeque<>();

        int left = 0;

        for (int right = 0; right < n; right++) {

            while (!maxDeque.isEmpty()
                    && nums[maxDeque.peekLast()] <= nums[right]) {
                maxDeque.pollLast();
            }
            maxDeque.addLast(right);

            while (!minDeque.isEmpty()
                    && nums[minDeque.peekLast()] >= nums[right]) {
                minDeque.pollLast();
            }
            minDeque.addLast(right);

            while ((long) nums[maxDeque.peekFirst()]
                    - nums[minDeque.peekFirst()] > k) {

                if (maxDeque.peekFirst() == left) {
                    maxDeque.pollFirst();
                }

                if (minDeque.peekFirst() == left) {
                    minDeque.pollFirst();
                }

                left++;
            }

            dp[right + 1] = prefix[right] - (left > 0 ? prefix[left - 1] : 0);

            dp[right + 1] %= MOD;

            if (dp[right + 1] < 0) {
                dp[right + 1] += MOD;
            }

            prefix[right + 1] = (prefix[right] + dp[right + 1]) % MOD;
        }

        return (int) dp[n];
    }
}