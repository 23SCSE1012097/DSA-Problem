class Solution {
    private static final int MOD = 1000000007;

    public int numberWays(List<List<Integer>> hats) {
        int n = hats.size();

        List<Integer>[] people = new ArrayList[41];

        for (int i = 1; i <= 40; i++) {
            people[i] = new ArrayList<>();
        }

        for (int person = 0; person < n; person++) {
            for (int hat : hats.get(person)) {
                people[hat].add(person);
            }
        }

        int totalMasks = 1 << n;
        long[] dp = new long[totalMasks];
        dp[0] = 1;

        for (int hat = 1; hat <= 40; hat++) {
            long[] next = dp.clone();

            for (int mask = 0; mask < totalMasks; mask++) {
                if (dp[mask] == 0) {
                    continue;
                }

                for (int person : people[hat]) {
                    int bit = 1 << person;

                    if ((mask & bit) == 0) {
                        int newMask = mask | bit;
                        next[newMask] = (next[newMask] + dp[mask]) % MOD;
                    }
                }
            }

            dp = next;
        }

        return (int) dp[totalMasks - 1];
    }
}