import java.util.*;

class Solution {
    public long maximumProfit(int[] prices, int k) {
        int n = prices.length;
        if (n <= 1 || k == 0) return 0;

       
        long[] holdLong = new long[k + 1];
        
        long[] holdShort = new long[k + 1];
      
        long[] sell = new long[k + 1];
        Arrays.fill(holdLong, Long.MIN_VALUE / 2);
        Arrays.fill(holdShort, Long.MIN_VALUE / 2);
        Arrays.fill(sell, 0);

        for (int price : prices) {
            for (int t = k; t >= 1; t--) {
                sell[t] = Math.max(sell[t], Math.max(holdLong[t] + price, holdShort[t] - price));
                holdLong[t] = Math.max(holdLong[t], sell[t - 1] - price);
                holdShort[t] = Math.max(holdShort[t], sell[t - 1] + price);
            }
        }

        long maxProfit = 0;
        for (int t = 0; t <= k; t++) {
            maxProfit = Math.max(maxProfit, sell[t]);
        }
        return maxProfit;
    }
}