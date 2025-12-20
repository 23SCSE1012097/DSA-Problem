class Solution {
    public int divide(int dividend, int divisor) {

        // Edge case: overflow
        if (dividend == Integer.MIN_VALUE && divisor == -1) {
            return Integer.MAX_VALUE;
        }

        // Sign check
        boolean negative = (dividend < 0) ^ (divisor < 0);

        // Convert to positive long to avoid overflow
        long a = Math.abs((long) dividend);
        long b = Math.abs((long) divisor);

        int result = 0;

        // Main logic using bit shifting
        while (a >= b) {
            long temp = b;
            int count = 1;

            while (a >= (temp << 1)) {
                temp <<= 1;
                count <<= 1;
            }

            a -= temp;
            result += count;
        }

        return negative ? -result : result;
    }
}
