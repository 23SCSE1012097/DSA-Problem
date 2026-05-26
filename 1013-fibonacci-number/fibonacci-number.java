class Solution {

    int[] dp;

    public int fib(int n) {

        dp = new int[n + 1];

        for (int i = 0; i <= n; i++) {
            dp[i] = -1;
        }

        return fibonacci(n);
    }

    public int fibonacci(int n) {

        if (n == 0 || n == 1) {
            return n;
        }

        if (dp[n] != -1) {
            return dp[n];
        }

        dp[n] = fibonacci(n - 1) + fibonacci(n - 2);

        return dp[n];
    }
}