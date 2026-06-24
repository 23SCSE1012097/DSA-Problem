class Solution {
    public int maximizeTheProfit(int n, List<List<Integer>> offers) {
        List<int[]>[] endAt = new ArrayList[n];

        for (int i = 0; i < n; i++) {
            endAt[i] = new ArrayList<>();
        }

        for (List<Integer> offer : offers) {
            int start = offer.get(0);
            int end = offer.get(1);
            int gold = offer.get(2);
            endAt[end].add(new int[]{start, gold});
        }

        long[] dp = new long[n + 1];

        for (int i = 0; i < n; i++) {
            dp[i + 1] = dp[i];

            for (int[] offer : endAt[i]) {
                int start = offer[0];
                int gold = offer[1];
                dp[i + 1] = Math.max(dp[i + 1], dp[start] + gold);
            }
        }

        return (int) dp[n];
    }
}