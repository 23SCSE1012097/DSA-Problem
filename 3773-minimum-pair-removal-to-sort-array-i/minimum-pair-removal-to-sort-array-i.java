import java.util.*;

class Solution {
    public int minimumPairRemoval(int[] nums) {
        int operations = 0;

        while (!isNonDecreasing(nums)) {
            int minSum = Integer.MAX_VALUE;
            int index = 0;

            // Find adjacent pair with minimum sum (leftmost if tie)
            for (int i = 0; i < nums.length - 1; i++) {
                int sum = nums[i] + nums[i + 1];
                if (sum < minSum) {
                    minSum = sum;
                    index = i;
                }
            }

            // Create new array after replacing the pair
            int[] newNums = new int[nums.length - 1];
            int k = 0;

            for (int i = 0; i < nums.length; i++) {
                if (i == index) {
                    newNums[k++] = minSum;
                    i++; // skip next element
                } else {
                    newNums[k++] = nums[i];
                }
            }

            nums = newNums;
            operations++;
        }

        return operations;
    }

    private boolean isNonDecreasing(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] < arr[i - 1]) {
                return false;
            }
        }
        return true;
    }
}
