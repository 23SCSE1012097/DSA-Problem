class Solution {
    public int minLengthAfterRemovals(List<Integer> nums) {
        int n = nums.size();
        int maxFreq = 0;
        int count = 1;

        for (int i = 1; i < n; i++) {
            if (nums.get(i).equals(nums.get(i - 1))) {
                count++;
            } else {
                maxFreq = Math.max(maxFreq, count);
                count = 1;
            }
        }

        maxFreq = Math.max(maxFreq, count);

        if (maxFreq > n / 2) {
            return 2 * maxFreq - n;
        }

        return n % 2;
    }
}