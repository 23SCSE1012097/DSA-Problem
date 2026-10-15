
class Solution {
    public int movesToMakeZigzag(int[] nums) {
        int even = 0;
        int odd = 0;
        int n = nums.length;

        for (int i = 0; i < n; i++) {
            int left = (i > 0) ? nums[i - 1] : 1001;
            int right = (i < n - 1) ? nums[i + 1] : 1001;

            int decrease = Math.max(0, nums[i] - Math.min(left, right) + 1);

            if (i % 2 == 0) {
                even += decrease;
            } else {
                odd += decrease;
            }
        }

        return Math.min(even, odd);
    }
}
