class Solution {
    public int sumSubarrayMins(int[] arr) {
        int n = arr.length;
        long MOD = 1_000_000_007L;

        long[] left = new long[n];
        long[] right = new long[n];

        java.util.Stack<int[]> stack = new java.util.Stack<>();

        // Previous Less Element (strictly greater)
        for (int i = 0; i < n; i++) {
            long count = 1;
            while (!stack.isEmpty() && stack.peek()[0] > arr[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{arr[i], (int) count});
            left[i] = count;
        }

        stack.clear();

        // Next Less Element (greater or equal)
        for (int i = n - 1; i >= 0; i--) {
            long count = 1;
            while (!stack.isEmpty() && stack.peek()[0] >= arr[i]) {
                count += stack.pop()[1];
            }
            stack.push(new int[]{arr[i], (int) count});
            right[i] = count;
        }

        long result = 0;

        for (int i = 0; i < n; i++) {
            result = (result + arr[i] * left[i] * right[i]) % MOD;
        }

        return (int) result;
    }
}
