class Solution {
    private static final long MOD = 1000000007;

    // Fast modular exponentiation
    private long modPow(long base, long exp) {
        long result = 1;
        base %= MOD;
        while (exp > 0) {
            if ((exp & 1) == 1) { // if exp is odd
                result = (result * base) % MOD;
            }
            base = (base * base) % MOD;
            exp >>= 1; // divide exp by 2
        }
        return result;
    }

    public int countGoodNumbers(long n) {
        long evenPositions = (n + 1) / 2; // ceil(n/2)
        long oddPositions = n / 2;        // floor(n/2)

        long result = (modPow(5, evenPositions) * modPow(4, oddPositions)) % MOD;
        return (int) result;
    }

    // Quick test
    public static void main(String[] args) {
        Solution sol = new Solution();
        System.out.println(sol.countGoodNumbers(1));   // Expected 5
        System.out.println(sol.countGoodNumbers(4));   // Expected 400
        System.out.println(sol.countGoodNumbers(50));  // Expected 564908303
    }
}