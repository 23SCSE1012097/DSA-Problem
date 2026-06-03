class Solution {
    static final int MOD = 1_000_000_007;

    public int numberOfPermutations(int n, int[][] requirements) {

        int[] req = new int[n];
        Arrays.fill(req, -1);

        for (int[] r : requirements) {
            req[r[0]] = r[1];
        }

        if (req[0] > 0) {
            return 0;
        }

        int MAX_INV = 400;

        long[][] dp = new long[n + 1][MAX_INV + 1];
        dp[1][0] = 1;

        for (int len = 2; len <= n; len++) {

            long[] prefix = new long[MAX_INV + 2];

            for (int i = 0; i <= MAX_INV; i++) {
                prefix[i + 1] = (prefix[i] + dp[len - 1][i]) % MOD;
            }

            for (int inv = 0; inv <= MAX_INV; inv++) {

                int left = Math.max(0, inv - (len - 1));
                int right = inv;

                dp[len][inv] =
                        (prefix[right + 1] - prefix[left] + MOD) % MOD;
            }

            int need = req[len - 1];

            if (need != -1) {
                for (int inv = 0; inv <= MAX_INV; inv++) {
                    if (inv != need) {
                        dp[len][inv] = 0;
                    }
                }
            }
        }

        int finalInv = req[n - 1];

        return (int) dp[n][finalInv];
    }
}