class Solution {
    public int minSizeSubarray(int[] nums, int target) {
        int n = nums.length;

        long totalSum = 0;
        for (int num : nums) {
            totalSum += num;
        }

        long cycles = target / totalSum;
        long remainder = target % totalSum;

        if (remainder == 0) {
            return (int) (cycles * n);
        }

        int minLen = Integer.MAX_VALUE;

        long currentSum = 0;
        int left = 0;

        // Traverse nums twice to handle wrap-around
        for (int right = 0; right < 2 * n; right++) {
            currentSum += nums[right % n];

            while (currentSum > remainder) {
                currentSum -= nums[left % n];
                left++;
            }

            if (currentSum == remainder) {
                minLen = Math.min(minLen, right - left + 1);
            }
        }

        if (minLen == Integer.MAX_VALUE) {
            return -1;
        }

        return (int) (cycles * n + minLen);
    }
}