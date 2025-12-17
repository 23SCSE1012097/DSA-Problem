import java.util.*;

class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n <= 1 || k == 0) return 0;

        // holdLong[t]: Max profit on current day if we are currently "Long" in our t-th transaction
        long[] holdLong = new long[k + 1];
        // holdShort[t]: Max profit on current day if we are currently "Short" in our t-th transaction
        long[] holdShort = new long[k + 1];
        // sell[t]: Max profit on current day if we have completed t transactions
        long[] sell = new long[k + 1];

        // Initialize with very small values because we haven't started any transactions
        Arrays.fill(holdLong, Long.MIN_VALUE / 2);
        Arrays.fill(holdShort, Long.MIN_VALUE / 2);
        Arrays.fill(sell, 0);

        for (int price : prices) {
            // We iterate backwards through k to ensure we use results from the "previous" transaction count
            for (int t = k; t >= 1; t--) {
                // 1. Update 'sell' (Closing a transaction)
                // We can close a Long by selling (+price) or close a Short by buying (-price)
                sell[t] = Math.max(sell[t], Math.max(holdLong[t] + price, holdShort[t] - price));

                // 2. Update 'holding' states (Starting or continuing a transaction)
                // To start the t-th transaction, we use the profit from the (t-1)th completed transaction
                holdLong[t] = Math.max(holdLong[t], sell[t - 1] - price);
                holdShort[t] = Math.max(holdShort[t], sell[t - 1] + price);
            }
        }

        // The answer is the maximum profit after completing at most k transactions
        long maxProfit = 0;
        for (int t = 0; t <= k; t++) {
            maxProfit = Math.max(maxProfit, sell[t]);
        }
        return maxProfit;
    }
}