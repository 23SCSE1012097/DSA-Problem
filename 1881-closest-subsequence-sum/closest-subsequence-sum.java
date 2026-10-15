
import java.util.*;

class Solution {
    public int minAbsDifference(int[] nums, int goal) {
        int n = nums.length;
        int mid = n / 2;

        List<Long> left = new ArrayList<>();
        List<Long> right = new ArrayList<>();

        generate(nums, 0, mid, 0L, left);
        generate(nums, mid, n, 0L, right);

        Collections.sort(right);

        long ans = Math.abs((long) goal);

        for (long sum : left) {
            long target = (long) goal - sum;
            int low = 0;
            int high = right.size() - 1;

            while (low <= high) {
                int m = low + (high - low) / 2;
                long total = sum + right.get(m);

                ans = Math.min(ans, Math.abs(total - goal));

                if (total == goal) {
                    return 0;
                } else if (total < goal) {
                    low = m + 1;
                } else {
                    high = m - 1;
                }
            }
        }

        return (int) ans;
    }

    private void generate(int[] nums, int start, int end,
                          long sum, List<Long> sums) {
        if (start == end) {
            sums.add(sum);
            return;
        }

        generate(nums, start + 1, end, sum, sums);
        generate(nums, start + 1, end, sum + nums[start], sums);
    }
}
