import java.util.*;

class Solution {
    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        // Step 1: Store sums of nums1 + nums2
        for (int i = 0; i < nums1.length; i++) {
            for (int j = 0; j < nums2.length; j++) {
                int sum = nums1[i] + nums2[j];
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int count = 0;

        // Step 2: Check nums3 + nums4
        for (int k = 0; k < nums3.length; k++) {
            for (int l = 0; l < nums4.length; l++) {
                int sum = nums3[k] + nums4[l];
                count += map.getOrDefault(-sum, 0);
            }
        }

        return count;
    }
}

