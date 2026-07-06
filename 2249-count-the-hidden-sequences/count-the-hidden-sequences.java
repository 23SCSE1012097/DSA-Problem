class Solution {
    public int numberOfArrays(int[] differences, int lower, int upper) {
        long prefix = 0;
        long minPrefix = 0;
        long maxPrefix = 0;

        for (int diff : differences) {
            prefix += diff;
            minPrefix = Math.min(minPrefix, prefix);
            maxPrefix = Math.max(maxPrefix, prefix);
        }

        long range = maxPrefix - minPrefix;
        long ans = (long) (upper - lower) - range + 1;

        return ans > 0 ? (int) ans : 0;
    }
}