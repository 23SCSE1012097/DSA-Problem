class Solution {
    public int numPermsDISequence(String s) {
        int mod = 1000000007;
        int n = s.length();

        long[] dp = new long[n + 1];
        for (int j = 0; j <= n; j++) {
            dp[j] = 1;
        }

        for (int i = 0; i < n; i++) {
            long[] ndp = new long[n + 1];

            if (s.charAt(i) == 'I') {
                long sum = 0;
                for (int j = 0; j < n - i; j++) {
                    sum = (sum + dp[j]) % mod;
                    ndp[j] = sum;
                }
            } else {
                long sum = 0;
                for (int j = n - i - 1; j >= 0; j--) {
                    sum = (sum + dp[j + 1]) % mod;
                    ndp[j] = sum;
                }
            }

            dp = ndp;
        }

        return (int) dp[0];
    }
}